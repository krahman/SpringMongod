package us.coderscamp.blog.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import us.coderscamp.blog.model.Car;

@Repository
public class CarService {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "car";
	
	public void addCar(Car car){
		if(!mongoTemplate.collectionExists(Car.class)){
			mongoTemplate.createCollection(Car.class);
		}
		car.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(car, COLLECTION_NAME);
	}
	
	public List<Car> listCar(){
		return mongoTemplate.findAll(Car.class, COLLECTION_NAME);
	}
	
	public void deleteCar(Car car){
		mongoTemplate.remove(car, COLLECTION_NAME);
	}
	
	public void updateCar(Car car){
		mongoTemplate.insert(car, COLLECTION_NAME);
	}
}
