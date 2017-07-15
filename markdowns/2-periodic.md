# Periodic Timers

Vert.x also supports scheduling periodic tasks. The timer fires periodically calling the _handler_ every time. There 
will be an initial delay equal to the period.

@[Periodic timer]({"stubs": ["src/main/java/io/vertx/playground/PeriodicExample.java"], "command": "io.vertx.playground.PeriodicExampleTest#test"})

The return value of `setPeriodic` is a unique timer id (long). This can be later used if the timer needs to be cancelled.
The argument passed into the timer event handler is also the unique timer id. So the action can decide to cancel the 
periodic task.

Keep in mind that the timer will fire on a periodic basis. If your periodic treatment takes a long amount of time to proceed, your timer events could run continuously or even worse : stack up. In this case, you should consider using `setTimer` instead. Once your treatment has finished, you can set the next timer:

```java
    private static Handler<Long> action;

    public static void main(String... args) {
        Vertx vertx = Vertx.vertx();

        action = id -> {
            // Execute the task
            // ...

            // Schedule the next execution in one hour
            vertx.setTimer(TimeUnit.HOURS.toMillis(1), action);
        };

        // Schedule the first execution
        vertx.setTimer(TimeUnit.HOURS.toMillis(1), action);
    }
```

