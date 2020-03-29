package com.matias.apiRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.matias.apiRest.converter.Convertidor;
import com.matias.apiRest.entity.Nota;
import com.matias.apiRest.repository.INotaRepositorio;
import com.matias.apiRest.model.MNota;

@Service("servicio")
public class NotaService {
	@Autowired //inyectar
	@Qualifier("repositorio") //nombre del bean
	private INotaRepositorio repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	public boolean crear(Nota nota) {
		try {
			repositorio.save(nota);
			return true;
		} catch ( Exception e) {
			return false;
		}
	}
	
	public boolean actualizar(Nota nota) {
		try {
			repositorio.save(nota);
			return true;
		} catch ( Exception e) {
			return false;
		}
	}
	
	public boolean borrar(String nombre, long id) {
		try {
			Nota nota = repositorio.findByNombreAndId(nombre, id);
			repositorio.delete(nota);
			return true;
		} catch ( Exception e) {
			return false;
		}
	}
	
	public List<MNota> obtener() {
		return convertidor.convertirLista(repositorio.findAll());
	}
	
	public MNota obtenerPorNombreTitulo (String nombre, String titulo) {
		return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
	}
	
	public List<MNota> obtenerTitulo(String titulo){
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
	}
}
