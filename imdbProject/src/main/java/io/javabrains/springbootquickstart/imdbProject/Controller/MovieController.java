package io.javabrains.springbootquickstart.imdbProject.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootquickstart.imdbProject.Bean.Movie;
import io.javabrains.springbootquickstart.imdbProject.Service.MovieService;
import io.javabrains.springbootquickstart.imdbProject.Service.MovieServiceImpl;

@RestController
public class MovieController {

	MovieService movieService = new MovieServiceImpl();
	
	@RequestMapping(value="/movies",method=RequestMethod.GET)
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}
	@RequestMapping(value="/movies/{id}",method=RequestMethod.GET)
	public Movie getMovie(@PathVariable String id){
		return movieService.getMovie(id);
	}
	@RequestMapping(value="/movies",method=RequestMethod.POST)
	public void addMovie(@RequestBody Movie movie){
		movieService.addMovie(movie);
	}
	@RequestMapping(value="/movies/{id}",method=RequestMethod.PUT)
	public void updateMovie(@PathVariable String id,@RequestBody Movie movie){
		movieService.updateMovie(id , movie);
	}
	@RequestMapping(value="/movies/{id}",method=RequestMethod.DELETE)
	public void deleteMovie(@PathVariable String id){
		movieService.deleteMovie(id);
	}
}
