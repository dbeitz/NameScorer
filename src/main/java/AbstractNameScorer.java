import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public abstract class AbstractNameScorer {
    public abstract int scoreName(String name);

    int process(List<String> nameList) {
        Collections.sort(nameList);

        int total = 0;
        int count = 1;

        for (String name : nameList) {
            total += scoreName(name) * count++;
        }

        return total;
    }

    String readStringFromFile(String path) {
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
            System.out.printf("Size of string read from %s: %d%n", path, content.length());
        } catch (IOException e) {
            return "";
        }
        return content;
    }

}
