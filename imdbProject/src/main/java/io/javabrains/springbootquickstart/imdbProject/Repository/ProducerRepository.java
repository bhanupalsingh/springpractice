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
import io.javabrains.springbootquickstart.imdbProject.Bean.Producer;

public class ProducerRepository {


	
	public List<Producer> getAllProducers() {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    ArrayList<Producer> producers = new ArrayList<Producer>();
        
	    try {
	        query = "Select * from Producer";
	        statement = connection.prepareStatement(query);
	        ResultSet resultset=statement.executeQuery();
	        while (resultset.next()) {
	            Producer producer = new Producer();
	            producer.setProducerId(resultset.getInt("producerId"));
	            producer.setName(resultset.getString("name"));
	            producer.setSex(resultset.getString("sex"));
	            producer.setDob(resultset.getString("dob"));
	            producer.setBio(resultset.getString("bio"));
	            producers.add(producer);
	        }
	        
	    }
	    catch(SQLException e){
	    	System.out.println(e.getMessage());
	    }
	    finally {
	        Utility.closeClosable(statement);
	        Utility.closeClosable(connection);
	    }
	    return producers;
	}

	public Producer getProducer(String id) {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    Producer producer = new Producer();
	    
	    try {
	        query = "select * from Producer where producerId = ?";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, Integer.parseInt(id));
	        ResultSet resultset = statement.executeQuery();
	        if(resultset.next()){
	            producer.setProducerId(Integer.parseInt(id));
	            producer.setName(resultset.getString("name"));
	            producer.setSex(resultset.getString("sex"));
	            producer.setDob(resultset.getString("dob"));
	            producer.setBio(resultset.getString("bio"));
	        }
	    }
	    catch(SQLException e){
	    	System.out.println(e.getMessage());
	    }
	    finally {
	        Utility.closeClosable(statement);
	        Utility.closeClosable(connection);
	    }
		return producer;
	}

	public void deleteProducer(String id) {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    try {
	        query = "delete from Producer where producerId = ?";
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

	public void updateProducer(String id , Producer producer) {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    try {
	        query = "update Producer  set name = ? , sex = ? , dob = ? , bio = ?  where producerId = ?";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, producer.getName());
	        statement.setString(2, producer.getSex());
	        statement.setDate(3, producer.getDob());
	        statement.setString(4, producer.getBio());
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

	public void addProducer(Producer producer) {
		ConnectionCustom conn = new ConnectionCustom();
		Connection connection = conn.connect();
		String query = null;
	    PreparedStatement statement = null;
	    try {
	    	query = "select max(producerId) as producerId from Producer";
	    	statement = connection.prepareStatement(query);
	    	ResultSet resultset = statement.executeQuery();
	    	int a =1 ;
	    	if(resultset.next()){
	    		String str = resultset.getString("producerId");
	    		if(str != null ){
	    			a = Integer.parseInt(str)+1;
	    		}else{
	    			a = 1;
	    		}
	      	}
	    	System.out.println("last added primary key value is"+a);
	    	query = "insert into Producer values (?,?,?,?,?)";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, a);
	        statement.setString(2, producer.getName());
	        statement.setString(3, producer.getSex());
	        statement.setDate(4, producer.getDob());
	        statement.setString(5, producer.getBio());
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
