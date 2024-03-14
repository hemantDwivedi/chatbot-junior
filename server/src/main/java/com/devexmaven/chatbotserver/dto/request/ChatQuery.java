package com.devexmaven.chatbotserver.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatQuery {
    @JsonProperty("Query")
    private String query;

    public ChatQuery() {
    }

    public ChatQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
