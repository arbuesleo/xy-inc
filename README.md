# XYInc App

## Pré requisitos
* Maven 3.5 ou superior
* Jvm 1.8 ou superior

## Excutando o projeto
* Excutar `mvn exec:java` no root de projeto, esse comando irá iniciar a aplicação na porta 8081.

## Serviços disponivéis

* Busca Pontos de Interesse por Proximidade:  metódo: `GET` URL: `http://localhost:8081/api/private/poi/pesquisaPorProximidade?cooX=20&cooY=10&DMax=10`
    * ResponseBody: `[
    {
        "id": 1,
        "descricao": "Alter",
        "coordenadaX": 27,
        "coordenadaY": 12
    },
    {
        "id": 3,
        "descricao": "Joalheria",
        "coordenadaX": 15,
        "coordenadaY": 12
    },
    {
        "id": 5,
        "descricao": "Pub",
        "coordenadaX": 12,
        "coordenadaY": 8
    },
    {
        "id": 6,
        "descricao": "Supermercado",
        "coordenadaX": 23,
        "coordenadaY": 6
    },
    {
        "id": 8,
        "descricao": "testestes",
        "coordenadaX": 27,
        "coordenadaY": 12
    }
]`

* Listagem de Pontos de Interesse: metódo: `GET` URL: `http://localhost:8081/api/private/poi`
 
* Cadastro de Pontos de Interesse:  metódo: `POST` URL: `http://localhost:8081/api/private/poi`
    * RequestBody: `{
        "descricao": "asdfasdf",
        "coordenadaX": 27,
        "coordenadaY": 12}`  
    * ResponseBody: `{
    "atributos": {
        "MESSAGE": "REGISTRO INSERIDO COM SUCESO!"
    },
    "data": {
        "id": 8,
        "descricao": "testestes",
        "coordenadaX": 27,
        "coordenadaY": 12
    }`

* Atualização de Pontos de Interesse:  metódo: `PUT` URL: `http://localhost:8081/api/private/poi`
    * RequestBody ` {
        "id": 1,
        "descricao": "Alter",
        "coordenadaX": 27,
        "coordenadaY": 12
    }`
    * ResponseBody: `{
    "atributos": {
        "MENSAGE": "EDITADO COM SUCESSO"
    },
    "data": {
        "id": 1,
        "descricao": "Alter",
        "coordenadaX": 27,
        "coordenadaY": 12
    }
}`

* Deletar Pontos de Interesse:  metódo: `DELETE` URL: `http://localhost:8081/api/private/poi`
    * RequestBody: `{
        "id": 9,
        "descricao": "asdfasdf",
        "coordenadaX": 27,
        "coordenadaY": 12
    }`
    * ResponseBody: `{
    "atributos": {
        "MESSAGE": " DELETADO COM SUCESSO",
        "STATUSERROR": "SUCCESS"
    },
    "data": null
}`