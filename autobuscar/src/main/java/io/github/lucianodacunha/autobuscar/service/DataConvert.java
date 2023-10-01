package io.github.lucianodacunha.autobuscar.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConvert implements IDataConvert {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> claz) {
        try {
            return mapper.readValue(json, claz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
