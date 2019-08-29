package io.javabrains.springbootquickstart.imdbProject.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootquickstart.imdbProject.Bean.Producer;
import io.javabrains.springbootquickstart.imdbProject.Service.ProducerService;
import io.javabrains.springbootquickstart.imdbProject.Service.ProducerServiceImpl;

@RestController
public class ProducerController {

	ProducerService producerService = new ProducerServiceImpl();
	
	@RequestMapping(value="/producers",method=RequestMethod.GET)
	public List<Producer> getAllProducers(){
		return producerService.getAllProducers();
	}
	@RequestMapping(value="/producers/{id}",method=RequestMethod.GET)
	public Producer getProducer(@PathVariable String id){
		return producerService.getProducer(id);
	}
	@RequestMapping(value="/producers",method=RequestMethod.POST)
	public void addProducer(@RequestBody Producer producer){
		producerService.addProducer(producer);
	}
	@RequestMapping(value="/producers/{id}",method=RequestMethod.PUT)
	public void updateProducer(@PathVariable String  id,@RequestBody Producer producer){
		producerService.updateProducer(id,producer);
	}
	@RequestMapping(value="/producers/{id}",method=RequestMethod.DELETE)
	public void deleteProducer(@PathVariable String id){
		producerService.deleteProducer(id);
	}
}
