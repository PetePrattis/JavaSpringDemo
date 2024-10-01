package com.prattis.javaspringdemo.service;

import com.prattis.javaspringdemo.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public abstract class BaseServiceImpl<T extends BaseModel> {
	public abstract JpaRepository<T, Long> getRepository();
	
	public T create(T item) {
		return getRepository().save(item);
	}
	
	public List<T> createAll(List<T> items) {
		return getRepository().saveAll(items);
	}
	
	public List<T> createAll(T... items) {
		return createAll(Arrays.asList(items));
	}
	
	public void update(T item) {
		getRepository().save(item);
	}
	
	public void delete(T item) {
		getRepository().delete(item);
	}
	
	public void deleteById(Long id) {
		getRepository().deleteById(id);
	}
	
	// @Transactional(readOnly = true)
	public T get(Long id) {
		return getRepository().findById(id).get();//.orElseThrow(NoSuchElementException::new);
	}
	
	// @Transactional(readOnly = true)
	public boolean exists(T item) {
		return getRepository().existsById(item.getId());
	}
	
	// @Transactional(readOnly = true)
	public List<T> findAll() {
		return getRepository().findAll();
	}
}
