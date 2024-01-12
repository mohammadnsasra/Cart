package com.testproj.test.service.impl;

import com.testproj.test.exceptionHandel.ConflictException;
import com.testproj.test.exceptionHandel.NotFoundException;
import com.testproj.test.mapper.CartMapper;
import com.testproj.test.model.document.Cart;
import com.testproj.test.model.dto.request.CartProductRequest;
import com.testproj.test.model.dto.request.CartRequest;
import com.testproj.test.model.dto.request.CartStatusRequest;
import com.testproj.test.model.dto.response.CartResponse;
import com.testproj.test.model.enums.CartStatus;
import com.testproj.test.repository.CartRepository;
import com.testproj.test.repository.ProductRepository;
import com.testproj.test.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public CartResponse createCart(CartRequest cartRequest) {
        log.info("Creating a new cart");
        Cart cart=this.cartMapper.CartToCartRequest(cartRequest);
          if(this.cartRepository.findByUserIdAndStatus(cart.getUserId(), CartStatus.ACTIVE).isPresent()){
             throw new ConflictException("the  user already has a  cart");
          }
         cart.setStatus(CartStatus.ACTIVE);
          Map<String,Integer> products=new HashMap<>();
          cart.setProduct(products);
        return this.cartMapper.CartToCartResponse(this.cartRepository.save(cart));
    }

    public Double getPrice(Map<String,Integer> map){
        log.info("calculating price");
         double totalPrice=0.0;
        for(String str:map.keySet())
            totalPrice+=this.productRepository.getProductPriceByProductId(str)*map.get(str);
        return totalPrice;
    }

@Override
    public CartResponse findById(String cartId) {
        log.info(String.format("getting cart  by id" + cartId));
    Cart cart=this.cartRepository.findByCartIdAndStatus(cartId,CartStatus.ACTIVE).orElseThrow(()->
            new NotFoundException("this cart %s does not exist or deleted "+ cartId));
        return this.cartMapper.CartToCartResponse(cart) ;
    }

    @Override
    public void deleteCartById(String cartId) {
        log.info("deleting a cart by id");
        this.cartRepository.findByCartIdAndStatus(cartId,CartStatus.ACTIVE).orElseThrow(()->
         new NotFoundException(String.format("this cart %s does not exist ",cartId)));
        this.cartRepository.deleteById(cartId);
    }


    @Override
    public CartResponse removeProductFromCart(String cartId, String productId) {
        log.info(String.format("removing  product in cart by %s id",cartId));
        Cart cart=this.cartRepository.findByCartIdAndStatus(cartId,CartStatus.ACTIVE).orElseThrow(()->
                new NotFoundException(String.format("this cart %s does not exist",cartId)));

            if(! cart.getProduct().containsKey(productId)) {
                throw new NotFoundException(String.format("this product %s does not exist in cart", productId));
            }
               int quantity=cart.getProduct().get(productId) - 1;
             if(quantity == 0) {
                 cart.getProduct().remove(productId);
                 cart.setTotalPrice(this.getPrice(cart.getProduct()));
                 return this.cartMapper.CartToCartResponse(this.cartRepository.save(cart));
             }

        cart.getProduct().put(productId,quantity);
        cart.setUpdatedAt(LocalDateTime.now());
        cart.setTotalPrice(this.getPrice(cart.getProduct()));
        return this.cartMapper.CartToCartResponse(this.cartRepository.save(cart));
    }

    @Override
    public CartResponse addProductsInCart(String cartId, String productId) {
        log.info(String.format("adding product in cart by %s id",productId));
        Cart cart=this.cartRepository.findByCartIdAndStatus(cartId,CartStatus.ACTIVE).orElseThrow(() ->
                new NotFoundException(String.format("this cart %s does not exist ",cartId)));
           if(cart.getProduct().containsKey(productId)){
            Integer quantity=cart.getProduct().get(productId) + 1;
            cart.getProduct().put(productId,quantity);
        }
        else{
            cart.getProduct().put(productId,1);
           }
        cart.setTotalPrice(this.getPrice(cart.getProduct()));
        cart.setUpdatedAt(LocalDateTime.now());
        return this.cartMapper.CartToCartResponse(this.cartRepository.save(cart));
    }
    @Override
    public CartResponse updateQuantityByProductId(String cartId, CartProductRequest request) {
        log.info(String.format("updating quantity by %s product id",request.getProductId()));
        Cart cart=this.cartRepository.findByCartIdAndStatus(cartId,CartStatus.ACTIVE).orElseThrow(()->
                new NotFoundException(String.format("this cart %s does not exist",cartId)));
         if(! cart.getProduct().containsKey(request.getProductId())) {
            throw  new NotFoundException(String.format("this product %s does not exist", request.getProductId()));
         }
             cart.getProduct().put(request.getProductId(), request.getQuantity());
         cart.setTotalPrice(this.getPrice(cart.getProduct()));
         cart.setUpdatedAt(LocalDateTime.now());
        return this.cartMapper.CartToCartResponse(this.cartRepository.save(cart));
    }

    @Override
    public CartResponse activationStatus(String cartId) {
        log.info(String.format("activation status of cart %s by id",cartId));
        Cart cart=this.cartRepository.findByCartIdAndStatus(cartId,CartStatus.DELETED).orElseThrow(()->
                new NotFoundException(String.format("this cart %s does not exist",cartId)));
        cart.setStatus(CartStatus.ACTIVE);
        return this.cartMapper.CartToCartResponse(this.cartRepository.save(cart));
    }
    @Override
    public List<CartStatus> getStatus() {
        log.info("Fetching cart statuses");
        return Arrays.stream(CartStatus.values()).toList();
    }

    public CartResponse softDeleted(String cartId){
        Cart cart=this.cartRepository.findByCartIdAndStatus(cartId,CartStatus.ACTIVE).orElseThrow(()->
                new NotFoundException(String.format("this cart %s does not exist",cartId)));
        cart.setStatus(CartStatus.DELETED);
        return this.cartMapper.CartToCartResponse(this.cartRepository.save(cart));
    }
    public CartResponse getCartByUserId(String userId){
        log.info(String.format("getting cart %s by user id",userId));
        Cart cart=this.cartRepository.findByUserIdAndStatus(userId,CartStatus.ACTIVE).orElseThrow(()->
                new NotFoundException(String.format("this user does not have any active cart %s  ",userId)));
        return this.cartMapper.CartToCartResponse(this.cartRepository.save(cart));
    }
    public CartResponse updateStatus(String cartId, CartStatusRequest statusRequest){
        log.info(String.format("update status of cart by %s ",cartId));
        Cart cart=this.cartRepository.findById(cartId).orElseThrow(()->
                new NotFoundException(String.format("this cart %s does not exist",cartId)));
        cart.setStatus(CartStatus.valueOf(statusRequest.getCartStatus()));
        return this.cartMapper.CartToCartResponse(this.cartRepository.save(cart));
    }


}
