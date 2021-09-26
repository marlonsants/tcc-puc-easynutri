package com.tcc.easynutri.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.easynutri.model.entity.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
}
