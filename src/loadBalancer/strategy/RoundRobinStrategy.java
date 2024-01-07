package loadBalancer.strategy;

import loadBalancer.Request;
import loadBalancer.Server;

import java.util.List;

public class RoundRobinStrategy implements ILoadBalancerStrategy{
    private int currentIndex; // todo: keep it thread safe, as it would lead to improper distribution of load
    public RoundRobinStrategy() {
        this.currentIndex = 0;
    }
    @Override
    public Server getServer(List<Server> servers, Request request) {
        int totalServers = servers.size();
        if (totalServers == 0) {
            throw new IllegalStateException("no servers available");
        }

        int newIndex = currentIndex;
        int prevIndex = (newIndex - 1 + totalServers) % totalServers;
        while (true) {
            Server server = servers.get(newIndex);
            if (!server.isHealthy()) {
                if (newIndex == (prevIndex + 1) % totalServers) {
                    throw new RuntimeException("no healthy servers available");
                }
                newIndex = (newIndex + 1) % totalServers;
            } else {
                currentIndex = (newIndex + 1) % totalServers;
                return servers.get(currentIndex);
            }
        }
    }
}
