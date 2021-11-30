package com.auliahanifan.common.dto;

import lombok.Data;

@Data
public class BaseResponse<T> {
  private Boolean success = true;
  private String message = "Operation success";
  private T data;

  public BaseResponse(T data) {
    this.data = data;
  }

  public BaseResponse(T data, String message, Boolean success) {
    this.data = data;
    this.message = message;
    this.success = success;
  }

  public BaseResponse() {

  }
}
