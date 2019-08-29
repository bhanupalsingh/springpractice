package io.javabrains.springbootquickstart.imdbProject.Repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.javabrains.springbootquickstart.imdbProject.Bean.Actor;

public interface ActorRepository1 extends JpaRepository<Actor, Integer> {
	
	/*@Query("insert into Actor (name,sex,dob,bio) values(:name,:sex,:dob,:bio)")
    public int actionInsertion(@Param("name") String name,@Param("sex") String sex,@Param("dob") Date dob,@Param("bio") String bio);
*/
	
}
