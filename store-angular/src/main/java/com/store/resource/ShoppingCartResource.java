package com.store.resource;

import com.store.domain.CartItem;
import com.store.domain.Product;
import com.store.domain.ShoppingCart;
import com.store.domain.User;
import com.store.service.CartItemService;
import com.store.service.ProductService;
import com.store.service.ShoppingCartService;
import com.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShoppingCartResource {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/add")
    public ResponseEntity addItem (
            @RequestBody HashMap<String, String> mapper, Principal principal
    ){
        String productId = (String) mapper.get("productId");
        String qty = (String) mapper.get("qty");

        User user = userService.findByUsername(principal.getName());
        Product product = productService.findOne(Long.parseLong(productId));

        if(Integer.parseInt(qty) > product.getInStockNumber()) {
            return new ResponseEntity("Not Enough Stock!", HttpStatus.BAD_REQUEST);
        }

        CartItem cartItem = cartItemService.addProductToCartItem(product, user, Integer.parseInt(qty));

        return new ResponseEntity("Book Added Successfully!", HttpStatus.OK);
    }

    @RequestMapping("/getCartItemList")
    public List<CartItem> getCartItemList(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        shoppingCartService.updateShoppingCart(shoppingCart);

        return cartItemList;
    }

    @RequestMapping("/getShoppingCart")
    public ShoppingCart getShoppingCart(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();

        shoppingCartService.updateShoppingCart(shoppingCart);

        return shoppingCart;
    }

    @RequestMapping("/removeItem")
    public ResponseEntity removeItem(@RequestBody String id) {
        cartItemService.removeCartItem(cartItemService.findById(Long.parseLong(id)));

        return new ResponseEntity("Cart Item Removed Successfully!", HttpStatus.OK);
    }

    @RequestMapping("/updateCartItem")
    public ResponseEntity updateCartItem(
            @RequestBody HashMap<String, String> mapper
    ){
        String cartItemId = mapper.get("cartItemId");
        String qty = mapper.get("qty");

        CartItem cartItem = cartItemService.findById(Long.parseLong(cartItemId));
        cartItem.setQty(Integer.parseInt(qty));

        cartItemService.updateCartItem(cartItem);

        return new ResponseEntity("Cart Item Updated Successfully!", HttpStatus.OK);
    }

}
