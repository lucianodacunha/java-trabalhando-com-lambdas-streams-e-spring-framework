# Java: trabalhando com lambdas, streams e Spring Framework

<details>
<summary><h2>Aula 1: Um novo projeto utilizando Spring Framework</h2></summary>
    <ul>
        <li>Estrutura de um Projeto Spring: Vimos a estrutura inicial de um projeto Spring e discutimos sobre os pacotes, classes e o método run.</li>
        <li>Inferência de tipos no Java: Vimos um exemplo prático de inferência de tipos com 'var' no código Java.</li>
        <li>Consumo de API: Aprendemos a consumir APIs através do método 'obterDados', que retorna os dados desejados no formato Json.</li>
        <li>Modularização de código: Aprendemos a importância de ter um código modularizado e de fácil manutenção.</li>
        <li>Serialização e Desserialização: Aprendemos como transformar JSON em classes e como isso é útil para o projeto.</li>
        <li>Criação de interfaces e implementação de métodos: Foi demonstrada a criação de uma interface com um método genérico que usa Generics, bem como a implementação deste método em uma classe separada.</li>
        <li>Inclusão de novas dependências no Projeto: Vimos como adicionar uma nova dependência ao arquivo .pom.xml e como esse processo é gerenciado pelo Maven.</li>
    </ul>
</details>

<details>
<summary><h2>Aula 2: Modelando os dados da aplicação</h2></summary>
<ul>
<li>Desenvolvimento Colaborativo: Discutimos a importância do desenvolvimento colaborativo em projetos de programação e como ferramentas como o Git facilitam esse processo.</li>

<li>APIs e Consultas Detalhadas: Descobrimos como trabalhar com APIs para detalhar informações e obter consultas mais específicas.</li>

<li>Utilização de anotações @JsonAlias e @JsonIgnoreProperties: A importância de usar essas funções para mapear a API para a aplicação.</li>

<li>Criação de métodos para interação do usuário: Criamos um método para exibir o menu e interagir com o usuário, permitindo que digitem o nome da série que desejam pesquisar.</li>

<li>Manipulação de dados de uma API: Mostramos como importar e manipular dados de uma API, neste caso, dados de séries de TV.</li>

<li>Manipulação de Strings para acessar uma API: Vimos como manipular strings para criar endereços que a API compreenderá e retornará os dados desejados.</li>

<li>Introdução aos Lambdas: Conhecemos o Lambda Expressions em Java, conhecidas como funções anônimas que podemos usar para escrever código mais eficiente.</li>
</ul>
</details>

<details>
<summary><h2>Aula 3: Manipulando com fluxos as coleções de dados</h2></summary>
<ul>
<li>Introdução às Funções Lambda: Aprendemos a sintaxe das funções lambda em Java e como elas permitem uma escrita mais concisa.</li>

<li>Uso de Streams em Java: Obtemos um entendimento essencial das streams, que são fluxos de dados em Java, e como realizar operações encadeadas neles.</li>

<li>Filtragem de Dados: Aprendemos como usar o recurso de filtragem em streams para selecionar apenas dados específicos, neste caso, episódios de séries de TV com avaliação específica.</li>

<li>Manipulando Datas: Exploramos como converter strings em LocalDates e tratamos possíveis exceções que podem ocorrer neste processo.</li>

<li>Tratando Exceções: Fizemos tratamento de exceções específicas, como NumberFormatException e DateTimeParseException, que podem ocorrer devido à conversão de dados.</li>
</ul>
</details>

<details>
<summary><h2>Aula 4: Explorando mais os fluxos e gerando estatísticas</h2></summary>
<ul>
<li>Uso da função peek: Foi introduzida a função peek no Java, que permite visualizar o que está acontecendo em cada etapa da stream, facilitando o processo de debug.</li>

<li>Operações Intermediárias e Finais: Aprendemos sobre a utilização de operações (como map, filter e find) que nos permitem manipular e encontrar dados dentro de um Stream.</li>

<li>Uso de Containers para Dados: Examinamos como usar o Container Optional para armazenar um episódio dentro de um Stream e evitar referências nulas.</li>

<li>Filtragem de dados: Aprendemos a importância de filtrar dados adequados para análises e como isso pode afetar os resultados.</li>

<li>Uso do DoubleSummaryStatistics: Aprendemos como a classe Double Summary Statistics do Java pode ajudar a analisar informações, como a maior avaliação, a menor e a quantidade de avaliações em nossas séries.</li>
</ul>
</details>

<details>
<summary><h2>Aula 5: Consolidando conhecimento</h2></summary>
<li>A aplicar seus conhecimentos para implementar uma aplicação com objetivo de consultar o valor médio de veículos de acordo com a tabela FIPE, consumindo uma API e utilizando conceitos como coleções, listas e streams no Java.</li>
    <li><a href="https://start.spring.io/">Spring Initializr</a></li>
    <li><a href="https://publicapis.dev/">Página web do Public Apis</a></li>
</ul>
</details>
