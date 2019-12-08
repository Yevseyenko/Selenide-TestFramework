package com.epam.core2.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private Object dob;
    private String email;
    private Object phone;
    private Object website;
    private Object address;
    private String status;
    private Links links;

    @JsonProperty("id")
    public String getID() {
        return id;
    }

    @JsonProperty("id")
    public void setID(String value) {
        this.id = value;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String value) {
        this.firstName = value;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String value) {
        this.lastName = value;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String value) {
        this.gender = value;
    }

    @JsonProperty("dob")
    public Object getDob() {
        return dob;
    }

    @JsonProperty("dob")
    public void setDob(Object value) {
        this.dob = value;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String value) {
        this.email = value;
    }

    @JsonProperty("phone")
    public Object getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(Object value) {
        this.phone = value;
    }

    @JsonProperty("website")
    public Object getWebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setWebsite(Object value) {
        this.website = value;
    }

    @JsonProperty("address")
    public Object getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Object value) {
        this.address = value;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String value) {
        this.status = value;
    }

    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links value) {
        this.links = value;
    }
}
