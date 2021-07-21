# config-server

Responsável por carregar os arquivos de configuração de cada microsserviço.

Este componente está configurado para puxar cada arquivo deste mesmo repositório, ou seja, da pasta de nível superior.

Comando para verificar se uma configuração está sendo puxada do config-server:
````
curl http://localhost:8888/(service name)/default
````
