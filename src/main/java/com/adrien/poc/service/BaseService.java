package com.adrien.poc.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * This class is the main service that access all the basic method from spring data
 * 
 * @author adurand
 * @param <T> the entity
 * @param <A> the repository related to the entity
 */
public class BaseService<T, A extends MongoRepository<T, Long>> {

	// The repository
	protected A repo;
	// The logger
	protected Logger logger;

	/**
	 * Constructor of the class that initialize the repository and the logger
	 * 
	 * @param repo
	 * @param logger
	 */
	public BaseService(A repo, Logger logger) {
		this.repo = repo;
		this.logger = logger;
	}

	/**
	 * This method save an entity
	 * 
	 * @param entity to be saved
	 * @return an entity
	 */
	public T save(T entity) {
		logger.debug("Save: {}", entity.toString());
		return repo.save(entity);
	}

	/**
	 * This method delete all entities
	 */
	public void deleteAll() {
		logger.debug("Delete all");
		repo.deleteAll();
	}

	/**
	 * This method delete an entity
	 * 
	 * @param entity to be deleted
	 */
	public void delete(T entity) {
		logger.debug("Delete: " + entity.toString());
		repo.delete(entity);
	}

	/**
	 * This method delete an entity by his id
	 * 
	 * @param id to be deleted
	 */
	public void deleteOne(Long id) {
		logger.debug("Id to delete: {}", id);
		repo.delete(id);
	}

	/**
	 * This method return all the entities
	 * 
	 * @return a list of entities
	 */
	public List<T> findAll() {
		logger.debug("Find all");
		return repo.findAll();
	}

	/**
	 * This method return an entity by his id
	 * 
	 * @param id to be returned
	 * @return an entity
	 */
	public T findOne(Long id) {
		logger.debug("Find with id: {}", id);
		return repo.findOne(id);
	}
}
