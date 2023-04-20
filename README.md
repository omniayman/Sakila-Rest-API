# Sakila-Rest-API
This is a restful API that allows users to interact with the Sakila database. This API provides CRUD for customer, address, film, actor, category, staff, store, payment, rental, and inventory tables in Sakila database.
# Documentation
https://documenter.getpostman.com/view/26734817/2s93Y2T2Jy
# Technologies used:
- Tomcat
- MySql
- Maven
- MapStruct
- JAX-RS
- Hibernate
# Getting started
- Download Sakila database from this link:
- (https://dev.mysql.com/doc/index-other.html)
- For more details about the database documentation link:
- (https://dev.mysql.com/doc/sakila/en/)
- clone this repository
- Run the tomcat server
- change username and password and port number in pom.xml
- change username and password in persistence.xml
# EndPoints
### Actor
- GET /actors: Retrieves all actors in the database.
- GET /actors/{id}: Retrieves an actor by ID.
- GET /actors/search?name={name}: Retrieves actors by name.
- GET /actors/{id}/films: Retrieves all films associated with an actor.
- POST /actors: Adds a new actor to the database.
- PUT /actors/{id}: Updates an existing actor in the database.
### Address
- GET /address: retrieves all addresses
- GET /address/{oid}: retrieves an address by its ID
- GET /address/{id}/customers: retrieves all customers associated with an address
- GET /address/{id}/staff: retrieves all staff members associated with an address
- GET /address/{id}/stores: retrieves all stores associated with an address
- POST /address: adds a new address
- PUT /address: updates an existing address
### Category
- GET /category - retrieves all categories
- GET /category/{id} - retrieves a category by id
- PUT /category - updates a category
- POST /category - creates a new category
- GET /category/{id}/films - retrieves all films for a given category
- GET /category/name/{name} - retrieves all categories with a given name
- GET /category/count/{id} - retrieves the count of films in a given category
### customer
* POST /customer: adds a new customer.
* PUT /customer: updates an existing customer.
* GET /customer: returns a list of all customers.
* GET /customer/{id}: returns a specific customer by ID.
* GET /customer/{id}/homeStore: returns the home store of a customer.
* GET /customer/{id}/address: returns the address of a specific customer by ID.
* GET /customer/{id}/rents: returns a list of all rentals made by a specific customer by ID.
* GET /customer/{id}/payments: returns a list of all payments made by a specific customer by ID.
### Film
* GET /film: Returns a list of all films.
* GET /film/{oid}: Returns details of the film with the given ID.
* POST /film: Adds a new film.
* PUT /film: Updates an existing film.
* GET /film/{id}/CheckFilmInInventory: Checks if a film is in the inventory.
* GET /film/{id}/filmsCountInInventory: Returns the number of films in the inventory.
* GET /film/{id}/stores: Returns a list of stores where a film is available.
* GET /film/{id}/rate: Returns the average rate of a film.
* GET /film/{id}/rentals: Returns a list of rentals for a film.
### Inventory
* GET /inventory - returns all the inventory items.
* GET /inventory/{id} - returns the inventory item with the specified id.
* PUT /inventory - updates an existing inventory item.
* POST /inventory - adds a new inventory item.
* GET /inventory/{id}/checkInventoryInStock - checks if the inventory item with the specified id is in stock.
* GET /inventory/{id}/film - returns the film associated with the inventory item with the specified id.
* GET /inventory/{id}/store - returns the store associated with the inventory item with the specified id.
### Payment 
* GET /payment: Returns a list of all payments.
* GET /payment/{oid}: Returns a payment with the specified ID.
* PUT /payment: Updates an existing payment.
* POST /payment: Adds a new payment.
* GET /payment/{id}/customer: Returns the customer associated with a payment.
* GET /payment/{id}/rents: Returns the rental associated with a payment.
* GET /payment/maxPayment: Returns the highest payment amount.
* GET /payment/{id}/staff: Returns the staff member associated with a payment.
### Rental 
* GET /rents - returns a list of all rentals.
* GET /rents/{oid} - returns the rental with the specified id.
* PUT /rents/return/{oid} - marks the rental with the specified id as returned.
* POST /rents - adds a new rental to the system.
* GET /rents/{id}/customer - returns the customer associated with the rental with the specified id.
* GET /rents/{id}/inventory - returns the inventory associated with the rental with the specified id.
### Staff
* GET /staff - retrieve all staff members
* GET /staff/{id} - retrieve a specific staff member by ID
* PUT /staff - update a staff member
* POST /staff - add a new staff member
* GET /staff/{id}/rents - retrieve all rentals associated with a specific staff member
* GET /staff/{id}/payments - retrieve all payments associated with a specific staff member
* GET /staff/{id}/isManager - check if a specific staff member is a manager
* GET /staff/active - retrieve the number of active staff members
* GET /staff/name/{name} - retrieve all staff members with a specific name
* GET /staff/{id}/address - retrieve the address of a specific staff member by ID
### Store 
* GET /store: Returns a list of all stores.
* GET /store/{id}: Returns the store with the specified ID.
* PUT /store: Updates an existing store.
* POST /store: Creates a new store.
* GET /store/{id}/address: Returns the address of the store with the specified ID.
* GET /store/{id}/customers: Returns a list of customers for the store with the specified ID.
* GET /store/{id}/staff: Returns a list of staff for the store with the specified ID.
* GET /store/{id}/manager: Returns the manager of the store with the specified ID.
* GET /store/{id}/films: Returns a list of films available at the store with the specified ID.
* GET /store/{id}/rents: Returns a list of rentals for the store with the specified ID.

