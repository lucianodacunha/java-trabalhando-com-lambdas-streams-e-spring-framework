package io.github.lucianodacunha.autobuscar.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Data(
        @JsonAlias("codigo") Integer code,
        @JsonAlias("nome") String description) {}
