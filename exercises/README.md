# Exercises

## HashMaps
### Map-1
Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that same value. In all cases remove the key "c", leaving the rest of the map unchanged.

mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}

<details><summary>Solution</summary>
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
