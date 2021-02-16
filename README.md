# Biroliro Quotes API
As melhores frases ditas pelo Excelentíssimo Senhor Presidente da República Jair Messias Bolsonaro.

<p align="center">
  <img src="site-biroliro.gif">
</p>

# API REST
### Citações
GET /api/quote - Lista todas as citações

GET /api/quote/{id} - Busca uma citação pelo id

GET /api/random/quote - Busca uma citação aleatoriamente

### Tags
GET /api/tag - Lista todas as tags

GET /api/tag/{value} - Busca uma tag pelo nome

# Paginação
A paginação para do método GET /api/quote que lista todos as citações pode ser utilizada opcionalmente através dos parâmetros page, size e sort do Spring Data.

