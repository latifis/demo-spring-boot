package com.auliahanifan.demo.product.controller;

import com.auliahanifan.demo.product.dto.input.ProductInput;
import com.auliahanifan.demo.product.dto.output.ProductOutput;
import com.auliahanifan.demo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController  {
  private final ProductService productService;

  @GetMapping("/{id}")
  public ProductOutput getOne(@PathVariable Long id) {
    return productService.getOne(id);
  }

  @GetMapping
  public List<ProductOutput> getAll(Pageable pageable) {
    return productService.getAll(pageable);
  }

  @PostMapping
  public ProductOutput addOne(@RequestBody ProductInput input) {
    return productService.addOne(input);
  }

  public void deleteOne(Long id) {
    // TODO impl
  }

  public List<ProductOutput> getAllByName(String name, Pageable pageable) {
    return null;  // TODO impl
  }
}
