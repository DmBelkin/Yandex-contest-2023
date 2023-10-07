import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intimacy {


    public File prefixes(File file) throws IOException {
        long start = System.currentTimeMillis();
        File resultFile = new File("out/output3.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        StringBuilder builder = new StringBuilder();
        List<Node> nodes = new ArrayList<>();
        int prefixCount = 0;
        for (int i = 1; i <= list.size() - 1; i++) {
            if (i % 2 == 0) {
                String[] array = list.get(i).split("\\s");
                List<String> values = new ArrayList<>(Arrays.stream(array).toList());
                Node node = new Node();
                node.val = Integer.parseInt(values.get(0));
                node.list = new ArrayList<>(values);
                node.index = i;
                nodes.add(node);
            }
        }
        for (int j = 0; j <= nodes.size() - 1; j++) {
            Node node = nodes.get(j);
            if (j > 0 && !node.hasDuplicates) {
                nodes.remove(j);
                continue;
            }
            for (int k = 0; k <= nodes.size() - 1; k++) {
                Node nextNode = nodes.get(k);
                if (node.index == nextNode.index) {
                    continue;
                }
                node.hasDuplicates = false;
                nextNode.hasDuplicates = false;
                if (node.val == nextNode.val) {
                    node.hasDuplicates = true;
                    nextNode.hasDuplicates = true;
                    prefixCount++;
                    if (node.switcher < node.list.size()) {
                        node.val = Integer.parseInt(node.list.get(node.switcher++));
                    } else {
                        nodes.remove(node);
                    }
                    if (nextNode.switcher < nextNode.list.size()) {
                        nextNode.val = Integer.parseInt(nextNode.list.get(nextNode.switcher++));
                    } else {
                        nodes.remove(nextNode);
                    }
                }
            }
        }
        builder.append(prefixCount);
        PrintWriter writer = new PrintWriter(resultFile);
        writer.write(builder.toString());
        writer.flush();
        writer.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start + " time");
        return resultFile;
    }
}
