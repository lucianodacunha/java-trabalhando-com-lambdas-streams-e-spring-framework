package io.github.lucianodacunha.autobuscar.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record VehicleData(
        @JsonAlias("TipoVeiculo") Integer type,
        @JsonAlias("Valor") String value,
        @JsonAlias("Marca") String brand,
        @JsonAlias("Modelo") String model,
        @JsonAlias("AnoModelo") Integer year,
        @JsonAlias("Combustivel") String fuel,
        @JsonAlias("CodigoFipe") String fipeCode,
        @JsonAlias("MesReferencia") String monthRef,
        @JsonAlias("SiglaCombustivel") String fuelCode) {}
