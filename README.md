# Clean Architecture (Java)

## Visao geral

Projeto de exemplo que aplica Clean Architecture em Java 21. O dominio exposto e o cadastro de usuarios, com operacoes de criacao, busca e autenticacao. As dependencias externas foram isoladas em adaptadores: codificacao de senha via SHA-256 (`commons-codec`) e geracao de identificador por UUID.

## Como esta organizado

- `br.ifg.urutai.entity` — Entidades de negocio (ex.: `User`).
- `br.ifg.urutai.usecase` — Casos de uso (`CreateUser`, `FindUser`, `LoginUser`) e validadores/excecoes.
- `br.ifg.urutai.usecase.port` — Portas que definem contratos para adaptadores (`UserRepository`, `PasswordEncoder`, `IdGenerator`).
- `br.ifg.urutai.adapter` — Implementacoes concretas das portas (repositorio em memoria, encoder SHA-256, gerador UUID).
- `br.ifg.urutai.config` — Montagem manual das dependencias (`ManualConfig`).
- `br.ifg.urutai.application.Main` — Exemplo de uso orquestrando os casos de uso.

## Requisitos

- JDK 21
- Maven 3.9 ou superior

## Como executar

```powershell
mvn clean package
mvn dependency:copy-dependencies -DincludeScope=runtime -DoutputDirectory=target/dependency
java -cp "target/clean-architecture-1.0.0.jar;target/dependency/*" br.ifg.urutai.application.Main
```

> Em sistemas Unix troque o `;` por `:` no classpath.

O programa `Main` executa o fluxo completo: cria um usuario, consulta por id, lista todos e valida o login com senha codificada.

## Testes

O projeto ja esta configurado com JUnit 5 (`junit-jupiter`). Adicione classes em `src/test/java` e execute:

```bash
mvn test
```

## Proximos passos sugeridos

1. Persistir usuarios em um banco relacional ou NoSQL implementando um novo adaptador de `UserRepository`.
2. Cobrir os casos de uso com testes unitarios (validacao, fluxo feliz, cenarios de erro).
3. Expor os casos de uso via API HTTP, CLI ou outro boundary mantendo as mesmas portas.

