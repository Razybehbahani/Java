In this project we are going to code that finds a path from the entrance chamber of a mystical pyramid to all the treasure chambers. The path should not include any sealed or dark chambers.   

Chambers are in one of the types Sealed, Lighted, Dim, Dark, Entrance or Treasure chambers. Starting from the Entrance chamber, next chamber in the path is prefered from 6 neighboring chambers with the priority of 1) if it has tresure in it; 2) if it is lighted; 3) if it is Dim; meeting the condition that the neighbor-chamber has not been tried before. We use double linked list stacks for saving the path. 

We have the following classes:
- Chamber.java
- DLStack.java
- DLStackADT.java
- DoubleLinkedNode.java 
- FindPath.java
- Pyramid.java 
- TestStackMap.java

In this project we will get practice with
- Implementing doubly linked lists
- Implementing an extended stack ADT using doubly linked lists
- Finding a path in a map using a stack


To check the code
1- one can run the tests defined in `TestStackMap.java`
2- try 5 different maps named map#.txt. For this test you need to adjust the run configuration, by including the path of the all the files and tests in the working directory and specifying the name of the testing map in Build and run part.

   
