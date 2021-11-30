package com.auliahanifan.demo.category.service;

import com.auliahanifan.demo.category.dto.input.CategoryInput;
import com.auliahanifan.demo.category.dto.output.CategoryOutput;
import com.auliahanifan.demo.category.model.Category;

public interface CategoryService {

  CategoryOutput getCategory(Long id);

  Iterable<Category> getAllCategories();

  CategoryOutput addCategory(CategoryInput input);

  void deleteCategory(Long id);

  void deleteAllCategories();
}
