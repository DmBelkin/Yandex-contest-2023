
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dinosaurs {

    private static int[][] indexes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int factorial = 1;
        String str = "";
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            str += i;
        }
        StringBuilder builder = new StringBuilder(str + "\n");
        String[] data = str.split("");
        int size = data.length;
        int[] array = new int[size];
        while (size > 0) {
            array[array.length - size] = Integer.parseInt(data[data.length - size--]);
        }

//        indexes = new int[n][n];
//        System.out.println(dinosaurs(n));
    }


    public static String swap(String[] input, int index) {
        String result = "";
        for (int i = index; i < input.length; i++) {
            //result +=
        }
        return "";
    }

    public static int dinosaurs(int n) {
        int[][] ary = new int[n][n];
        List<int[]> combination = new ArrayList<>();
        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary[i].length; j++) {

            }
        }
        return 0;
    }

    public static boolean validate(int x, int y, int[][] field) {
        int vert = 0;
        int diag1 = 0;
        int diag2 = field.length;
        for (int i = 0; i < field.length; i++) {

        }
        return true;
    }
}
