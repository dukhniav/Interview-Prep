# Advanced java

- Iterator
- Comparator

## Iterator

```java
public interface Iterable<item> {
  Iterator<item> iterator();
}
```

- What is an Iterator?
  - Has methods `hasNext()` and `next()`.

```java
public interface Iterable<item> {
  boolean hasNext();
  Item next();
}
```

- Why make data structures Iterable?
  - Java supports elegant client code.
    > "foreach" statement (shorthand):

```java
for (String s : stack)
  StdOut.println(s);
```

> equivalent code (longhand):

```java
Iterator<String> i = stack.iterator();
while (i.hasNext()) {
  String s = i.next();
  StdOut.println(s);
}
```

## Comparator

### Comparator with system sort

```java
String[] a;
// ...
// Uses natural order
Arrays.sort(a);
// ...
// uses alternate order defined by Comparator<String> object
Arrays.sort(a, String.CASE_INSENSITIVE_ORDER);
// ...
Arrays.sort(a, Collator.getInstance(new Locale("es")));
// ...
Arrays.sort(a, new BritishPhoneBookOrder());
```

### Comparator with our sorting libraries

```java
public static void sort(Object[] a, Comparator comparator){
    int N = a.length;
    for(int i = 0; i < N; i ++){
        for(int j = i; j > 0 && less(comparator, a[j], a[j-1]; j--)){
            exch(a, j, j-1);
        }
    }
}

private static boolean less(Comparator c, Object v, Object w){
    return c.compare(v,w) < 0;
}

private static void exch(Object[] a, int i, int j){
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
}
```

> Insertion sort using a `Comparator`

### Implementing

- Define a (nested) class that implements the Comparator interface
- Implement the compare() method

```java
public class Student{
    // `static` --> one Comparator for the class
    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_SECTION = new BySection();
    private final String name;
    private final int section;

    private static class ByName implementa Comparator<Student>{
        public int compare(Student v, Student w){
            return v.name.compareTo(w.name);
        }
    }

    private static class BySection implements Comparator<Student>{
        public int compare(Student v, Student w){
            // this technique works here since no danger of overflow
            return v.section - w.section;
        }
    }
}
```
