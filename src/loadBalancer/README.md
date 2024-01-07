https://lldcoding.com/design-lld-load-balancer-machine-coding
https://www.youtube.com/watch?v=YM_dEeXmnuY&t=1170s

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
2. Make LoadBalancer class from some abstract type for loggers, etc to also be decorated on top of it



