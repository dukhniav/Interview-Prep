# Exercises

## HashMaps
#### [Map-1 > mapShare](http://codingbat.com/prob/p148813)
Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that same value. In all cases remove the key "c", leaving the rest of the map unchanged.

- mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
- mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
- mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}

<details>
<summary>Solution</summary>

```java
public Map<String, String> mapShare(Map<String, String> map) {

    if (map.containsKey("a")){
      String temp = map.get("a");
      if (map.containsKey("b")){
        map.put("b", temp);
      } else {
        map.put("b", temp);
      }
    }
    if (map.containsKey("c")){
      map.remove("c");
    }

  return map;
}
```

</details>

#### [Map-1 > mapAB](https://codingbat.com/prob/p107259)
Modify and return the given map as follows: for this problem the map may or may not contain the "a" and "b" keys. If both keys are present, append their 2 string values together and store the result under the key "ab".

- mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
- mapAB({"a": "Hi"}) → {"a": "Hi"}
- mapAB({"b": "There"}) → {"b": "There"}

<details>
<summary>Solution</summary>
    
```java
public Map<String, String> mapAB(Map<String, String> map) {
  if (map.containsKey("a") && map.containsKey("b")){
    String temp = map.get("a") + map.get("b");
    map.put("ab", temp);
  }

  return map;
}
```

</details>
