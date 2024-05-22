package com.erayerm.ecommercebackend.exceptions;

//Http Status Code
//200 => OK (200 -> get, 201 -> post)
//400 => Bad Request, Client exceptions
//500 => Server Errors

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductErrorResponse {
    private Integer status;
    private String message;
    private Long timestamp;
}
