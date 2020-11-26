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

OR

Run a MySQL Server on a GCP instance

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
In this project, I have included JUnit tests to ensure that the code is working to specifications by running these tests and making sure that they all pass. **The coverage of the entire project is 88.3%.**

### Unit Tests 

There are three main test suites in the project. These are stored under:

```
src/test/java -> com.qa.ims
```

The test suites are: 
-Controllers
-DAO
-Domain

Each test suite has a corresponding test suite that tests if the program has failed correctly. An example of this is:

```
CustomerDAOTest.java
```
and
```
CustomerDAOTestFail.java
```

#### Domain
These tests use JUnit to test the Customer, Item, Order, and OrderLine classes. These consist of constructor tests, getters and setters tests, and method tests.

#### DAO
These tests use JUnit to test the DAOs that 'bridge the gap' between the objects in Domain and the Database. It feeds in objects to the DAO and checks the output after the database has been updated.

#### Controllers
These tests use Mockito to test the controllers that connect the User to the DAOs.

To run all of the tests, make sure that a MySQL server is running as either a localhost or GCP instance.
In the Package Explorer, right-click on the _src/test/java_ folder then Run As, then JUnit Test.

It usually take 5 minutes to complete all tests.


## Deployment

To run the .jar file from the command-line, navigate to the directory that holds the _ims-x.x.x-jar-with-dependencies.jar_ file and execute the following command once you have ensured that a MySQL localhost Server is running on your machine:

Example:
```
java -jar ims-0.0.1-jar-with-dependencies.jar
```

Username:
```
root
```

Password:
```
root
```


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
