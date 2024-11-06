package dao;

import java.util.Collection;

public interface OperacionesCRUD<T> {

	
	
	//CU3 CU4a CU5a
	public long insertar(T elemento);
	
	

	//CU5b
	public T buscarPorID(long id);

	//CU1 CU5c
	public Collection<T> verTodos(); 
	
	
	//CU4b
	public boolean modificar(T elemento);
	
	
	

	
	
	
	
	
	
	
	
}
