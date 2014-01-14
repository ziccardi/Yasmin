package org.jnag.api;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NagiosConfiguration {
    @JsonProperty
    private String name;
    
    @JsonProperty
    private Map<String, Object> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }
    
    
}
