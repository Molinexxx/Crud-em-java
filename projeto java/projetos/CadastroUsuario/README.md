# CRUD de Academia

API REST em Java com Spring Boot para cadastrar alunos de uma academia.

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

### Deletar aluno

`DELETE /alunos/1`

## Tela HTML

- Pagina inicial: `http://localhost:8080/`
- A tela consome a propria API `/alunos`
- Permite cadastrar, listar, editar, excluir e pesquisar alunos

## Banco H2

- Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:academia`
- User: `sa`
- Password: vazio
