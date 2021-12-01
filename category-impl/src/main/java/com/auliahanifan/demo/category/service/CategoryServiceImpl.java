package com.auliahanifan.demo.category.service;

import com.auliahanifan.demo.category.dto.input.CategoryInput;
import com.auliahanifan.demo.category.dto.output.CategoryOutput;
import com.auliahanifan.demo.category.model.Category;
import com.auliahanifan.demo.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository categoryRepository;
  private ModelMapper modelMapper;

  @Autowired
  public void setModelMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public CategoryOutput getCategory(Long id) {
    Optional<Category> category = categoryRepository.findById(id);
    if (category.isEmpty()) {
      return null;
    }
    return modelMapper.map(category.get(), CategoryOutput.class);
  }

  @Override
  public List<CategoryOutput> getAllCategories(Pageable pageable) {
    List<Category> categoryList = IterableUtils.toList(categoryRepository.findAll(pageable));
    List<CategoryOutput> outputList = new ArrayList<>();
    for (Category category: categoryList) {
      outputList.add(modelMapper.map(category, CategoryOutput.class));
    }
    return outputList;
  }

  @Override
  public CategoryOutput addCategory(CategoryInput input) {
    Category categoryInit = modelMapper.map(input, Category.class);
    Category category = categoryRepository.save(categoryInit);
    return modelMapper.map(category, CategoryOutput.class);
  }

  @Override
  public void deleteCategory(Long id) {
    categoryRepository.deleteById(id);
  }

  @Override
  public List<CategoryOutput> getAllCategoriesByName(String name, Pageable pageable) {
    List<Category> categoryList = IterableUtils.toList(categoryRepository.findAllByNameContains(name, pageable));
    List<CategoryOutput> outputList = new ArrayList<>();
    for (Category category: categoryList) {
      outputList.add(modelMapper.map(category, CategoryOutput.class));
    }
    return outputList;
  }
}
