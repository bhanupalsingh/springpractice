package io.javabrains.springbootquickstart.imdbProject.Service;

import java.util.List;

import io.javabrains.springbootquickstart.imdbProject.Bean.Actor;

public interface ActorService {

	List<Actor> getAllActors();

	Actor getActor(String id);

	void deleteActor(String id);

	void updateActor(String id , Actor actor);

	void addActor(Actor actor);

}
