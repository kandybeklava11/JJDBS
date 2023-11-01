package Dao;

import Enums.Enums;
import Model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao {
    Connection connection = Config.Connection.getConnection();

    @Override
    public void creatEnumGenre() {

    }

    @Override
    public void creatTable() {
        String sql=
                "CREATE TABLE IF NOT EXISTS movies (" +
                        "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                        "title VARCHAR(255), " +
                        "director VARCHAR(255), " +
                        "release_year VARCHAR(4), " +
                        "genre VARCHAR(20), " +
                        "runtime INT" +
                        ")";

        Statement statement;
        try {
            statement=connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Table Successfully created!");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void insertMovie(Movie movie) {
        try {
            String sql = "INSERT INTO movies (title, director, release_year, genre, runtime) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getDirector());
            statement.setString(3, movie.getRleaseYear());
            statement.setString(4, movie.getGenre().name());
            statement.setInt(5, movie.getRuntime());
            statement.executeUpdate();
            System.out.println("Фильм успешно добавлен в базу данных.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Movie> getMovieByGenre(Enums genre) {
        List<Movie> moviesByGenre = new ArrayList<>();
        try {
            String sql = "SELECT * FROM movies WHERE genre = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, genre.name());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getLong("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setRleaseYear(resultSet.getString("release_year"));
                movie.setGenre(Enums.valueOf(resultSet.getString("genre")));
                movie.setRuntime(resultSet.getInt("runtime"));
                moviesByGenre.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moviesByGenre;
    }


    @Override
    public void deleteMovieById(Long Id) {
        try {
            String sql = "DELETE FROM movies WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, Id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Фильм успешно удален из базы данных.");
            } else {
                System.out.println("Фильм с указанным идентификатором не найден.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Movie> getMovieByRuntimeRange(int minRuntime, int maxRuntime) {
        List<Movie> moviesByRuntimeRange = new ArrayList<>();
        try {
            String sql = "SELECT * FROM movies WHERE runtime >= ? AND runtime <= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minRuntime);
            statement.setInt(2, maxRuntime);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getLong("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setRleaseYear(resultSet.getString("release_year"));
                movie.setGenre(Enums.valueOf(resultSet.getString("genre")));
                movie.setRuntime(resultSet.getInt("runtime"));
                moviesByRuntimeRange.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moviesByRuntimeRange;
    }

    @Override
    public List<Movie> getMovieSortByRleaseYear(String ascOrDesc) {
        List<Movie> sortedMovies = new ArrayList<>();
        try {
            String sql = "SELECT * FROM movies ORDER BY release_year " + ascOrDesc;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getLong("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setRleaseYear(resultSet.getString("release_year"));
                movie.setGenre(Enums.valueOf(resultSet.getString("genre")));
                movie.setRuntime(resultSet.getInt("runtime"));
                sortedMovies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sortedMovies;
    }
    }

