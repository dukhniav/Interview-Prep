# Java style and advanced Java

## Primitive and Reference Types

- Primitive Types
  - Complete list: `byte, short, int, long, char, float, double, boolean`
- Reference Types:
  - Everything else: objects and arrays
  - Objects (of a reference type) and all arrays are stored in the heap
  - All references are the same size

## Enum

A Java _Enum_ is a special Java type used to define collections of constants. More precisely, a Java enum type is a special kind of Java class. An enum can contain constants, methods etc. Java enums were added in Java 5.

Here is a simple Java enum example:

```java
public enum Level {
    HIGH,
    MEDIUM,
    LOW
}
```

Notice the `enum` keyword which is used in place of `class` or `interface`. The Java enum keyword signals to the Java compiler that this type definition is an enum.

Constants can be referred to like:

`Level level = Level.HIGH;`

Notice how the `level` variable is of the type `Level` which is the Java enum type defined in the example above. The `level` variable can take one of the `Level` enum constants as value (`HIGH, MEDIUM or LOW`). In this case `level` is set to `HIGH`.

<details>
<summary>Enums in if Statements</summary>
Since Java enums are constants you will often have to compare a variable pointing to an enum constant against the possible constants in the enum type. Here is an example of using a Java enum in an `if`-statement:

```java
Level level = ...  //assign some Level constant to it

if( level == Level.HIGH) {

} else if( level == Level.MEDIUM) {

} else if( level == Level.LOW) {

}
```

This code compares the level variable against each of the possible enum constants in the `Level` enum.

If one of the enum values occur more often than the others, checking for that value in the first if-statement will result in better performance, as less comparison on average are executed. This is not a big difference though, unless the comparisons are executed a lot.

</details>

<details>
<summary>Enums in switch Statements</summary>
If your Java enum types contain a lot constants and you need to check a variable against the values as shown in the previous section, using a Java switch statement might be a good idea.

You can use enums in switch statements like this:

```java
Level level = ...  //assign some Level constant to it

switch (level) {
    case HIGH   : ...; break;
    case MEDIUM : ...; break;
    case LOW    : ...; break;
}
```

Replace the ... with the code to execute if the level variable matches the given Level constant value. The code could be a simple Java operation, a method call etc.

</details>

<details>
<summary>Enum Iteration</summary>
You can obtain an array of all the possible values of a Java enum type by calling its static values() method. All enum types get a static values() method automatically by the Java compiler. Here is an example of iterating all values of an enum:

```java
for (Level level : Level.values()) {
    System.out.println(level);
}
```

Running this Java code would print out all the enum values. Here is the output:

```
HIGH
MEDIUM
LOW
```

Notice how the names of the constants themselves are printed out. This is one area where Java enums are different than static final constants.

</details>

<details>
<summary>Enum toString()</summary>

An enum class automatically gets a `toString()` method in the class when compiled. The toString() method returns a string value of the name of the given enum instance. Here is an example:

`String levelText = Level.HIGH.toString();`

The value of the `levelText` variable after execution of the above statement will be the text HIGH .

</details>

<details>
<summary>Enum Printing</summary>

If you print an enum, like this:

```java
System.out.println(Level.HIGH);
```

Then the `toString()` method will get called behind the scenes, so the value that will be printed out is the textual name of the enum instance. In other words, in the example above the text HIGH would have been printed.

</details>

<details>
<summary>Enum valueOf()</summary>

An enum class automatically gets a static `valueOf()` method in the class when compiled. The `valueOf()` method can be used to obtain an instance of the enum class for a given String value. Here is an example:

`Level level = Level.valueOf("HIGH");`

The level variable will point to the `Level.HIGH` after executing this line.

</details>

<details>
<summary>Enum Fields</summary>

You can add fields to a Java enum. Thus, each constant enum value gets these fields. The field values must be supplied to the constructor of the enum when defining the constants. Here is an example:

```java
public enum Level {
    HIGH  (3),  //calls constructor with value 3
    MEDIUM(2),  //calls constructor with value 2
    LOW   (1)   //calls constructor with value 1
    ; // semicolon needed when fields / methods follow


    private final int levelCode;

    private Level(int levelCode) {
        this.levelCode = levelCode;
    }
}
```

Notice how the Java enum in the example above has a constructor which takes an int. The enum constructor sets the int field. When the constant enum values are defined, an int value is passed to the enum constructor.

The enum constructor must be either private or package scope (default). You cannot use public or protected constructors for a Java enum.

</details>

<details>
<summary>Enum Methods</summary>

You can add methods to a Java enum too. Here is an example:

```java
public enum Level {
    HIGH  (3),  //calls constructor with value 3
    MEDIUM(2),  //calls constructor with value 2
    LOW   (1)   //calls constructor with value 1
    ; // semicolon needed when fields / methods follow


    private final int levelCode;

    Level(int levelCode) {
        this.levelCode = levelCode;
    }

    public int getLevelCode() {
        return this.levelCode;
    }

}
```

You call a Java enum method via a reference to one of the constant values. Here is Java enum method call example:

```java
Level level = Level.HIGH;

System.out.println(level.getLevelCode());
```

This code would print out the value 3 which is the value of the levelCode field for the enum constant HIGH.

You are not restricted to simple getter and setter methods. You can also create methods that make calculations based on the field values of the enum constant. If your fields are not declared final you can even modify the values of the fields (although that may not be so good an idea, considering that the enums are supposed to be constants).

</details>

<details>
<summary>Enum Abstract Methods</summary>
It is possible for a Java enum class to have abstract methods too. If an enum class has an abstract method, then each instance of the enum class must implement it. Here is a Java enum abstract method example:

```java
public enum Level {
    HIGH{
        @Override
        public String asLowerCase() {
            return HIGH.toString().toLowerCase();
        }
    },
    MEDIUM{
        @Override
        public String asLowerCase() {
            return MEDIUM.toString().toLowerCase();
        }
    },
    LOW{
        @Override
        public String asLowerCase() {
            return LOW.toString().toLowerCase();
        }
    };

    public abstract String asLowerCase();
}
```

Notice the abstract method declaration at the bottom of the enum class. Notice also how each enum instance (each constant) defines its own implementation of this abstract method. Using an abstract method is useful when you need a different implementation of a method for each instance of a Java enum.

</details>

<details>
<summary>Enum Implementing Interface</summary>
A Java Enum can implement a Java Interface in case you feel that makes sense in your situation. Here is an example of a Java Enum implementing an interface:

```java
public enum EnumImplementingInterface implements MyInterface {
    FIRST("First Value"), SECOND("Second Value");


    private String description = null;

    private EnumImplementingInterface(String desc){
        this.description = desc;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
```

It is the method `getDescription()` that comes from the interface MyInterface.

Implementing an interface with an Enum could be used to implement a set of different Comparator constants which can be used to sort collections of objects. Sorting of objects in Java is explained in more detail in the Java Collection Sorting Tutorial.

</details>

<details>
<summary>EnumSet</summary>
Java contains a special Java Set implementation called EnumSet which can hold enums more efficiently than the standard Java Set implementations. Here is how you create an instance of an EnumSet :

`EnumSet<Level> enumSet = EnumSet.of(Level.HIGH, Level.MEDIUM);`

Once created, you can use the EnumSet just like any other Set.

</details>

<details>
<summary>EnumMap</summary>
Java also contains a special Java Map implementation which can use Java enum instances as keys. Here is a

Java EnumMap example:

```java
EnumMap<Level, String> enumMap = new EnumMap<Level, String>(Level.class);
enumMap.put(Level.HIGH  , "High level");
enumMap.put(Level.MEDIUM, "Medium level");
enumMap.put(Level.LOW   , "Low level");

String levelValue = enumMap.get(Level.HIGH);
```

</details>

<details>
<summary>Enum Miscellaneous Details</summary>

Java enums extend the `java.lang.Enum` class implicitly, so your enum types cannot extend another class.

If a Java enum contains fields and methods, the definition of fields and methods must always come _after_ the list of constants in the enum. Additionally, the list of enum constants must be terminated by a semicolon;

</details>

### In General

- Values of primitive types are stored directly - Local variables in the stack frame
  - Object attributes in the object - Array values in the array
- Objects and arrays are stored by reference - References for local variables in the stack frame
  - References for object attributes in the object
  - Arrays of reference types are arrays of references
    - A 2-D array of Strings is an array of references to arrays of references to Strings

## Value semantics

- _Value semantics_: Values (of primitive types) are copied when assigned to each other or passed as parameters.
  - Modifying the value of one variable does not affect others.

```
    int x = 5;
    int y = x;    //  x = 5, y = 5
    y = 17;       //  x = 5, y = 17
    x = 8;        //  x = 8, y = 17
```

## Reference semantics

- _Reference semantics_: Variables store the reference to an object in the heap.
  - When one variable is assigned to another, the object is not copied; both variables refer to the same object.

```java
class MyClass {int x; int y; }

MyClass m1 = new MyClass();
m1.x = 1;
m1.y = 2;
MyClass m2 = m1;
m2.y = 3;
System.out.println(m1.y); // 3
```

<img src="images/java1.png" width="500">

## Cautions

Be aware of reference semantics.

- Consider using _value types_.
  - A value type is one that “plays the role” of a primitive type even if it is a reference type
  - A value type is one where instances cannot be changed after being constructed.
  - `String` is a value type.
- `==` comparison works for:
  - primitive types
  - enums
  - some other special cases (**<ins>not</ins>** including Strings)
- Otherwise, use `.equals()`
  - use `s1.equals(s2)` to compare Strings for equality
    - This is true if the two strings are the same sequence of characters
  - `s1 == s2` is only true if s1 and s2 are the same `String object`
- Make a copy if / when you need to.
  - Use a “copy” constructor for objects.
  - Typical use-case: You are returning the value of a private, non-value type attribute that the caller cannot be allowed to modify. This is called a defensive copy!

## Garbage Collection

### Dynamic Memory (Java)

- The Stack and global variables can contain primitive types and references to objects of reference types.
- The data for all reference types are stored in the Heap.
- Objects stored in the Heap can contain references to other objects in the Heap.

### Terminology

- Allocated Objects
  - Objects allocated by the program and still in the heap
- Reachable Objects
  - Objects that are still reachable by following references from the the stack and global variables
- Live Objects
  - Objects the program might actually use in the future
- Syntactic garbage
  - Allocated objects that are not reachable
- Semantic garbage
  - Reachable objects that are not live

### Manual Memory Management

- C, C++, Ada (and others) use manual memory management
- In those languages, your program must explicitly deallocate (free, delete) memory for objects allocated on the heap.
  - Doing this correctly is hard.

#### Manual Memory Management Correctness

- Your program is correct as long as objects are deallocated:
  - After the object becomes semantic garbage - Before the object becomes syntactic garbage
- Once an object becomes syntactic garbage, you no longer have a reference to it to use to deallocate it.
- Error 1: Failing to free something before it becomes syntactic garbage.
  - Do enough of this and sooner or later you run out of memory.
  - This is known as a memory leak.
- Error 2: Freeing something that is still live.
  - Oh \*&#\*! Prepare for a strange and spectacular failure.
  - This is known as a _dangling pointer_.

### What is Garbage Collection (GC)?

- Automatic reclamation of syntactic garbage Why syntactic garbage?
  - Because a program can decide whether or not something is syntactic garbage.
  - In general, you can’t decide (It is mathematically, theoretically impossible!) whether or not something is semantic garbage.
- This requires knowing all possible future behaviors of the program. Java uses GC
  - The JVM tracks everything allocated on the heap and knows how to trace all the references.

### How to you do GC?

#### Basic Approach: Mark and Sweep

- Simple version:
  - Periodically, stop everything you are doing (_stop the
    world_).
  - Starting at the roots, recursively mark all objects that are
    reachable.
  - Anything that was not marked is garbage and is swept up and deallocated.
- Some well known users (maybe): - Java, C#, Go
  - Lisp/Scheme
  - Python to recover circular garbage
