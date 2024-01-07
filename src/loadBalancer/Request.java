package loadBalancer;

public class Request {
    private final String url;

    public Request(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
