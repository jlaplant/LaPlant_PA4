public class Application {
    public static void main(String[] args) {
        String inFilename = "problem2.txt";
        String outFilename = "unique_word_counts.txt";
        DuplicateCounter dc = new DuplicateCounter();
        dc.count(inFilename);
        dc.write(outFilename);
    }
}
