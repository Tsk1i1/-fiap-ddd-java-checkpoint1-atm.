# Protótipo ATM FiapBank.
Este projeto consiste no desenvolvimento do protótipo de um terminal de autoatendimento (ATM) para a fintech FIAP Bank.

A aplicação foi construída em Java 21, focando em robustez de entrada de dados, validação de segurança via Expressões Regulares e lógica de operações bancárias em memória.

O sistema simula o fluxo completo de um cliente, desde o cadastro de credenciais até a execução de transações financeiras via console.

## Arquitetura Lógica
A arquitetura do software segue um fluxo linear de estados:

Fase de Cadastro: Coleta do nome completo e definição da senha mestra.

Fase de Autenticação: Validação da identidade do usuário com contador de tentativas.

Loop de Operações: Menu interativo baseado em switch-case que mantém o estado do saldo.

Validação de Regras: Camada lógica que impede transações inválidas antes da atualização do saldo.

***Nota: A aplicação utiliza o padrão de projeto Alpha, rodando inteiramente em memória sem dependência de bancos de dados externos nesta versão.

## Critérios de Senha Forte (Regex)
A segurança é garantida pela expressão regular fornecida pelo professor:
```^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-_+=?><]).{8,}$```

| Componente | Regra Regex | Objetivo de Segurança |
| :--- | :--- | :--- |
| **Início/Fim** | `^` e `$` | Garante que a validação cubra toda a senha, do primeiro ao último caractere. |
| **Números** | `(?=.*[0-9])` | Obriga a presença de ao menos um dígito numérico (0-9). |
| **Maiúsculas** | `(?=.*[A-Z])` | Obriga a presença de ao menos uma letra em caixa alta. |
| **Especiais** | `(?=.*[!@#$%...])` | Exige símbolos (`!`, `@`, `#`, etc.), o que aumenta a complexidade contra ataques de dicionário. |
| **Comprimento** | `.{8,}` | Define que a senha deve ter, no mínimo, 8 caracteres no total. |

## Manual de Instalação e Operação
1. Pré-requisitos
Ter o JDK 21 (Java Development Kit) instalado e configurado nas variáveis de ambiente.

Um terminal ou IDE de sua preferência (VS Code, IntelliJ, Eclipse).

2. Compilação e Execução
Baixe o arquivo FiapBankAtm.java.

Abra o terminal na pasta do arquivo e compile:
```javac FiapBankAtm.java```

```java FiapBankAtm```

3. Operação do Sistema
Cadastro: Insira seu nome completo. O sistema removerá espaços extras e usará apenas seu primeiro nome.

Senha: A senha deve ter 8+ caracteres, incluindo letra maiúscula, número e símbolo (!@#$%^&*()-_+=?><).

Menu:

Digite 1 para ver o saldo.

Digite 2 para depositar (apenas valores positivos).

Digite 3 para sacar (verifique se possui saldo disponível).

Digite 4 para encerrar a sessão com segurança.

## Agradecimentos
Professor Eduardo Ramos da disciplina de Domain Driven Desing - Java.

> Observação: Este projeto foi desenvolvido como parte dos requisitos acadêmicos para a formação em Engenharia de Software.
