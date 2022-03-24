
# Laboratorul 4

 * [Compulsory](#Compulsory) :heavy_check_mark:
 * [Homewrok](#homework) :heavy_check_mark:
 * [Bonus](#bonus) :hourglass:

## Enunt

Use appropriate collections in order to represent data (otherwise: -0.5 points)

Use Java Stream API in order to perform aggregate operations on data.

A city hall wants to install surveillance cameras at all intersections in a city.
To do this, it must connect all intersections with data cables, along the streets between them, such that the resulting network is connected.
We assume that the lengths (in km) of the streets between all the intersections of the city are known and the costs of installing the cables is proportional with the street lengths.
The problem is to determine how to install the data cables (on which streets) such as the total cost is minimum.

Example (the dots are the intersections, the lines are the streets)


![image](https://user-images.githubusercontent.com/79217056/159515649-fc094ee7-7e0f-4b22-8508-c3e7d89b82fc.png)

## Compulsory 

Este implementat in Homework, dar nu este trimis la timp :disappointed_relieved:

### Enunt!
 * Create a Maven project. :heavy_check_mark:
 * Create an object-oriented model of the problem. Streets have names and lengths, intersections have names. A street joins two intersections. :heavy_check_mark:
 * Create the streets and the intersections of the problem described in the example. Use streams in order to easily create the intersections. :heavy_check_mark:
 * Create a list of streets, using LinkedList implementation and sort it by the length, using a comparator expressed as a lambda-expression or method reference. Make sure all the objects are comparable. :heavy_check_mark:
 * Create a set of intersections, using a HashSet implementation. Verify the property that a Set does not contain duplicates.:heavy_check_mark:

## Homework

### Enunt
  * Create a class that describes the city. :heavy_check_mark:
  * Using Java Stream API, write a query that display all the streets that are longer than a specified value and join at least 3 streets. :heavy_check_mark:
  * Use a third-party library in order to generate random fake names for intersections and streets.  :heavy_check_mark:
  * You may use this package of JGraphT in order to solve the problem (or other library). :heavy_check_mark:
  * A personal implementation of the algorithm will be will be scored extra (+1p). :heavy_check_mark:

![image](https://user-images.githubusercontent.com/79217056/159517954-e4329273-0b50-4bf1-a87f-ed690252697b.png)

## Bonus 

In curand
