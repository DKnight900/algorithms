package codesignal;

public class MessageFromBinaryCode {
    public static void main(String[] args) {
        System.out.println(messageFromBinaryCode("010010000110010101101100011011000110111100100001"));
    }
    private static String messageFromBinaryCode(String code) {
        String binaryString;
        StringBuilder result = new StringBuilder();
        if(code.length() % 8 == 0) {
            for (int i = 0; i < code.length(); i += 8) {
                binaryString = code.substring(i, i + 8);
                char asciiCharacter = (char) Integer.parseInt(binaryString,2);
                result.append(asciiCharacter);
            }
        }
        return result.toString();
    }
}
