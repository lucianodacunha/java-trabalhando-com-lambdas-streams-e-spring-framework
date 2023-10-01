package io.github.lucianodacunha.autobuscar.main;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.lucianodacunha.autobuscar.model.*;
import io.github.lucianodacunha.autobuscar.service.ConsumerAPI;

import java.io.IOException;
import java.util.*;


public class Main {

    private Scanner input = new Scanner(System.in);
    private final String root_url;
    private final ConsumerAPI consumerAPI = new ConsumerAPI();

    public Main(){
        this.root_url = "https://parallelum.com.br/fipe/api/v1";
    }

    public void showMenu() throws IOException, InterruptedException {
        Optional<Data> choosedBrand = null;
        Optional<Data> choosedModel = null;
        ObjectMapper mapper = new ObjectMapper();

        var vehicle = "carros"; // input.nextLine();
        System.out.print("Enter the vehicle type: " + vehicle);
        System.out.println();
        String brandURL = String.format("%s/%s/%s",
                this.root_url, vehicle, "marcas");
        String brandJSON = consumerAPI.getData(brandURL);

        List<Data> brands = mapper.readValue(
                brandJSON, new TypeReference<List<Data>>(){});
        var orderedBrands = brands.stream()
                .sorted(Comparator.comparing(Data::code))
                .toList();

        try {
            choosedBrand = pagination(orderedBrands, "brand");
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        if (!choosedBrand.isPresent()){
            System.out.println("Code not found.");
            return;
        }

        String modelURL = String.format("%s/%s/%s/%d/%s",
                this.root_url, vehicle, "marcas", choosedBrand.get().code(),
                "modelos");
        String modelJSON = consumerAPI.getData(modelURL);
        ListData brandModels = mapper.readValue(modelJSON, ListData.class);
        var orderedModels = brandModels.models().stream()
                .sorted(Comparator.comparing(Data::code))
                .toList();

        try {
            choosedModel = pagination(orderedModels, "model");
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        String yearURL = String.format("%s/%s/%s/%d/%s/%d/%s/",
                this.root_url, vehicle, "marcas", choosedBrand.get().code(),
                "modelos", choosedModel.get().code(), "anos");
        String yearJSON = consumerAPI.getData(yearURL);


        List<YearData> years = mapper.readValue(
                yearJSON, new TypeReference<List<YearData>>(){});
        var orderedYears = years.stream()
                .sorted(Comparator.comparing(YearData::code))
                .toList();

        List<Vehicle> vehicles = new ArrayList<>();

        for(YearData year : orderedYears){
            String vehicleURL = String.format("%s/%s/%s/%d/%s/%d/%s/%s",
                    this.root_url, vehicle, "marcas", choosedBrand.get().code(),
                    "modelos", choosedModel.get().code(), "anos", year.code());
            String vehicleJSON = consumerAPI.getData(vehicleURL);
            VehicleData vehicleData = mapper.readValue(vehicleJSON, VehicleData.class);
            vehicles.add(new Vehicle(vehicleData));
        }

        System.out.printf("\n%-50s %-4s %15s %-8s\n",
                "MODEL", "YEAR", "VALUE", "FUEL");
        vehicles.forEach(System.out::println);
        input.close();
    }

    Optional<Data> pagination (List<Data> elements, String elementType){
        var index = 0;
        var pagination = true;
        var count = (long) elements.size();
        Optional<Data> choosedElement = null;

        while(pagination) {

            System.out.printf("%-5s %s\n", "CODE", elementType.toUpperCase());
            for (int i = 0; (i < 30 && index < count); i++ ){
                System.out.printf(
                        "%-5s %s\n",
                        elements.get(index).code().toString(),
                        elements.get(index).description());
                index += 1;
            }

            System.out.printf("\nEnter the %s code or type N to next page: ",
                    elementType);
            var code = input.nextLine();

            if (code.equalsIgnoreCase("n")){
                if (index >= count) {
                    System.out.printf("End of list. Do you Wish to restart [s/N]? ");
                    var restart = input.nextLine();
                    if (restart.equalsIgnoreCase("s")){
                        index = 0;
                    } else {
                        pagination = false;
                    }
                }
            } else {
                choosedElement = elements.stream()
                        .filter(b -> b.code().equals(Integer.valueOf(code)))
                        .findFirst();
                pagination = false;
            }
        }

        return choosedElement;
    }
}
