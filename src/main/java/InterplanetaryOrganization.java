import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InterplanetaryOrganization {

    public File nodesCompany(File file) throws IOException {
        long start = System.currentTimeMillis();
        File resultFile = new File("out/output1.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        List<EmployeeNode> nodes = new ArrayList<>();
        List<EmployeeNode> chiefs = new ArrayList<>();
        EmployeeNode company = new EmployeeNode("AB", 0);
        company.post = "chief";
        nodes.add(company);
        chiefs.add(company);
        String[] languageData = list.get(1).split("\\s");
        String[] numbersData = list.get(2).substring(2, list.get(2).length() - 2).split("\\s");
        int index = 1;
        int languageIndex = 0;
        for (int i = 0; i <= numbersData.length - 1 && languageIndex < languageData.length; i++) {
            EmployeeNode node = new EmployeeNode();
            node.number = Integer.parseInt(numbersData[i]);
            node.language = languageData[languageIndex];
            if (numbersData[i].equals(numbersData[index])) {
                node.post = "employee";
                i++;
                index++;
            } else {
                node.post = "chief";
                chiefs.add(node);
            }
            nodes.add(node);
            index++;
            languageIndex++;
        }
        StringBuilder builder = new StringBuilder();
        for (int j = nodes.size() - 1; j >= 0; j--) {
            int count = 0;
            EmployeeNode employee = nodes.get(j);
            for (int k = chiefs.size() - 1; k >= 0; k--) {
                EmployeeNode anotherEmployee = chiefs.get(k);
                if (employee.number == anotherEmployee.number) {
                    chiefs.remove(anotherEmployee);
                    continue;
                }
                if (!anotherEmployee.language.contains(employee.language)) {
                    count++;
                } else {
                    builder.append(count + "\s");
                    break;
                }
            }
        }
        builder.reverse();
        PrintWriter writer = new PrintWriter(resultFile);
        writer.write(builder.toString().trim());
        writer.flush();
        writer.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start + " time");
        return resultFile;
    }

}
