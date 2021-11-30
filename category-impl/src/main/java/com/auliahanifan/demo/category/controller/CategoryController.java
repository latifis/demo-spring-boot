package com.auliahanifan.demo.category.controller;

import com.auliahanifan.common.dto.BaseResponse;
import com.auliahanifan.demo.category.dto.input.CategoryInput;
import com.auliahanifan.demo.category.dto.output.CategoryOutput;
import com.auliahanifan.demo.category.model.Category;
import com.auliahanifan.demo.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
@Slf4j
public class CategoryController {
  private final CategoryService categoryService;

  @GetMapping("/{id}")
  public ResponseEntity<BaseResponse<CategoryOutput>> getCategory(@PathVariable("id") Long id) {
    CategoryOutput output = categoryService.getCategory(id);
    if (output.equals(null)) {
      log.error("Get Category Fail: ID" + id.toString());
      BaseResponse<CategoryOutput> response = new BaseResponse<>(null, "Failed to get category id " + id.toString(), false);
      return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(new BaseResponse<>(categoryService.getCategory(id)));
  }

  @GetMapping
  public ResponseEntity<BaseResponse<Iterable<Category>>> getAllCategories() {
    return ResponseEntity.ok(new BaseResponse<>(categoryService.getAllCategories()));
  }

  @PostMapping
  public ResponseEntity<BaseResponse<CategoryOutput>> addCategory(@Valid @RequestBody CategoryInput input) {
    return ResponseEntity.ok(new BaseResponse<>(categoryService.addCategory(input)));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<BaseResponse<?>> deleteCategory(@PathVariable Long id) {
    categoryService.deleteCategory(id);
    return ResponseEntity.ok(new BaseResponse<>(null));
  }

  @DeleteMapping
  public ResponseEntity<BaseResponse<?>> deleteAllCategories() {
    categoryService.deleteAllCategories();
    return ResponseEntity.ok(new BaseResponse<>(null));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ResponseBody
  public BaseResponse<?> handleValidationError(MethodArgumentNotValidException ex) {
    BindingResult bindingResult = ex.getBindingResult();
    FieldError fieldError = bindingResult.getFieldError();
    String defaultMessage = fieldError.getDefaultMessage();
    BaseResponse<?> response = new BaseResponse<>(null);
    response.setMessage(defaultMessage);
    response.setSuccess(false);
    return response;
  }
}
