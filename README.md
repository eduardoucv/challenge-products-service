# challenge-products-service

New feature showing similar products. 

This project depends on project [backendDevTest](https://github.com/dalogax/backendDevTest) running to work properly.

openapi-generator-maven-plugin was used to generate code from the swagger file

## Getting Started

To start developing the project please check if you have these tools installed on your machine:

* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Docker](https://www.docker.com/get-started)
* [Mocks Application Running](https://github.com/dalogax/backendDevTest)

### Installation

1. Clone the repo

```sh
git clone https://github.com/eduardoucv/challenge-products-service.git
```

2. Move into challenge-products-service folder

```sh
cd challenge-products-service
```

3. compile the project

```sh
mvn clean package
```

4. docker build to create the image

```sh
docker build -t challenge-products-service .
```

5. docker run to start the application

```sh
docker run --name challenge-products-service -dp 5000:8082 challenge-products-service
```



## API Reference

#### getProductSimilar

```http
  GET http://localhost:5000/product/{productId}/similar
```


| Parameter    | Type     | Description                           |
| :--------    | :------- | :--------------------------------     |
| `productId`  | `string` | **Required**. Id of product to fetch  |



## Authors

- [@eduardoucv](https://www.github.com/eduardoucv)


## Tech Stack

Java version: 17

Spring boot

Docker



  
