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

## Stacks
#### [Arithmetic Expression Evaluation](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Stacks%20and%20Queues/Stacks%20and%20Queues.html)
##### Converting from Infix to Postfix
An important application of stacks is in parsing. For example, a compiler must parse arithmetic expressions written using infix notation:

`1 + ((2 + 3) * 4 + 5) * 6`

We break the problem of parsing infix expressions into two stages. First, we convert from infix to a different representation called postfix. Then we parse the postfix expression, which is a somewhat easier problem than directly parsing infix.

<details>
<summary>Converting from Infix to Postfix</summary>

Typically, we deal with expressions in infix notation:

`2 + 5`

where the operators (e.g. +, \*) are written between the operands (e.q, 2 and 5). Writing the operators after the operands gives a postfix expression 2 and 5 are called operands, and the '+' is operator. The above arithmetic expression is called infix, since the operator is in between operands. The expression:

`2 5 +`

Writing the operators before the operands gives a prefix expression:

`+ 2 5`

Suppose you want to compute the cost of your shopping trip. To do so, you add a list of numbers and multiply them by the local sales tax (7.25%):

`70 + 150 * 1.0725`

Depending on the calculator, the answer would be either 235.95 or 230.875. To avoid this confusion we shall use a postfix notation:

`70  150 + 1.0725 *`

Postfix has the nice property that parentheses are unnecessary.

Now, we describe how to convert from infix to postfix.

1. Read in the tokens one at a time
2. If a token is an integer, write it into the output
3. If a token is an operator, push it to the stack, if the stack is empty. If the stack is not empty, you pop entries with higher or equal priority and only then you push that token to the stack.
4. If a token is a left parentheses '(', push it to the stack
5. If a token is a right parentheses ')', you pop entries until you meet '('.
6. When you finish reading the string, you pop up all tokens which are left there.
7. Arithmetic precedence is in increasing order: '+', '-', '\*', '/';

Example. Suppose we have an infix expression:`2+(4+3*2+1)/3`. We read the string by characters.

```
'2' - send to the output.
'+' - push on the stack.
'(' - push on the stack.
'4' - send to the output.
'+' - push on the stack.
'3' - send to the output.
'*' - push on the stack.
'2' - send to the output.
```

</details>

<details>
<summary>Evaluating a Postfix Expression</summary>

We describe how to parse and evaluate a postfix expression.

1. We read the tokens in one at a time.
2. If it is an integer, push it on the stack
3. If it is a binary operator, pop the top two elements from the stack, apply the operator, and push the result back on the stack.

Consider the following postfix expression:

`5 9 3 + 4 2 * * 7 + *`

Here is a chain of operations:

```
Stack Operations              Output
--------------------------------------
push(5);                        5
push(9);                        5 9
push(3);                        5 9 3
push(pop() + pop())             5 12
push(4);                        5 12 4
push(2);                        5 12 4 2
push(pop() * pop())             5 12 8
push(pop() * pop())             5 96
push(7)                         5 96 7
push(pop() + pop())             5 103
push(pop() * pop())             515
```

>Note, that division is not a commutative operation, so 2/3 is not the same as 3/2.

</details>
