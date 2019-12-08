package com.epam.core2.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
    private boolean success;
    private long code;
    private String message;
    private long totalCount;
    private long pageCount;
    private long currentPage;
    private long perPage;
    private RateLimit rateLimit;

    @JsonProperty("success")
    public boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(boolean value) {
        this.success = value;
    }

    @JsonProperty("code")
    public long getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(long value) {
        this.code = value;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String value) {
        this.message = value;
    }

    @JsonProperty("totalCount")
    public long getTotalCount() {
        return totalCount;
    }

    @JsonProperty("totalCount")
    public void setTotalCount(long value) {
        this.totalCount = value;
    }

    @JsonProperty("pageCount")
    public long getPageCount() {
        return pageCount;
    }

    @JsonProperty("pageCount")
    public void setPageCount(long value) {
        this.pageCount = value;
    }

    @JsonProperty("currentPage")
    public long getCurrentPage() {
        return currentPage;
    }

    @JsonProperty("currentPage")
    public void setCurrentPage(long value) {
        this.currentPage = value;
    }

    @JsonProperty("perPage")
    public long getPerPage() {
        return perPage;
    }

    @JsonProperty("perPage")
    public void setPerPage(long value) {
        this.perPage = value;
    }

    @JsonProperty("rateLimit")
    public RateLimit getRateLimit() {
        return rateLimit;
    }

    @JsonProperty("rateLimit")
    public void setRateLimit(RateLimit value) {
        this.rateLimit = value;
    }
}
