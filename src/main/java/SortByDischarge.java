import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SortByDischarge {

    private  int sortIndex;

    private  int[] frequency;

    public  File radixSort(File file) throws IOException {
        File resultFile = new File("out/outputPart.txt");
        PrintWriter writer = new PrintWriter(resultFile);
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        int size = Integer.parseInt(list.get(0));
        StringBuilder builder = new StringBuilder();
        String initial = "";
        Bucket[] buckets = new Bucket[10];
        sortIndex = list.get(1).length() - 1;
        Item[] stack = new Item[size];
        for (int i = 0; i <= 9; i++) {
            buckets[i] = new Bucket(0, i);
        }
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            int[] array = new int[list.get(i).length()];
            String number = list.get(i);
            String[] arr = number.split("");
            initial = initial.concat(number).concat(",\s");
            for (int j = 0; j < arr.length; j++) {
                array[j] = Integer.parseInt(arr[j]);
            }
            stack[index++] = new Item(array, sortIndex, number);
        }
        builder.append("Initial array:" + "\n");
        builder.append(initial.substring(0, initial.length() - 2) + "\n");
        builder.append("**********" + "\n");
        for (int i = 0; i < list.get(1).length(); i++) {
            builder.append("Phase " + (i + 1) + "\n");
            long maximum = max(stack);
            int placeValue = 1;
            long numberLength = Long.toString(maximum).split("").length;
            while (numberLength-- > 0) {
                sortByDischarge(stack, placeValue);
                placeValue *= 10;
            }
            prettyPrint(buckets, stack, builder, i);
            --sortIndex;
            if (sortIndex < 0) {
                break;
            }
            for (Item item : stack) {
                item.switchValue(sortIndex);
            }
        }
        builder.append("Sorted array:" + "\n");
        String sorted = "";
        for (Item item : stack) {
            sorted += item.num + ",\s";
        }
        builder.append(sorted.substring(0, sorted.length() - 2).trim());
        writer.write(builder.toString());
        writer.close();
        return resultFile;
    }

    public  void prettyPrint(Bucket[] buckets, Item[] items, StringBuilder builder, int phase) {
        for (int k = 0; k < buckets.length; k++) {
            Bucket bucket = buckets[k];
            for (int j = 0; j < items.length; j++) {
                Item item = items[j];
                int symbol = Integer.parseInt(item.num.charAt(item.num.length() - phase - 1) + "");
                if (symbol == bucket.number) {
                    bucket.setValues(item.num);
                }
            }
            if (bucket.values.equals("")) {
                bucket.values = "empty,\s";
            }
            builder.append(bucket.toString().substring(0, bucket.toString().length() - 2) + "\n");
            bucket.values = "";
        }
        builder.append("**********" + "\n");
    }

    public long max(Item[] items) {
        long max = 0;
        for (int i = 0; i < items.length - 1; i++) {
            max = Long.max(max, items[i].value);
        }
        return max;
    }

    public  void sortByDischarge(Item[] stack, int max) {

        int range = 10;

        frequency = new int[range];
        for (int i = 0; i < stack.length; i++) {
            int digit = (int) (stack[i].value / max) % range;
            frequency[digit]++;
        }

        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        Item[] sortedValues = new Item[stack.length];
        for (int i = stack.length - 1; i >= 0; i--) {
            int digit = (int) (stack[i].value / max) % range;
            sortedValues[frequency[digit] - 1] = stack[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, stack, 0, stack.length);
    }
}


class Item {

    int[] array;
    int sortIndex;
    String val = "";
    long value;
    String num = "";

    public Item(int[] array, int sortIndex, String num) {
        this.array = array;
        this.sortIndex = sortIndex;
        this.num = num;
        switchValue(sortIndex);
    }

    public void switchValue(int sortIndex) {
        val = Integer.toString(array[sortIndex]);
        value = Long.parseLong(val);
    }
}

class Bucket {
    int sortIndex;
    String values = "";
    int number;

    public Bucket(int sortIndex, int number) {
        this.sortIndex = sortIndex;
        this.number = number;
    }

    public void setValues(String num) {
        values = values + num + ",\s";
    }

    @Override
    public String toString() {
        return "Bucket" + "\s" + number + ":" +
                "\s" + values;
    }
}
