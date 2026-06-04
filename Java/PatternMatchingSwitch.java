public class PatternMatchingSwitch {

    static void checkType(Object obj) {
        switch (obj) {
            case Integer i ->
                System.out.println("Integer value: " + i);

            case String s ->
                System.out.println("String value: " + s);

            case Double d ->
                System.out.println("Double value: " + d);

            case Boolean b ->
                System.out.println("Boolean value: " + b);

            case null ->
                System.out.println("Object is null");

            default ->
                System.out.println("Unknown type");
        }
    }

    public static void main(String[] args) {
        checkType(100);
        checkType("Hello");
        checkType(45.67);
        checkType(true);
        checkType(null);
    }
}