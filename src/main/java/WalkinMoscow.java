
import java.util.Scanner;

public class WalkinMoscow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculateDist(scanner.nextLine());
    }
//оформить с тeстом

    public static void  calculateDist(String input) {
        String[] coordinates = input.split("\\s");
        double radius1 = Math.sqrt(Math.pow(Double.parseDouble(coordinates[0]), 2) +
                Math.pow(Double.parseDouble(coordinates[1]), 2));
        double radius2 = Math.sqrt(Math.pow(Double.parseDouble(coordinates[2]), 2) +
                Math.pow(Double.parseDouble(coordinates[3]), 2));
        double firstWay = radius1 + radius2;
        double deltaRadius = Math.abs(radius1 - radius2);
        double minRadius = Double.min(radius1, radius2);
        double angle1 = Math.atan2(Double.parseDouble(coordinates[1]), Double.parseDouble(coordinates[0]));
        double angle2 = Math.atan2(Double.parseDouble(coordinates[3]), Double.parseDouble(coordinates[2]));
        double absolutAngle = Math.abs(angle1 - angle2);
        double splineWay = (Math.PI * minRadius / 180) * Math.toDegrees(absolutAngle) + deltaRadius;
        if (firstWay >= splineWay) {
            System.out.println(splineWay);
        } else {
            System.out.println(firstWay);
        }
    }

}