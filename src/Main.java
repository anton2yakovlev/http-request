public class Main {

    public static void main(String[] args) {
        System.out.println(RestAPI.putXML("test.xml","<?xml version=\"1.0\"?><Test><First>Good</First></Test>", "admin", "admin"));
        System.out.println(RestAPI.getXML("test.xml", "/Test/First"));
        System.out.println(RestAPI.putXML("test.xml","<?xml version=\"1.0\"?><Test><Second>Good</Second></Test>", "admin", "admin"));
        System.out.println(RestAPI.getXML("test.xml", "/Test/Second"));
    }
}
