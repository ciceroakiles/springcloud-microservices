# Microsserviço - Catálogo de produtos

### Alguns comandos importantes do Docker

* Configuração de um container com o ElasticSearch:
```
docker pull docker.elastic.co/elasticsearch/elasticsearch:(version)
docker run -d --name (name) -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:(version)
```

Se o container não estiver rodando, a conexão na porta dele será recusada, e o serviço não vai subir.

### Exemplos de requisições HTTP

* Verificação do actuator:
```
curl http://localhost:8081/actuator/health
```

* POST no endpoint produto através do product-catalog:
```
curl -X POST http://localhost:8080/api/v1/produto -H "Content-Type:application/json" -d "{\"id\":1,\"name\":\"Nome do produto\",\"qtde\":10}"
```

* GET do registro salvo no ElasticSearch:
```
curl http://localhost:9200/produto/catalogo/1
```
