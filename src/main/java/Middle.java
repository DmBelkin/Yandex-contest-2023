
import java.util.Arrays;
import java.util.Scanner;

public class Middle {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s");
        long[] result = new long[length];
        int hate = 0;
        for (int i = 0; i < input.length; i++) {
            long rate = Long.parseLong(input[i]);
            result[i] += rate * i - hate;
            hate += rate;
        }
        hate = 0;
        int index = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            long rate = Long.parseLong(input[i]);
            result[i] += Math.abs(rate  * index++ - hate);
            hate += rate;
        }
        String resultString = Arrays.toString(result);
        System.out.println(resultString.substring(1, resultString.length() - 1).replaceAll(",", ""));
    }
}


