package com.scb.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserNotFoundException extends Exception {
    String errorCode;
    String errorMessage;
}
