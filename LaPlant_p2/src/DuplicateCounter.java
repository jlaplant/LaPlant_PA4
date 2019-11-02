import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCounter {
    private Map<String, Integer> wordCounter;

    public DuplicateCounter() {
        wordCounter = new HashMap<String, Integer>();
    }

    public void count(String dataFile) {
        Scanner infile = null;
        try {
            infile = new Scanner(new File(dataFile));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        infile.useDelimiter("([0-9]|[.,!?:;'\"-]|\\s)+"); //use the delimiting characters digits, spaces or punctuation marks to extract words
        while (infile.hasNext()) {
            String word = infile.next().toLowerCase();
            Integer count = wordCounter.get(word); //get the count from map
            if (count == null)
                count = 1;
            else
                count = count + 1;
            wordCounter.put(word, count);
        }
        infile.close();
    }

    public void write(String dataFile) {
        try {
            PrintWriter outfile = new PrintWriter(new File(dataFile));
            for (String k : wordCounter.keySet()) {
                outfile.println(k + " " + wordCounter.get(k));
            }
            outfile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
