##### **Spring Cloud Sleuth**

A powerful tool for enhancing logs in any application, but especially in a system built up of multiple services.

This library makes it possible to identify logs pertaining to a specific job, thread, or request. Sleuth integrates effortlessly with logging frameworks like Logback and SLF4J to add unique identifiers that help track and diagnose issues using logs.
s
Spring Cloud Sleuth uses **Brave** as the tracing library that adds unique ids to each web request that enters our application. Furthermore, the Spring team has added support for sharing these ids across thread boundaries.
 
 1. **Traces** can be thought of like a single request or job that is triggered in an application. All the various steps in that request, even across application and thread boundaries, will have the same traceId.
 
 2. **Spans** can be thought of as sections of a job or request.  Using trace and span ids we can pinpoint exactly when and where our application is as it processes a request. Making reading our logs much easier.
 
 **Format of Logs** -
 
 **[application name, traceId, spanId, export]**
 
 1. **Application name** – This is the name we set in the properties file and can be used to aggregate logs from multiple instances of the same application.
 2. **TraceId** – This is an id that is assigned to a single request, job, or action. Something like each unique user initiated web request will have its own traceId.
 3. **SpanId** – Tracks a unit of work. Think of a request that consists of multiple steps. Each step could have its own spanId and be tracked individually. By default, any application flow will start with same TraceId and SpanId.
 4. **Export** – This property is a boolean that indicates whether or not this log was exported to an aggregator like Zipkin. Zipkin is beyond the scope of this article but plays an important role in analyzing logs created by Sleuth.
 
 
**Examples** -
 
 1. **HEALTH check endpoint** - 

    **Endpoint** - ```http://localhost:8080/ping```
 
 2. **Distributed Tracing for REST in downstream calls** -

    **Endpoint** - ```http://localhost:8081/class/student/{studentid}```
 
 Webapp LOG
 
 ```INFO [webapp,ab64d1373dc07e01,ab64d1373dc07e01,true] 30229 --- [nio-8080-exec-1] c.a.p.resource.AggregatorController      : Fetching student details for student with id : AA```
 
 Backend LOG
 
 ```INFO [backend-app,ab64d1373dc07e01,10b41726f0dab072,true] 27890 --- [nio-8081-exec-1] com.arijeet.projects.StudentController   : Student details with id : AA```

3. **Message Broker Integration (Kafka)** -

```_Coming up. Stay tunes._```

4. **gRPC Integration** -

```_Coming up. Stay tuned._```

###### All Spring Sleuth Integrations are available here.

[Spring Sleuth Integrations](https://cloud.spring.io/spring-cloud-sleuth/reference/html/)



 
 
 
**Used Libraries**
 
 **WebClient** - 
 
 An interface representing the main entry point for performing web requests.
 
 It has been created as a part of the Spring Web Reactive module and will be replacing the classic RestTemplate in these scenarios. The new client is a reactive, non-blocking solution that works over the HTTP/1.1 protocol.