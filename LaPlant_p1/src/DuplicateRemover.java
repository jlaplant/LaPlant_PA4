import java.util.Scanner;
import java.util.Set;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

public class DuplicateRemover {
    private Set<String> uniqueWords;

    public void remove(String dataFile) throws FileNotFoundException{
        String word;
        uniqueWords = new HashSet<String>();
        Scanner sc = new Scanner(new File(dataFile));
        while (sc.hasNext()) {
            word = sc.next();
            uniqueWords.add(word);
        }
        sc.close();


    }


    public void Write(String outputFile) throws IOException {
        File file;
        FileWriter writer = null;

        file = new File(outputFile);

        if (file.exists()) {
            writer = new FileWriter(file, true);
            Iterator itr = uniqueWords.iterator();

            while (itr.hasNext()) {
                String str = (String) itr.next();
                writer.write(str + "\n");
            }
            writer.close();
            System.out.println("Data Written to File");

        } else {

            file.createNewFile();
            writer = new FileWriter(file);
            Iterator itr = uniqueWords.iterator();

            while (itr.hasNext()) {
                String str = (String) itr.next();
                writer.write(str + "\n");
            }
            writer.close();
            System.out.println("Data Written to File");
        }
    }
}
