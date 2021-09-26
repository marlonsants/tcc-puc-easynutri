package com.tcc.easynutri.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.easynutri.model.entity.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
	
}
