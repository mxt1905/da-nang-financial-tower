package com.uit.danangfinancialtower.service;

import com.uit.danangfinancialtower.exception.BaseException;
import lombok.extern.slf4j.Slf4j;

/**
 * BaseService
 */
@Slf4j
public abstract class BaseService<I, O> {

    protected I input;

    @SuppressWarnings("unchecked")
    public <T extends BaseService<I, O>> T setInput(I input) {
        this.input = input;
        return (T) this;
    }

    /**
     * validate input
     * Use to validate input: check null and assign default values if any
     */
    protected void validateInput() {
    }

    protected abstract O setOutput();

    public O execute() {
        try {
            this.validateInput();
            log.info("Validate input successfully!");
            return this.setOutput();
        } catch (BaseException e) {
            log.info("Throw exception");
            throw e;
        }
    }
}
