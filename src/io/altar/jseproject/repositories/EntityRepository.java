package io.altar.jseproject.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import io.altar.jseproject.model.Entity;

public abstract class EntityRepository<T extends Entity> {

	// Initializing
	private Map<Long, T> data = new HashMap<Long, T>();

	private long currentID = 0;

	// Methods
	private long nextID() {
		return currentID++;
	}

	public boolean emptyData() {
		if (data.isEmpty())
			return true;
		else
			return false;
	}

	public void save(T entity) {
		entity.setId(currentID);
		data.put(entity.getId(), entity);
		nextID();
	}

	public Iterator<T> findAll() {
		return data.values().iterator();
	}

	public T findById(Long id) {
		return data.get(id);
	}

	public void updateById(T entity) {
		data.replace(entity.getId(), entity);
	}

	public void removeById(Long id) {
		data.remove(id);
	}

}
