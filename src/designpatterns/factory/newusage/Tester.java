package designpatterns.factory.newusage;

public class Tester {

    public static void main(String[] args) {
        Chess chess = new Chess(new Board());
    }
}
