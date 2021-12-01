package com.auliahanifan.demo.product.service;

import com.auliahanifan.demo.product.dto.input.ProductInput;
import com.auliahanifan.demo.product.dto.output.ProductOutput;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

  ProductOutput getOne(Long id);

  List<ProductOutput> getAll(Pageable pageable);

  ProductOutput addOne(ProductInput input);

  void deleteOne(Long id);

  List<ProductOutput> getAllByName(String name, Pageable pageable);

  List<ProductOutput> getAllByCategoryId(Long categoryId);
}
