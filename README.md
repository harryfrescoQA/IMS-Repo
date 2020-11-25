Coverage: 34%
# QA IMS Java Project

This Inventory Management System uses a command-line interface to allow a user to perform CRUD operations on a variety of objects. These objects are Customer, Item and Order. A customer can have many orders, Orders can have many items. A MySQL Server database is used to hold the schema and it's data.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Install: Eclipse IDE for Java

Install: Java Development Kit 14

Install: Maven

Install: MySQL Server (for localhost running/testing) and MySQL Workbench

```

### Installing

Once this repo has been downloaded or cloned, open the project in Eclipse:

```
File -> Import -> Select Maven/Existing Maven Projects -> Browse to the folder and click Finish
```
Ensure that a localhost MySQL is set-up on your computer by opening MySQL Workbench, and under MySQL Connections is 

```
root
localhost:3306
```

Right click Runner.Java -> Run With... -> Java Application

Username:
```
root
```

Password:
```
root
```
The domain menu is then shown. This is where you can select the entities and then perform CRUD operations.

### Example with Customer

```
Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
STOP: To close the application
```
Type:
```
customer
```

then:
```
read
```
You will see:
```
ID       First Name:     Surname:
------------------------------------

 1       Jordan          Harrison
```
To create a customer type:
```
create
```
then enter the name of the customer you would like to create. To read it after creation simply type
```
read
```
and you will see:
```
ID       First Name:     Surname:
------------------------------------

 1       Jordan          Harrison

 2       f               d
```

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Explain what these tests test, why and how to run them

```
Give an example
```

### Integration Tests 

Explain what these tests test, why and how to run them

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
