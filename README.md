# CRUD de Academia em Java

Projeto de estudo sobre cadastro de alunos de uma academia, com uma API REST em Spring Boot e uma interface HTML que consome a própria API.

## Recursos presentes no código

- Criar, listar, buscar por ID, atualizar e excluir alunos.
- Registrar nome, e-mail, telefone, plano e situação ativa.
- Verificar e-mail duplicado no cadastro e na atualização.
- Operar o cadastro pela página inicial, quando a aplicação estiver em execução.

## Tecnologias e estrutura

O módulo [CadastroUsuario](projeto%20java/projetos/CadastroUsuario/) usa Java 17, Spring Boot 3.4.3, Spring Data JPA, H2 em memória, Lombok e Maven. O controller, o serviço e o repositório ficam em `src/main/java/`. A página está em `src/main/resources/static/index.html`.

## Execução e status

No PowerShell, a partir da raiz, com o JDK 17:

```powershell
Set-Location "projeto java/projetos/CadastroUsuario"
.\mvnw.cmd spring-boot:run
```

**Inicialização bloqueada na versão auditada.** O módulo compila, mas o Spring Boot encerra a inicialização ao encontrar dois componentes chamados `globalExceptionHandler` nos pacotes `exception` e `exceptions`. Após resolver os conflitos de componentes, o endereço previsto para a interface é [http://localhost:8080/](http://localhost:8080/).

O [README do módulo](projeto%20java/projetos/CadastroUsuario/README.md) descreve as rotas e o formato dos dados.
