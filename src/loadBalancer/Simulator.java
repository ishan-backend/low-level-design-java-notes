package loadBalancer;

import loadBalancer.strategy.ILoadBalancerStrategy;
import loadBalancer.strategy.LoadBalancerFactory;

public class Simulator {
    public static void main(String[] args) {
        Server server1 = new Server("server1");
        Server server2 = new Server("server2");
        Server server3 = new Server("server3");

        LoadBalancer loadBalancer = LoadBalancer.getInstance();
        loadBalancer.addServer(server1);
        loadBalancer.addServer(server2);
        loadBalancer.addServer(server3);

        ILoadBalancerStrategy loadBalancerStrategy = LoadBalancerFactory.getRoundRobinLB();
        loadBalancer.setLoadBalancerStrategy(loadBalancerStrategy);

        // Requests
        Request request1 = new Request("/v1");
        Request request2 = new Request("/v2");
        Request request3 = new Request("/v3");

        // search for server to which to send request to
        Server selectedServer1 = loadBalancer.getServer(request1);
        System.out.println("selected server for request1: " + selectedServer1.getServerId());
        Server selectedServer2 = loadBalancer.getServer(request2);
        System.out.println("selected server for request2: " + selectedServer2.getServerId());
        Server selectedServer3 = loadBalancer.getServer(request3);
        System.out.println("selected server for request3: " + selectedServer3.getServerId());
    }
}
