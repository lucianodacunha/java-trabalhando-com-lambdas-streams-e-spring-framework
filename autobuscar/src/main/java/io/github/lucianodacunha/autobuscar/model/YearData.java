package io.github.lucianodacunha.autobuscar.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record YearData(
        @JsonAlias("codigo") String code,
        @JsonAlias("nome") String description) {}
