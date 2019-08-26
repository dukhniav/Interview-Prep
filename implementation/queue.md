# Queue implemention

## Pseudocode

`ENQUEUE(Q,x)`

1. _Q_[*Q.tail*] = x
2. **if** _Q.tail_ == _Q.length_
3. &nbsp;&nbsp;&nbsp;&nbsp;_Q.tail_ = 1
4. **else** _Q.tail_ = _Q.tail_ + 1

`DEQUEUE(Q)`

1. x = _Q_[*Q.head*]
2. **if** _Q.head_ == _Q.length_
3. &nbsp;&nbsp;&nbsp;&nbsp;_Q.head_ = 1
4. **else** _Q.head_ = _Q.head_ + 1
5. **return** x
