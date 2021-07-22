# Microsserviço - Carrinho de compras

* Comando do Docker para preparar o container:
```
docker run -d --name (name) -p 6379:6379 redis
```

* Requisições de teste:
```
curl -X POST http://localhost:8082/api/v1/carrinho/1 -H "Content-Type:application/json" -d "{\"idProd\":1,\"qtde\":10}"
```
```
curl http://localhost:8082/api/v1/carrinho/1
```
```
curl -X DELETE http://localhost:8082/api/v1/carrinho/1
```
