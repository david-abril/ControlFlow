public class AsciiChars {
    public static void printNumbers() {
        //TODO: print valid numeric input (48-57)
        for (int i = 48; i <= 57; i++) {
            System.out.println("The ASCII value of " + (char) i + " = " + i);
        }
    }

    public static void printLowerCase() {
        //TODO: print valid lowercase alphabetic input (97-122)
        for (int i = 97; i <= 122; i++) {
            System.out.println("The ASCII value of " + (char) i + " = " + i);
        }
    }

    public static void printUpperCase() {
        //TODO: print valid uppercase alphabetic input (65-90?)
        for (int i = 65; i <= 90; i++) {
            System.out.println("The ASCII value of " + (char) i + " = " + i);
        }
    }
}
