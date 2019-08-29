package io.javabrains.springbootquickstart.imdbProject.Service;



import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootquickstart.imdbProject.Bean.Actor;
import io.javabrains.springbootquickstart.imdbProject.Repository.ActorRepository;
import io.javabrains.springbootquickstart.imdbProject.Repository.ActorRepository1;
import io.javabrains.springbootquickstart.imdbProject.Repository.ActorRepositoryCrud;


public class ActorServiceImpl implements ActorService {
	@Autowired
    private ActorRepositoryCrud actorRepositoryCrud;
	ActorRepository actionRepository = new ActorRepository();
	@Autowired
	ActorRepository1 actorRepository1 ; 
	public List<Actor> getAllActors() {
		return actionRepository.getAllActors();
	}

	public Actor getActor(String id) {
		return actionRepository.getActor(id);
	}

	public void deleteActor(String id) {
		actionRepository.deleteActor(id);
	}

	public void updateActor(String id , Actor actor) {
		if(actor.getDob() == null){
			actor.setDob("2015-03-31");
		}
		actionRepository.updateActor(id , actor);
	}

	public void addActor(Actor actor) {
		actor.setDob("2015-03-31");
		//actor.setActorId(1234);
		actor.setName("bhanu");
		actor.setBio("ramesh tendulkar");
		actor.setSex("male");
		actorRepositoryCrud.save(actor);
		//actorRepository1.actionInsertion(actor.getName(),actor.getSex(),actor.getDob(),actor.getBio());
		//actionRepository.addActor(actor);
	}
}
