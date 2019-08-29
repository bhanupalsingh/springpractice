package io.javabrains.springbootquickstart.imdbProject.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.springbootquickstart.imdbProject.Bean.Actor;




@Repository
public interface ActorRepositoryCrud extends CrudRepository<Actor, Integer> {

}