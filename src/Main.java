import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int res = 0;
        int numberStart = -1;
        int numberEnd = -1;
        for (int i = 0; i<str.length(); i++) {
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                if (numberStart == -1) {
                    numberStart = i;
                }
                numberEnd = i;
                int num = str.charAt(i) - 48;
                res = res * 10 + num;
            } else if (numberStart != -1) {
                break;
            }
        }
        int len = String.valueOf(res).length();
        String newString;
        if (numberStart != -1) {
            for (int i = 0; i < str.length() - len + 1; i++) {
                newString += i;
                if (str.charAt(i) == numberStart) {
                    newString += res;
                    i = len;
                }
            }
        }
    }
}