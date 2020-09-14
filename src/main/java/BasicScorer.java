import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicScorer extends AbstractNameScorer {

    @Override
    public int scoreName(String name) {
        return name.toUpperCase().chars()
                // Consider only uppercase letters A->Z (ASCII values 65->90)
                .filter(n -> n >= 65)
                .filter(p -> p <= 90)
                .map(q -> q - 64)
                .sum();
    }

    public int scoreNamesFromFile(String pathToFile) {

        // Parse file contents to List<String>
        List<String> list = Arrays.asList(readStringFromFile(pathToFile).split("[,\r\n]"));

        // Transform to new list with non-letter characters removed and empty strings removed
        List<String> list2 = list.stream()
                // remove empty strings
                .filter(f -> f.length() > 0)
                .map(String::toUpperCase)
                .map(s -> s.replaceAll("[^A-Z ]", ""))
                .sorted()
                .collect(Collectors.toList());

        return process(list2);
    }

}
