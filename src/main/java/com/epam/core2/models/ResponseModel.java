package com.epam.core2.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseModel {
    private Meta meta;
    private List<Result> result;

    @JsonProperty("_meta")
    public Meta getMeta() {
        return meta;
    }

    @JsonProperty("_meta")
    public void setMeta(Meta value) {
        this.meta = value;
    }

    @JsonProperty("result")
    public List<Result> getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(List<Result> value) {
        this.result = value;
    }
}
