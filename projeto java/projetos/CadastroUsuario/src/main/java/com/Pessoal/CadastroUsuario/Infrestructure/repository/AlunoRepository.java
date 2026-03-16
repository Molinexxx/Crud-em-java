package com.Pessoal.CadastroUsuario.Infrestructure.repository;

import com.Pessoal.CadastroUsuario.Infrestructure.entitys.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    Optional<Aluno> findByEmail(String email);
}
