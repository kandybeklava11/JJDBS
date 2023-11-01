package org.example;

import Enums.Enums;
import Model.Movie;
import Service.MovieServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        MovieServiceImpl movieService=new MovieServiceImpl();
       Movie movie=new Movie();
        int sss = 0;
        do {

            System.out.println("1-> Creat Table" +
                    "\n2-> Insert movie" +
                    "\n3-> Get movie by genre" +
                    "\n4-> Delete movie by id" +
                    "\n5-> Get Movie by runtime range" +
                    "\n6-> Get movie sort by rlease year");

            sss = scanner.nextInt();
            switch (sss) {
                case 1:
                    movieService.creatTable();
                    break;
                case 2:
                    System.out.println("Enter movie details:");
                    System.out.print("Title: ");
                    String title = scanner.next();
                    System.out.print("Runtime: ");
                    int runtime = scanner.nextInt();

                    movie.setTitle(title);
                    movie.setGenre(Enums.DRAMA);
                    movie.setRuntime(runtime);

                    movieService.insertMovie(movie);
                    movieService.insertMovie(movie);
                    break;
                case 3:
                    movieService.getMovieByGenre(Enums.DRAMA);
                    break;
                case 4:
                    System.out.print("Enter movie id: ");
                    long movieId = scanner.nextLong();
                    movieService.deleteMovieById(movieId);
                    break;
                case 5:
                    System.out.print("Enter minimum runtime: ");
                    int minRuntime = scanner.nextInt();
                    System.out.print("Enter maximum runtime: ");
                    int maxRuntime = scanner.nextInt();
                    movieService.getMovieByRuntimeRange(minRuntime,maxRuntime);
                    break;
                case 6:

                    System.out.print("Enter sorting order (ASC/DESC): ");
                    String sortOrder = scanner.next().toUpperCase();
                    List<Movie> sortedMovies = movieService.getMovieSortByRleaseYear(sortOrder);
                    if (!sortedMovies.isEmpty()) {
                        System.out.println("Movies sorted by release year:");
                        for (Movie movie1 : sortedMovies) {
                            System.out.println(movie1);
                        }
                    } else {
                        System.out.println("No movies found.");
                    }
                    break;
                default:
                    System.out.println("Error!!!");
            }
        }while (sss != 7) ;
    }
    }

