package com.epam.core2.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RateLimit {
    private long limit;
    private long remaining;
    private long reset;

    @JsonProperty("limit")
    public long getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(long value) {
        this.limit = value;
    }

    @JsonProperty("remaining")
    public long getRemaining() {
        return remaining;
    }

    @JsonProperty("remaining")
    public void setRemaining(long value) {
        this.remaining = value;
    }

    @JsonProperty("reset")
    public long getReset() {
        return reset;
    }

    @JsonProperty("reset")
    public void setReset(long value) {
        this.reset = value;
    }
}
