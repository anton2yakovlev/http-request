public class Main {

    public static void main(String[] args) {
        System.out.println(RestAPI.getXML("test.xml", "/PurchaseOrder/Address/Name"));
        //System.out.println(RestAPI.putXML("new.xml","<?xml version=\"1.0\"?><Name>Ellen Adams</Name>\n<Street>123 Maple Street</Street>", "admin", "admin"));
        System.out.println(RestAPI.getXML("test.xml"));
    }
}
