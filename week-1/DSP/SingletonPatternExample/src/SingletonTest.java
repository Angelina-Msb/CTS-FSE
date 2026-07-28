public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        System.out.println("\n--- Verification Result ---");
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both variables point to the exact same Logger instance.");
        } else {
            System.out.println("FAILURE: Multiple instances exist!");
        }
    }
}