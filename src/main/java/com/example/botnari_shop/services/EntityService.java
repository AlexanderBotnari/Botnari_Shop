package com.example.botnari_shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.botnari_shop.entities.BaseEntity;
import com.example.botnari_shop.repositories.EntityRepository;

@Service
public class EntityService<T extends BaseEntity> {

	@Autowired
	private EntityRepository<T> repository;

	public List<T> all(){
		return repository.findAll();
	}
	public List<T> allByType(String type){
		return repository.findAllByType(type);
	}
	
	public T find(Integer id){
		return (T) repository.findById(id).get();
	}
	
	public T save (T entity) {
		repository.save(entity);
		return entity;
	}
	
	public T delete(Integer id) {
	    T entity = repository.findById(id).get();
	    repository.delete(entity);
	    return entity;
	}
	
	public T delete(T entity) {
		T entityFromDb = repository.findById(entity.getId()).get();
	    repository.delete(entity);
	    return entityFromDb;
	}
}
