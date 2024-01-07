**Introduction**
1. Let’s imagine that we have taken a project from the airplane authority of India. They wanted us to build a software that displays the List of flight numbers that updates from a certain airport.

2. As we know there are so many airlines. Let’s consider some airlines AirIndia , Vistara, Indigo. Each airline has their list of flight numbers and they will be storing those data in some sort of data structure of their own choice.

3. We have to build a generic System which will be capable of retrieving the data from them and rendering the data on the display board.

4. It may be possible that each airline has their own way to store the Flight Numbers or Data. Let’s say the data provider of AirIndia stores the flight numbers in a BinarySearchTree , And in each node of that Binary Search Tree we can expect the data part to be an integer which will be our flight number.

5. The class BinarySearchTree has 3 attributes i.e. data (which is our  flight number ), left and right pointers . Here data is final or constant as it won’t be changing with time.

6. This class also has different methods , getters and setters  such as setData() , getData() , insert() etc . Here our getdata() method will return a List of integers containing flight Numbers.

7. So whatever software we develop , we will be talking to this getData() method for our System.

8. Let’s say Indigo Airlines stores their data in the form of LinkedList. Each node of LinkedList has two attributes i.e. val (final / constant)  and next , where val is an integer denoting Flight Number and next contains the address for next LinkedList Node.

9. This class also has some getters , setters, insert(), traverse() methods. But we will be dealing with the getData() method which will return us an array of LinkedList Nodes.

10. Let’s Say Vistara Airlines keeps their Data Storing process pretty simple with a List of integers and adds a new flight at the back of the single List and this class getData() Method returns us a Single List of Integer.

11. Now we can see that AirIndia gives us a List of TreeNodes and Indigo gives us an Array of LinkedList Nodes whereas Vistara AirLines gives us List of Integers. As a developer it is our responsibility to deal with this heterogeneous data to make a generic System.

12. Now Our Duty is to develop a Software that talks to these all airlines public getData() method and fetch the Data from them and one by one iterates on each List to render the flight Numbers on the Display Board.

13. Let’s Imagine for fetching data and rendering it on the display board we develop an API class. Which will iterate on each List ( List of LinkedList Node , List of BinaryTreeNode, List of Integer ) then our API class will violate the OPEN-CLOSE principle as for each new Airline added there must have different iterating syntax for displaying the flight numbers.

14. For these types of cases as a developer it is our responsibility to make code at our end a bit extensible . Code should be open for extension.


**Responsibility of Iteration**
1. To improve our previous Design we can ask all the Airlines data providers to implement a common getData() method which will always give us a List of Integers and this getData() method will be of polymorphic Type or Super Type .

2. Super Type could be something like an Interface ”DataStructure”.

3. Since BinaryTreeNode , LinkedListNode etc are data structures Hence we can implement an interface named “DataStructure”. And this interface will contain a method getData() which will return us a List of Integers.

4. Now All the AirLines can implement this interface and as a result they will be forced to return a List of Integers from their getData() method.

5. Now doing this we can remove the different iteration logic parts from our main code. And make it pretty clear.

7. Now we can implement a private function “Display()” which will take DataStructure as a parameter and call getData() on it. In return we will get a List of Integers which we will display by simply traversing on it.

8. In Our display() Method ,The Responsibility of iteration is at our end i.e. we are the one who knows when to stop while iteration or from where to start by declaring an iterator to 0 or start position.

9. Ideally these things should be abstracted out by the data Provider. Let’s imagine in the future instead of List of Integers we work on a Doubly ended queue. Then We don’t know from where or which end to start from.

10. Hence the easiest way to iterate over these Data Structures to Use two functions HasNext() and Next(). Where HasNext() will give a boolean value (True if there exists a Next value else False ) and Next() will give us the next value present in the data Structure.

**Iterable and Iterators**
1. From our last discussion we can think of creating an Iterator interface. This interface will consist of two methods i.e. boolean hasNext() and int next().

2. Then We can ask our BinaryTreeNode , LinkedListNode and List to implement this iterator interface. Now our MAIN will become independent and it will no longer need to set an iterator to some initial value and traverse it using a for loop. Instead we can use hasNext() and next() method and a while loop for traversal.

3. Problems with the above design where BinaryTreeNode , LinkedListNode and List implement this iterator interface is that these classes will Burden out as someTimes logic for iterators can be pretty complex.

4. It would be much cleaner to abstract out or decoupled hasNext() and next() from these classes. Let dataStructure as it is But separate out the hasNext() and next() for cleaner implementation.

5. Another problem is that there can be many ways to implement an iterator, for example BinarySearchTree Iterator can use logic of inorder , preorder or postorder giving birth to 3 different iterators.

6. Hence it is optimal to decouple the iterator from dataStructure class (BinaryTreeNode , LinkedListNode and List) and separate it out.

7. The data Structure should be made iterable. It should be possible to iterate. But do not make it implement the iterator. Just abstract out the Iterator and keep it separate.

8. Now we can make BSTIterator class , LinkedListIterator class and MyListIterator class and all of these classes will implement the iterator.

9. BSTIterator will contain a private final root variable , LinkedListIterator will contain a private final head variable and MyListIterator will contain a private final internalList. These all will be injected via the constructor.

10. Now we have the different iterators who are responsible for the actual iterations But how do we get them from data structures ? For that we should create a new interface called as iterable which all the data structures can implement.

11. This interface will contain a method getIterator() which will give us the iterator to iterate the particular data structure.

12. Now if we look at our design from High Level , we will see the two parallel interfaces i.e iterators and iterable.

13. Iterable is an interface that is being implemented by all the data structures or data  providers. Whereas iterators is an interface which is being implemented by all the concrete iterators whose responsibility is to take a data structure and figure out a way to implement hasNext() and next() method on top of them.

14. Doing this we have made our code very flexible. Also Responsibility of iterators have completely decoupled from the data structures and the data structures are iterables which they should be and they return a polymorphic type which is iterator.

**Concrete Iterators**
1. Now we will implement hasNext() and next() functions in our concrete classes.

2. We will write the logic for hasNext() and next() for all dataStructure i.e. BSTITerator, LinkedListIterator and MyListIterator..

3. After that we can change our Display function in main , Now it will take Iterable as parameter and initialize Iterator iterator = iterable.getIterator() .

4. We can iterate using a while loop with a condition iterator.hasNext() and till our hasNext() return True value we will printout our next().

**Conclusion**
1. As we see in our Lecture , debugging also became easier due to the way of  implementation we followed.

2. While using Unit Tests we can easily find out where the Bug resides in our code. This is a benefit of decoupling things.

3. Highest purpose of the LLD is to make code simple and extensible.

4. The Iterator pattern is not new to us, it has been implemented by the writers of language java.

5. Let’s Browse through the source code of the arrayList. Now inside the arrayList class we can see that it extends AbstractList .AbstractList is a supertype of arrayList.

6. On browsing the source code of abstractList we see that it implements another superType called List.

7. This List again extends the superType called as Collections. Collections are just like dataStructures .

8. If we go to these Collection source code then we can see that collections are iterables , they extend iterables Just like we have implemented in our design.

9. If we look into the iterator then we will find out that it has a method very similar to getIterator which we had implemented which returns us a generic iterator.

10. If we look deep into the iterator then we can see that it has the same methods hasNext() and next() in the source code.