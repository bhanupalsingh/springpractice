package io.javabrains.springbootquickstart.imdbProject.Service;

import java.util.List;

import io.javabrains.springbootquickstart.imdbProject.Bean.Producer;

public interface ProducerService {

	List<Producer> getAllProducers();

	Producer getProducer(String id);

	void addProducer(Producer producer);

	void updateProducer(String id,Producer producer);

	void deleteProducer(String id);

}
