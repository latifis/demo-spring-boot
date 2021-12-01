package com.auliahanifan.demo.category.service;

import com.auliahanifan.demo.category.dto.input.CategoryInput;
import com.auliahanifan.demo.category.dto.output.CategoryOutput;
import com.auliahanifan.demo.category.model.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

  CategoryOutput getCategory(Long id);

  List<CategoryOutput> getAllCategories(Pageable pageable);

  CategoryOutput addCategory(CategoryInput input);

  void deleteCategory(Long id);

  List<CategoryOutput> getAllCategoriesByName(String name, Pageable pageable);
}
