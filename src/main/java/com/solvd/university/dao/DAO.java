package com.solvd.university.dao;

import java.util.List;


public interface DAO<T,K> {
	boolean removeById(K id);
	T getById(K id);
	List<T> getAll();
}
