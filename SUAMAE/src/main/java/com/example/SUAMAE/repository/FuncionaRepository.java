package com.example.SUAMAE.repository;

import com.example.SUAMAE.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionaRepository extends JpaRepository<Funcionario, Long> {
}
