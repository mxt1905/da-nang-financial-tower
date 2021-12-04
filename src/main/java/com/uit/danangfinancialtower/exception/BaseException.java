package com.uit.danangfinancialtower.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseException
 */
@Getter
public class BaseException extends RuntimeException {

    private final String errorCode;
    private List<String> errorFields = new ArrayList<>();
    private final Object[] arguments;

    public BaseException(String errorCode, Object... arguments) {
        this.errorCode = errorCode;
        this.arguments = arguments;
    }

    public BaseException(String errorCode, List<String> errorFields, Object... arguments) {
        this(errorCode, arguments);
        this.errorFields = errorFields;
    }
}
