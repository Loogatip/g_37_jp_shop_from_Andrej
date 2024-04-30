package de.aittr.g_37_jp_shop.controller;

import de.aittr.g_37_jp_shop.domain.dto.ProductDto;
import de.aittr.g_37_jp_shop.service.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // 1 способ: передача ID в виде части строки запроса
    // GET - localhost:8080/products/example/5

//    @GetMapping("/example/{id}")
//    public Product getById(@PathVariable Long id) {
//        return service.getById(id);
//    }

    // 2 способ: передача ID в виде параметра запроса
    // GET - localhost:8080/products/example?id=5

    @GetMapping
    public ProductDto getById(@RequestParam Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto product) {
        return service.save(product);
    }
}