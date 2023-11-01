package Dao;

import Enums.Enums;
import Model.Movie;

import java.util.List;

public interface MovieDao {
 void creatEnumGenre();
 void creatTable();
 void insertMovie(Movie movie);
 List<Movie> getMovieByGenre(Enums genre);
 void deleteMovieById(Long Id);
 List<Movie> getMovieByRuntimeRange(int minRuntime,int maxRuntime);
 List<Movie> getMovieSortByRleaseYear(String ascOrDesc);
}
