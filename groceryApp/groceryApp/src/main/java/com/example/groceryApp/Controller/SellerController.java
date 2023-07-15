package com.example.groceryApp.Controller;

import com.example.groceryApp.Model.Product;
import com.example.groceryApp.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "productList";
    }

    @GetMapping("/products/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "productForm";
        }

        // Set the product seller to the currently logged-in user (seller)
        // product.setSeller(seller); // Set the seller based on your authentication mechanism

        productRepository.save(product);

        return "redirect:/seller/products";
    }

    @GetMapping("/products/{id}/edit")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product id: " + id));
        model.addAttribute("product", product);
        return "productForm";
    }

    @PostMapping("/products/{id}/edit")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") @Valid Product updatedProduct,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "productForm";
        }

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product id: " + id));

        // Update the product properties
        product.setProductName(updatedProduct.getProductName());
        product.setDescription(updatedProduct.getDescription());
        product.setImage(updatedProduct.getImage());
        product.setSellPrice(updatedProduct.getSellPrice());
        product.setCostPrice(updatedProduct.getCostPrice());
        product.setStockUnit(updatedProduct.getStockUnit());

        productRepository.save(product);

        return "redirect:/seller/products";
    }

    @GetMapping("/products/{id}/delete")
    public String deleteProduct(@PathVariable("id") Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product id: " + id));

        productRepository.delete(product);

        return "redirect:/seller/products";
    }

}
