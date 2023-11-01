package Service;

import Dao.MovieDao;
import Dao.MovieDaoImpl;
import Enums.Enums;
import Model.Movie;

import java.util.List;

public class MovieServiceImpl implements MovieService{
    MovieDaoImpl movieDao=new MovieDaoImpl();
    @Override
    public void creatEnumGenre() {
        movieDao.creatEnumGenre();
    }

    @Override
    public void creatTable() {
movieDao.creatEnumGenre();
    }

    @Override
    public void insertMovie(Movie movie) {
movieDao.insertMovie(movie);
    }

    @Override
    public List<Movie> getMovieByGenre(Enums genre) {
        return movieDao.getMovieByGenre(genre);
    }

    @Override
    public void deleteMovieById(Long Id) {
movieDao.deleteMovieById(Id);
    }

    @Override
    public List<Movie> getMovieByRuntimeRange(int minRuntime, int maxRuntime) {
        return movieDao.getMovieByRuntimeRange(minRuntime,maxRuntime);
    }

    @Override
    public List<Movie> getMovieSortByRleaseYear(String ascOrDesc) {
        return movieDao.getMovieSortByRleaseYear(ascOrDesc);
    }
}
