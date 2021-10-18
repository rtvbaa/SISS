package com.solidsystems.siss.controller;

import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.controller.model.Sale;
import com.solidsystems.siss.controller.model.Statistics;
import com.solidsystems.siss.dao.model.DiscountEntity;
import com.solidsystems.siss.service.DiscountService;
import com.solidsystems.siss.service.ProductService;
import com.solidsystems.siss.service.SaleService;
import com.solidsystems.siss.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class MainController {

    private final ProductService productService;
    private final DiscountService discountService;
    private final SaleService saleService;
    private final StatisticsService statisticsService;

    @Autowired
    public MainController(ProductService productService, DiscountService discountService, SaleService saleService, StatisticsService statisticsService) {
        this.productService = productService;
        this.discountService = discountService;
        this.saleService = saleService;
        this.statisticsService = statisticsService;
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return productService.getAll();
    }

    @PostMapping(value = "/postProduct",
            produces = {"application/json;charset=UTF-8"},
            consumes = {"application/json"})
    public HttpStatus postProduct(@RequestBody Product product) {
        productService.add(product);
        return HttpStatus.OK;
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
    public HttpStatus postSales(@RequestBody Map<String, String> json) {
        saleService.add(json.get("products"), json.get("discountId"));
        return HttpStatus.OK;
    }

    @GetMapping("/getHourlyStatistics")
    public List<Statistics> getHourlyStatistics() {
        return statisticsService.getHourlyStatistics();
    }
}
