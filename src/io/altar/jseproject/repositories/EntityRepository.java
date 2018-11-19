package io.altar.jseproject.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import io.altar.jseproject.model.Entity;

public abstract class EntityRepository <T extends Entity>{
	
	private Map<Long, T> baseDeDados = new HashMap<Long, T>();
	
	private long currentID=0;
	
	private long nextID() {
		return currentID++;
	}
	
	public void save(T entity) {
		entity.setId(currentID);
		baseDeDados.put(entity.getId(),entity);
		nextID();
	}
	
	public Iterator<T> findAll() {
		return baseDeDados.values().iterator();
	}

	public T findById(Long id) {
		return baseDeDados.get(id);
	}
	
	public void updateById(T entity) {
		baseDeDados.replace(entity.getId(), entity);
	}
	
	public void removeById(Long id) {
		baseDeDados.remove(id);
	}
}
