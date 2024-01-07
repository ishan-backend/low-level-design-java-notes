package loadBalancer;

import loadBalancer.strategy.ILoadBalancerStrategy;

import java.util.ArrayList;
import java.util.List;

// LoadBalancer class using Singleton pattern
public class LoadBalancer {
    private static LoadBalancer INSTANCE;
    private List<Server> servers;
    private ILoadBalancerStrategy loadBalancerStrategy;

    private LoadBalancer() {
        this.servers = new ArrayList<>();
    }

    public static LoadBalancer getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new LoadBalancer();
        }
        return INSTANCE;
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }

    public void setLoadBalancerStrategy(ILoadBalancerStrategy loadBalancerStrategy) {
        this.loadBalancerStrategy = loadBalancerStrategy;
    }

    // getting servers will be based on load-balancing strategy
    public Server getServer(Request request) {
        return this.loadBalancerStrategy.getServer(this.servers, request);
    }
}
