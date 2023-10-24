import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hokku {

    public static void main(String[] args) {
        try {
            File file = hokku(new File("input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static File hokku(File file) throws IOException {
        File resultFile = new File("out/output7.txt");
        PrintWriter writer = new PrintWriter(resultFile);
        String input = Files.readString(Paths.get(file.getPath()));
        String[] yandex = {"Yandex", "Cup"};
        String result = "";
        for (int i = 0; i < yandex.length; i++) {
            result = getResult(yandex[i], input);
            System.out.println(result);
            input = result;
        }
        writer.write(result);
        writer.close();
        return resultFile;
    }

    public static String getResult(String str, String input) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            String symbol = "" + str.charAt(i);
            if (input.contains(symbol)) {
                int index = input.indexOf(symbol);
                for (int j = 0; j < str.length(); j++) {
                    if (input.contains("" + str.charAt(j))) {
                        input.replace("" + str.charAt(j), "");
                    }
                }
                result += input.substring(0, index - i);
                result += str;
                result += input.substring(index + str.length() - i);
                break;
            }
        }
        return result;
    }

}
