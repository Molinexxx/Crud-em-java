package com.Pessoal.CadastroUsuario.repository;

import com.Pessoal.CadastroUsuario.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    // O Spring cria automaticamente a consulta com base no nome do metodo.
    Optional<Aluno> findByEmail(String email);
}
