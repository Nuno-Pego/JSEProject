package io.altar.jseproject.repositories;

import java.util.ArrayList;
//Imports:
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import io.altar.jseproject.model.Entity;

//Abstract Class - Data Base CRUD
public abstract class EntityRepository <T extends Entity> {
	
	// Fields:
	private Map<Long, T>  baseDeDados = new HashMap<Long, T>();
	private long actualID = 0;
	
	
	// Size of DataBase
	public int lenghtData(){
		return baseDeDados.size();
	}
	
	// Get ID:
	public long getActualID() {
		return actualID;
	}
	
	// Prepare for next ID
	public long nextID(){
		return actualID++;
	}

	// Check if is empty:
	public boolean isEmpty(){
		if (baseDeDados.isEmpty())
		{return true;}else{
			return false;}
	}
	
	// Save:
	public void save(T entity){
		entity.setId(actualID);
		baseDeDados.put(entity.getId(), entity);
		nextID();
	}
	
	// Find by id:
	public T findByID(Long id){
		return baseDeDados.get(id);
	}
	
	// Get all:
	 public Iterator<T> getAll(){
		return baseDeDados.values().iterator();
	}
	 
	 // Get all IDS
	 public Iterator<Long> getAllIDs(){
		 return baseDeDados.keySet().iterator();
	 }
	
	 // Edit by id:
	 public void updateByID (T entity){
		 baseDeDados.replace(entity.getId(), entity);
	 }
	 
	 // Remove:
	 public void removeByID (Long id){
		 baseDeDados.remove(id);
	 }
}
