package com.Pessoal.CadastroUsuario.service;

import com.Pessoal.CadastroUsuario.entity.Aluno;
import com.Pessoal.CadastroUsuario.exception.RegraDeNegocioException;
import com.Pessoal.CadastroUsuario.exception.RecursoNaoEncontradoException;
import com.Pessoal.CadastroUsuario.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    // O repository concentra o acesso ao banco usando o Spring Data JPA.
    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno salvarAluno(Aluno aluno) {
        // Impede cadastro de dois alunos com o mesmo email.
        if (repository.findByEmail(aluno.getEmail()).isPresent()) {
            throw new RegraDeNegocioException("Ja existe um aluno cadastrado com este email");
        }
        return repository.save(aluno);
    }

    public List<Aluno> listarAlunos() {
        return repository.findAll();
    }

    public Aluno buscarAlunoPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Aluno nao encontrado"));
    }

    public Aluno atualizarAluno(Integer id, Aluno aluno) {
        Aluno alunoEntity = buscarAlunoPorId(id);

        // Se o email mudou, valida se o novo endereco ja nao pertence a outro aluno.
        if (aluno.getEmail() != null && !aluno.getEmail().equals(alunoEntity.getEmail())) {
            repository.findByEmail(aluno.getEmail()).ifPresent(alunoExistente -> {
                throw new RegraDeNegocioException("Ja existe um aluno cadastrado com este email");
            });
        }

        // Atualiza apenas os campos enviados na requisicao.
        alunoEntity.setNome(aluno.getNome() != null ? aluno.getNome() : alunoEntity.getNome());
        alunoEntity.setEmail(aluno.getEmail() != null ? aluno.getEmail() : alunoEntity.getEmail());
        alunoEntity.setTelefone(aluno.getTelefone() != null ? aluno.getTelefone() : alunoEntity.getTelefone());
        alunoEntity.setPlano(aluno.getPlano() != null ? aluno.getPlano() : alunoEntity.getPlano());
        alunoEntity.setAtivo(aluno.getAtivo() != null ? aluno.getAtivo() : alunoEntity.getAtivo());

        return repository.save(alunoEntity);
    }

    public void deletarAluno(Integer id) {
        Aluno aluno = buscarAlunoPorId(id);
        repository.delete(aluno);
    }
}
