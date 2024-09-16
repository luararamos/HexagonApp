# HexagonApp 📁📱
O projeto é um aplicativo Android desenvolvido utilizando Kotlin e Jetpack Compose. O objetivo principal é gerenciar informações pessoais, como CPF e datas, com funcionalidades para adicionar, editar e exibir esses dados.

![Gravar_2024_09_16_20_21_02_566-ezgif com-resize](https://github.com/user-attachments/assets/28e1d44a-7438-4458-bb26-949a566ad39d)

## ⚙ Funcionalidades
1. Adicionar e Editar Pessoas: 
- Adicionar Pessoa: Permite ao usuário inserir informações como nome, data de nascimento, CPF, cidade e foto.
- Editar Pessoa: Permite ao usuário modificar as informações de uma pessoa já existente. A funcionalidade é acessada a partir de uma lista onde cada item pode ser editado.
  
2. Formatação de Dados:
- Formatação de CPF: Implementa a formatação do CPF com pontos e hífen, conforme o padrão brasileiro.
- Formatação de Data: Implementa a formatação de datas no formato "dd/MM/yyyy".

## 🛠 Tecnologias
As seguintes ferramentas foram utilizadas na construção do projeto:
- Jetpack Compose
- Room Database 
- Coroutines
- Injeção de dependência com Koin
- Arquitetura MVVM + Clean Architecture

## 💻 Decisões de Desenvolvimento
- Utilização de Jetpack Compose para a construção da interface do usuário, aproveitando o poder dos componentes declarativos e reativos.
- Uso de Koin como framework de injeção de dependência para uma configuração simplificada e gestão de dependências.
- Implementação de Room para gerenciamento local de banco de dados, facilitando operações de leitura e escrita.
- Utilização de State e LiveData para gerenciar e observar mudanças de estado na interface do usuário.
- Implementação de navegação entre telas utilizando o Navigation Compose para uma navegação fluída e intuitiva.
- Coroutines são usadas para operações assíncronas, permitindo uma execução eficiente de tarefas em segundo plano.


## 📲 Passos para rodar o aplicativo
Após baixar o projeto, você pode abrir com o Android Studio. Para isso, na tela de launcher clique em:
Open an Existing Project (ou alguma opção similar) Procure o local onde o projeto está e o selecione (Caso o projeto seja baixado via zip, é necessário extraí-lo antes de procurá-lo) Por fim clique em OK O Android Studio deve executar algumas tasks do Gradle para configurar o projeto, aguarde até finalizar. Ao finalizar as tasks, você pode executar o App 🏆


##  👩‍💻 Author
<img width= "80px" height="80px" src = "https://github.com/luararamos/NetflixRemake/assets/35637366/a7aa35cc-bbd2-457e-b738-19c39ba89011">
</br>
<a href="https://www.linkedin.com/in/luararamos-desenvolvedor-android/">
 <sub><b>Luara Ramos (Lise)</b></sub></a> 


Feito com ❤️ por Luara Ramos.

[![Linkedin Badge](https://img.shields.io/badge/-LuaraRamos-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/luararamos/)](https://www.linkedin.com/in/luararamos-desenvolvedor-android/) 
[![Gmail Badge](https://img.shields.io/badge/-luara.m.ramos@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:luara.m.ramos@gmail.com)](mailto:luara.m.ramos@gmail.com)
