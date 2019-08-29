package io.javabrains.springbootquickstart.imdbProject.Service;

import java.sql.Date;
import java.util.List;

import io.javabrains.springbootquickstart.imdbProject.Bean.Producer;
import io.javabrains.springbootquickstart.imdbProject.Repository.ProducerRepository;

public class ProducerServiceImpl implements ProducerService{

	ProducerRepository producerRepository = new ProducerRepository();
	public List<Producer> getAllProducers() {
		return producerRepository.getAllProducers();
	}

	public Producer getProducer(String id) {
		return producerRepository.getProducer(id);
	}

	public void addProducer(Producer producer) {
		if(producer.getDob() == null){
			producer.setDob("2015-03-31");
		}
		producerRepository.addProducer(producer);
	}

	public void updateProducer(String id , Producer producer) {
		if(producer.getDob() == null){
			producer.setDob("2015-03-31");
		}
		producerRepository.updateProducer(id,producer);
	}

	public void deleteProducer(String id) {
		producerRepository.deleteProducer(id);
	}

}
