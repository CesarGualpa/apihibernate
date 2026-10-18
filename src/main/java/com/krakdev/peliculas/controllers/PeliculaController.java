package com.krakdev.peliculas.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.services.ServicioPelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

	private final ServicioPelicula servicioPelicula;

	public PeliculaController(ServicioPelicula servicioPelicula) {
		this.servicioPelicula = servicioPelicula;
	}

	@PostMapping
	public ResponseEntity<Pelicula> crear(
			@RequestBody Pelicula pelicula) {

		Pelicula creada = servicioPelicula.crear(pelicula);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(creada);
	}

	@GetMapping
	public ResponseEntity<List<Pelicula>> listar() {

		List<Pelicula> peliculas = servicioPelicula.listar();

		return ResponseEntity.ok(peliculas);
	}

}