package com.example.apiHelpers.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {
    @Override
    public String toString() {
        return "Resource{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }

    @JsonProperty("data")
    private DataResource data;
    @JsonProperty("support")
    private SupportResponce support;

    public DataResource getData() {
        return data;
    }

    public SupportResponce getSupport() {
        return support;
    }

}
