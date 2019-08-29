package io.javabrains.springbootquickstart.imdbProject.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.javabrains.springbootquickstart.imdbProject.ConnectionCustom;
import io.javabrains.springbootquickstart.imdbProject.Utility;
import io.javabrains.springbootquickstart.imdbProject.Bean.Actor;
import io.javabrains.springbootquickstart.imdbProject.Bean.Movie;

public class MovieRepository {

	public List<Movie> getAllMovies() {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    ArrayList<Movie> movies = new ArrayList<Movie>();
        
	    try {
	        query = "Select * from Movie";
	        statement = connection.prepareStatement(query);
	        ResultSet resultset=statement.executeQuery();
	        while (resultset.next()) {
	            Movie movie = new Movie();
	            movie.setMovieId(resultset.getInt("movieId"));
	            movie.setName(resultset.getString("name"));
	            movie.setYear(resultset.getString("year"));
	            movie.setGenre(resultset.getString("genre"));
	            movie.setPoster(resultset.getString("poster"));
	            movies.add(movie);
	        }
	        
	    }
	    catch(SQLException e){
	    	System.out.println(e.getMessage());
	    }
	    finally {
	        Utility.closeClosable(statement);
	        Utility.closeClosable(connection);
	    }
	    return movies;
	}

	public Movie getMovie(String id) {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
    	Movie movie = new Movie();
	    
	    try {
	        query = "select * from Movie where movieId = ?";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, Integer.parseInt(id));
	        ResultSet resultset = statement.executeQuery();
	        if(resultset.next()){
	            movie.setMovieId(Integer.parseInt(id));
	            movie.setName(resultset.getString("name"));
	            movie.setYear(resultset.getString("year"));
	            movie.setGenre(resultset.getString("genre"));
	            movie.setPoster(resultset.getString("poster"));
	        }
	    }
	    catch(SQLException e){
	    	System.out.println(e.getMessage());
	    }
	    finally {
	        Utility.closeClosable(statement);
	        Utility.closeClosable(connection);
	    }
		return movie;
	}

	public void deleteMovie(String id) {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    try {
	        query = "delete from Movie where movieId = ?";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, Integer.parseInt(id));
	        statement.execute();
	    }
	    catch(SQLException e){
	    	System.out.println(e.getMessage());
	    }
	    finally {
	        Utility.closeClosable(statement);
	        Utility.closeClosable(connection);
	    }
	}

	public void updateMovie(String id , Movie movie) {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    try {
	        query = "update Movie  set name = ? , year = ? , genre = ? , poster = ?  where movieId = ?";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, movie.getName());
	        statement.setString(2, movie.getYear());
	        statement.setString(3, movie.getGenre());
	        statement.setString(4, movie.getPoster());
	        statement.setInt(5, Integer.parseInt(id));
	        int a = statement.executeUpdate();
	        if(a>-1){
	        	System.out.println("succcessfully updated");
	        }else{
	        	System.out.println("error while updating data");
	        }
	    }
	    catch(SQLException e){
	    	System.out.println(e.getMessage());
	    }
	    finally {
	        Utility.closeClosable(statement);
	        Utility.closeClosable(connection);
	    }
	}

	public void addMovie(Movie movie) {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    try {
	    	query = "select max(movieId) as movieId from Movie";
	    	statement = connection.prepareStatement(query);
	    	ResultSet resultset = statement.executeQuery();
	    	int a =1 ;
	    	if(resultset.next()){
	    		String str = resultset.getString("movieId");
	    		if(str != null ){
	    			a = Integer.parseInt(str)+1;
	    		}else{
	    			a = 1;
	    		}
	      	}
	    	System.out.println("last added primary key value is"+a);
	    	query = "insert into Movie values (?,?,?,?,?)";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, a);
	        statement.setString(2, movie.getName());
	        statement.setString(3, movie.getYear());
	        statement.setString(4, movie.getGenre());
	        statement.setString(5, movie.getPoster());
	        statement.execute();
	    }
	    catch(SQLException e){
	    	System.out.println(e.getMessage());
	    }
	    finally {
	        Utility.closeClosable(statement);
	        Utility.closeClosable(connection);
	    }
	}

}
