# Scheduling tasks with Vert.x

When building an application with [Eclipse Vert.x](http://vertx.io), it's very common to want to perform an action 
after a delay or periodically. Because of the non-blocking aspect of Vert.x, you can't make the thread sleep to 
introduce a delay. It would block the event loop and that's forbidden. Instead use Vert.x timers.   

In this short tutorial you learn:

* How to create delayed actions using a one-shot timer,
* How to schedule the periodic execution of tasks,
* How to cancel timers.

It's going to take less than 10 minutes to complete, so don't delay it and give it a shot now!

If you are looking for a more gentle introduction to vert.x, look at this 
[other playground](https://tech.io/playgrounds/1342/building-a-http-endpoint-with-eclipse-vert-x) explaining how to 
create a HTTP endpoint with Vert.x.
