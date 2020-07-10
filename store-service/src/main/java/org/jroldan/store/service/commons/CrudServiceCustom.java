package org.jroldan.store.service.commons;

import java.io.Serializable;
import java.util.List;


public interface CrudServiceCustom<T, ID> extends Serializable {
	
	T findById(ID id);
	
	List<T> findAll();
	
	boolean exists(T entity);
	
	boolean existsById(ID id);
	
	T saveOrUpdate(T entity);
	
	void delete(T entity);
	
	void deleteById(ID id);

}
