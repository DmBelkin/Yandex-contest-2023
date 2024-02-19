
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FinalContest {


    public static void main(String[] args) throws IOException {
        solution(16);
        //треугольник паскаля

    }

    public static List<Integer> solution(Integer s) {
        List<Integer> list = new ArrayList<>();
        long fn = factorial(s);
        int sum = 0;
        System.out.println(fn);
        for (int i = 0;s - i > 0; i++) {
            long num = fn / (factorial(i) * factorial(s - i));
            sum += num;
            System.out.println(num);
            list.add((int)num);
        }
        list.add(1);
        return list;

    }

    public static long factorial(int n) {
        long res = 1;
        for (int i = 1; i <=n; i++) {
            res *= i;
        }
        return res;
    }
}
