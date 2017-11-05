# Homework 4
#### Garbage Collector 

Write an application that logs GC activity for each type (young, old) 
and the time spent for garbage collection in minutes.
- Make sure that the application crashes with ```OutOfMemory``` error
due to slow memory leak. For example, by constantly adding elements to
 ```List``` and removing only half of them.
- Get the application crashing with ```OutOfMemory``` error after 5
minutes have elapsed.
- Log the stats of GC activity (number of collections, time spent in
minutes) for different types of GC.

