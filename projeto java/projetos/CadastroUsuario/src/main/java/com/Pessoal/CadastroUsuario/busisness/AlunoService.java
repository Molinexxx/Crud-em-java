package com.Pessoal.CadastroUsuario.busisness;

import com.Pessoal.CadastroUsuario.Infrestructure.entitys.Aluno;
import com.Pessoal.CadastroUsuario.Infrestructure.repository.AlunoRepository;
import com.Pessoal.CadastroUsuario.exceptions.RegraDeNegocioException;
import com.Pessoal.CadastroUsuario.exceptions.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno salvarAluno(Aluno aluno) {
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

        if (aluno.getEmail() != null && !aluno.getEmail().equals(alunoEntity.getEmail())) {
            repository.findByEmail(aluno.getEmail()).ifPresent(alunoExistente -> {
                throw new RegraDeNegocioException("Ja existe um aluno cadastrado com este email");
            });
        }

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
