package com.publicacoesonline.avaliacaodesenvolvedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.publicacoesonline.avaliacaodesenvolvedor.entities.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Integer>{

}
