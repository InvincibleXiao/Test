package dao;

import java.util.List;

public interface IDao<T> {
	int deletyById(int id);
	int insert(T t);
	int update(T t);
	T findById(int id);
	List<T> findAll();
}
