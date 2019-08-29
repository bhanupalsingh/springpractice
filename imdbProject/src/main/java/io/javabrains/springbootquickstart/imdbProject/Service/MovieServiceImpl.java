package io.javabrains.springbootquickstart.imdbProject.Service;

import java.util.List;

import io.javabrains.springbootquickstart.imdbProject.Bean.Movie;
import io.javabrains.springbootquickstart.imdbProject.Repository.MovieRepository;

public class MovieServiceImpl implements MovieService {
 
	MovieRepository movieRepository = new MovieRepository();
	public List<Movie> getAllMovies() {
		return movieRepository.getAllMovies();
	}

	public Movie getMovie(String id) {
		return movieRepository.getMovie(id);
	}

	public void addMovie(Movie movie) {
		movieRepository.addMovie(movie);
	}

	public void updateMovie(String id , Movie movie) {
		movieRepository.updateMovie(id , movie);
	}

	public void deleteMovie(String id) {
		movieRepository.deleteMovie(id);
	}

}
