public class Main {

    public static void main(String[] args) {
        System.out.println(RestAPI.getXML("test.xml"));
        System.out.println(RestAPI.putXML("test.xml","<?xml version=\"1.0\"?><Test>Good</Test>", "admin", "admin"));
        System.out.println(RestAPI.getXML("test.xml"));
    }
}
