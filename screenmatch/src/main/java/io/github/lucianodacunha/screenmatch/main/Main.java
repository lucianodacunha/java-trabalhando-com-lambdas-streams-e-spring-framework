package io.github.lucianodacunha.screenmatch.main;

import io.github.lucianodacunha.screenmatch.model.Episode;
import io.github.lucianodacunha.screenmatch.model.EpisodeData;
import io.github.lucianodacunha.screenmatch.model.SeasonData;
import io.github.lucianodacunha.screenmatch.model.SerieData;
import io.github.lucianodacunha.screenmatch.services.ConsumerAPI;
import io.github.lucianodacunha.screenmatch.services.DataConvert;
import io.github.lucianodacunha.screenmatch.util.GetAPIKey;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private Scanner input = new Scanner(System.in);
    private ConsumerAPI consumer = new ConsumerAPI();
    private final String root_url;
    private final String API_KEY;
    private DataConvert converter = new DataConvert();

    public Main(){
        this.root_url  = "https://www.omdbapi.com/?t=";
        this.API_KEY = GetAPIKey.getAPIKey();
    }

    public void showMenu(){
        System.out.print("Entre com o nome do título: ");
        var title = input.nextLine().replace(" ", "+");
        var url = String.format("%s%s&apikey=%s", root_url, title, API_KEY);

        var json = consumer.getData(url);
        SerieData data = converter.getData(json, SerieData.class);
        System.out.println(data);

        List<SeasonData> seasons = new ArrayList<>();

        for (int i = 1; i <= data.totalSeasons(); i++){
            url = String.format("%s%s&season=%d&apikey=%s",root_url , title, i, API_KEY);
            json = consumer.getData(url);
            SeasonData seasonDate = converter.getData(json, SeasonData.class);
            seasons.add(seasonDate);
        }

        seasons.forEach(System.out::println);

        seasons.forEach(t -> t.episodes().forEach(e -> System.out.println(e.title())));

        List<EpisodeData> episodeData = seasons.stream()
                .flatMap(t -> t.episodes().stream())
                .collect(Collectors.toList());

        System.out.println("\nTop 5 episodes");
        episodeData.stream()
                .filter(e -> !e.rating().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(EpisodeData::rating).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episode> episodios = seasons.stream()
                .flatMap(t -> t.episodes().stream()
                        .map(d -> new Episode(t.number(), d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        System.out.print("What year do you want to watch the episodes from? ");
        var ano = Integer.parseInt(input.nextLine());

        LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e -> e.getReleased() != null && e.getReleased().isAfter(dataBusca))
                .forEach(e -> System.out.println(
                        "Season:  " + e.getSeason() +
                                " Episode: " + e.getTitle() +
                                " Released: " + e.getReleased().format(formatador)));
    }
}
