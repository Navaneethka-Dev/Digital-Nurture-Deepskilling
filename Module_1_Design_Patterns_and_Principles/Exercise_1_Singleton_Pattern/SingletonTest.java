public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("--- Testing Singleton Pattern ---");
        
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        System.out.println("Logger 1 HashCode: " + logger1.hashCode());
        System.out.println("Logger 2 HashCode: " + logger2.hashCode());
        
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both references point to the same Logger instance.");
        } else {
            System.out.println("FAILURE: Different instances were created.");
        }
        
        logger1.log("This is a test message to verify the logging utility.");
    }
}
