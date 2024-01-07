package loadBalancer;

public class Server {
    private final String serverId;
    private boolean isHealthy;
    private int liveConnectionsCount; // todo: keep it thread safe

    public Server(String serverId) {
        this.serverId = serverId;
        this.isHealthy = true;
        this.liveConnectionsCount = 0;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        if(!healthy) {
            liveConnectionsCount = 0;
        }
        isHealthy = healthy;
    }

    public int getLiveConnectionsCount() {
        return liveConnectionsCount;
    }

    public String getServerId() {
        return serverId;
    }
}
