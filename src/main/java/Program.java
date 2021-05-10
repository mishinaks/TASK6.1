import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Program {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter file path:");
        String filePath = in.nextLine();
        Path testFilePath = Paths.get(filePath);
        if(!(testFilePath.isAbsolute())) {
            testFilePath = testFilePath.toAbsolutePath();
        }
        List<String> file = Files.readAllLines(testFilePath);
        String words = String.join(" ", file);

        int sizeStr = words.length();
        for (int a = 0; a < sizeStr; a++) {
            char sim = words.charAt(a);
            if (!(sim >= '\u0041' && sim <= '\u005A' || sim >= '\u0061' && sim <= '\u007A' || sim >= '\u0410' && sim <= '\u042F' || sim >= '\u0430' && sim <= '\u044F')) {
                words = words.replace(sim, ' ');
            }
        }
        while (words.contains("  ")){
            words = words.replaceAll("  ", " ");
        }
        ArrayList<String> wordsOne = new ArrayList<> (Arrays.asList(words.split(" ")));
        Collections.sort(wordsOne);
        System.out.println("Words in ascending order: ");
        for(String element : wordsOne) {
            System.out.println(element);
        }
        System.out.println(" ");
        Set<String> setWorlds = new HashSet<String>(wordsOne);
        System.out.println("Statistics: ");
        int maxRepeat = 0;
        for (String elementSet : setWorlds) {
            System.out.println("Word \"" + elementSet +  "\" - " + Collections.frequency(wordsOne, elementSet));
            maxRepeat = Math.max(Collections.frequency(wordsOne, elementSet), maxRepeat);
        }
        System.out.println(" ");
        System.out.println("Maximum number of repetitions: ");
        for (String elementSet : setWorlds) {
            if(Collections.frequency(wordsOne, elementSet) == maxRepeat) {
                System.out.println("Word \"" + elementSet +  "\" - " + Collections.frequency(wordsOne, elementSet));
            }
        }
    }
}
