# ClassCastException

- When references to objects points to objects different classes
- When argument is wrong type, method compareTo should throw ClassCastException
- No explicit casting
- Try add wrong data type to collection or array
- SerialVersionUID


# Constructor Chaining

Call in the same class this()
Call from parent class super()
Use to execute more tasks in one constructor
Improve readability of code

+-----------------------------------------+
| public Temporary(int x, int y) {//23,34 |
|    this(5);                             |
|    System.out.print(" " + x * y + " "); |
| }                                       |
| public Temporary(int x) {     //5       |
|     this();                             |
|     System.out.print(" " + x + " ");    |
| }                                       |
| public Temporary() {                    |
|     System.out.print(" Default ");      |
| }                                       |
|//Temporary temp = new Temporary(23, 34);|
|-> Default  5  782                       |
+-----------------------------------------+


# Overloading

Compile time polymorphism
Use the same method name but with different arguments
static binding binds private, final, static method, fields, class, variables


# Overriding

Runtime polymorphism
The same method name with exactly the same arguments
dynamic binding

We cannot override private methods in Java as if we declare any variable, method as private that variable or method
will be visible for that class only and also if we declare any method as private than they are bounded with class at compile
time not in runtime so we can't reference those method using any object

You cannot override static method in Java because method overriding is based upon dynamic binding at runtime
and static method are bounded using static binding at compile time


# final

Value of member variable cannot be changed
Object reference cannot be changed
Class cannot be inherited
Method cannot be Overriding


# finally

Try, catch block. Stuff in finally always be executed, even when in try return statement
Finally does't execute in cases like
program crash before go to this block or System.exit(0) in try


# finalize

JVM call this method when GC is about to be called


# == vs equals

== check whether object are the same (point to the same place in memory, the same object)
.equals() when compare content of objects


# Class Loaders

A Java class is made up of a number of custom classes (written by programmers) and core classes
(which come pre-packed with Java). When program is executed, JVM needs to load the content of the needed class.
JVM uses class loader to find the classes.

- Bootstrap Class Loader : Loads all the Java core files
- Extension Class Loader : Loads all classes from extension directory
- System Class Loader : Loads all classes from CLASSPATH

When JVM needs to find a class, it starts with System Class Loader. If it is not found, it checks with Extension Class Loader.
If it not found, it goes to the Bootstrap Class Loader. If class is still not found, a ClassNotFoundException is thrown.

+---------------------------------------------------------------------------------------------------+
| System Class Loader -> Extension Class Loader -> Bootstrap Class Loader -> ClassNotFoundException |
+---------------------------------------------------------------------------------------------------+


# Autoboxing

Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their
corresponding object wrapper classes. For example, converting an int to an Integer, double to a Double.
If conversions goes the other way it is called unboxing.
Auto boxing helps in saving memory by reusing already created wrapper objects. However wrapper classes
created using new are not reused.

Two wrapper objects created using new are not same object

+--------------------------------------------------+
| Integer nineA = new Integer(9);                  |
| Integer nineB = new Integer(9);                  |
| System.out.println(nineA == nineB); // false     |
| System.out.println(nineA.equals(nineB)); // true |
+--------------------------------------------------+

Two wrapper objects created using boxing are same object

+--------------------------------------------------+
| Integer nineC = 9;                               |
| Integer nineD = 9;                               |
| System.out.println(nineC == nineD); // true      |
| System.out.println(nineC.equals(nineD)); // true |
+--------------------------------------------------+

Wrapper classes are final and immutable.


# SerialVersionUID

Mark added to class to during deserialization, reconstruct proper class (unique identifier).
Useful when there is some complex class hierarchies parent class, child class.


# this

Can separate local variables from instance variables.
'this' determines instance variables.
Use this reference when instance and local variables have the same name.


# static

For specified class can be only one static variable.
Initialization is during class loading. Static method does not work on objects. Math.pow(x,a)
Gets memory only once in class are at time class loading.
Refer to common property of all objects, company name for example.
Static methods belongs to class rather than object of class.
Can be invoked without creating an instance of class.
'this' and 'super' cannot be used in static context.

# Why java main method is static?
Because object is not required to call static method if it were non static method, jvm create object first
then call main() method that will lead the problem of extra memory allocation.

Static block is used to initialize the static data member. It is executing before main method at the time of class loading.
Static, variable (class variable), method (class method), block, nested class.
Factories methods - static methods that returns new class instance.

You cannot override static method in Java because they are resolved at compile time rather than runtime

In Java6 it was possible to run program without main method by using static initialization block. It is not a case anymore.

+-----------------------------------------+
| public class Foo {                      |
|     static {                            |
|          System.out.println("Message"); |
|          System.exit(0);                |
|     }                                   |
| }                                       |
+-----------------------------------------+


# What are Initialization Blocks

Initialization blocks - code which runs when an object is created or class is loaded.
There are two types of Initialization blocks.
- Static Initializer : Code runs when a class is loaded
- Instance Initializer : Code runs when a new object is created


# What is static initializer

Code within static '{}' is called a static initializer. This is run only when class is first loaded.
Only static variables can be accessed in a static initializer. Even though three instances are created static
initializer is run only once.

+---------------------------------------------------------------------+
| public class InitializerExamples() {                                |
|   static int count;                                                 |
|   int i;                                                            |
|   static {                                                          |
|       // Static initializer is run only when class is first loaded. |
|       // only static vars can be accessed                           |
|       // i = 6; // ERROR                                            |
|       count = 2; // OK                                              |
|   }                                                                 |
| }                                                                   |
+---------------------------------------------------------------------+


# What is Regular Expression

Regular Expression makes parsing, scanning and splitting a String very easy.
Java classes:
- Pattern
- Matcher
- Scanner


# Enum

Sometimes you need to define connected constants like

+------------------------------------+
| public static final int MONDAY = 0 |
+------------------------------------+

You can do this using enum
Now weekday is data type with values Weekday.MON

+--------------------------+
| enum Weekday {MON, TUE}; |
+--------------------------+

+--------------------------------------------+
| public Enum Size { SMALL, MEDIUM, LARGE; } |
+--------------------------------------------+

Named constants. No need to use equals method. No need to override toString.
Thread safe.
Enum is subclass class of Enum class, which contains toString, valueOf and compareTo method
Compare element using ==
Methods : valueOf, ordinal
Enum constructors are always private.
Variables Enum type can contains static variables
static import now can use SMALL instead of Size.SMALL

Enum alows specifying a list of values for a Type.
Example below declares an enum Season with 4 possible values

+--------------------------------+
| enum Season {                  |
|   WINTER, SPRING, SUMMER, FALL |
| };                             |
+--------------------------------+

Value of enums can be compared using == or equals function.


# Variable arguments

Variable arguments allow calling method with different number of parameters.

+----------------------------------+
| public int sum(int... numbers) { |
|   ...                            |
| }                                |
+----------------------------------+


# String

Immutable and final
- Thread safe : prevent from change cache
- String pool cache : (optimization)
- Hash codes : keys in hashCodes are Strings

# Why String is immutable?
Value of a String once created cannot be modified. Any modification on a String object creates a new object.

+--------------------------------------+
| String str3 = "string1";             |
| str3.concat("string2");              |
| System.out.println(str3); // string1 |
+--------------------------------------+

The result should be assigned to a new reference variable (or some variable can be reused)

+-----------------------------------------------+
| String concat = str3.concat("string2");       |
| System.out.println(concat); // string1string2 |
+-----------------------------------------------+

# Where are String literals store in memory?
All strings literals are stored in "String constant pool". If compiler finds a String literal, it checks if
it exists, it is reused.
Following statement creates 1 String object (created on pool) and 1 referenced variable

+------------------------+
| String str1 = "Value"; |
+------------------------+

However if 'new' operator is used to create String object, the new object is created on heap.
Following piece of code created 2 objects

+----------------------------------------------------------------------+
| // 1. String Literal "Value" - created in the "string constant pool" |
| // 2. String object - created on the heap                            |
| String str1 = "Value"                                                |
| String str2 = new String("Value");                                   |
+----------------------------------------------------------------------+

Some methods:
.charAt()
.length()
.equalsIgnoreCase()
.substring()


# toString method

Is used to print a content of an object. If not overridden default implementation is printed.
It prints hashCode and class name. If is overridden new content is printed


# Interfaces

- All methods public abstract (Since Java8 can also be static and default methods)
- All properties public static final

Implement interfaces, want to imitate behavior of class
Use to impose behavior on other classes

You can implements more than one interface (impose behavior), example implements Comparable interface (strategy pattern)
to extort sorting behavior.

You cannot put instance variables. Interface determines behavior not state of object.
You can provide default implementation of interface. Mark such method with 'default' modifier

+-----------------------------------------------+
| public interface IntSequence {                |
|     default boolean hasNext() {return true; } |
| }                                             |
+-----------------------------------------------+

Keyword super allows to call super type methods
Comparable interface when class want to allow sort their elements Comparable.
Callback - code fragment is call as a result on user response
Interface is used heavily in API to define contract of a class.
You cannot create non abstract method in interface. All methods are for default abstract.
Since Java8 methods in interfaces can contain 'default'. 'static' and 'abstract' methods.


# Class Object

Parent class of all classes
- hashCode
- equals
- toString - representation of object as String by default class name plus hash
- clone


# Abstract class and methods

Cannot instantiate abstract class
Are needed during inheritance
Want something to be overridden to not forget about it later
Additional responsibilities added to class


# OOP

- Objects : containers that keep variables functions thematically connected to each others, to use it easier later
- Classes : frame to build instances of objects
Objects have, properties, methods
- Constructor : reserve space in memory for object
Creating an object from a class is called instantiation

Constructor references
Are counterpart to method references.
Employee::new
int[]::new === n->new int[n]

Local class is not declared as public or private as it isn't available outside of method

Abstract method does not have implementation, abstract class can not have instantiation.
Class can define methods without implementation forcing subclasses to implement them.
Such method and class that contain it are called abstract.
Abstract classes can have instance variables or constructors.
Cannot instantiate abstract class
Abstract class is used to provide default implementation with something left to customize.

Encapsulation - use of objects implemented by someone else, use their methods without know what sits inside

Instance variable are in default initialized
Local variables need to be explicitly initialized

If part can exists without whole then relationship between two class is known as 'aggregation'
If part cannot exists without whole the relationship between two class is known as 'composition'


# What is the difference between composition and inheritance ?

Composition refers to defining behavior by member variables a class includes
Inheritance refers to defining behavior by the interfaces or classes that a class inherits from
Composition = "has-a", Inheritance = "is-a"


# Association

The Association relationship indicates that class know about and holds reference to another class.
Association can be described as "has-a" relationship

+-------------------------+           +----------------------------+
| public class Cannon {   |           | public class Plane {       |
|   private Plane target; |           |     private Cannon target; |
|   private int posX;     +---------->+     private int posX;      |
|   private int posY;     |           |     private int posY;      |
|   private int damage;   |           |     private int damage;    |
|   ...                   |           |     ...                    |
| }                       |           | }                          |
+-------------------------+           +----------------------------+


# Aggregation

One object is User of another object.

+-----------------------------+       +----------------------------+
| public class Organization { |       | public class Person {      |
|   private List employees;   +-----<>+   private String name;     |
| }                           |       | }                          |
+-----------------------------+       +----------------------------+


# Composition

One object is an owner of another.

+---------------------------------------------+         +------------------------+
| public class Car {                          |         | class Engine {         |
|   // final make sure that will be initiated +------<*>+   private String type; |
|   private final Engine engine;              |         | }                      |
|   public Car() {                            |         +------------------------+
|       engine = new Engine();                |
|   }                                         |
| }                                           |
+---------------------------------------------+

Relations between objects only differ in their strength. Composition strongest relationship, ASSOCIATION the most general.

+-------------------------------+
|   ASSOCIATION                 |
|   +-------------------------+ |
|   |   AGGREGATION           | |
|   |   +-------------------+ | |
|   |   |   COMPOSITION     | | |
|   |   +-------------------+ | |
|   +-------------------------+ |
+-------------------------------+


# How are the Strategy Pattern and Dependency Injection related ?

Each defines behavior by setting member variables of a class


# Reflection

Reflection is a way to invoke methods of objects on the fly at run-time
Reflection is slow and complicated. Method call via reflection may take 10x longer than usual
Instantiation an object from a name of a class
Reflection is the ability at runtime to actually create objects of classes, invoke methods, manipulate metadata

Type introspection is the ability at runtime to explore the type of an object.

Reflection drawbacks: complexity, performance overhead, security consideration, violation of abstraction

Reflection is good for unit testing jUnit


# Volatile

Declaring variable volatile means the value of this variable will never be cached thread locally
All reads and writes will go straight to main memory. Access to the variable acts as through it is
enclosed in a synchronized bock, synchronized on itself
Slower than cache, make sure value be read every time

Happens-before relationship means any writes happens before any read in volatile variable
Every thread reads its value from main memory and don't used cached value available in every thread stack
Volatile variable prevents compiler from doing reordering which can compromise synchronization

Only applicable to field or properties of class.
You cannot use volatile keyword during class or method declaration in Java


# Synchronized

Every objects in Java has a lock associated with it
This lock is called the intrinsic lock or monitor. It is possible to specify that only one thread can
execute a section of code once it has acquired the lock on same object
If some other thread currently holds that lock, the current thread must waits its turn
This is achieved using synchronized keyword

Using right making a method synchronized can help eliminate thread interference and memory consistency error
Making method synchronized is a shortcut to making the entire body of the method as synchronized on "this"
If we use synchronized we don't need to use volatile keyword


# Enumerator and Iterator differences

Iterator allows you to remove elements from collection. Methods for iterator hasNext(), next()
Iterator does not allow other thread to modify the collection object while some thread is iterating over it and throws
ConcurrentModificationException

Enumerator hasMoreElements(). For Collections read only


# What is load factor of HashMap

HashMap performance depends on two things initial capacity and load factor.
Whenever create HashMap initial capacity number of buckets is created initially and load factor is criteria
to decide when we have to increase the size of HashMap when its about to get full


# Why wait and notify is declared in Object class instead Thread?

Both are communication mechanism between two threads in Java
Object class makes them available for every object if this mechanism is not available via any Java keyword like
synchronized
Locks are available on per Object basis, which is another reason wait and notify is declared in Object class
rather than Thread class


# Why wait and notify called from synchronized method in Java?

To avoid:
- IllegalMonitorStateException which will occur if we don't call wait(), notify() or notifyAll() method
from synchronized context
- Any potential race condition between wait and notify method in Java


# What will happen if we put a key object in a HashMap which is already there?

It will replace the old mapping because HashMap doesn't allow duplicate keys
The same key will result in the same hashcode and will end up at the same position in the bucket
Each bucket contains a linked list of Map.Entry object, which contains both Key and Value
Now Java will take the Key object from each entry and compare with this new key using equals() method, if
that return true then value object in that entry will be replaced by new value


# Casting

Casting is used when we want to convert one data type to another. Two types of casting:
- Implicit casting
- Explicit casting

Implicit Casting is done by compiler. Good example of implicit casting are all the automatic widening conversions
i.e. storing smaller values in larger variables types.

+------------------------------------------+
| int value = 100;                         |
| long number = value; // Implicit casting |
| float f = 100; // Implicit casting       |
+------------------------------------------+

Explicit Casting is done through code. Example are narrowing conversions - storing larger values into smaller variables.
Explicit casting would cause truncation of value if the value stored is greater than the size of varible.

+------------------------------------------+
| long number1 = 12345;                    |
| int x = (int) numer1; // Explicit castig |
+------------------------------------------+


# Variables initialization in Java

- Member object and static class variables are always initialized with default values
- Local/block variables are NOT initialized by complier

+-----------------------------------------------------------+
| public class VariableInit {                               |
|   public static void main(String[] args) {                |
|       Player player = new Player();                       |
|       // score is an int variable default 0               |
|       System.out.println(player.score); // 0              |
|       // name is a member reference variable default null |
|       System.out.println(player.name); // null            |
|       int local; // not initialized                       |
|       // System.out.println(local); // ERROR              |
|       String value = null; // initialized                 |
|       System.out.println(value); // null                  |
|   }                                                       |
| }                                                         |
+-----------------------------------------------------------+


# Variables in JAVA

- Instance Variables (Non-Static Fields), declared outside a method but inside a class
- Class Variables (Static Fields) : one copy of this variable in existence.
- Local Variables : methods stores its temporary state in local variables. Declared between {} in method.
  Accessible only in method declared.
- Parameters : classified as variables.


##########################
# Java Memory Management #
##########################

# Stack

The stack
+----+
|+---++
||+---++  PUSH  +---+   +     +    +---+  PULL, POP
|||    |  --->  |   |   |     |    |   |  --->      FILO
+||    |        +---+   |     |    +---+
 +|    |                |     |
  +----+                +-----+

  every threads has
  its own stack

All local variables are defined in stack.
No more data after last }. Tide scoping.
Local variable short lifetime.


# Heap

Longer lifetime store data
Objects are in Heap. Huge area of storing data. All memory from your application except data on stack.
One heap for all threads, number of stacks for each Thread.

The stack               The Heap
+-------+              +---------------------+
|+------++             | String              |
||+------++            | Integer             |
||| int   |            |                     |
+|| double|            |                     |
 +|       |            |                     |
  +-------+            +---------------------+

int age = 21;
String name = "Hello";

   Stack
+----------+            +----------------------+
|+--------+|            |   +------+           |
||  name  ++---------+  |   |String|           |
|+--------+|          \ | +-+------+-+         |
|+--------+|           ++>+  Hello   |         |
|| age=21 ||            | +----------+         |
|+--------+|            |                      |
|          |            |                      |
+----------+            +----------------------+

Java Memory - Rule
- Objects are stored on the heap
- Variables are a reference to the object
- Local variables are stored on the stack


# Passing variables by value

+--------------------------------------------------+
| class Main {                                     |
|    public static void main(String[] args) {      |
|        int localValue = 5;                       |
|        calculate(localValue);                    |
|        System.out.println(localValue); // 5      |
|    }                                             |
|    // copy of local variable                     |
|    public static void calculate(int calcValue) { |
|        calcValue = calcValue * 100;              |
|    }                                             |
| }                                                |
+--------------------------------------------------+


# How objects are passed

For object passed into methods, the REFERENCE to the object is passed BY VALUE.
"No object passed to method but rather pointer to object"
Passing Values

+--------------------------------------------------------+
| public class Main {                                    |
|     public static void main(String[] args) {           |
|         Customer c = new Customer("Betty");            |
|         renameCustomer(c);                             |
|         System.out.println(c.getName()); // Grazyna    |
|     }                                                  |
|     public static void renameCustomer(Customer cust) { |
|         cust.setName("Grazyna");                       |
|     }                                                  |
| }                                                      |
+--------------------------------------------------------+

            +-------------------------------------------+
            |      +----------+                         |
+-----+     |      | Customer |           +--------+    |
|+---+|     |    +-+----------+-+         | String |    |
|| c |+-----+--->+  +------+    |       +-+--------+-+  |
|+---+|     |    |  | name +----+------>+ Grazyna    |  |
|     |     |    |  +------+    |       +------------+  |
+-----+     |    +-----+--------+                       |
            |          X (break this reference)         |
            |          V                                |
            |    +-----+--+                             |
            |    | String |                             |
            |    +--------+                             |
            |    | Betty  |                             |
            |    +--------+                             |
            +-------------------------------------------+


# The "final" keyword

Can be assigned only once

+--------------------------------------+
| final Customer c;                    |
| c = new Customer("Mark");            |
| c = new Customer("Amanda"); // ERROR |
| c.setName("Robert"); // OK           |
+--------------------------------------+


# Immutable collections

Collections.unmodifableMap()
Collections.unmodifableList()

+-----------------------------------------------------------------------------------------+
| String three = new Integer(67).toString().intern(); // JVM optimizes of building object |
| String four = "67";                                                                     |
+-----------------------------------------------------------------------------------------+

# Garbage Collector

In other languages you must state when an object is no longer needed by calling a method like free().
Object that are not freed continue to consume memory ... this is a memory leak.

Java avoids memory leak by:
- Running on a virtual machine
- Adapts a Garbage Collection strategy

Garbage collection - any object on the heap which cannot be reached through a reference from a stack
is eligable for garbage collection.

Soft leaks - an object is referenced on the stack even though it will never be used again.

Vm arguments
-Xmx100m - run application with small heap size
jvisualvm.exe

General Garbage collection
The "Mark and Sweep" process.

Generational Garbage Collection
- Most object's don't live for long
- If an object survives it is likely for live forever

                    minor    major collection
+---------+        +-------+----------------+
|         |        | young | old generation |
|         |        |       |  +--------+    |
|         |        |       |  | String |    |
| +-----+ |        |       |  +--------+    |
| |name |-+--------+-------+->| John   |    |
| +-----+ |        |       |  +--------+    |
+---------+        +-------+----------------+

GC young generation deletes unused objects
After that String John go to old generation.
Actually it can be 8 GC, but the VM changes the number of generations based on the amount of memory available.

Program VirtualGC to view some memory leaks


# PermGen / MetaSpace

PermGen is never GC
On PermGen internalize String metadata of class is stored in this.
Info about class.
Problem to many classes or internalized strings
Increase size of PermGen
If you redeploy number of times the PermGen will run out of space

Java 7
No internalized Strings are stored in PermGen. They are an old part of heap and can be GC.

Java 8
Remove PermGen introduce metaspace where all metadata of classes are placed. No part of heap.
Max size of metaspace is your computer Space

+-------+---------------+   +-----------+
| young | old           |   | Metaspace |
|       |               |   |           |
|       |               |   |           |
|       |               |   |           |
|       |               |   |           |
+-------+---------------+   +-----------+
Heap


# Tuning the VM

-Xmx set the maximum heap size
-Xms set starting heap size

+-------------------+
| -Xmx512m -Xms150m |
+-------------------+

PermGen Size
-XX:MaxPermSize

+----------------------+
| -XX:MaxPermSize=256m |
+----------------------+

-verbose:gc // print to the console when garbage collection takes place

-Xmx10m -verbose:gc // print garbage collection

Young generation = 1/3 heap size
-Xmn set the size of young generation
-Xms256m


# Generating heap dumps

-XX:HeapDumpOnOutOfMemory // creates a heap dump file "hprof"


# Choosing a GC

Types of GC:
- Serial : -XX:+UseSerialGC
- Parallel young generation: -XX:+UseParallelGC
- Mostly Concurrent: -XX:+UseConcMarkSweepGC
                     -XX:+UseG1GC

use -XX:+PrintCommandLineFlag to find out which is your default

jmeter to generate load
apache-jmeter

WeakReferences - might not survive GC. If not variable will be equal to null.
Soft - stronger than weak, can be destroy if GC claims that space is needed.

+-------------------------------------+
| WeakReferencs<Book> mybook = book1; |
| SoftReference<Book> mybook = book2; |
+-------------------------------------+

WeakHashMap - reference between key and values are weak.

+--------------------------------------------------------+
| Map<Book, BookImage> imageCache = new WeakHashMap<>(); |
+--------------------------------------------------------+

Guava Library can make soft hash map


##############################
# hashCode, equals, toString #
##############################

You must override hashcode in every class that overrides equals. Failure to do so affect working with hash based
collections like HashMap, HashSet
In Map objects are stored as key and value. put(key,value) method is used to store objects in HashMap at this time
hashCode() method is used to calculate the hash code of key object and both key and value object is stored
as map.entry, if two keys object have some hash code then only one value object is stored in the same bucket location but
as a linked list value is stored and if hash code is different then another bucket location is created.
While retrieving get(key) method is used at this time hash code of key object is calculated and then equals() method
is called to compare value object.


# equals

Check whether one object can be equal to another.
Equals method implemented in Object class, check whether two references to object are identical.
Override equal method if you want to check equality based on state of object.
Two object are equals when they have the same value.

Equals method is used when we compare two objects. Default implementation of equals method is defined in Object class.
Two object references are equals only if they are pointing to the same object.
We need to override equals method, if we would want to compare the contents of an object.

We can override equals method in the class to check the content of the objects.
The implementation of equals method checks if the id's of both objects are equal.
If so return true.

+-------------------------------------+
| @override                           |
| public boolean equals(Object obj) { |
|   Client other = (Client) obj;      |
|   if (id != other.id)               |
|       return false;                 |
|   return true;                      |
| }                                   |
+-------------------------------------+

Important things to consider when implementing equals method.
- Reflexive: For any reference value x, x.equals(x) return true
- Symmetric: For any reference values x and y, if x.equals(y) should return true if and only if y.equals(x) returns true.
- Transitive: For any reference values x, y and z, if x.equals(y) returns true and y.equals(z) returns true,
    then x.equals(z) must return true
- Consistent: For any reference values x and y, multiple invocations of x.equals(y) consistently return true
    if no information used in equals is modified
- For any non-null reference value x, x.equals(null) should return false

+---------------------------------------+
| @Override                             |
| public boolean equals(Object obj) {   |
|   if (this == obj) {                  |
|       return true;                    |
|   }                                   |
|   if (obj == null) {                  |
|       return false;                   |
|   }                                   |
|   if (getClass() != obj.getClass()) { |
|       return false;                   |
|   }                                   |
|   Client other = (Client) obj;        |
|   if (id != other.id) {               |
|       return false;                   |
|   }                                   |
|   return true;                        |
| }                                     |
+---------------------------------------+


# hashCode

Hash is integer number that identify an object.
If x and y are different objects, x.hashCode and y.hashCode should also be different (but not always are).

+--------------------------------------------+
| @Override                                  |
| public int hashCode() {                    |
|   int hash = 1;                            |
|   for (int i = 0; i < str.length(); i++) { |
|         hash = 31 * hash + chartAt(i)      |
|   }                                        |
|   return hash;                             |
| }                                          |
+--------------------------------------------+

HashCode must be compatible.
if x.equals(y) return true, x.hashCode() == y.hashCode().
If you change equals method you have to change hashCode also. Failure to do so results in objects put in hash based
data structures HasSet, HashMap could be lost.

+---------------------------+
| Object.hash(some, some2); |
+---------------------------+

HashCode's are used in hashing to decide which group (or bucket) an object should be placed into.
A group of object's might share the same hashCode.
The implementation of hashCode decides effectiveness of Hashing. A good hashing function evenly
distributes object's into different groups or buckets.
A good hashCode should have the following properties:
- if obj1.equals(obj2) is true, then obj1.hashCode() should be equal to obj2.hashCode().
- obj.hashCode() should return the same value when run multiple times, if values of obj used in equals() have not change.
- if obj1.equals(obj2) is false, it is NOT required thet obj1.hashCode() is not equal to obj2.hashCode().
    Two unequals objects might have the same hashCode.

+----------------------------------+
| @Override                        |
| public int hashCode() {          |
|   final int prime = 31;          |
|   int result = 1;                |
|   result = prime * result + id;  |
|   return result;                 |
| }                                |
+----------------------------------+


#################
# Serialization #
#################

Abstract class - high level class, by whom inherits
Data serialization allows to know about all references (extends)
Serialized object will be read to file. They will acquire some special identification number (SerialVersionUID),
object will use this number to other objects
To perform serialization class need to implements Serializable interface
Serializable marker interface (without method), safety guard to make sure you know what you are doing
transient data that we don't want to be serialized
Fragile data should be marked as transient, or should not implement Serializable

Serialization is a mechanism to transform in collection of bytes, which can be then deliver to other place
save on disk, and reconstruct objects based on this collection of bytes.
Deliver object from one VM to another. To make object serializable that means can transform to bytes states
it has to be an instance of Serializable interface. It is an marker interface without methods.
All object must be serializable.
Serializable mechanism supports version mechanism serialVersionUID = 1L;
is used to enhanced state, what would happen when class would change
Static variables are no serialized only instance variables are serialized

Serialization is a process saving state of an object to a sequence of bytes. These sequence of bytes
can be sent over a network or stored in a file.

+-----------------+
|  Serializable   |                       +------+
| << interface >> |                       | file |
+--------+--------+                       +------+
         |                               /
  +------+------+     +-----------------+     +----------+
  | Java Object +---->+ Stream of bytes +---->+ Database |
  +-------------+     +-----------------+     +----------+
                                         \
                                          +--------+
                                          | memory |
                                          +--------+

Serialization helps us to save and retreive state of an object.
-Serialization : convert object state to some internal object representation
-Deserialization : To reverse convert internal representation to object

Two important methods
-ObjectOutputStream.writeObject(): serialize and write to file
-ObjectInputStream.readObject(): read from file and deserialize

How to serialize object using Serializable interface
To serialize object it should implements Serializable interface. In the example below, Rectangle class implements
Serializable interface. Note that Serializable interface does not declare any method to be implemented.
Create new Rectangle object and serializing it to a file Rectangle.ser.

+----------------------------------------------------------------------+
| class Rectangle implements Serializable {                            |
|   public Rectangle(int length, int breadth) {                        |
|       this.length = length;                                          |
|       this.breadth = breadth;                                        |
|       area = length * breadth;                                       |
|   }                                                                  |
|   int length;                                                        |
|   int breadth;                                                       |
|   int area;                                                          |
| }                                                                    |
+----------------------------------------------------------------------+

+-----------------------------------------------------------------------+
| FileOutputStream fileStream = new FileOutputStream("Rectangle.ser");  |
| ObjectOutputStream objectStream = new ObjectOutputStream(fileStream); |
| objectStream.writeObject(new Rectangle(5,6));                         |
| objectStream.close();                                                 |
+-----------------------------------------------------------------------+

How to deserialize on Java
A rectangle object is deserialize from file Rectangle.ser

+-------------------------------------------------------------------------------+
| FileInputStream fileInputStream = new FileInputStream("Rectangle.ser");       |
| ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); |
| Rectangle rectangle = (Rectangle) objectInputStream.readObject();             |
| objectInputStream.close();                                                    |
+-------------------------------------------------------------------------------+

We mark all the properties of the Object that should not be serialized as transient.
Transient attributes in an object are not serialized. As we don't need to serialize 'area' we can calculate it later
mark this variable as transient.

All classes that need to be serialized have to implement Serializable interface


# Are the constructors in an object invoked when it is de-serialized?
No when a class is de-serialized, initialization (constructor's initializer's) does not take place.
The state of an object is retained as it is.


# Are the values of static variables stored when object is serialized?
Static variables are not part of the object they are not serialized.

+---------------------+
| transient int area; |
+---------------------+


# Different between Serializable and Externalizable
Serializable is marker interface with no method defined
Use default serialization process which can be very slow for some application
Externalizable interface has two methods readExternal() and writeExternal() which allows you to control the
serialization process


######################
# How HashMap works? #
######################

It's a map implementation
A map is an associative array data structure "key1"->value, "key2"->value

Hashing: transformation of a string of characters(Text) to a shorted fix-length value that represents original string.
A shorter value helps in indexing and faster searches.

In Java every object has a method public int hashCode() that will return a hash value for given object.

If two object are equal they should have the same hashcode as well.
Hashcode is used to storing values in hash map. If hashcode is wrong you could not get corresponding value.

Index of null key is always 0, as hash of null is always 0

HASHMAP
+-------------+
|<<interface>>|  +-------------+ +-----------+ +--------------+
|     Map     |  | AbstractMap | | Cloneable | | Serializable |
+-------------+  +-------------+ +-----------+ +--------------+
        |      /
        |     /
        |    /
    +-------+
    |HashMap|
    +-------+

Detailed
+------------------+
|Node<K,V>[] table;|
+++----------------+
 ||
 \/
+--+                        +-----------------+
|  |                        |    Node<K,V>    |
+--+                        +-----------------+
+--+                        | int hash;       |
|  |                        | K key;          |
+--+                        | V value;        |
+--+                        | Node<K,V> next; | <- It is a LinkedList
|  |                        +-----------------+
+--+


# PUT

Each index in this table is known as bucket. Each bucket is a node that can be linked list of nodes

                                                +---+
scores.put("QUEEN",120);                        | 0 |--> WALL | 70772256 | 70 | null
scores.put("KNIGHT",100);                       +---+
scores.put("CASTLE",10);                        | 1 |
scores.put("RAM",110);                          +---+
scores.put("SWORD",99);                         | 2 |--> KNIGHT | 64205538 | 100 | null
scores.put("GALLEON",80);                       +---+
scores.put("WALL",70);                          | 3 |
                                                +---+
+------------------------+                      | 4 |--> QUEEN | 2306996 | 120 | * --> CASTLE | 63281940 | 10 | * --> GALLEON | 2656852 | 80 | null
| put(K k, V v)          |                      +---+
|   hash(k)              |                      | 5 |
|                        |                      +---+
|   index = hash & (n-1) |                      | 6 |--> SWORD | 79019862 | 99 | null
| n = 16                 |                      +---+
+------------------------+                      | 7 |
scores.put("QUEEN",120);                        +---+
hash("QUEEN") = 2306996                         | 8 |
index = 2306996 & 15 = 4                        +---+
                                                | 9 |
scores.put("KNIGHT",100);                       +---+
hash("KNIGHT") = 64205538                       | 10|--> RAM | 2163866 | 110 | null
index = 64205538 & 15 = 2                       +---+
                                                | 11|
scores.put("CASTLE",10);                        +---+
hash("CASTLE") = 63281940                       | 12|
index = 63281940 & 15 = 4 (COLLISION)           +---+
                                                | 13|
scores.put("RAM",110);                          +---+
hash("RAM") = 2163866                           | 14|
index = 2163866 & 15 = 10                       +---+
                                                | 15|
scores.put("SWORD",99);                         +---+
hash("SWORD") = 79019862
index = 79019862 & 15 = 6

scores.put("GALLEON",80);
hash("GALLEON") = 2656852
index = 2656852 & 15 = 4 (COLLISION)

scores.put("WALL",70);
hash("WALL") = 70772256
index = 70772256 & 15 = 0

# GET

scores.get("KNIGHT");
scores.get("QUEEN");
scores.get("GALLEON");

+------------------------+
| V get(Object key)      |
|   hash(key)            |
|                        |
|   index = hash & (n-1) |
+------------------------+
scores.get("KNIGHT");
hash = 64205538
index = 64205538 & 15 = 2

    Compare hash with hash that is stored under index = 2, 64205538 == 64205538 = true
    Compare key using equals method "KNIGHT".equals("KNIGHT") = true

scores.get("KNIGHT") = 100; // FOUND VALUE


scores.get("QUEEN");
hash = 2306996
index = 2306996 & 15 = 4

    Compare hash with hash that is stored undex index = 4, 2306996 == 2306996 = true
    Compare key using equals method "QUEEN".equals("QUEEN") = true

scores.get("QUEEN") = 120; // FOUND VALUE


scores.get("GALLEON");
hash = 2656852
index = 2656852 & 15 = 4

    Compare hash with that is stored under index = 4, 2656852 == 2306996 = false
        Compare hash with that is stored under index = 4, next node, 2656852 == 63281940 = false
            Compare hash with that is stored under index = 4, next node, 2656852 == 2656852 = true
    Compare key using equals method "GALLEON".equals("QUEEN") = false
        Compare key using equals method, next node, "GALLEON".equals("CASTLE") = false
            Compare key using equals method, next node, "GALLEON".equals("GALLEON") = true

scores.get("GALLEON") = 80; // FOUND VALUE


In Java 8, when we have too many unequal keys which gives some hashcode(index)
- when the number of items in a hash bucket grows beyond threshold(TREEIFY_TRESHOLD = 8), content of that bucket
switches from using linked list of Entry objects to a balanced tree. This theoretically improves the worst-case
performance from O(n) to O(log n).
Balanced search tree, where leaf nodes have lesser weight (HashCode or Comparable result) for the Keys involved.


######################
# Exception Handling #
######################

Exception handling helps us to recover from an unexpected situations like file not found, connection is lost.
Important part is try-catch block.
If exception is handled it does not propagate further
In a try block, the lines after the line throwing exception are not executed


# finally block

When an exception happens the code after the line throwing exception is not executed.
If code like closing connection is present in these lines of code, it is not executed.
This leads to connection and other resource leaks.
Code written in finally block is executed even when there is an exception.
Dangling unclosed connection. Finally block is used when code needs to be executed irrespective
of whether an exception is thrown.

+--------------------------+
| } finally {              |
|       connection.close();|
| }                        |
+--------------------------+

In what scenarios finally block not executed?
- If exception is thrown in finally
- If JVM crashes in between (for example System.exit())
Finally block execute even when there is a return statement in try block

try without catch block is allowed for instance since Java 7

+-------------+
| try {       |
|   ...       |
| } finally { |
|   ...       |
| }           |
+-------------+

Java 7 try with resources (automatic resource management)

+-----------------------------------------------------------------+
| try (FileInputStream input = new FileInputStream("file.txt")) { |
|   ...                                                           |
| }                                                               |
+-----------------------------------------------------------------+

Hierarchy of Exception class in Java
Throwable is the highest level of Error Handling classes.

+---------------------------------------------+
| // Pre defined Java Classes                 |
| class Error extends Throwable {}            |
| class Exception extends Throwable {}        |
| class RuntimeException extends Exception {} |
+---------------------------------------------+

# Difference between Error and Exception
Error is used in situation where there is nothing programmer can do about an error.
StackOverflow, OutOfMemory. Programmer can handle Exception.


# Difference between checked and un-checked exceptions
Runtime Exceptions and classes that extends RuntimeException are called unchecked exception.
Other Exception classes are called Checked Exceptions. They are Subclasses of Exception which are
not subclass of RuntimeException. Checked exceptions should be handled or thrown.

+-----------------------------------+
|throw new Exception("Exception 1");|
+-----------------------------------+


# Create custom Exception
By extending Exception class or RuntimeException class.
If extends Exception class it will be checked exception.
If extends RuntimeException it will be un-checked exception.

+-----------------------------------------------+
| class CustomException extends Exception {...} |
+-----------------------------------------------+


# Order of Exceptions
Specific Exception should be before the Generic Exception.

+---------------------------------------------+
| try {                                       |
|   ...                                       |
| } catch (CurrenciesDoNotMatchException e) { |
|   ...                                       |
| } catch (Exception e) {                     |
|   ...                                       |
| }                                           |
|                                             |
| // Multiple repeated exception              |
| catch (IOException | SQLException e)        |
+---------------------------------------------+


# Checked and Unchecked Exceptions
Checked Exceptions ensures that handling of exception is provided and its verified by compiler also
For throwing unchecked exception no special provision is needed.


############
# Generics #
############

Generics are used to create Generic Classes and Generic Methods which can work with different Types (classes).
Make class type parameter to a class.

+---------------------------------+
| class MyListGeneric<T> {        |
|   private List<T> values;       |
|                                 |
|   void add(T value) {           |
|       values.add(value);        |
|   }                             |
|                                 |
|   void remove(T value) {        |
|       values.remove(value);     |
|   }                             |
|                                 |
|   T get(int index) {            |
|       return values.get(index); |
|   }                             |
| }                               |
+---------------------------------+

To restrict Generics to a subclass of particular class we can use Generic Restrictions.
"T extends Number"
We can use the class MyListRestricted with any class extending (subclass) of Number - Float, Integer, Double
String is not valid substitute for "T extends Number"

+--------------------------------------------+
| class MyListRestricted<T extends Number> { |
|   private List<T> values;                  |
|                                            |
|   void add(T value) {                      |
|       values.add(value);                   |
|   }                                        |
|                                            |
|   void remove(T value) {                   |
|       values.remove(value);                |
|   }                                        |
|                                            |
|   T get(int index) {                       |
|       return values.get(index);            |
|   }                                        |
| }                                          |
+--------------------------------------------+

To restrict Generic class to a super class of particular class we can use Generic Restrictions.
"T super Number"
We can use the class MyListRestricted with any class that is super to class Number.

PECS - Produces extends, Consumer super


############
# File API #
############

+-----------------+------------------------------------+
| Create file     | File file = new File("nazwa.txt"); |
+-----------------+------------------------------------+
| Check if exists | file.exists();                     |
+-----------------+------------------------------------+
| Create new file | file.createNewFile();              |
+-----------------+------------------------------------+
| Full path       | file.getAbsolutePath()             |
|                 | file.isFile()                      |
|                 | file.isDirectory()                 |
+-----------------+------------------------------------+
| Print files and | Arrays.toString(directory.list()); |
| directories in  |                                    |
| folder          |                                    |
+-----------------+------------------------------------+
| Create new      | File newDir = new File("newDir");  |
| directory       | newDir.mkdir();                    |
+-----------------+------------------------------------+

File class represents files and directories.

Write to file using FileWriter
.write(), .flush(), .close()

Read from file using FileReader
.read(), .close()

BufferedWriter and BufferedReader provide better buffering in addition to basic file writing and reading
operations. For example instead reading entire file, we can read file line by line.

BufferedWriter class helps writing to a class with better Buffering than FileWriter.
BufferedWriter constructor only accept another writer as argument

+-----------------------------------------------------------------+
| FileWriter fileWriter = new FileWriter("text.txt");             |
| BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); |
| bufferedWriter.write("Elephant");                               |
| bufferedWriter.newLine();                                       |
| bufferedWriter.write("Africa");                                 |
| bufferedWriter.flush();                                         |
| bufferedWriter.close();                                         |
| fileWriter.close();                                             |
+-----------------------------------------------------------------+

BufferedReader helps to read the file line by line. BufferedReader constructors only accept another Reader as argument.

+-----------------------------------------------------------------+
| FileReader fileReader = new FileReader("text.txt");             |
| BufferedReader bufferedReader = new BufferedReader(fileReader); |
| String line;                                                    |
| while ((line = bufferedReader.readLine()) != null) {            |
|   System.out.println(line);                                     |
| }                                                               |
| bufferedReader.close();                                         |
| fileWriter.close();                                             |
+-----------------------------------------------------------------+

PrintWriter
Provides advanced methods to write formatted test to the file. It supports printf function.
PrintWriter constructor supports varied kind of arguments - Fle, String Path and Writer

+-----------------------------------------------------------------+
| PrintWriter printWriter = new PrintWriter("text.txt");          |
| printWriter.format("%15s", "My Name");                          |
| printWriter.println();                                          |
| printWriter.printf("Formatted number: %5.5f", 4.5);             |
| printWriter.flush();                                            |
| printWriter.close();                                            |
+-----------------------------------------------------------------+


###############
# Collections #
###############

# Why need collections
Arrays are not dynamic. Once an array of particular size is created, the size cannot be modified.
To add new element new array have to be created with bigger size and all elements from the old array copied to new array.
Collections are used in situations where data is dynamic. Collections allow adding an elements, deleting an elements and
lots of other operations.

Some methods in collection class
add, remove, size, isEmpty, clear, contains, containsAll, retainAll

Collection interface provides methods for all collections except Map which are provided by Map interface


# Thread safe data structures
In such collections iterators presents elements which exists on the beginning of iteration but can reflect
all modifications that being processed after their creation. Such iterator does not throw ConcurrentModificationException.
In multithreading Java application synchronized collection classes like HashTable and Vector quickly becomes
the bottleneck, to address that Java 5 introduced some concurrent collections.

+------+--------------+-----------------------+
|      | Collection   | Cononcurrent          |
|      |              | Thread Safe           |
+------+--------------+-----------------------+
| List | ArrayList    | CopyOnWriteArrayList  |
|      | LinkedList   | Vector                |
+------+--------------+-----------------------+
| Set  | HashSet      | CopyOnWriteArraySet   |
|      | TreeSet      | ConcurrentSkipListSet |
|      | LinkedHashSet|                       |
+------+--------------+-----------------------+
| Map  | HashMap      | ConcurrentHashMap     |
|      | TreeMap      | HashTable             |
|      | LinkedHashMap| ConcurrentSkipListMap |
+------+--------------+-----------------------+
| Queue| PriorityQueue| LinkedBlockingQueue   |
|      | ArrayDequeue | ArrayBlockingQueue    |
|      |              | BlockingQueue         |
|      |              | PriorityBlockingQueue |
+------+--------------+-----------------------+


# LIST

List interface extends Collection interface. It contains all methods defined in Collection interface.
In addition List interface allows operation specifying the position of the element in the Collection.
Any implementation of List interface would maintain the insertion order.
When new element is inserted without specifying a position it is inserted at the end of the List of elements.
We can also use void add(int position, E param) method to insert an element at specific position.
Methods:
get, set, add, remove, indexOf, lastIndexOf

List is sequential collection in which every element has index in form of integral number
List interface has methods which allow to access to n'th element of List. To do so Class should implement RandomAccess
interface. It is a marker interface which does not have any methods.
For instance ArrayList implements List and RandomAccess, but LinkedList only List interface.
RandomAccess means random search if you know the index, LinkedList only allows sequential search.
Adding and removing elements from middle of LinkedList is fast compared to ArrayList, because it only
require to modify links and no other elements are rearranged.


# ArrayList

ArrayList implements the List interface. So ArrayList stores the elements in insertion order.
Elements can be inserted into and removed from ArrayList based on their positions.
ArrayList can have duplicate elements.
Iterate around ArrayList using Iterator

+------------------------------------------------------------+
| Iterator<String> arrayListIterator = arrayList.iterator(); |
| while (arrayListIterator.hasNext()) {                      |
|   String str = arrayListIterator.next();                   |
|   System.out.println(str);                                 |
| }                                                          |
+------------------------------------------------------------+

We can sort ArrayList using Collection.sort method
We can also use Comparable interface, with method compareTo

+--------------------------------------------------------------+
| class DescendingSorter implements Comparator<Cricket> {      |
|   @Override                                                  |
|   public int compareTo(Cricket cricket1, Cricket cricket2) { |
|       if (cricket1.points > cricket2.points) {               |
|           return -1;                                         |
|       }                                                      |
|       else if (cricket1.points < cricket2.points) {          |
|           return 1;                                          |
|       }                                                      |
|       return 0;                                              |
|   }                                                          |
| }                                                            |
| // Use                                                       |
| Collections.sort(cricket, new DescendingSorter());           |
+--------------------------------------------------------------+

Convert List to an Array
Object[] numObj = numberArray.toArray();

Convert Array to List
List<String> valueList = Arrays.asList(valueArray)


# SET

Java has implementation of HashSet and TreeSet.
Does not allow duplicates.


# What is a difference between Set and SortedSet?
SortedSet interface extends the Set interface. Both Set and SortedSet does not allow duplicate elements.
SortedSet maintains its elements in a sorted order. Set interface does not guaranteed any order
Methods of Sorted Set:
subset(), headSet(), tailSet()


# HashSet

HashSet implements Set interface. HashSet does not allow duplicates. HashSet does not supports ordering.
The order in which elements are inserted is not maintained.

+----------------------------------------+
| Set<String> hashSet = new HashSet<>(); |
+----------------------------------------+


# LinkedHashSet

LinkedHashSet implements Set interface and exposes similar operations to HashSet.
Maintains insertion order.


# TreeSet

TreeSet implements Set, SortedSet and NavigableSet interfaces. TreeSet is similar to HashSet except
that it stores elements in sorted order.
Some methods:
lower(), floor(), higher(), ceiling()

+----------------------------------------+
| Set<String> treeSet = new TreeSet<>(); |
+----------------------------------------+


# MAP

Map interface does not extends Collection.
A Map interface supports Collections that use a key value pair.
A key-value pair is a set of linked data items a key, which is a unique identifier for some item data, and the value
which is either data or pointer to a data. Key-value pairs are used in lookups tables, hash tables and configuration
files. A key-value pair in Map interface is called Entry.
Put method allows to add a key-value pair to the Map.
Get method allows to get a value from the Map based on key
Other methods:
size(), isEmpty(), remove(), putAll(), clear(), containsKey(), containsValue()

In Map you can choose between HashMap or TreeMap. LinkedHashMap maintains insertion order
LinkedHashMap maintains insertion order and process elements based on this order
HashMap implements Map interface there by supporting key values pairs.
TreeMap is similar to HashMap except that it stores keys in sorted order. It implements NavigableMap interface and
SortedMap interfaces along with tha Map interface


# ConcurrentHashMap

Methods in atomic ways sets or replace elements if it is the same at a point of time.
There are couple of mass operations to search, modify or look for ConcurrentHashMap.
search, reduce, forEach.
ConcurrentHashMap does not allow null values for keys or values
ConcurrentHashMap and CopyOnWriteArrayList implementations provide much higher concurrency while preserving
thread safety
ConcurrentSkipListMap


# Difference between Map and SortedMap

SortedMap interface extends Map interface. In addition, an implementation of SortedMap interface maintains
keys in sorted order.
Methods are available in the interface to get a ranges of values based on their keys:
subMap(), headMap(), tailMap(), firstKey(), lastKey()


# QUEUES

Queue interface extends Collection interface. Queue interface is typically used for implementation
holding elements in order for some processing.
Queue interface offers methods peek() and poll(), which get element at the head of a queue.
The difference is that poll() method removes the head from queue also. peek() would keep head of
the queue unchanged.
offer(), remove(), pull(), element(), peek()


# BlockingQueue

pool, peek methods return null to signal failure. In that reason insert null vales to them is incorrect
LinkedBlockingQueue
ArrayBlockingQueue


# PriorityQueue

Implements Queue interface.
-offer() adding an element to priority queue
-peek() get the element with highest priority


# Iterator

Iterator interface allows us to iterate (loop around) a collection. All collections define a method iterator()
that gets an iterator of collection.
hasNext() check if there is another elements in the collection being iterated, next() gets the next element

+--------------------------------+
| public interface Iterator<E> { |
|   boolean hasNext();           |
|   E next();                    |
| }                              |
+--------------------------------+


# What is the difference between synchronized and Concurrent Collections?
Synchronized collections are implemented using synchronized methods and synchronized blocks. Only one Thread
can executing any of the synchronized code at given point in time. This places severe restrictions on the concurrency
of thread - there by affecting performance of the application. All the pre Java 5 synchronized collections
HashTable & Vector use this approach
Post Java 5 collections using new approach to synchronization are available in Java.
These are concurrent collections

+--------------------------------+--------------------------------+
| SYNCHRONIZED                   | CONCURRENT                     |
+--------------------------------+--------------------------------+
| Use synchronized               | New approach to thread safety  |
| methods and blocks             |   - Copy on Write              |
|                                |   - Compare and Swap           |
|                                |   - Lock and unlock            |
+--------------------------------+--------------------------------+
| Vector, HashTable              | CopyOnWriteArrayList           |
|                                | ConcurrentLinkedQueue          |
|                                | ConcurrentHashMap              |
+--------------------------------+--------------------------------+
| Only one thread Executing      | New approaches allow more      |
| any of the synchronized        | concurrency in specific        |
| code                           | context                        |
+--------------------------------+--------------------------------+
| fail fast iterators            | fails safe iterators           |
| throw                          | don't throw                    |
| ConcurrentModificationException| ConcurrentModificationException|
+--------------------------------+--------------------------------+

Post Java 5 collections using new approach to synchronization are available in Java.
These are called concurrent collections. Examples of new approaches are
- Copy on Write
- Compare and Swap
- Lock and Unlock
New approaches to concurrency provide better performance in specific context


# Copy on Write?
All collections are sorted in immutable array. A new array is created if there is any modification to the collection
Read operations are not synchronized. Writes operations are synchronized.
Copy on Write scenario is used where reads greatly out number writes on a collection
CopyOnWriteArrayList and CopyOnWriteArraySet are implementations of this approach
Copy on Write collections are typically used in subject - observer scenario, where the observed very
rarely change. Most frequent operations would be iteration around the observers and notifying them.


# What is Compare and Swap approach?
In compare and swap approach instead of synchronizing entire method, the value of member variable before
calculation is cached. After the calculation the cache value is compared with the current value of member variable.
If the value is not modified the calculated result is stored into the member variable.
If another thread has modified the value, then the calculation can be performed again, or skipped as the need might be.
ConcurrentLinkedQueue uses this approach.


# What is a Lock? How is it different from using synchronized approach?
When 10 methods are declared as synchronized, only any of them is executed by any of the threads at any point in time.
This has severe performance impact.
Another new approach introduced in Java 5 is to use lock and unlock methods. Lock an unlock methods are used
to divide methods into different blocks and help enhance concurrency.
The 10 methods can be divided into different blocks which can be synchronized on different variables.


# What is initial capacity of a HashMap?
An instance of HashMap has two parameters that affect its performance initial capacity and load factor.
The capacity is the number of buckets in the hash table, and the initial capacity is the capacity at the time the
hash table is created. The load factor a measure of how full the hash table is allowed to get before its capacity
automatically increased.
When the number of entries in the hash table exceeds the product of load factor and the current capacity, the hash
table is rehashed (internal structure rebuild). So the hash table has approximately twice the number of buckets.
As a general rule the default load factor .75 offers a good trade off between time and space cost.
Higher value decrease space overhead but increase the lookup cost (put and get operations).


# What is a different between fail safe and fail fast?
Fail fast iterators throw ConcurrentModificationException if there is a modification to the underlying collection is modified.
This was the default behavior of the synchronized collections of pre Java 5
Fail safe iterators do not throw ConcurrentModificationException even when there are changes in the collection.
This is the default behavior of the concurrent collections, introduced since Java 5


# ConcurrentHashMap vs HashTable vs SynchronizedMap
All are thread safe.
HashTable uses synchronized method to achieve thread-safety. Quite slow if number of thread increases.
SynchronizedMap not very different from HasTable similar performance in concurrent Java program.
You can create synchronized Map version by using Collections.synchronizedMap().
ConcurrentHashMap is specially designed for concurrent use i.e. more than one thread.
By default it simultaneously allows 16 threads to read and write from Map without any external synchronization.
It is very scalable because of stripped locking technique used in the internal implementation of ConcurrentHashMap class.
Unlike HashTable and Synchronized Map, it never locks whole Map, instead, it divides the Map into segments and locking is done on those.
It perform better if number of reader are greater than the number of writer threads.


# What are atomic operations in Java?
In programming an atomic action is one that effectively happens all at once. An atomic action cannot stop in the middle.
It either happens completely or it doesn't happen at all. No side effect of an atomic action are visible until the action is completed.
Even small operation like i++ is not thread safe. Operation involves three steps:
- Read the value which is currently stored in i
- Add one to it (atomic operation)
- Store it in i
In multithreaded environment there can be unexpected results. For example if thread 1 is reading the value
and immediately after that thread 2 store the value.
To prevent these, Java provides atomic operations. Atomic operations are performed as a single unit
without interference from other threads ensuring data consistency.
A good example is AtomicInteger. To implement a value of AtomicInteger we use the incrementAndGet()
method Java ensures this operation is Atomic.


# What is the BlockedQueue in Java?
BlockedQueue interface is introduced in Java specifically to address specific needs of some Producer Consumer scenarios.
BlockedQueue allows the consumer to wait (for a specific time of infinitely) for an element to become available.


# HashMap and HashTable differences?
HashMap is not synchronized. Faster than HashTable. Allows null keys.
Hashtable is synchronized. Slower than HashMap. Does not allow null keys.


# TreeSet and TreeMap differences?
TreeSet and TreeMap are both sorted. TreeSet is a Set data structure so it does not allow duplicates.
TreeMap is an implementation of Map.
TreeSet is implemented via TreeMap much like how HashSet is implemented using HashMap.


# Vector Class
Vector class has the same operations as ArrayList. However all methods in Vector are synchronized.
We can use Vector if we share a List between two threads that we would want them synchronized.


# What is a LinkedList
LinkedList extends List and Queue interfaces. Other than operations exposed by Queue interface, LinkedList
has the same operations as ArrayList.
ArrayList uses an Array kind of structure to share elements. So inserting and deleting from an ArrayList are expensive operations.
However search of an ArrayList is faster than LinkedList.
LinkedList uses Linked representation. Each object holds a link to the next element. Hence insertion and deletion are faster than
ArrayList, but searching is slower.


# HashMap, Collections.synchronizedMap, ConcurrentHashMap
The Map object is an associative containers that store elements, formed by a
combination of a unique identify key and a mapped value. If very highly concurrent
application in which may want to modify or read key value in different threads then
it's ideal to use ConcurrentHashMap.
If multiple threads access a hash map concurrently, and at least one of the threads
modifies the map structurally, it must be synchronized externally to avoid inconsistent
view of contents.
Two ways to synchronize HashMap
- Java Collections synchronizedMap()
- ConcurrentHashMap

+-----------------------------------------------------------------------------------+
| // Hashtable                                                                      |
| Map<String, String> normalMap = new Hashtable<>();                                |
| // synchronizedMap                                                                |
| synchronizedHashMap = Collections.synchronizedMap(new HashMap<String, String>()); |
| // ConcurrentHashMap                                                              |
| concurrentHashMap = new ConcurrentHashMap<String, String>();                      |
+-----------------------------------------------------------------------------------+

# ConcurrentHashMap
- To achieve high concurrency in project
- Thread safe without synchronizing whole map
- Reads happen very fast while write is done with a lock
- Not locking at object level
- Lock is at HashMap bucket level
- Does not throw ConcurrentModificationException if one thread tries to modify it while another is iterating over it
- Uses multitude of locks


# SynchronizedHashMap
- Synchronized at object level
- Every read/write operations need to acquire lock
- Locking the entire collection leads to performance overhead
- May cause contention
- Returns iterator which fail fast on concurrent modification


##########
# Java 8 #
##########

# Lambda
Is a block of code that you can pass to use in future once or more times
Useful
Pass comparison method Arrays.sort
Run task in different thread
Action event example after button clicked
Lambda Functions are simply anonymous functions

Output of one operation is fed into another
This functionality using something called AGGREGATE OPERATIONS
FILTER, MAP and FOREACH are standard aggregate operations in functional programming


# Functional Interfaces

In Java there are a lot of interfaces that determines the action like Runnable or Comparator
Lambda expression is compatible with these interfaces
You can put lambda expression in all places, when you can put object that implements one abstract method
Such interfaces are called functional interfaces


# Streams

Process data in more abstract way, than in case of collections. In case of stream you determine what should be done
not the way it will be executed. Processing details live on implementation.
Example calculate average value of parameters. Your task is to determine the source of data
and parameters, library that use stream optimizes all calculations and process the result.
Returns Optional<T> value.

+------------------------------------------------------------------+
| long counter = word.stream().filter(s->s.length() > 12).count(); |
+------------------------------------------------------------------+

3 stream steps. Create stream, determine intermediate operations that modify stream to other form.
End operation that generates result. After that step stream cannot be used anymore.

Streams allow efficient parallel process
You can create streams from Collection, Generators or Iterators
Use filter to choose elements and map to process them
Other operation to process stream : limit, distinct, sorted
To get result from stream use reduce operator like : count, max, min, findFirst, findLast, some of them returns Optional vale

Optional type is a safe way to work with null values. To use them use methods ifPresent, orElse
You can collect stream results in Collections, Arrays, Strings or Maps
GroupingBy and partitioningBy From Collector class allows to separate stream on group and determine result for each of these groups
Special streams for primitive typed like : int, long, double
Parallel Streams automated parallel operations on streams


# Streams vs Collections

Streams does not store elements. They can be stored in processing by stream collection or generated on demand
Streams operation does not modify source data. For instance filter does not delete elements from stream but returns new one
Streams operations are lazy. They process is delay until the results are needed.


# Stream workflow

- Create stream
- Determine intermediate operations which process stream to different form, this process might require couple of steps (filter)
- Process end operation which generates the result. After this step stream can no longer be used

Map method is analogous to map interface from stream. Optional value is a stream on size zero or one.
filterMap method from stream interface. Is used to join two methods.


# ParallelStreams

+------------------------------------------------------------------------------------------------------------------+
| Stream.of(arrays).parallel()                                                                                     |
| Map<Integer, Long> word = words.parallelStream().filter(s->s.length() < 12).collect(groupingBy(String::length)); |
+------------------------------------------------------------------------------------------------------------------+

Streams are introduced in Java. In combination with Lambda expression, they attempt to bring some of the
important functional programming concepts to Java.
A stream is a sequence of elements supporting sequential and parallel aggregate operations.
Consider the flow:
- Creating an array as stream
- Use lambda expression to create a filter
- Use map function to invoke a String function
- Use sorted function to sort array
- Print the array using forEach

+--------------------------------------------------+
| Arrays.stream(new String[]{"Ram", "Tam", "Tam"}) |
|    .filter(s->s.startsWith("Ta"))                |
|    .map(String::toLowerCase)                     |
|    .sorted()                                     |
|    .forEach(System.out::println);                |
+--------------------------------------------------+

In general any use of streams involves.
- source : Creating or use existing stream
- Intermediate Operations : returns new stream
- Terminal operation : consume the stream print
Intermediate Operations are of two parts
- Stateful : elements need to be compared against each others (sort)
- Stateless : no need for comparing with other element (map, filter)


# Optional

Optional object Optional<T> pack up object type T. Optional Object is safe alternative to reference to T type,
which can accept object or null value. Use method that returns alternative value if returned value does not exists
or take value if present.

+--------------------------------------------------------------------------------------------------------+
| String value = optionalString.orElse(""); // String or " " if not                                      |
| String result = optionalString.orElseThrow(IllegalStateException::new); // Throw exception if no value |
+--------------------------------------------------------------------------------------------------------+

ifPresent method accepts function. If optional value exists, is passed to function. Else do nothing.
Optional value is a stream of size zero or one. If value exists function is triggered.


# Predicate<T>

Function that return logical value.
Predicate.isEqual(a) is counterpart of a::equals, but works correctly even with null values.
Methods and, or, negate to join predicates
Predicate.isEqual(b) === x->b.equal(x)


##################
# Big-O Notation #
##################

# Complexity and the Big-O notation
Performance is a measured along resource consumption and code consumes variety of resources
Improving code performance beyond a certain point involves Trade offs
Consuming more of one resources can help consume less of another.


# Measures of performance
Time - The amount of processing or number of operations code has to perform to accomplish it's objectives
Space - This is both the memory needed by code to store information at run-time as well as disk space needed by code
for persistent storage
Network - The bandwidth code uses to pass information to clients or other machines

Performance indicates how much of these resources the code uses. Code is also more efficient when
it uses the resources we have in plenty rather that those we lack.


# Complexity
Complexity is a measure of how resource requirements change as the size of the problem gets larger
Affects performance. The higher the complexity the problem the lower the performance

Time required by code to run depends on the basic operations it performs
Arithmetic operations read, assignment write. How performance changes based on input size
Focus on the worst case performance
Code uses time, space and network resource. The amount of resource used determines code's performance
Complexity is a measure of performance

Big O Notation allows us express complexity as a measure of input size. This express the complexity of an algorithm
A algorithm which complexity does not change with input size is O(1), is said to have constant time complexity
The Complexity of an algorithm is O(N) is the time taken by the algorithm increases linearly when N increases
The Complexity of an algorithm is O(N^2) if the time taken by the algorithm increases quadratically when N increases

+---------------------------+
| for (int i = 1; i < n;) { |
|    i = i * 2;             |
| }                         |
+---------------------------+

The complexity of this operation is O(log(N))

+----------------+-------+-------+--------+----------+
| Lists and Sets |  get  | add   | remove | contains |
+----------------+-------+-------+--------+----------+
| ArrayList      | O(1)  |  O(1) |  O(n)  |  O(n)    |
| LinkedList     | O(n)  |  O(1) |  O(1)  |  O(n)    |
| HashSet        | O(1)  |  O(1) |  O(1)  |  O(1)    |
| LinkedHashSet  | O(1)  |  O(1) |  O(1)  |  O(1)    |
| TreeSet        |O(logN)|O(logN)| O(logN)| O(logN)  |
+----------------+-------+-------+--------+----------+
| Maps                                               |
+----------------+-------+-------+--------+----------+
| HashMap        | O(1)  |  O(1) |  O(1)  |  O(1)    |
| LinkedHashMap  | O(1)  |  O(1) |  O(1)  |  O(1)    |
| TreeMap        |O(logN)|O(logN)| O(logN)| O(logN)  |
+----------------+-------+-------+--------+----------+

+-----------------+--------+------+--------+------+
| Queue           | offer  | peek | pull   | size |
+-----------------+--------+------+--------+------+
| PriorityQueue   | O(logN)| O(1) | O(logN)| O(1) |
+-----------------+--------+------+--------+------+

+--------------------+-----------------+------------------+
| Sorting algorithms | Time Complexity | Space Complexity |
+--------------------+-----------------+------------------+
| MergeSort          |     O(NlogN)    |       O(n)       |
| TreeSort           |     O(NlogN)    |       O(n)       |
+--------------------+-----------------+------------------+


# Sorting
Trade offs in sorting
What is the complexity of the algorithm used
How does it scales as the input size increases?
How much space does it occupy?
Does it need extra space to hold information during sorting?
Is the sort stable?
Do equal elements maintain their original order after sorting?
How many comparisons and elements swaps are needed?
Do the algorithm work better with nearly sorted list?
Is the sort adaptive?
Does it breaks early when the list is sorted?

Sorting algorithms
- Selection Sort
- Bubble Sort
- Insertion Sort
- Shell Sort
- Merge Sort
- Quick Sort
- Binary Search


##################
# Data Structure #
##################

# TREE DATA STRUCTURE
Tree is a structure which is made up of nodes. Each node can point to a number of nodes
Unlike stacks, queues, linked lists the order of elements is not important in a tree
It is non linear data structure
Tree is used to represent hierarchical information


# The Binary Tree
A general tree data structure can have number of children but these trees are less useful and not very commonly used
in data structure
In binary tree each node can have 0, 1 or 2 children

Root - a node with no parents, every tree has exactly one root
Edge - a link from a parent to a child node
Leaf - node with no children
Siblings node - are in the same level in a tree

     +---+
     | A | A -> ROOT
     +---+
    /     \ Edges
 +---+   +---+
 | B |   | C |   B-C -> SIBLINGS
 +---+   +---+
        /     \ Edges
     +---+   +---+
     | D |   | E | D-E -> SIBLINGS, LEAF
     +---+   +---+

Binary Tree Traversal
Visiting nodes of a tree is called TRAVERSING TREE


# BREADTH-FIRST TRAVERSAL
Involves visiting nodes at every leaf before moving on to the next level
Start at root node it is at level 0 and is the first node to visit
Next step check whether there are other Nodes at the same level and visit them
Once a level is exhausted then we can move to the next level
Continue process till every node is visited

A root node is ancestor of all nodes.
A Binary tree is one where every node can have a maximum of two children. The left and right
Two binary trees are the same if
1. Every corresponding node has the same value
2. The structure of the tree at every corresponding node is the same


# DEPTH-FIRST TRAVERSAL
Depth first traversal involves going right to the leaf of the binary Tree first before moving up tree.
Depth first can be:
PRE-ORDER, IN_ORDER, POST-ORDER

All depth first traversal are most efficiently and intuitively implemented using RECURSION

PRE-ORDER
Each node is processed first (pre) before it's right and left subtrees.
The left sub-trees are processed before the right sub trees.
NODE -> LEFT SUBTREE -> RIGHT SUBTREE

IN-ORDER
The Left subtree is processed first, then the NODE, then RIGHT SUBTREE
LEFT-SUBTREE -> NODE -> RIGHT SUBTREE

POST-ORDER
Both subtrees are processed BEFORE the node itself. The node is processed AFTER (POST) the subtree
LEFT-SUBTREE -> RIGHT SUBTREE -> NODE


# The Binary Search Tree
Also called an Ordered binary tree and it's a tree with some specific Characteristics.

For Every Node in the TREE:
Each node in the left subtree of that node has a value less than or equal to the value of the node.
Each node in the right subtree of that node has a value greater than the value of the node.

            8                   Every node in the left subtree is <= 8
           / \
          7   14                Every node in the right subtree in > 8
         /   /  \
        4   12   16
       / \    \    \
      2   5    13   18

Binary search tree are typically used for FAST INSERTION and FAST LOOKUP.

The structure of a tree depends on the order in which the nodes are ADDED:
INSERTION

We can simply follow the RIGHT or LEFT subtrees based on the value we want to find:
LOOKUP

Insertion and Lookup
Insert the Node 2 in the tree

            8       step-1) Compare Node to be inserted with root node
           / \      step-2) 8 has left child so continue compare node values
          6   14    step-3) 6 already has a left child continue compare node values
         / \    \   step-4) 2 < 4 so mowe down to the left subtree
        4   7    16
       /           \
     +-+            18
     |2|
     +-+

Lookup in a Binary Search Tree
Lookup the value 7 in the tree

            8       step-1) Compare 7 with the root value
           / \      step-2) 8 has a left child so continue comparing the node
          6   14    step-3) Compare 7 to 6. Go to right child
         / \    \   step-4) Match. The Node has been found
        4  +-+   16
           |7|     \
           +-+      18

Insertion
The Complexity for Node insertion is O(logN).
The actual complexity depends on the shape of the tree. I.E all right or left child can have O(N)

Lookup
The Complexity for value lookup is O(logN) in average case.
For both insertion and lookup we have the TREE we have to traverse at every step. This gives us the log(N) complexity.


# HEAPS

# THE PRIORITY QUEUE
When a certain element in a collection has HIGHEST WEIGHT-AGE OR PRIORITY - A common use case is to process that first.
The data structure to store elements where the highest priority has to be processed first can be called a
priority queue.
At every step we access the element with highest priority.

Common operations on a priority Queue:
INSERT ELEMENTS
ACCESS the highest priority element
REMOVE the highest priority element

An Array or List
          | UNORDERED                             | ORDERED
----------+---------------------------------------+----------------------------------------------------------------------
INSERTION | Can be anything in a list or array    | Requires finding the right position for the element based on priority
          | complexity O(1)                       | complexity O(N)
----------+---------------------------------------+----------------------------------------------------------------------
ACCESS    | Accessing the highest priority        | Accessing the highest priority elements is easy
          | element requires going through all    | complexity O(1)
          | elements in the list - complexity O(N)|
----------+---------------------------------------+----------------------------------------------------------------------
REMOVE    | Requires going through all elements   | Removing the highest prioritity element - O(1)
          | O(N)                                  |
----------+---------------------------------------+----------------------------------------------------------------------

BALANCED BINARY SEARCH TREE

INSERTION | O(logN)
----------+---------
ACCESS    | O(logN)
----------+---------
REMOVE    | O(logN)

Both insertion and access moderately fast.
List solutions make one of these super fast while comparing heavily on the other

BINARY HEAP

INSERTION | O(logN)
----------+---------
ACCESS    | O(1)
----------+---------
REMOVE    | O(logN)
----------+---------

THE BINARY HEAP
A Heap is just a tree with a special properties or constraints on the vales of it's Nodes
This is called a HEAP Property

Types of Heap:
-MINIMUM HEAP
Every node value should be <= value of it's children
The node with the smallest value should be the root of the tree

-MAXIMUM HEAP
Every Node value should be >= Value of it's children.
The node with the largest value should be the root of the tree

The heap should form a complete binary tree -
all levels except the last one should be filled

Node at index 0, left child at index 1, right child at index 2
Node at index: i
has a left child at index: 2i + 1
has a right child at index: 2i + 2
Node at index: i GetParent at index: (i-1)/2

        5
      /   \
     8     6
    / \    /\
   9   12 11 7
  / \
 15 10

 5 | 8 | 6 | 9 | 12 | 11 | 7 | 15 | 10


# THE BINARY HEAP
Place a single element in the wrong place.
Then try to find the right position for the element.
This process is called HEAPIFY

        13
      /    \
     8      6
    / \    /  \
   9  12  11   7
  / \
 15  10

SHIFT DOWN                   | SHIFT UP
-----------------------------+-----------------------------
All elements in the wrong    | An element is in the wrong
position with respect to     | position with respect to
other elements below it on   | other above in the
the heap                     | heap
                             |
It has to be moved downwards | It has to be moved upwards in
in the heap towards the leaf | the Heap towards the ROOT
node to find it's right      | Node to find it's right position
position                     |

SWAP 6 and 8
SWAP 13 and 7

        7
      /    \
     6      8
    / \    /  \
   9  12  11   13
  / \
 15  10

Insertion                       | O(logN)
--------------------------------+--------
Access highest priority element | O(1)
--------------------------------+--------
Remove                          | O(logN)
--------------------------------+--------

Heap Sort
Insertion and removal | O(logN)
----------------------+---------
Sorting               | O(NlogN)

Heap sort is not adaptive
It's not a stable sort
It does not need additional space - space complexity is O(1)


# THE GRAPH
A Graph is used to represent relationships between entities.

The entities can be anything - Graphs find applications in variety of ways in real world.
These relationship can be arbitrarily complicated and of a variety of different types.

VERTEX                     | EDGE
---------------------------+---------------------------------------------------------
The Entities Are People    | Personal Relationships - People Work Together - Linkedin
                           +---------------------------------------------------------
                           | Personal Relationships - People are friends - Facebook
---------------------------+---------------------------------------------------------
The Entities Are Locations | A Way to Get from location to another ROADS, RAIL, AIR - Google Maps
---------------------------+---------------------------------------------------------
The Entities are old       | A Network to carry voice from one instrument to another - at&t
fashioned Phones -         |
LANDLINES                  |
---------------------------+---------------------------------------------------------
The Entities Are computer  | A Way to send information or data from one computer to
across the world           | another - Google, Level(3), cisco

The Graphs are used to represent information in many real world applications
There are many algorithms to optimize different problems represented using graphs

A Graph is a SET of VERTICES and EDGES

+---+                    +---+
| A +--------------------+ B | (V,E)
+---+                    +---+

Two Vertices and A single Edge is also a valid graph

+---+   Edge             +---+
| A +--------------------+ B | (V,E)
+---+                    +---+
VERTEX                  VERTEX

+---+                    +---+
| A +------------------->+ B |
+---+                    +---+
SOURCE                  DESTINATION

The Arrow on the Edge. This means that the relationship between two vertices is directed - THE EDGE is a DIRECTED EDGE

+---+                    +---+ | UNDIRECTED edges represent
| A +--------------------+ B | | two - way relationship such as:
+---+                    +---+ | 1. Two way road
                               | 2. I am his friend and he is mine
-------------------------------+----------------------------------
                               | DIRECTED edges represent
+---+                    +---+ | 1 - way relationship such as:
| A +------------------->+ B | | 1. ONE way road
+---+                    +---+ | 2. I report to my manager


UNDIRECTED GRAPH

+---+         +---+         +---+
| A +---------+ B +---------+ F |
+-+-+         +---+         +-+-+
  |  \       /                |  \
  |   \     /                 |   \
  |    +---+                  |    +---+
  |    | D |                  |    | H |
  |    +---+                  |    +---+
  |         \                 |
  |          \                |
+-+-+         +---+         +-+-+
| C +---------+ E +---------+ G |
+---+         +---+         +---+

A - C are ADJACENT Nodes
3 edges are INDICENT Vertex F

The way to go from C to B. C -> A -> B
This series of Edges is called a PATH

Nodes A,D,E,C form a cycle


UNDIRECTED ACYCLIC GRAPH

+---+         +---+         +---+
| A +---------+ B +---------+ F |
+-+-+         +---+         +-+-+
  |          /                |  \
  |         /                 |   \
  |    +---+                  |    +---+
  |    | D |                  |    | H |
  |    +---+                  |    +---+
  |                           |
  |                           |
+-+-+         +---+         +-+-+
| C +---------+ E |         | G |
+---+         +---+         +---+

Every Node is CONNECTED TO EVERY OTHER NODE via a series of edges
This Graph has no cycles
A Connected graph with no cycles. This is a connected graph

               B
             / | \
            A  D  F
           /     / \
          C     G   H
         /
        E

Graph with no cycle is tree


DIRECTED GRAPH

+---+         +---+         +---+
| A +-------->+ B +-------->+ F |
+---+         +---+         +-+-+
  |  A       /                A  \
  |   \     V                 |   V
  |    +---+                  |    +---+
  |    | D |                  |    | H |
  |    +---+                  |    +---+
  |         \                 |
  V          V                |
+-+-+         +---+         +-+-+
| C +-------->+ E +-------->+ G |
+---+         +---+         +---+

Nodes A,B,D,A form a cycle


DIRECTED ACYCLIC GRAPH (DAG)

+---+         +---+         +---+
| A +-------->+ B +-------->+ F |
+-+-+         +---+         +-+-+
  |  A                        A  \
  |   \                       |   V
  |    +---+                  |    +---+
  |    | D |                  |    | H |
  |    +---+                  |    +---+
  |         \                 |
  V          V                |
+-+-+         +---+         +-+-+
| C +-------->+ E +-------->+ G |
+---+         +---+         +---+

A Graph Representation
To represent a Graph there is a need a way to model a vertex which may held some information.
A way to model directed or undirected EDGES.

There are 3 standard ways that Graphs can be represented.
ADJACENCY MATRIX
ADJACENCY SET
ADJACENCY LIST

ADJACENCY MATRIX
Use a metrix with ROWS and COLUMNS a matrix is table
The Row labels and the column labels represent the Vertices
Each cell represent relationship between the vertices i.e. the EDGES

+---+     +---+                   A  B  C  D  E
| A +---->+ B |                 +----------------
+-+-+     +-+-+               A | 0  1  1  0  0
  |         A   V             B | 0  0  0  1  0
  |         |    +---+        C | 0  0  0  0  1
  |         |    | D |        D | 0  0  0  0  0
  |         |    +---+        E | 0  1  0  1  0
  V         |  A
+-+-+     +-+-+
| C +---->+ E |
+---+     +---+

A value 1 or true in (row A, column B) indicates Edge from A to B
DIRECTED GRAPH

+---+     +---+                   A  B  C  D  E
| A +-----+ B |                 +----------------
+-+-+     +-+-+               A | 0  1  1  0  0
  |         |   \             B | 1  0  0  1  1
  |         |    +---+        C | 1  0  0  0  1
  |         |    | D |        D | 0  1  0  0  1
  |         |    +---+        E | 0  1  1  1  0
  |         |  /
+-+-+     +-+-+
| C +-----+ E |
+---+     +---+


ADJACENCY LIST (adjacent means neighbors cells)

Each vertex is a node.
Each vertex as a pointer to a LinkedList.
This LinkedList contains all the other nodes this vertex connects to directly.

If a vertex V has an Edge leading to Another Vertex U
Then U is present in V's LinkedList

+---+     +---+                   DIRECTED GRAPH
| A +---->+ B |               A -> B -> C
+-+-+     +-+-+               B -> D
  |         A   V             C -> E
  |         |    +---+        D
  |         |    | D |        E -> B -> D
  |         |    +---+
  V         |  A
+-+-+     +-+-+
| C +---->+ E |
+---+     +---+

+---+     +---+                   UNDIRECTED GRAPH
| A +-----+ B |
+---+     +-+-+               A -> B -> C
  |         |   \             B -> A -> D -> E
  |         |    +---+        C -> A -> E
  |         |    | D |        D -> B -> E
  |         |    +---+        E -> C -> B -> D
  |         |  /
+-+-+     +-+-+
| C +-----+ E |
+---+     +---+

Adjacency List Downsides
The ORDER of the Vertices in the AdjacencyList is MATTER
The same Graph can have MULTIPLE REPRESENTATIONS
Certain operation become tricky e.g. deleting a Node involves looking through all the adjacency List to
remove the Node from all Lists


ADJACENCY SET

Similar to AdjacencyList
Instead of a LinkedList to maintain the adjacent vertices USE A SET

The GRAPH Representations

ADJACENCY MATRIX             |   ADJACENCY LIST, SET
-----------------------------+-----------------------
This works well when the     | A SPARSE Graph with Few
Graph is WELL CONNECTED i.e. | Connections between nodes
Many Nodes are connected     | might be more efficiently
with many other Nodes.       | represented using Adjacency
The overhead of V^2 spece is | List or Set
worth it when the number of  |
connections are large        |

E = Number of Edges
V = Number of Vertices

                  | Adjacency Matrix | Adjacency List | Adjacency Set
------------------+------------------+----------------+------------------
SPACE             |     V^2          |  E + V         |  E + V
------------------+------------------+----------------+------------------
IS EDGE PRESENT   |     1            |  DEGREE OF V   |  Log(DEGREE OF V)
------------------+------------------+----------------+------------------
Iterate over      |     V            |  DEGREE OF V   |  DEGREE OF V
edges on a vertex |                  |                |


THE GRAPH Traversal

DEPTH-FIRST, BREADTH-FIRST
In a graph multiple paths can lead from one node to another

A Graph can also have cycles, the same Node can be visited multiple times

In order to avoid infinite looping In a Graph we need to keep track of the Node previously visited


THE GRAPH TOPOLOGICAL SORT

It is an ordering of vertices in a DIRECTED ACYCLIC GRAPH in which each node comes before
all the nodes to which it has outgoing EDGE

+---+       +---+
| A +------>+ B | A should come before
+---+       +---+

+---+     +---+
| A +---->+ B |               A should come before B and C
+-+-+     +-+-+               C should come before E
  |         A   V             E should come before B and D
  |         |    +---+        B should come before D
  |         |    | D |
  |         |    +---+
  V         |  A
+-+-+     +-+-+
| C +---->+ E |
+---+     +---+

Topological sort for this graph will be:
A,C,E,B,D

First find vertex which has no incoming edge
It's the destination of no edge no arror points to it

A - is the only vertex with No incoming edge this is the first element of the SORT!

IN DEGREE
Number of inward directed graph edges for a given graph vertex

In degree of A is 0

If there were NO VERTICES WITH 0 IN DEGREE, than there would have been no topological sort.

If we remove A from this graph, we have to reduce the IN DEGREE of all its immediate neighbors.
The Next vertex in this SORT the One with In degree 0
C is the Next element

Remove C from a graph and decrement the indegree of its immediate neighbors. The Next vertex with indegree of 0 is E.

Result: ACEBD

Running time for topological sort is O(V + E)

Every Edge and Every vertex is visited ONCE

It is an ordering of vertices in DIRECTED ACYCLIC GRAPH i which each node comes before all the
Nodes to which It has outgoing EDGES


# STACK DATA STRUCTURE
A stack is data structure to hold elements such that the last element you add to the stack is first one you access
LIFO list in first out
Major operations that you performed on the stack are always focused on one end of the stack, called the TOP

Adding new elements to the stack is called -> PUSH -> push an element to the top of a stack
Removing an element from the top a stack is called -> POP -> pop an element from the top of stack
See what element on stack is do not remove it -> PEEK -> peek at the top of a stack

                  +---+
 |     |         || X ||                |     |                 |     |
 |     |  PUSH   |+---+|      POP       |     |      PEEK       |     |
 |+---+|  +---+  |+---+|     +---+      |+---+|      +---+      |+---+|
 || Y ||  | X |  || Y ||     | X |      || Y ||      | Y |      || Y ||
 |+---+|  +---+  |+---+|     +---+      |+---+|      +---+      |+---+|
 |+---+|         |+---+|                |+---+|                 |+---+|
 || Z ||         || Z ||                || Z ||                 || Z ||
 |+---+|         |+---+|                |+---+|                 |+---+|
 +-----+         +-----+                +-----+                 +-----+


Peek let's you access the top element in the stack without actually changing the Data Structure

Common operations on stack
PUSH    POP     PEEK

Other operations which are useful
ISEMPTY     ISFULL      SIZE

If you try to POP from an empty element or PUSH into full stack -> It's an ERROR throw an Exception!

The most common operations on a stack involve pushing and popping elements from the TOP.
The operations are on one end of the stack.
A LinkedList match perfectly to build a stack

Performance
PUSH and POP from a stack O(1) constant time complexity.
isEmpty and isFull also O(1)
Size O(1)

Useful
Implementing Undo in application
Implementing back button in browser
Holding the memory for recursive calls in a programing language

+-------+------+-----+------+--------+---------+------+
|       | PUSH | POP | PEEK | isFull | isEmpty | Size |
+-------+------+-----+------+--------+---------+------+
| Stack | O(1) |O(1) | O(1) |  O(1)  |   O(1)  | O(1) |
+-------+------+-----+------+--------+---------+------+


# QUEUE DATA STRUCTURE
Queue is a Data Structure where you add elements to the End of the Queue and remove elements
from the beginning of the QUEUE.

                +--------------------------------------------------+
                     +---++---++---++---++---+
                     | A || B || C || D || E |
                     +---++---++---++---++---+
                +--------------------------------------------------+


DEQUEUE remove  +--------------------------------------------------+   ENQUEUE add new element
     +---+           +---++---++---++---++---+                        +---+
  <- | A |           | B || C || D || E || F |                     <- | F |
     +---+           +---++---++---++---++---+                        +---+
                +--------------------------------------------------+

FIFO first in first out
LILO last in last out

The operations are performed at two ends. Removal its at the beginning and addition is at the end of the queue.

Adding a new element to the end of the Queue is called
ENQUEUE -> enqueue an element from the queue

Removing an element from the beginning of a queue is called
DEQUEUE -> dequeue an element from the queue

Similar to stack you might just want to see what the first element in a queue is without removing it
PEEK -> Peek at the first element in a queue

The Queue implementation in Java
OFFER -> adds to a queue if space is available

Common operations on the queue
ENQUEUE     DEQUEUE     PEEK

Other operations
ISEMPTY ISFULL OFFER

If you try to dequeue from an empty queue or enqueue into full queue. It's an error throw Exception

The most common operations on queue involve enqueueing and dequeueing elements
The operations are on both ends of queue
A LinkedList which is a pointer to head and tail works well

Performance
Enqueueing and dequeueing implemented in this way is O(1)
IsEmpty isFull O(1)
Space complexity O(N)

Useful
Calls
Queueing job to be printed
Order processing system E-Commerce websites or bank transactions.

+-------+---------+---------+--------+---------+
|       | Enqueue | Dequeue | isFull | isEmpty |
+-------+---------+---------+--------+---------+
| Queue |   O(1)  |   O(1)  |  O(1)  |   O(1)  |
+-------+---------+---------+--------+---------+


#########################
# Garbage Collection GC #
#########################

Java provides automatic memory management through a program called Garbage Collector. "Remove object that are not use"
live object = reachable (referenced by someone else)
dead object = unreachable (unreferenced)
- Objects are allocated in the "heap" of java memory
- Static members, class definition are stored in "method area" PermGen/Metaspace
Garbage Collection is carried out by a daemon thread called "Garbage Collector"
Force GC to happened System.gc (no guaranteed)
When failed to allocated because of full heap. Error message java.lang.OutOfMemoryError

Garbage Collector involves
    - Mark : go through all program structure, mark reachable objects as live
    - Delete/Sweep : Delete unreachable objects
    - Compacting : Compact memory by moving around objects

Typed of Garbage Collector
    - Serial Collector : Runs on single thread, useful in basic applications
    - Concurrent Collector : GC execute as application runs, not wait the old generation to full stop the world
      execute only during mark/re-mark phase
    - Parallel Collector : Uses multiple CPUs to perform GC. Multiple threads doing mark/sweep. Does not start until
      heap is full/near-full. "Stop the world" when runs.

Use Concurrent collector, when there is more memory, high number of CPUs, short pauses required
Use parallel collector, when there is less memory, lesser number of CPUs, high throughput required, pauses are OK

java -XX:+UseSerialGC
java -XX:+UseParallelGC
java -XX:+UseConcMarkSweepGC


# Garbage Collector example

+----------------------------------------------------------+
| void method() {                                          |
|   Calendar calendar = new GregorianCalendar(2000,12,12); |
|   System.out.println(calendar);                          |
| }                                                        |
+----------------------------------------------------------+

Object of class GregorianCalendar is created on the heap by the first line in method with one reference variable calendar.
After method ends execution the reference variable calendar is no longer valid. Hence there are no reference
to the object created in the method. JVM recognizes this and removes the object from the heap. This is called GC


# When Garbage Collection is run
Based on fancies of JVM. Possible situations
- When available memory on he heap is low
- When CPU is free


###############
# Concurrency #
###############

fail-safe does not throw ConcurrentModificationException
fail-fast throw ConcurrentModificationException
volatile - value read always from main memory no cache
synchronized - acquire intrinsic lock on object. Only one object can execute this part of code
join() - wait until other thread finish executing

wait and notify for inter thread communication. Must be called from synchronized context method, block


# Process and threads
In concurrent programming two units of execution process and treads.
Processing time for a single core is shared among processes and threads, time slicing

Process : Has a self contained execution environment. Private set of runtime resources
Each process has its own memory space. Process can communicate with each others IPC

Threads : Lightweight process. Creating a new thread requires fewer resources than creating a new process
Exists within a process. Every process has at least one thread

join() : method wait until thread to finish

threads priority : importance of a thread to the scheduler. Lower priority thread tend to run less often.
setPriority(), getPriority(). MAX_PRIORITY, NORM_PRIORITY, MIN_PRIORITY

yield() : this static method is essentially used to notify the system that the current thread is willing to
give up CPU for a while, but scheduler can immediately pick them back. Is put back into the ready queue of the processor,
and waits for it next turn.


# Start Thread
Extends Thread - override run() method

Implements Runnable - override run() method, pass Runnable object to Thread class constructor. Call start method
on thread object.

Executor Service - dynamically reuse thread. Check if threads are already working
  - Executors.newCachedThreadPool() return an executor service that can dynamically reuse threads
    Before starting a job, it going to check whether there are any threads that finished the job if so reuse them
    If no create new one, good for processor effective solution
  - Executors.newSingleThreadPool() uses single thread for the job
  - Executors.newFixedThreadPool() maximize the number of threads. If all the thread are busy we have to wait
    for one to terminate

  - executorService.execute(Runnable)
  - executorService.submit(Callable or Runnable)


# Concurrent Collections

# ConcurrentHashMap
Full concurrency during retrieval
Reads can happen fast, while writes require lock
Whole table is not locked only segment is locked
Iterations do not throw concurrent modification exception
Null key not allowed
Operations are atomic


# BlockingQueue
Interface that represents a queue that is thread safe. put(), take()


# DelayQueue
Like BlockingQueue that implements Delay interface. Cannot put null into it.


# PriorityBlockingQueue
Implements Comparable interface. Determine what will be the order of a Queue.


# Threads complications
Thread interference and memory consistency errors
    - If two thread access the same variable, it is possible for them to get in each others way
      For example two threads incrementing the same variable at the same time
      To fix this make sure that section of code is only accessed by one thread at a time, by using synchronized keyword for example
      But this slows down performance, and can lead to thread contention issues (starvation, livelock, deadlock)

Thread Contention
    - Deadlock : two thread each is blocked by a lock held by the other
    - Livelock : two thread's don't deadlock, but keep blocking on locks held by each other, neither can progress
    - Starvation : Same thread keep acquiring locks, and cause other threads to be unable to get anything done


# Semaphores
Variables that are used to controlling access to common resources, important in OS
is a record of how many units of particular resource are available
Semaphores track how many resources are free, it does not keep track of which of the resources are free
Mutexes are binary semaphores. Mutex has a concept of an owner. Only process that locked a mutex is supposed to unlock it
Methods acquire() if permit is available take it, release() add a permit


# Callable and Future
Returns something from a thread implements Callable instead of Runnable


# Thread States
Runnable - create a new thread and call start method
Blocked - enter synchronized block, lock
Waiting - after wait()
Terminated - run method is over


# Concurrent Libraries

# CountDownLatch
Used to synchronize one or more tasks by forcing them to wait for completion of a set of operations
being performed by other tasks. Give initial count to count down latch object and task that calls await() on that
object will block until count reaches zero. The count cannot be reset. Typically use is to divide a problem into "n"
independently solve able tasks and create a CountDownLatch with value of "n"
When each task is finished it calls countDown on Latch. Task waiting to solve call await() on the Latch to hold
themselves back until it is completed


# CyclicBarrier
Used in situation where you want to create a group of tasks to perform work in parallel plus wait
until they are still finished before moving on to the next step, like join or countDownLatch.
Can be reused.


# From Java 8 Book

# Concurrent Programming
Runnable describes task that might be executed asynchronously
Executor plans execute runnable instance
Callable tasks that return results or throw exception
Results without synchronization are unpredictable
Better use thread safe data structures than use locks
ConcurrentHashMap is thread safe array allows to updates elements using atomic operations
To interrupt task set interrupt flag or throw InterruptedException

Thread is mechanism that allow to execute sequence of instruction, these instructions are provided by OS
Couple of threads work in parallel using multiple processors of different time slice of the same processor

Executor executes a task by choosing threads that might be executed with

+-------------------------------+
| Runnable task = () -> {};     |
| Executor exec = Executors...; |
| exec.execute(task);           |
+-------------------------------+

Factory method Executor class
Executors.newCachedThreadPool() - each task execute in safe thread, couple of small tasks
Executors.newFixedThreadPool(thread_num); - good for grater amount of tasks
To acquire number of thread based on number of processors

+--------------------------------------------------------------+
| int processors = Runtime.getRuntime().availableProcessors(); |
+--------------------------------------------------------------+

Objects Future and Executor
Callable - Method call() oposite to method run() from Runnable interface returns value or throw an Exceptions
To execute callable there is a need for ExecutorService instance

+---------------------------------------------------------------+
| ExecutorService exec = ExecutorService.newFixedThreadPool(2); |
| Callable<V> call = ...;                                       |
| Future<V> result = exec.submit(call);                         |
+---------------------------------------------------------------+

Future is an object that represents a calculations, which results will be accessible in a future

Thread safety
RAM memory are slow, couple of time slower then modern processors. Processor try to collect needed data
in registers or cache memory on main board, and at the end make changes in main memory
This cache memory is key factor for performance optimization

Thread Visibility
- final value is visible after initialization
- initial value of static variable is visible after static initialization
- changes variable with volatile keyword are visible
- changes after release a lock are visible for all that acquire this lock
Volatile keyword - compiler generates needed instructions to make sure that all changes that being applied in
one task are visible in another

Chasing
Are problems always when shared variables are modified. Locks to critical section make atomic

Strategy of safety concurrency
- Avoid shared data between tasks. One task z1, second task z2, third z3 = z1 + z2
- Use immutable objects
- Locks allows only one task access to data at a time. Use data structures and algorithms from java libraries

Immutable classes
Class is immutable if instance after creation cannot change
Implement immutable class
- variable with final keyword
- non method can modify data
- do not allow to leak modification
- do not allow to "this" reference pass outside constructor

Concurrent Algorithms
Parallel Streams

+----------------------------------------------------------------------------+
| Long results = coll.parallelStream().filter(s->s.startsWith('a')).count(); |
+----------------------------------------------------------------------------+

ParallelStream method returns parallel stream. Stream is parted on segments
Filtering and counting is executed for each segments and results are joined together without your further interactions
Parallel operations on arrays
Arrays operations part array on segments, parallelly process them and join results
Arrays.pararellSetAll(), parallelSort()
Process array into a stream,

+--------------------------------------------------+
| long sum = IntStream.of(value).parallel().sum(); |
+--------------------------------------------------+


Thread safe data structures

ConcurrentHashMap
Map on which operations are thread safe. Can support large number of parallel read and some number of parallel writes
To actualize data compute() method. This method is Atomic, no other thread can modify map content while executing operation

BlockingQueues
Is one of the most commonly used tool for synchronized work. One task put element into the queue, while another
take element from a queue. Allows to safety pass tasks from one task to another

LinkedBlockingQueue, ArrayBlockingQueue
ConcurrentSkipListMap - compare keys
ConcurrentSkipListSet
CopyOnWriteArrayList, CopyOnWriteArraySet - are thread safe thanks the fact that all methods that modify collection
make copy used array. Good in situation when number of threads go through queue is larger than number of thread that modify queue

Atomic Values

+-------------------------------------------+
| AtomicLong nextNumber = new AtomicLong(); |
| long id = nextWord.incrementAndGet();     |
+-------------------------------------------+

Atomic operation, load data, modify data and save data cannot be interrupted in between.


###################
# Design Patterns #
###################

Design Patterns are canonical solutions to recurring problems
Creational Patterns "How should object be created"
    - Factory, AbstractFactory, Singleton, Builder, Prototype, Dependency Injection
Behavioral Patterns "How should object behave and interact with each other"
    - Strategy, Template, Iterator, Command, Chain of Responsibility, Memento, Visitor, State, Mediator, Observer
Structural Patterns "How should classes behave and interact with each other"
    - Decorator, Adapter, Facade, Composite, Flyweight, Bridge, Proxy
Concurrency Pattern "How should specific situation be handled in multithreading"
    - Double checked locking
Model View Controller "Architectural pattern"

Libraries and Frameworks are both code written by others that we can use
Design Patterns are proven ideas for solving common problems
Code usually calls libraries and is often called by frameworks, but is structured using Design Patterns


# Creational

How objects are constructed
Decouple the construction of an action from its use
Hide implementation of an object only reveal its interface
Defer instantiation until run time
Families of related objects that must be used together
Allow creation of finite number of instances


# Behavioral

How do objects behave and interact with each other
How logical unit (classes) as whole interacts with the outside world
Iterator pattern - here logical unit includes one class Iterator class. This pattern governs how the
is used by the client (the outside world)


# Structural

How classes within the logical unit interacts with each other
MVC pattern - logical unit includes 3 classes model, view, controller
The pattern governs how the Model, View, Controller interact with each other
If the interaction between the M, V, C were change, the UI would not look or behave any different !


# Design Principle #1 : Relay on Interfaces, not implementation

"Program to an interface not implementation" decorator, iterator, adapter

Interface is a surface that a unit offers to outside world
That unit could be a single class, or even be a collection of classes
The implementation is a guts of that unit
Never get assumption about content of any unit

+------------------------------------------------------+
| ArrayList<String> list = new ArrayList<>(); // wrong |
| List<String> list = new ArrayList<>(); // correct    |
+------------------------------------------------------+


# Design Principle #2 : The Open / Close Principle

"Classes should be open for extension but closed for modification"

Once you have written a class, it's done. Never add anything to it after that
No new member variables, no new methods, no new interfaces implemented, No modification
But other code should be able to use your class in new ways. New applications via extension

Inheritance, template pattern
    - If you structure your code into abstract base class, other classes can find
      new way to use it via Inheritance

Delegation, observer, MVC, Chain of Responsibility
    - If you fire events and expose properties, other code can listen in, and use your code via Delegation

Composition, strategy pattern
    - If you take in member variable to determine behavior, you allow extension via Composition


# Design Principle #3 : Principle of Least Knowledge

"Only talk to friends, don't talk to strangers"

Only make method calls to friends
friends - object passed in as parameter to methods of your classes. Object created inside your class
Code should never include multiple '.' operators in the same function call

+----------------------------------------------------------------+
| int friendNumber = media.getRelatives().getFriend(); // not OK |
| int friendNumber = media.getFriend(); // OK                    |
+----------------------------------------------------------------+

But this rule is not always a case
Summarized, each unit should have only limited knowledge about other units. Each unit should only talk to its friend


# Design Principle #4 : Dependency Injection

"Depend on abstraction never on details"
Used technique to set member variables of objects on the fly.


# Design Principle #5 : Hollywood Principle

"Don't call us we will call you"
Class notifies other class of changes when they occurs via events or messages.
Idea high-level component calling low-level is used components in frameworks.


# MVC Paradigm

Model View Controller is an architectural pattern. In Java API Swing
Basic idea of MVC is to separate data from its representation, separating data from its manipulation,
allowing different simultaneous representations of the same data
MediaPlayer Example. Controller a slider to adjust volume in a media player app. Model the mp4 file of a movie
to be played in a media player app. View the area of the media-player app that actually displays video
User sees the model through a view, and manipulates it via the controller


# What is a basic point of observer pattern?
An object announces updates to its value, and other objects can read to these updates


# When a publisher fires an update, how do subscriber become aware of it?
The publisher has a list of listeners, and Java cycles through them and Executes the callback function they had specified


# How are properties and bindings different from each other?
Properties are ONE:ONE, bindings are ONE:MANY


# How Observer and MVC related?
The View act as publisher, controller as subscriber