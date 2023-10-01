package io.github.lucianodacunha.autobuscar.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListData(
        @JsonAlias("modelos") List<Data> models) {}