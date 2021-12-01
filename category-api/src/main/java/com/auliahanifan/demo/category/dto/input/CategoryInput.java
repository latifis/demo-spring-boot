package com.auliahanifan.demo.category.dto.input;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryInput {

  @NotBlank(message = "Name is mandatory")
  @Size(min=2, max=30, message = "Name Minimal 2, Max 30")
  @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$", message = "Name Only Alphabet")
  private String name;
}
