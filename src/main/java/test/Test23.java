package test;

public class Test23 {
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
    
    @org.junit.jupiter.api.Test
    public void testHelloWorld() {
        String message = "Hello, World!";
        System.out.println(message);
        assert message.equals("Hello, World!");
    }
}
