Definição do projeto desenvolvivo no curso de Logica de Programação 3 Java

TODO APP:

Descrição: Aplicação para o gerenciamento de projetos e as tarefas envolvidas neste projeto.

Objetivo: Resolver a organização de tarefas de um ou vários projetos.

Entidades:
-Projeto;
-Tarefas;

Requisitos:
-Permitir criar o Projeto
-Permitir alterar o Projeto
-Permitir Deletar o projeto

-Permitir criar a Tarefa
-Permitir alterar a Tarefa
-Permitir Deletar a Tarefa

Regras de Negócio:
-Não terá sistema de login
-Não haverá conceito de usuário
-Toda tarefa deve pertencer a um projeto

Entidades:
-Projeto:
	Nome, Descrição, Data de criação, Data de atualização
-Tarefa:
	Nome, Descrição, Status, Observação, Prazo, Data de criação, Data de atualização

Banco de dados:
	Necessário criar tabelas no banco de dados para utilização no programa
	Necessário prototipar (desenhar) as telas do programa
	Necessário definir paleta de cores e ícones que serão usados

Criação do projeto:

	Criar classes do modelo (model)
	Criar classes da View
	Criar classes do Controller

Criação da conexão com banco de dados:

	Criar a classe connection Factory com informações da conexão com banco 	
	Necessário criar método para abrir a conexão com banco e fechar 
	Sinalizar para o Java Dependencies que vou utilizar um sgbd externo, graddle
	Dentro do build Scripts>build graddle colocar o texto da busca do google na tag 'dependencies' (mysql-connector java graddle: resultado pelo maven repository : graddle).
	Daí ele vai baixar as dependencias para dentro do projeto