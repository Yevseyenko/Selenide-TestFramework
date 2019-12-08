package com.epam.core2.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {
    private LinkElement self;
    private LinkElement edit;
    private LinkElement avatar;

    @JsonProperty("self")
    public LinkElement getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(LinkElement value) {
        this.self = value;
    }

    @JsonProperty("edit")
    public LinkElement getEdit() {
        return edit;
    }

    @JsonProperty("edit")
    public void setEdit(LinkElement value) {
        this.edit = value;
    }

    @JsonProperty("avatar")
    public LinkElement getAvatar() {
        return avatar;
    }

    @JsonProperty("avatar")
    public void setAvatar(LinkElement value) {
        this.avatar = value;
    }
}
