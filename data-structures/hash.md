# Hash Tables
A.K.A. *hash, hash map, map, unordered map, dictionary*

### Strengths:
- **Fast lookups** - Lookups take *O(1)* time on *average*.
- **Flexible keys** - Most data types can be used for keys, as long as they're hashable.

### Weaknesses:
- **Slow worst-case lookups** - Lookups take *O(n)* time in the worst case.
- **Unordered** - Keys aren't stored in a special order. If you're looking for the smallest key, the largest key, or all the keys in a range, you'll need to look through every key to find it.
- **Single-directional lookups** - While you can look up the value for a given key in *O(1)* time, looking up the keys for a given value requires looping through the whole dataset—*O(n)* time.
- **Not cache-friendly** - Many hash table implementations use linked lists, which don't put data next to each other in memory.

| . | Average | Worst Case |
| --- | --- | --- |
| space 	| O(n) | O(n) |
| insert |	O(1) | O(n) |
| lookup |	O(1) | O(n) |
| delete |	O(1) | O(n) |

### Compared to other data structures
|  | LinkedList | Array | Dynamic Array | Balanced Tree | Random Access List | Hashed Array Tree |
|---------------------------|--------------------------------------------------------------------|-------|----------------|---------------|--------------------|-------------------|
| Indexing | Θ(n) | Θ(1) | Θ(1) | Θ(log n) | Θ(log n) | Θ(1) |
| Insert/delete @ beginning | Θ(1) | N/A | Θ(n) | Θ(log n) | Θ(1) | Θ(n) |
| Insert/delete @ end | Θ(1) when last element is known; Θ(n) when last element is unknown | N/A | Θ(1) amortized | Θ(log n) | Θ(log n) updating | Θ(1) amortized |
| Insert/delete in middle | search time + Θ(1 | N/A | Θ(n) | Θ(log n) | Θ(log n) updating | Θ(n) |
| Wasted space (average) | Θ(n) | 0 | Θ(n) | Θ(n) | Θ(n) | Θ(√n) |

### In Java
 In Java, hash tables are called hash maps.
```
HashMap<String, Integer> lightBulbToHoursOfLight = new HashMap<>();

lightBulbToHoursOfLight.put("incandescent", 1200);
lightBulbToHoursOfLight.put("compact fluorescent", 10000);
lightBulbToHoursOfLight.put("LED", 50000);
```

### When hash table operations cost *O(n)* time
#### Hash collisions
If all our keys caused hash collisions, we'd be at risk of having to walk through all of our values for a single lookup (in the example above, we'd have one big linked list). This is unlikely, but it could happen. That's the worst case.

#### Dynamic array resizing
Suppose we keep adding more items to our hash map. As the number of keys and values in our hash map exceeds the number of indices in the underlying array, hash collisions become inevitable.

To mitigate this, we could expand our underlying array whenever things start to get crowded. That requires allocating a larger array and rehashing all of our existing keys to figure out their new position—*O(n)* time.


## Basic Operations
### Search
Searches an element in a hash table.

### Insert
Inserts an element in a hash table.

### Delete
Deletes an element from a hash table.

### Methods & Descriptions
`void clear( )` - Resets and empties the hash table.

`Object clone( )` - Returns a duplicate of the invoking object.

`boolean contains(Object value)` - Returns true if some value equal to the value exists within the hash table. Returns false if the value isn't found.

`boolean containsKey(Object key)` - Returns true if some key equal to the key exists within the hash table. Returns false if the key isn't found.

`boolean containsValue(Object value)` - Returns true if some value equal to the value exists within the hash table. Returns false if the value isn't found.

`Enumeration elements( )` - Returns an enumeration of the values contained in the hash table.

`Object get(Object key)` - Returns the object that contains the value associated with the key. If the key is not in the hash table, a null object is returned.

`boolean isEmpty( )` - Returns true if the hash table is empty; returns false if it contains at least one key.

`Enumeration keys( )` - Returns an enumeration of the keys contained in the hash table.

`Object put(Object key, Object value)` - Inserts a key and a value into the hash table. Returns null if the key isn't already in the hash table; returns the previous value associated with the key if the key is already in the hash table.

`void rehash( )` - Increases the size of the hash table and rehashes all of its keys.

`Object remove(Object key)` - Removes the key and its value. Returns the value associated with the key. If the key is not in the hash table, a null object is returned.

`int size( )` - Returns the number of entries in the hash table.

`String toString( )` - Returns the string equivalent of a hash table.

#### Example
```java
import java.util.*;
public class HashTableDemo {

   public static void main(String args[]) {
      // Create a hash map
      Hashtable balance = new Hashtable();
      Enumeration names;
      String str;
      double bal;

      balance.put("Zara", new Double(3434.34));
      balance.put("Mahnaz", new Double(123.22));
      balance.put("Ayan", new Double(1378.00));
      balance.put("Daisy", new Double(99.22));
      balance.put("Qadir", new Double(-19.08));

      // Show all balances in hash table.
      names = balance.keys();

      while(names.hasMoreElements()) {
         str = (String) names.nextElement();
         System.out.println(str + ": " + balance.get(str));
      }        
      System.out.println();

      // Deposit 1,000 into Zara's account
      bal = ((Double)balance.get("Zara")).doubleValue();
      balance.put("Zara", new Double(bal + 1000));
      System.out.println("Zara's new balance: " + balance.get("Zara"));
   }
}
```
#### Output
```
Qadir: -19.08
Zara: 3434.34
Mahnaz: 123.22
Daisy: 99.22
Ayan: 1378.0

Zara's new balance: 4434.34
```
