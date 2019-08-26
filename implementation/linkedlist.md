# Linked-list implementation

## Searching a Linked List

The procedure `LIST-SEARCH(L,k)` finds the first element with key _k_ in list _L_ by a simple linear search, returning a pointer to this element. If no object with key _k_ appears in the list, then the procedure returns NIL. For the linked list in above figure (**a**), the call `LIST-SEARCH(L,4)` returns a pointer to the third element, and the call `LIST-SEARCH(L,7)` returns NIL.

`LIST-SEARCH(L,k)`

1. x = _L.head_
2. **while** _x_ &#8800; NIL and _x.key_ &#8800; _k_
3. &nbsp;&nbsp;&nbsp;&nbsp;_x_ = _x.next_
4. **return** _x_

To search a list of n objects, the `LIST-SEARCH` procedure takes &Theta;(_n_) time in the **worst case**, since it may have to search the entire list.

## Inserting into a linked list

Given an element x whose _key_ attribute has already been set, the `LIST-INSERT` procedure “splices” x onto the front of the linked list, as shown above figure (**b**).

`LIST-INSERT(L,x)`

1. _x.next_ = _L.head_
2. **if** _L.head_ &#8800; NIL
3. &nbsp;&nbsp;&nbsp;&nbsp;_L.head.prev_ = _x_
4. _L.head_ = _x_
5. _x.prev_ = NIL

(Recall that our attribute notation can cascade, so that _L.head.prev_ denotes the _prev_ attribute of the object that _L.head_ points to.) The **running time** for `LIST-INSERT` on a list of _n_ elements is &Omicron;(1).

## Deleting from a linked list

The procedure `LIST-DELETE` removes an element _x_ from a linked list _L_. It must be given a pointer to _x_, and it then “splices” _x_ out of the list by updating pointers. If we wish to delete an element with a given key, we must first call `LIST-SEARCH` to retrieve a pointer to the element.

`LIST-DELETE(L,x)`

1. **if** _x.prev_ &#8800; NIL
2. &nbsp;&nbsp;&nbsp;&nbsp;_x.prev.next_ = _x.next_
3. **else** _L.head_ = _x.next_
4. **if** _x.next_ &#8800; NIL
5. &nbsp;&nbsp;&nbsp;&nbsp;_x.next.prev_ = _x.prev_

Above figure shows how an element is deleted from a linked list. `LIST-DELETE` runs in &Omicron;(1) time, but if we wish to delete an element with a given key, &Theta;(_n_) time is required in the worst case because we must first call `LIST-SEARCH` to find the element.
