import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hokku {
    
    public File hokku(File file) throws IOException {
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
        int cupIndex = result.indexOf('C');
        int yandexIndex = result.indexOf('Y');
        if (cupIndex < yandexIndex) {
            result = result.substring(0, cupIndex) +
                    result.substring(cupIndex + 3) + "Cup";
        }
        writer.write(result);
        writer.close();
        return resultFile;
    }

    public String getResult(String str, String input) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            String symbol = "" + str.charAt(i);
            if (input.contains(symbol)) {
                int index = input.indexOf(symbol);
                result += input.substring(0, index - i);
                result += str;
                result += input.substring(index + str.length() - i);
                break;
            }
        }
        if (result.equals("") && input.contains("Yandex")) {
            return input.substring(0, input.length() - 3) + "Cup";
        } else if (result.equals("")) {
            return "Yandex" + input.substring(6, input.length() - 2);
        }
        return result;
    }

}
