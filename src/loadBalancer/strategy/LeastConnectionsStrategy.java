package loadBalancer.strategy;

import loadBalancer.Request;
import loadBalancer.Server;

import java.util.List;

public class LeastConnectionsStrategy implements ILoadBalancerStrategy{
    private int getConnections(Server server) {
        return server.getLiveConnectionsCount();
    }
    @Override
    public Server getServer(List<Server> servers, Request request) {
        int minConnections = Integer.MAX_VALUE;
        Server selectedServer = null;
        for (Server server : servers) {
            if (server.isHealthy()) {
                int connections = getConnections(server); // Get live connections for the current server
                if (connections < minConnections) {
                    minConnections = connections;
                    selectedServer = server;
                }
            }
        }
        return selectedServer;
    }
}
