package com.publicacoesonline.avaliacaodesenvolvedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.publicacoesonline.avaliacaodesenvolvedor.entities.Reu;

@Repository
public interface ReuRepository extends JpaRepository<Reu, Integer>{

}
