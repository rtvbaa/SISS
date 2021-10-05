package com.solidsystems.siss.controller;

import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.controller.model.Sale;
import com.solidsystems.siss.dao.model.DiscountEntity;
import com.solidsystems.siss.dao.model.ProductEntity;
import com.solidsystems.siss.dao.model.SaleEntity;
import com.solidsystems.siss.service.DiscountService;
import com.solidsystems.siss.service.ProductService;
import com.solidsystems.siss.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class MainController {

    private final ProductService productService;
    private final DiscountService discountService;
    private final SaleService saleService;

    @Autowired
    public MainController(ProductService productService, DiscountService discountService, SaleService saleService) {
        this.productService = productService;
        this.discountService = discountService;
        this.saleService = saleService;
    }

    @GetMapping("/getProduct")
    public List<ProductEntity> getProduct() {
        return productService.getAll();
    }

    @PostMapping(value = "/postProduct",
            produces = {"application/json;charset=UTF-8"},
            consumes = {"application/json"})
    public ProductEntity postProduct(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/getDiscount")
    public List<DiscountEntity> getDiscount() {
        return discountService.getAll();
    }

    @GetMapping("/getSales")
    public List<Sale> getSales() {
        return saleService.getAll();
    }

    @PostMapping(value = "/postSales",
            produces = {"application/json;charset=UTF-8"},
            consumes = {"application/json"})
    public SaleEntity postSales(@RequestBody Sale sale) {
        return saleService.add(sale);
    }
}
