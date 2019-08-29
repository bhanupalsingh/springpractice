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




public class ActorRepository {
	
	
	public List<Actor> getAllActors() {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    ArrayList<Actor> actors = new ArrayList<Actor>();
        
	    try {
	        query = "Select * from Actor";
	        statement = connection.prepareStatement(query);
	        ResultSet resultset=statement.executeQuery();
	        while (resultset.next()) {
	            Actor actor = new Actor();
	            actor.setActorId(resultset.getInt("actorId"));
	            actor.setName(resultset.getString("name"));
	            actor.setSex(resultset.getString("sex"));
	            actor.setDob(resultset.getString("dob"));
	            actor.setBio(resultset.getString("bio"));
	            actors.add(actor);
	        }
	        
	    }
	    catch(SQLException e){
	    	System.out.println(e.getMessage());
	    }
	    finally {
	        Utility.closeClosable(statement);
	        Utility.closeClosable(connection);
	    }
	    return actors;
	}

	public Actor getActor(String id) {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
    	Actor actor = new Actor();
	    
	    try {
	        query = "select * from Actor where actorId = ?";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, Integer.parseInt(id));
	        ResultSet resultset = statement.executeQuery();
	        if(resultset.next()){
	            actor.setActorId(Integer.parseInt(id));
	            actor.setName(resultset.getString("name"));
	            actor.setSex(resultset.getString("sex"));
	            actor.setDob(resultset.getString("dob"));
	            actor.setBio(resultset.getString("bio"));
	        }
	    }
	    catch(SQLException e){
	    	System.out.println(e.getMessage());
	    }
	    finally {
	        Utility.closeClosable(statement);
	        Utility.closeClosable(connection);
	    }
		return actor;
	}

	public void deleteActor(String id) {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    try {
	        query = "delete from Action where actorId = ?";
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

	public void updateActor(String id , Actor actor) {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    try {
	        query = "update Actor  set name = ? , sex = ? , dob = ? , bio = ?  where actorId = ?";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, actor.getName());
	        statement.setString(2, actor.getSex());
	        statement.setDate(3, actor.getDob());
	        statement.setString(4, actor.getBio());
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

	public void addActor(Actor actor) {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    try {
	    	query = "insert into Actor values (?,?,?,?)";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, actor.getName());
	        statement.setString(2, actor.getSex());
	        statement.setDate(3, (Date) actor.getDob());
	        statement.setString(4, actor.getBio());
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
