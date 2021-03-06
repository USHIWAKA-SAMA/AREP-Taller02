# Workshop SparkWeb - AREP

This web application calculates the mean and the standard deviation of a given set of *n* real numbers.

The application is deployed here:
[Heroku deployment](https://quiet-wave-52141.herokuapp.com/)

##### Status
[![CircleCI](https://circleci.com/gh/JulianBenitez99/AREP-Taller02.svg?style=svg)](https://circleci.com/gh/JulianBenitez99/AREP-Taller02)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
#### Java
Java 1.8 JDK is necessary, check if it is installed by typing in the command prompt `java -version` and `javac -version`. The result should be similar to this:

```
java -version
java version "1.8.0_241"
Java(TM) SE Runtime Environment (build 1.8.0_241-b07)
Java HotSpot(TM) 64-Bit Server VM (build 25.241-b07, mixed mode)

javac -version
javac 1.8.0_221
```
If the command is not recognized, you can follow the instructions to install Java JDK 1.8 [here.](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

#### Maven
Maven is also necessary, you can check if it is installed by typing in the command prompt `mvn -v`. If installed, the result should be similar to this.

```
mvn -v

Apache Maven 3.6.1 (d66c9c0b3152b2e69ee9bac180bb8fcc8e6af555; 2019-04-04T14:00:29-05:00)
Maven home: C:\Program Files\Apache Maven\bin\..
Java version: 1.8.0_221, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_221\jre
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

If the command is not recognized, you can follow the instructions to install Maven [here.](https://maven.apache.org/install.html)

#### Heroku CLI
Heroku CLI is necessary for deployment, you can check if it is installed by typing in the command prompt `heroku -v`. If installed, the result should be similar to this.

```
heroku -v
heroku/7.37.0 win32-x64 node-v12.13.0
```

If the command is not recognized, you can follow the instructions to install Heroku CLI [here](https://devcenter.heroku.com/articles/heroku-cli#download-and-install).
### Installing

Clone the repository and go to the folder `AREP-Taller02`.

`git clone https://github.com/JulianBenitez99/AREP-Taller02.git`

To compile the project, in the command prompt type:

```
mvn package
```

This downloads the dependencies needed for the project and executes the tests. After it finishes, the project its ready for it to be used.

### Running the Project
In Windows or Linux, to run the web application type in the command prompt:

```
mvn exec:java
```
Access the web application in http://localhost:4567.

Using Heroku CLI in Linux, type in the terminal:

```
heroku local web
```
Access the web application in http://localhost:5000.

## Running the tests

The project counts with tests for the `LinkedList` and `StatisticUtils` classes. They can be run by typing in the command prompt:

```
mvn test
```

### LinkedListTest class

This class is used for testing all the implemented methods of the linked list, verifying their correct implementation.

Example:
```java
public class LinkedListTest{
    ...
    @Test
    public void shouldGetTheElementAtTheSpecifiedIndex() {
      List<Integer> compareList =  new ArrayList<>();
      List<Integer> linkedList = new LinkedList<>();
      Random random = new Random();
      for (int i = 0; i < 250; i++) {
        compareList.add(random.nextInt(1000));
      }
      linkedList.addAll(compareList);
      for (int i = 0; i < compareList.size(); i++){
         assertEquals(compareList.get(i), linkedList.get(i));
       }
    }
    ...
}
```

### StatisticUtilsTest class

Test for the methods used in statistics, mean and standard deviation.

Example:
```java
public class StatisticUtilsTest {

    @Test
    public void shouldGiveSameMeanAndStdAsTheData01(){
        List<Double> linkedList = new LinkedList<>();
        linkedList.add(160d);
        ...
        linkedList.add(624d);
        double mean = StatisticUtils.calculateMean(linkedList);
        double stdv = StatisticUtils.calculateStandardDeviation(linkedList);
        assertEquals(550.6, DoubleRounder.round(mean, 2), 0.0);
        assertEquals(572.03, DoubleRounder.round(stdv, 2), 0.0);
    }
}
```
## Deployment
To deploy this project in Heroku, clone this repository and in the folder `AREP-Taller02`.

Create the Heroku app: 
```
heroku login
heroku create
git push heroku master
```
Open the web application:
```
heroku open
```


## Design Document
The document describing the desing is [DESIGN.pdf](DESIGN.pdf)

## JavaDocs
JavaDocs are available in the `javadocs` folder. Opening `javadocs/index.html` in the browser will display them.

JavaDocs can be generated by going to `AREP-Taller02` folder and typing in the command prompt:

```
mvn javadoc:javadoc
```

The resulting JavaDocs will end in `target/site`.

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spark](http://sparkjava.com/) - A micro framework for creating web applications

## Authors

* **Julián Benítez Gutíerrez** - *Development* - [JulianBenitez99](https://github.com/JulianBenitez99)


## License

This project is licensed under the GNU License - see the [LICENSE.md](LICENSE.md) file for details.
