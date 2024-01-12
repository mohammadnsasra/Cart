package com.testproj.test.controller;


import com.testproj.test.model.dto.request.CartProductRequest;
import com.testproj.test.model.dto.request.CartRequest;
import com.testproj.test.model.dto.request.CartStatusRequest;
import com.testproj.test.model.dto.response.CartResponse;
import com.testproj.test.model.enums.CartStatus;
import com.testproj.test.service.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public CartResponse createCart(@Valid @RequestBody CartRequest cartRequest){
        return this.cartService.createCart(cartRequest);
    }
    @GetMapping
    public CartResponse getCartById(@RequestParam String cartId){

        return this.cartService.findById(cartId);
    }
    @DeleteMapping
    public void deleteById(@RequestParam String cartId){
         this.cartService.deleteCartById(cartId);
    }
    @PutMapping("remove-product-from-cart")
    public CartResponse removeProductFromCart(@RequestParam String cartId,@RequestParam String productId) {
        return this.cartService.removeProductFromCart(cartId,productId);
    }
    @PutMapping("/add-product")
    public CartResponse addProductsInCart(@RequestParam String cartId, @RequestParam String productId) {
        return this.cartService.addProductsInCart(cartId,productId);
    }
    @PutMapping("/activation-status")
    public CartResponse activationStatus(@RequestParam String cartId){
        return this.cartService.activationStatus(cartId);
    }
    @GetMapping("/get-status")
    public List<CartStatus> getStatus() {
        return this.cartService.getStatus();
    }
    @PutMapping
    public CartResponse  updateQuantityByProductId(@RequestParam String cartId,@Valid @RequestBody CartProductRequest request){

        return this.cartService.updateQuantityByProductId(cartId,request);
    }
    @PutMapping("soft-delete")
    public CartResponse softDeleted(@RequestParam String cartId){
        return this.cartService.softDeleted(cartId);
    }
    @GetMapping("get-cart-by-user-id")
    public CartResponse getCartByUserId(@RequestParam String userId){
        return this.cartService.getCartByUserId(userId);
    }
    @PutMapping("update-status")
    public CartResponse updateStatus(@RequestParam String cartId,@Valid @RequestBody  CartStatusRequest status){
      return this.cartService.updateStatus(cartId,status);
    }

}
