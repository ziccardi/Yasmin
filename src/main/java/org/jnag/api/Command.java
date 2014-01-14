package org.jnag.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Command {

    @JsonProperty
    private final long id;
    
    @JsonProperty
    private final String content;

    public Command(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
