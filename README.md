# Teste para vaga de estagio na empresa Hilab

O teste tinha como objetivo criar uma API CRUD com 3 end-points:  PUT, GET e POST para criar uma lista de usuarios e ao final da execução salvar as informações em um arquivo json.

A implementação foi feita na linguagem Java.

# Libs
No arquivo Teste.java:

A biblioteca Scanner serve para receber dados via terminal.
As bibliotecas PrintWriter e FileNotFoundException servem para criar o arquivo json, a segunda serve para caso de erro na criação.

No arquivo Controlador.java:

A biblioteca ArrayList serve para usar uma lista encadeada, que usei para salvar a lista de usuarios.
As bibliotecas Pattern e Matcher servem para usar Regex para verificar se as entradas de e-mail e data de nascimento são validas.

# Arquivos

O arquivo Teste.java serve apenas para testar a API ele tem acesso as funções disponibilizadas pelo controlador.

O arquivo Controlador.java serve para gerenciar a lista de usuarios, ele fornece uma classe controlador que disponibiliza os metodos POST, PUT e GET, ela não altera diretamente os dados mas usa a Ficha para isso.

O arquivo Ficha.jar que modifica os dados do usuario usando GET e SET.

# Como Rodar

Com o java devidamente instalado rode o seguinte comando:
```
    ./start.sh
```

Esse comando ira rodar o script em Bash que vai usar o arquivo makefile para compilar, apos isso ira criar o executavel .jar e ja vai rodar o programa.

Quando o programa for encerrado um arquivo usuarios.json vai ser criado no mesmo diretorio. Caso o arquivo ja exista os dados vão ser sobrescritos.


