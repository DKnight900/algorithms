package codesignal;

public class FirstDigit {
    public static void main(String[] args) {
        System.out.println(firstDigit("var_1__Int"));

    }

    static char firstDigit(String inputString) {
        char[] charactersInString = inputString.toCharArray();

        for(char characterInString: charactersInString) {
            if (Character.isDigit(characterInString)) {
                return characterInString;
            }
        }
        return '0';
    }
}
