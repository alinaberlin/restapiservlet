# restapiservlet
Exercise

Using the code provided create another resource with which the client interacts and expose it in your API.

1. Create a table in MySQL using the following command

CREATE TABLE Products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL
);

2. Create a ProductsDao class where you are going to write CRUD methods for Products

3. Create a ProductsResource class where you will expose methods for:
    - Adding a product
    - Getting all products
    - Getting a specific product
    - Deleting a product
    - Updating a product

4. Add the ProductResource to the ResourceConfig in the Main class
