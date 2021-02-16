# Biroliro Quotes API
As melhores frases ditas pelo Excelentíssimo Senhor Presidente da República Jair Messias Bolsonaro.

<p align="center">
  <img src="site-biroliro.gif">
</p>

## API REST
### Citações
GET /api/quote - Lista todas as citações

GET /api/quote/{id} - Busca uma citação pelo id

GET /api/random/quote - Busca uma citação aleatoriamente

### Tags
GET /api/tag - Lista todas as tags

GET /api/tag/{value} - Busca uma tag pelo nome

## Documentação
A documentação da API foi gerada via Swagger e está disponivel no link abaixo:

[DOCUMENTAÇÃO](https://biroliro.herokuapp.com/swagger-ui.html) 

## Tecnologias
As seguintes ferramentas foram usadas na construção do projeto:

- [Java 8](https://java.com/pt-BR/download/help/java8.html)
- [Spring](https://spring.io/)
- [MySQL](https://www.mysql.com/)
- [Maven](https://maven.apache.org/)
- [Swagger](https://swagger.io/)
- [Docker](https://www.docker.com/)
- [Heroku](https://www.heroku.com/)

## Paginação
A paginação para do método GET /api/quote que lista todos as citações pode ser utilizada opcionalmente através dos parâmetros page, size e sort do Spring Data.

## Motivação
Este projeto foi inspirado no [Birolipsum](https://github.com/izmcm/birolipsum) da [Izabella Melo](https://github.com/izmcm) (que prontamente cedeu todas as pérolas ditas pelo Excelentíssimo) para que outros desenvolvedores possam consumir também como forma de mostrar para mais pessoas o que nosso presidente pensa a respeito de determinados assuntos.

## Demo
O deploy foi realizado de forma gratuíta no [Heroku](https://www.heroku.com/) utilizando a plataforma Java e Addons ClearDB MySQL.

[https://biroliro.herokuapp.com/](https://biroliro.herokuapp.com/)

## Contribuição
Toda ideia de feature que queria implementar ou problema que tá super afim de consertar são super bem-vindo via PR. 

## Licença
A licença do projeto é MIT License - olhar [LICENSE](LICENSE) para mais detalhes.

