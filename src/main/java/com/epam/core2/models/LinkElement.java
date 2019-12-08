package com.epam.core2.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkElement {
    private String href;

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String value) {
        this.href = value;
    }
}
