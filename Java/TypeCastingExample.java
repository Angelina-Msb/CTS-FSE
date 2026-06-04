public class TypeCastingExample {
    public static void main(String[] args) {

        // Double to Int
        double num1 = 45.78;
        int intValue = (int) num1;

        System.out.println("Double value: " + num1);
        System.out.println("After casting to int: " + intValue);

        // Int to Double
        int num2 = 25;
        double doubleValue = (double) num2;

        System.out.println("Int value: " + num2);
        System.out.println("After casting to double: " + doubleValue);
    }
}