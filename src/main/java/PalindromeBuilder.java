
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PalindromeBuilder {

    public static void main(String[] args) throws IOException {
        File file = new File("input/input40.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        String input = list.get(1).replaceAll("\\s", "");
        if (input.length() == 1 || input.isBlank()) {
            System.out.println("0");
            return;
        }
        int[] data = isPalindrome(input);
        int position = data[0];
        int len = data[1];
        if (len == input.length()) {
            System.out.println("0");
            return;
        }
        int count = 0;
        System.out.println(position);
        System.out.println(len);
        if (position > 0 && len > 0) {
           String s = "";
           String piece = input.substring(0, position - len);
           for (int i = piece.length() - 1; i >= 0; i--) {
               s += piece.charAt(i) + " ";
               count++;
           }
            System.out.println(count + "\n" + s.trim());
           return;
        }
        String result = "";
        if (input.charAt(input.length() - 2) != input.charAt(input.length() - 1)) {
            for (int i = input.length() - 2; i >= 0; i--) {
                result += input.charAt(i) + " ";
                count++;
            }
        } else {
            for (int i = input.length() - 3; i >= 0; i--) {
                result += input.charAt(i) + " ";
                count++;
            }
        }
        System.out.println(count + "\n" + result.trim());
    }

    public static int[] isPalindrome(String input) {
        int[] result =  new int[2];
        int position = 0;
        int len = 0;
        for (int i = input.length() - 2; i >= 1; i--) {
            int c = i;
            int length = 0;
            int r = i - 1;
            int type = 0;
            for (int j = i; j < input.length() && c >= 0; j++) {
                if (input.charAt(c) == input.charAt(j)) {
                    length++;
                    c--;
                } else if (c > 0 && input.charAt(i) == input.charAt(r) &&
                        input.charAt(--c) == input.charAt(j)) {
                    length++;
                    type = 2;
                } else {
                    break;
                }
                if (j == input.length() - 1 && length > 2) {
                    System.out.println(input.substring(c + 1));
                    System.out.println(length);
                    len = length - 1;
                    if (type == 2) {
                        len +=1;
                    }
                    position = i;
                }
            }
        }
        result[0] = position;
        result[1] = len;
        return result;
    }

}
