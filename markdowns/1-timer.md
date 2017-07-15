# One-shot Timers

The first type of timer is used to create a delayed action. An one shot timer calls a _handler_ after a certain delay, 
expressed in milliseconds.

@[One-shot timer]({"stubs": ["src/main/java/io/vertx/playground/TimerExample.java"], "command": "io.vertx.playground.TimerExampleTest#test"})

The return value is a unique timer id which can later be used to cancel the timer. The  handler is also passed the 
timer id. This id is used to cancel the task.

Passing milliseconds can be inconvenient for long duration. Fortunately, you can use `TimeUnit`:

@[Using TimeUnit]({"stubs": ["src/main/java/io/vertx/playground/TimerWithDurationExample.java"], "command": "io.vertx.playground.TimerWithDurationExampleTest#test"})

To give another example, you can compute the number of milliseconds in a hour using:

```java
TimeUnit.HOURS.toMillis(1)
```



