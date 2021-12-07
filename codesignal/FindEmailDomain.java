package codesignal;

public class FindEmailDomain {
    public static void main(String[] args) {
        System.out.println(findEmailDomain("\"much.more unusual\"@yahoo.com"));
        System.out.println(findEmailDomain("\"very.unusual.@.unusual.com\"@usual.com"));

    }

    static String findEmailDomain(String address) {
        return address.substring(address.lastIndexOf("@") + 1);
    }
}
