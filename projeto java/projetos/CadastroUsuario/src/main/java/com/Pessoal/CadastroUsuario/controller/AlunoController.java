package com.Pessoal.CadastroUsuario.controller;

import com.Pessoal.CadastroUsuario.entity.Aluno;
import com.Pessoal.CadastroUsuario.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    // O controller recebe as requisicoes HTTP e delega a regra de negocio ao service.
    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvarAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        return ResponseEntity.ok(alunoService.listarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(alunoService.buscarAlunoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Integer id, @RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoService.atualizarAluno(id, aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Integer id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
