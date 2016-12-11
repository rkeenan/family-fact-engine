package com.fact.engine.model;

import java.util.Map;

/**
 * Created by Ryan on 12/11/2016.
 */
public class Request {
    private String fullInput;
    private Map<String, Object> result;

    public Request() {

    }

    public Request(String fullInput,  Map<String, Object> result) {
        this.fullInput = fullInput;
        this.result = result;
    }

    public String getFullInput() {
        return fullInput;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setFullInput(String fullInput) {

        this.fullInput = fullInput;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
