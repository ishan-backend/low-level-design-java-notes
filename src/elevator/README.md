**Requirements**:
* Two types: Residential, Corporate
* Corporate:
  * Multiple floors
  * Different passengers
  * 10-15 elevators
  * Building split across multiple zones of elevator
* We have to make, Residential building:
  * 10-15 floors
  * 1 elevator
  * On every floor, button, and is pressable -> if elevator is passing through that floor, it needs to stop.
  * Inside elevator, more buttons - G, 1, ... -> it needs to stop at a floor, when its passing to it
  * More buttons - Open, Close gate, Fan, Alarm
  * Extending to new use cases should be cake-walk in the future
  * I dont want to allow all sort of operations under all conditions. e.g. elevator is moving, gate should not open.
    e.g. gate is open at a floor, first gate should be closed then elevator should move to floor.
  * Weight limit -> on breach -> Alarm

**Preface to build APIs**:
1. When elevator is standing on a floor, it should hit some API at regular intervals, which should tell it direction in which it should start moving
   1. No request to serve, -> dont move
   2. Up
   3. Down
2. When elevator is moving, it will call another API with floor number to check if it should stop at a floor.
   1. If it needs to stop -> call stop API
      1. Open Gate API
      2. Close Gate API
   2. Else, pass the floor and move
3. Elevator at 4th floor, call from 10, 3, 11, 1 consecutively. Which direction should it move?
   1. When elevator is moving up -> it should move up until it has served all up requests, post that it should start moving down
   2. vice-versa

