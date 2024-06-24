package validate;

public class InputValidator{

    public static boolean validateUsername(String username) {
        return !(username.startsWith(",") || username.endsWith(","));
    }

    public static boolean validateMoreCard(String s) {
        return s.equals("y") || s.equals("n");
    }
}