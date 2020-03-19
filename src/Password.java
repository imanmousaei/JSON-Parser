import java.util.Scanner;

public class Password {

    public static String onlyAlphabet(int length) {
        String pass = "";
        for (int i = 0; i < length; i++) {
            int ran = (int) (Math.random() * 26);
            pass += (char) ('a' + ran);
        }
        return pass;
    }

    public static String onlyNumber(int length) {
        String pass = "";
        for (int i = 0; i < length; i++) {
            int ran = (int) (Math.random() * 9);
            pass += (char) ('0' + ran);
        }
        return pass;
    }

    public static String onlySpecialChars(int length) {
        String specialChars = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        int sz = specialChars.length();
        String pass = "";
        for (int i = 0; i < length; i++) {
            int ran = (int) (Math.random() * sz);
            pass += specialChars.charAt(ran);
        }
        return pass;
    }


    public static String generatePassword(int length, boolean useNumber, boolean useAlphabet) {
        String password = "";
        int usedLength = 0;
        if (useNumber) {
            password += onlyNumber(1);
            usedLength++;
        }
        if (useAlphabet) {
            password += onlyAlphabet(1);
            usedLength++;
        }


        if (useAlphabet) {
            int randomLength = (int) (Math.random() * (length - usedLength));
            usedLength += randomLength;
            password += onlyAlphabet(randomLength);
        }
        if (useNumber) {
            int randomLength = (int) (Math.random() * (length - usedLength));
            usedLength += randomLength;
            password += onlyNumber(randomLength);
        }

        password += onlySpecialChars(length - usedLength);

        return password;
    }

    public static void main(String[] args) {
        System.out.println(generatePassword(12, false, false));
    }
}
