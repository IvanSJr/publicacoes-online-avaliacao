package com.publicacoesonline.avaliacaodesenvolvedor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.publicacoesonline.avaliacaodesenvolvedor.dto.UsuarioDTO;
import com.publicacoesonline.avaliacaodesenvolvedor.dto.UsuarioNewDTO;
import com.publicacoesonline.avaliacaodesenvolvedor.entities.Processo;
import com.publicacoesonline.avaliacaodesenvolvedor.entities.Reu;
import com.publicacoesonline.avaliacaodesenvolvedor.entities.Usuario;
import com.publicacoesonline.avaliacaodesenvolvedor.repositories.ProcessoRepository;
import com.publicacoesonline.avaliacaodesenvolvedor.repositories.ReuRepository;
import com.publicacoesonline.avaliacaodesenvolvedor.repositories.UsuarioRepository;
import com.publicacoesonline.avaliacaodesenvolvedor.services.exceptions.ObjectNotFoundException;

@Service
public class Services {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProcessoRepository processoRepository;
	
	@Autowired
	private ReuRepository reuRepository;
		
	public Usuario find(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return usuarioRepository.findAll(pageRequest);
	}
	
	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return usuarioRepository.save(obj);
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getSenha());
	}
	public Usuario fromDTO(UsuarioNewDTO objDto) {
		Usuario usuario = new Usuario(null, objDto.getNome(), objDto.getEmail(), objDto.getSenha());
		Processo processo = new Processo(null, objDto.getCodigoProcesso(), usuario);
		Reu reu = new Reu(null, objDto.getNomeReu(), objDto.getCpfReu(), processo);
		usuario.getProcesso().add(processo);
		processo.getReus().add(reu);
		return usuario;
	}
	
	public List<Processo> findAllLawsuits(){
		return processoRepository.findAll();
	}
	
	public Page<Processo> findPageLawsuits(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return processoRepository.findAll(pageRequest);
	}
	
	@Transactional
	public Processo insertLawsuits(Processo obj) {
		obj.setId(null);
		return processoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		usuarioRepository.deleteById(id);
	}
	
	public void deleteLawsuits (Integer id) {
		processoRepository.deleteById(id);
	}
	
	public Reu insertDefendant(Reu obj) {
		obj.setId(null);
		return reuRepository.save(obj);
	}
	
	
}
