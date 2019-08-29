package io.javabrains.springbootquickstart.imdbProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootquickstart.imdbProject.Bean.Actor;
import io.javabrains.springbootquickstart.imdbProject.Service.ActorService;
import io.javabrains.springbootquickstart.imdbProject.Service.ActorServiceImpl;

@RestController
public class ActorController {
	
	ActorService actionService = new ActorServiceImpl();
	@Autowired
	ActorServiceImpl actorserv;
	
	@RequestMapping(value="/actors",method=RequestMethod.GET)
	public List<Actor> getAllActors(){
		return actionService.getAllActors();
		
	}
	
	@RequestMapping(value="/actors/{id}",method=RequestMethod.GET)
	public Actor getActor(@PathVariable String id){
		return actionService.getActor(id);
	}
	
	
	@RequestMapping(value="/actors",method=RequestMethod.POST)
	public void addActor(@RequestBody Actor actor){
		actionService.addActor(actor);
	}
	
	
	@RequestMapping(value="/actors/{id}",method=RequestMethod.PUT)
	public void updateActor(@PathVariable String id,@RequestBody Actor actor){
		actionService.updateActor(id , actor);
	}
	
	
	@RequestMapping(value="/actors/{id}",method=RequestMethod.DELETE)
	public void deleteActor(@PathVariable String id){
		actionService.deleteActor(id);
	}
	
}
