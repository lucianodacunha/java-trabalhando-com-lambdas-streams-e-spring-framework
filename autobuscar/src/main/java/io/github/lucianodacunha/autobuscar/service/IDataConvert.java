package io.github.lucianodacunha.autobuscar.service;

public interface IDataConvert {
    <T> T  getData(String json, Class<T> classe);
}

