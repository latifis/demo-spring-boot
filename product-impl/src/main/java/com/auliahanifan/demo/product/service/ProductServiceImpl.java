package com.auliahanifan.demo.product.service;

import com.auliahanifan.demo.product.dto.input.ProductInput;
import com.auliahanifan.demo.product.dto.output.ProductOutput;
import com.auliahanifan.demo.product.model.Product;
import com.auliahanifan.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  private ModelMapper modelMapper;

  @Autowired
  public void setModelMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public ProductOutput getOne(Long id) {
    Product product = productRepository.getById(id);
    ProductOutput productOutput = modelMapper.map(product, ProductOutput.class);
    return productOutput;
  }

  @Override
  public List<ProductOutput> getAll(Pageable pageable) {
    List<Product> productList = IterableUtils.toList(productRepository.findAll());
    List<ProductOutput> outputList = new ArrayList<>();
    for (Product product: productList) {
      outputList.add(modelMapper.map(product, ProductOutput.class));
    }
    return outputList;
  }

  @Override
  public ProductOutput addOne(ProductInput input) {
    Product product = modelMapper.map(input, Product.class);
    productRepository.save(product);
    return modelMapper.map(product, ProductOutput.class);
  }


  @Override
  public void deleteOne(Long id) {
    // TODO impl
  }

  @Override
  public List<ProductOutput> getAllByName(String name, Pageable pageable) {
    return null;  // TODO impl
  }

  @Override
  public List<ProductOutput> getAllByCategoryId(Long categoryId) {
    return null;  // TODO impl
  }
}
