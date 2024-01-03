import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinalContest {


    public static void main(String[] args) throws IOException {
        solution(16);
        //треугольник паскаля

    }

    public static List<Integer> solution(Integer s) {
        List<Integer> list = new ArrayList<>();
        int fn = factorial(s);
        int sum = 0;
        System.out.println(fn);
        for (int i = 0;s - i > 0; i++) {
            int num = fn / (factorial(i) * factorial(s - i));
            sum += num;
            System.out.println(num);
            list.add(num);
        }
        list.add(1);
        return list;

    }

    public static int factorial(int n) {
        int res = 1;
        for (int i = 1; i <=n; i++) {
            res *= i;
        }
        return res;
    }
}
