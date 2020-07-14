# Store management

store-springboot is a multi-module GraphQL API Spring Boot application that manage our 3 entities through CRUD operations:
- User
- Product
- Order

## Dependencies

- spring-boot-starter-data-jpa
- spring-boot-starter-web
- spring-boot-devtools
- mysql-connector-java
- graphql-java-tools
- graphiql-spring-boot-starter

## Requirements
- JDK 11
- Maven


## Installation

### Clone
Clone this repository to your local machine `https://github.com/javato/storeAssignment`.

### Import
Import as a maven project.

### Run locally
As it is a Spring Boot Application, a way is to execute the main method in the `org.jroldan.store.launcher.ControllerLauncher` class from your IDE.

## Docker

Instead of download the source code and run it locally, we have the possibility to deploy it directly using a Docker image.

### Prerequisites

In order to run this image you will need docker installed.
- [Windows](https://docs.docker.com/windows/started)
- [OS X](https://docs.docker.com/mac/started/)
- [Linux](https://docs.docker.com/linux/started/)

### Usage

We can pull it to our computer from our public repository:

```bash
docker pull dozze/store-springboot-jroldan:onlyjre
```

And then run it:

```bash
docker run --name store-springboot-jroldan -p 8080:8080 dozze/store-springboot-jroldan:onlyjre
```

## GraphQL API

### Endpoints

- Our server is listening for GraphQL requests at `http://localhost:8080/graphql`
- We can make requests through GraphiQL at `http://localhost:8080/graphiql`

### Schema

Our main schema file is `schema.graphqls`, and it is extended by:
- `user.graphqls`
- `product.graphqls`
- `order.graphqls`

## GraphQL requests

### 1. CRUD for managing Users

- Create User

```graphql
mutation{
  saveUser(user: {
    name: "New Name"
    email: "New Email"
    password:"New Password"
  }) {
    idUser
    name
    email
    password
  }
}
```

- Read User

```graphql
query{
  getUser(idUser: 5) {
    idUser
    name
    email
    password
  }
}
```

- Read all Users

```graphql
query{
  getAllUsers{
    idUser
    name
    email
    password
  }
}
```

- Update User

```graphql
mutation{
  saveUser(user: {
    idUser: 8
    name: "Updated Name"
    email: "New Email"
    password:"New Password"
  }) {
    idUser
    name
    email
    password
  }
}
```

- Delete User

```graphql
mutation{
  deleteUser(id: 7)
}
```

### 2. CRUD for managing Products
- Create Product

```graphql
mutation{
  saveProduct(product: {
    name: "New Product"
    stock: 100
    price: 25.99    
  }) {
    idProduct
    name
    stock
    price
  }
}
```

- Read Product

```graphql
query{
  getProduct(idProduct: 5) {
    idProduct
    name
    stock
    price
  }
}
```

- Read all Products

```graphql
query{
  getAllProducts{
    idProduct
    name
    stock
    price
  }
}
```

- Update Product

```graphql
mutation{
  saveProduct(product: {
    idProduct: 7
    name: "Updated Product"
    stock: 100
    price: 25.99    
  }) {
    idProduct
    name
    stock
    price
  }
}
```

- Update Stock

```graphql
mutation{
  updateStock(idProduct: 5, stock: 100) {
    idProduct
    name
    stock
    price
  }
}
```

- Delete Product

```graphql
mutation{
  deleteProduct(idProduct: 12)
}
```

### 3. POST for managing Orders

- Create Order
```graphql
mutation {
  newOrder(order :{
    productLines: [
      {
        quantity: 1
        product:{
          idProduct: 4
        }
      }
      {
        quantity: 2
        product: {
          idProduct: 5
        }
      }
    ]
    user:{
      idUser: 5
    }
  }) {
    idOrder
    productLines{
      product{
        idProduct
        name
        stock
        price
      }
      quantity
    }
    user{
      idUser
      name
      email
    }
  }
}
```

### 4. GET all orders given a customer

```graphql
query{
  getOrdersByUser(user: {idUser: 1}) {
    idOrder
    productLines{
      product{
        idProduct
        name
        stock
        price
      }
    }
  }
}
```

### 5. GET all products given an order

```graphql
query{
  findProductsByIdOrder(idOrder: 1) {
    idProduct
    name
    stock
    price
  }
}
```

## License
Released under the Apache License 2.0. See the LICENSE file.
