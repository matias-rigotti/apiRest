package com.matias.apiRest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matias.apiRest.entity.Nota;

//En el repositorio se hacen las peticiones a la DB
@Repository("repositorio")
public interface INotaRepositorio extends JpaRepository<Nota, Serializable>{
	 public abstract Nota findByNombre(String nombre);
	 
	 public abstract List<Nota> findByTitulo(String titulo);
	 
	 public abstract Nota findByNombreAndTitulo(String nombre, String titulo);
	 
	 public abstract Nota findByNombreAndId(String nombre, long id);
}
