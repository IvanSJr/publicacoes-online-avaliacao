package com.publicacoesonline.avaliacaodesenvolvedor.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.publicacoesonline.avaliacaodesenvolvedor.dto.UsuarioDTO;
import com.publicacoesonline.avaliacaodesenvolvedor.dto.UsuarioNewDTO;
import com.publicacoesonline.avaliacaodesenvolvedor.entities.Processo;
import com.publicacoesonline.avaliacaodesenvolvedor.entities.Reu;
import com.publicacoesonline.avaliacaodesenvolvedor.entities.Usuario;
import com.publicacoesonline.avaliacaodesenvolvedor.services.Services;

@RestController
@RequestMapping(value = "/usuarios")
public class Resource {
	
	@Autowired
	private Services service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		Usuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> objs = service.findAll();
		List<UsuarioDTO> objsDto = objs.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(objsDto);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<UsuarioDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Usuario> objs = service.findPage(page, linesPerPage, orderBy, direction);
		Page<UsuarioDTO> objsDto = objs.map(obj -> new UsuarioDTO(obj));
		return ResponseEntity.ok().body(objsDto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert (@Valid @RequestBody UsuarioNewDTO objDto){
		Usuario obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/processos")
	public ResponseEntity<List<Processo>> findAllLawsuits() {
		List<Processo> objs = service.findAllLawsuits();
		return ResponseEntity.ok().body(objs);
	}
	
	@GetMapping(value = "/processos/page")
	public ResponseEntity<Page<Processo>> findPageLawsuits(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Processo> objs = service.findPageLawsuits(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(objs);
	}
	
	@PostMapping(value = "/{id}/processos")
	public ResponseEntity<Void> insertLawsuits(@PathVariable Integer id,@Valid @RequestBody Processo obj){
		obj = service.insertLawsuits(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/processos/{id}")
	public ResponseEntity<Void> deleteLawsuits(@PathVariable Integer id) {
		service.deleteLawsuits(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/{id}/processos/reu")
	public ResponseEntity<Void> insertDefendant(@PathVariable Integer id,@Valid @RequestBody Reu obj){
		obj = service.insertDefendant(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
