package br.com.gerenciadorBancario.dao;

import java.util.List;

public interface GenericDAO {
	
	public List listAll(Object object);
	
	public void save(Object object);
	
	public Object searchById(Object object, Integer id);
	
	public void delete(Object object);
	
	public void update(Object object);

}
