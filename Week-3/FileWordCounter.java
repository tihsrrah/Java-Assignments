import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileWordCounter {

    public static void main(String[] args) {

        HashMap<String, Integer> wordCount = new HashMap<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("input.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] words = line.toLowerCase().split("\\s+");

                for (String word : words) {

                    if (wordCount.containsKey(word))
                        wordCount.put(word, wordCount.get(word) + 1);
                    else
                        wordCount.put(word, 1);
                }
            }

            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                bw.write(entry.getKey() + " : " + entry.getValue());
                bw.newLine();
            }

            bw.close();

            System.out.println("Word frequency written to output.txt");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
