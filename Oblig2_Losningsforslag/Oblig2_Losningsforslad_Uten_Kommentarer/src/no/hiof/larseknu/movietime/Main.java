package no.hiof.larseknu.movietime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        TvSerie strangerThings = new TvSerie("Stranger Things", "When a young boy disappears, his mother, a police chief, and his friends must confront terrifying forces in order to get him back.", LocalDate.of(2016, 7,15));

        Episode episode1 = new Episode(1, 1, "Chapter One: The Vanishing of Will Byers", 50);
        Episode episode2 = new Episode(2, 1, "Chapter Two: The Weirdo on Maple Street", 50);
        Episode episode3 = new Episode(3, 1, "Chapter Three: Holly, Jolly", 50);
        Episode episode4 = new Episode(4, 1, "Chapter Four: The Body", 50);

        strangerThings.leggTilEpisode(episode1);
        strangerThings.leggTilEpisode(episode2);
        strangerThings.leggTilEpisode(episode3);
        strangerThings.leggTilEpisode(episode4);

        strangerThings.leggTilEpisode(new Episode(1, 2, "Chapter One: MADMAX", 50));
        strangerThings.leggTilEpisode(new Episode(2, 2, "Chapter Two: Trick or Treat, Freak", 50));
        strangerThings.leggTilEpisode(new Episode(3, 2, "Chapter Three: The Pollywog", 50));


        ArrayList<Episode> episodeListe = strangerThings.getEpisodeListe();

        System.out.println("******************************");

        System.out.println(strangerThings);
        System.out.println("------------------------------");

        for (Episode episode : episodeListe) {
            System.out.println(episode);
        }

        System.out.println("******************************");

        TvSerie gameOfThrones = new TvSerie("Game of Thrones", "They are in a game for the throne.", LocalDate.of(2011, 4, 11));

        Random randomTallGenerator = new Random();

        for (int sesongNr = 1; sesongNr <= 5; sesongNr++) {
            for (int episodeNr = 1; episodeNr <= 20; episodeNr++) {

                gameOfThrones.leggTilEpisode(new Episode(episodeNr, sesongNr, "Generic Title ", randomTallGenerator.nextInt(11) + 20));
            }
        }

        ArrayList<Episode> gameOfThronesSesong4Episoder = gameOfThrones.hentEpisoderISesong(4);

        System.out.println("******************************");

        System.out.println(gameOfThrones);
        System.out.println("Gjennomsnittligspilletid ");
        System.out.println("------------------------------");

        for (Episode episode : gameOfThronesSesong4Episoder) {
            System.out.println(episode);
        }

        System.out.println("******************************");

        gameOfThrones.leggTilEpisode(new Episode(1, 10, "EpisodeISesong10", 50));
    }
}
