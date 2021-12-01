package com.auliahanifan.demo.category.repository;

import com.auliahanifan.demo.category.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
  Page<Category> findAllByNameContains(String name, Pageable pageableable);
}
