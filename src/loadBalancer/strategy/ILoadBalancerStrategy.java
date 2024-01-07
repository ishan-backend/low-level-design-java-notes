package loadBalancer.strategy;
import loadBalancer.Request;
import loadBalancer.Server;

import java.util.List;

public interface ILoadBalancerStrategy {
    Server getServer(List<Server> servers, Request request);
}
