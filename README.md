# Biblioteca FLISoL 2017

## Obtener autores
### Petición
```
GET /biblio/authors HTTP/1.1
Host: myhost*
```
### Respuesta
```json
{
  "authors": [
    {
      "id": 1,
      "lastName": "Nicolás",
      "firstName": "Paez"
    },
    {
      "id": 2,
      "lastName": "Diego",
      "firstName": "Fontdevila"
    },
    {
      "id": 3,
      "lastName": "Pablo",
      "firstName": "Suárez"
    }
  ]
}
```

## Obtener categorías
### Petición
```
GET /biblio/categories HTTP/1.1
Host: myhost*
```
### Respuesta
```json
{
  "categories": [
    {
      "id": 1,
      "name": "Programación"
    },
    {
      "id": 2,
      "name": "Software Libre"
    }
  ]
}
```

## Crear nuevo libro
### Petición
```
POST /biblio/book/save HTTP/1.1
Content-Type: application/json
Host: myhost*
{
  "authorId": 13,
  "categoryId": 1,
  "isbn": "9789871889433",
  "name": "Construcción de software: una mirada ágil",
  "publisher": "EDUNTREF",
  "datePublised": "2014-09-01"
}
```
### Respuesta
```json
{
  "id": 11,
  "isbn": "9789871889433",
  "name": "Construcción de software: una mirada ágil",
  "url": null,
  "cover": null,
  "edition": null,
  "publisher": "EDUNTREF",
  "datePublised": "2014-09-01",
  "datePublisedTimestamp": 1491274800000,
  "dateCreated": "2017-04-20",
  "dateCreatedTimestamp": 1492661573366,
  "author": {
    "id": 1,
    "lastName": "Nicolás",
    "firstName": "Paez"
  },
  "category": {
    "id": 1,
    "name": "Programación"
  }
}
```

## Buscar libros
### Petición
```
GET /biblio/books/search?name=code HTTP/1.1
Host: myhost*
```
### Respuesta
```json
[
  {
    "id": 102,
    "isbn": "0132350882",
    "name": "Clean Code: A Handbook of Agile Software Craftsmanship",
    "url": null,
    "cover": "http://biblio/book/cleancode.jpg",
    "edition": null,
    "publisher": "Prentice Hall",
    "datePublised": "2017-04-20",
    "datePublisedTimestamp": 1492661233352,
    "dateCreated": "2017-04-20",
    "dateCreatedTimestamp": 1492661233374,
    "author": {
      "id": 1,
      "lastName": "Martin",
      "firstName": "Robert Cecil"
    },
    "category": {
      "id": 1,
      "name": "Programación"
    }
  },
  {
    "id": 3,
    "isbn": "0735619670",
    "name": "Code Complete: A Practical Handbook of Software Construction",
    "url": null,
    "cover": "http://biblio/book/dontmakemethink.jpg",
    "edition": null,
    "publisher": "Prentice Hall",
    "datePublised": "2017-04-20",
    "datePublisedTimestamp": 1492661233386,
    "dateCreated": "2017-04-20",
    "dateCreatedTimestamp": 1492661233388,
    "author": {
      "id": 3,
      "lastName": "McConnell",
      "firstName": "Steve"
    },
    "category": {
      "id": 1,
      "name": "Programación"
    }
  }
]
```

## WAR file
- **v0.1** build/biblio-0.1.war
