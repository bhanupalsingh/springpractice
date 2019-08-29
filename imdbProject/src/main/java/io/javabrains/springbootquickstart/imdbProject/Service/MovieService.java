package io.javabrains.springbootquickstart.imdbProject.Service;

import java.util.List;

import io.javabrains.springbootquickstart.imdbProject.Bean.Movie;

public interface MovieService {

	List<Movie> getAllMovies();

	Movie getMovie(String id);

	void addMovie(Movie movie);

	void updateMovie(String id , Movie movie);

	void deleteMovie(String id);

}
