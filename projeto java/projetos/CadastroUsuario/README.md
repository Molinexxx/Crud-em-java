# CRUD de Academia

API REST em Java com Spring Boot para cadastrar alunos de uma academia.

> **Status:** a versão auditada compila, mas falha na inicialização devido ao conflito entre dois componentes chamados `globalExceptionHandler`. As rotas abaixo descrevem o contrato presente no código. Consulte o [README da raiz](../../../README.md) para o comando de execução.

## Funcionalidades

- Cadastrar aluno
- Listar alunos
- Buscar aluno por ID
- Atualizar aluno
- Remover aluno

## Dados do aluno

- `id`
- `nome`
- `email`
- `telefone`
- `plano`
- `ativo`

## Endpoints

### Criar aluno

`POST /alunos`

```json
{
  "nome": "Maria Souza",
  "email": "maria@academia.com",
  "telefone": "(11) 99999-0000",
  "plano": "Premium",
  "ativo": true
}
```

### Listar alunos

`GET /alunos`

### Buscar aluno por ID

`GET /alunos/1`

### Atualizar aluno

`PUT /alunos/1`

```json
{
  "telefone": "(11) 98888-7777",
  "plano": "Black"
}
```

### Excluir aluno

`DELETE /alunos/1`

## Tela HTML

A página inicial usa a API `/alunos` para cadastrar, listar, editar, excluir e pesquisar alunos. Quando a aplicação estiver em execução, a interface será servida em [http://localhost:8080/](http://localhost:8080/).

## Banco H2

O banco `jdbc:h2:mem:academia` é temporário. A configuração do [console H2](http://localhost:8080/h2-console) fica em [application.properties](src/main/resources/application.properties).
