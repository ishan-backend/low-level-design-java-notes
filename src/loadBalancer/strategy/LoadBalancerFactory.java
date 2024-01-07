package loadBalancer.strategy;

import parkingLot.data.EntryPoint;

public class LoadBalancerFactory {
    private LoadBalancerFactory(){}

    public static ILoadBalancerStrategy getRoundRobinLB() {
        return new RoundRobinStrategy();
    }

    public static ILoadBalancerStrategy getLeastConnectionsLB() {
        return new LeastConnectionsStrategy();
    }
}
