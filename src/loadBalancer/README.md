https://lldcoding.com/design-lld-load-balancer-machine-coding
https://www.youtube.com/watch?v=YM_dEeXmnuY&t=1170s

**Problem statement**:
Come up with Low Level Design of a Load-Balancer. Load-Balancer is
a component responsible for directing a request to a particular server.
All client requests are first received by a load-balancer(which
somehow knows about all the servers) and then it is upto
load-balancer to decide which server to forward the request to.
Features : -
1. It should be possible for the load-balancer to choose one server
   out of so many for directing the request.
2. We want support for varieties of load balancing algorithms, for
   e.g. round-robin (where 1st request goes to server-0, 2nd
   request goes to server-1,......,n-th request goes to server-n-1,
   then the next request again goes to server-0 and so on…),
   least-active (where a request is always forwarded to the server
   with minimum current load i.e. handling minimum concurrent
   requests at that time), etc…
3. Our load-balancer must be fault-tolerant i.e. if a server chosen by
   it is unhealthy for some reason, then it should forward the
   request to some other healthy server, we want to support
   different ways to handle this scenario, for e.g. Random : pick a
   random healthy server and forward request to it, Linear Scan :
   Iterate through a list of all the servers and send the request to
   the first healthy server you find. Note : It should be possible to
   iterate in different manners e.g. increasing/decreasing order of
   server IDs, increasing/decreasing order of server load etc…
4. Requests that are part of the same session created by a client
   should be forwarded to the same server to maintain the session
   state.

**Tutorial's Ideal Solution**:
1. In order to support multiple load-balancing strategies, did you make your LoadBalancer component depend on an abstract type called ‘LoadbalancingStrategy’ or something? - Award yourself 2 points if you did this.

2. Have you done similar thing as above by creating some abstract type called ‘FaultToleratingStrategy’? - Award yourself 2 points if you did this.

3. To ensure that our ‘LinearScanFaultTolerantStrategy’ allows for iterating across a list of servers in different ways, did you make it depend on an abstract type called ‘Iterator’? Did you write some implementations of this iterator? - Award yourself 2 points if you did this.

4. To ensure session persistence, did you create a component that behaves like a cache and stores a key-val pair of something like
   <sessionId => serverId>? Are you implementing this cache correctly, for e.g. updating it in case of cache-miss? - Award yourself 2 points if you did this.

5. Bonus: There can be different caching strategies too, for e.g. LRU, LFU etc. Could you take care of this? - Award yourself 2 points if you did this.

**Hints**:
1. As the requirements clearly mention different forms of load balancing strategy and fault tolerance, can we apply our strategy design pattern?
2. We want to iterate through a list of servers in different manners, so how about Iterator Pattern?

**Implementation steps**:
1. Made LoadBalancer class as singleton
2. Used strategy pattern for LB algorithms to follow OCP, DIP
3. SRP:
    Server class manages all attributes of server, uses observer pattern 
    LoadBalancer class instantiates strategy for LBing

**Todo**:
1. Make health state at LoadBalancer class as well, write observer pattern from servers to loadBalancer
    - Load balancer must listen to healths of servers, then give that map of health to strategy to choose from
    - todo: keep this map thread safe
2. Make LoadBalancer class from some abstract type for loggers, etc to also be decorated on top of it.



