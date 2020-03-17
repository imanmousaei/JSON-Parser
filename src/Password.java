import java.util.Scanner;

public class Password {

    public static String easyPassword(int len) {
        String pass = "";
        while (len-- > 0) {
            int ran = (int) (Math.random() * 26);
            pass += (char) ('a' + ran);
        }
        return pass;
    }

    public static String hardPassword(int len) {
        String specialChars = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        int sz = specialChars.length();
        String pass = easyPassword(len - 2);
        int ran = (int) (Math.random() * 9);
        pass += (char) ('0' + ran);

        ran = (int) (Math.random() * sz);
        pass = specialChars.charAt(ran) + pass;

        return pass;
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int len = cin.nextInt();

        System.out.println(easyPassword(len));
        System.out.println(hardPassword(len));

    }
}
