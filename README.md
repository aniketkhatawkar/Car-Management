# Car Management API

This is a Spring Boot-based Car Management API that allows users to manage car details. The API provides endpoints to **create**, **read**, **update**, and **delete** car entries. It supports features such as **pagination**, **sorting**, **global search**, and **validation**.

## Features
- Create, Read, Update, and Delete cars
- Global search by car attributes (name, model, year, color, fuel type)
- Pagination and sorting for handling large datasets
- Input validation to ensure correct data
- API documentation with Swagger/OpenAPI

## Technologies Used
- Spring Boot
- Spring Data JPA
- H2 Database (for development)
- Java 17
- Postman for testing and API documentation

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.x
- IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/car-management-api.git
Navigate to the project folder:

bash
Copy code
cd car-management-api
Build the project using Maven:

bash
Copy code
mvn clean install
Run the application:

bash
Copy code
mvn spring-boot:run
The application will start at http://localhost:8080.

Accessing Swagger API Documentation
Once the application is running, you can access the Swagger UI to explore the API endpoints:

bash
Copy code
http://localhost:8080/swagger-ui.html
This provides an interactive interface to test the endpoints.

API Endpoints
1. Create a Car
Method: POST
URL: /api/cars
Request Body:
json
Copy code
{
    "name": "Toyota Camry",
    "model": "2023",
    "year": 2023,
    "price": 30000,
    "color": "Red",
    "fuelType": "Petrol"
}
Response: The created car object with an ID.
2. Get All Cars
Method: GET
URL: /api/cars
Query Parameters:
page: Page number (default: 1)
size: Number of items per page (default: 10)
sort: Sorting order (e.g., name,desc for descending order)
Response: A list of cars with pagination.
3. Get Car by ID
Method: GET
URL: /api/cars/{id}
Response: The car object with the specified ID.
4. Update a Car
Method: PUT
URL: /api/cars/{id}
Request Body:
json
Copy code
{
    "name": "Toyota Camry",
    "model": "2024",
    "year": 2024,
    "price": 32000,
    "color": "Black",
    "fuelType": "Diesel"
}
Response: The updated car object.
5. Delete a Car
Method: DELETE
URL: /api/cars/{id}
Response: A 204 No Content status indicating successful deletion.
6. Global Search
Method: GET
URL: /api/cars/search
Query Parameters:
name: Car name
model: Car model
year: Car year
color: Car color
fuelType: Car fuel type
Response: A list of cars matching the search criteria.
7. Pagination & Sorting
Method: GET
URL: /api/cars
Query Parameters:
page: Page number
size: Number of cars per page
sort: Sorting criteria (e.g., name,desc)
Testing the API with Postman
Import the Postman collection Car Management API by downloading it or creating it manually based on the API documentation.
Test the API endpoints as described in the Postman collection.
Make sure the server is running (http://localhost:8080) while testing with Postman.
Validation Rules
Car Name: Required, should not exceed 100 characters.
Car Model: Required, should be in the format YYYY (e.g., 2023).
Year: Required, should be a valid year (e.g., 2023).
Price: Required, should be a positive value.
Color: Required, should not exceed 50 characters.
Fuel Type: Required, should be one of the following: Petrol, Diesel, Electric.
License
This project is licensed under the MIT License - see the LICENSE file for details.

markdown
Copy code

### Steps Explained:
1. **Getting Started**:
   - This section gives instructions to clone and run the application, including prerequisites and build commands.
   
2. **API Endpoints**:
   - Lists all available endpoints with their HTTP methods, request body, and expected responses.

3. **Swagger Documentation**:
   - Provides the link to access the interactive API documentation.

4. **Testing**:
   - Guides on using **Postman** to test the API after the server is up and running.

5. **Validation Rules**:
   - Ensures proper data validation and input checks.

Feel free to modify the repository links and license sections according to your needs.
