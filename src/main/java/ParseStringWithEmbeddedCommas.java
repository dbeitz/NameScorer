import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

//  The algorithm below can process a list of names enclosed in double quotes with embedded commas.
//  This can be used if the list of names can have first name and last name, for example, like:
//  "Snow, Jon" (last, first).

public class ParseStringWithEmbeddedCommas extends AbstractNameScorer {

    @Override
    public int scoreName(String name) {
        return 0;
    }

    public int readFile(String pathToFile) {
        String allNames = readStringFromFile(pathToFile);

        // Parse file contents to List<String> using regular expression
        List<String> list = Arrays.asList(allNames.split("(,(?=([^\"]*\"[^\"]*\")*[^\"]*$))|[\r\n]"));

        out.println(list);

        // Transform to new list with non-letter characters removed and empty strings removed
        List<String> list2 = list.stream()
                // remove empty strings
                .filter(f -> f.length() > 0)
                .map(String::toUpperCase)
                .map(p -> {
                    if (p.contains(",")) {
                        // Assume last name, first name
                        String[] s1 = p.split(",");
                        return s1[0].trim() + " " + s1[1].trim();
                    } else if (p.contains(" ")) {
                        // Assume first name then last name separated by space(s)
                        String[] s2 = p.split("[ ]+");
                        // Swap order: return last name then first name
                        return s2[1] + " " + s2[0];
                    } else {
                        return p;
                    }
                })
                .map(s -> s.replaceAll("[^A-Z ]", ""))
                .sorted()
                .collect(Collectors.toList());

        out.printf("List Sizes (list, list2): %d, %d%n", list.size(), list2.size());
        out.println(list2);

        return 0;
    }

    public static void main(String[] args) {
        String filename = "C:\\Misc\\OCC_Coding_Test_Sep2020\\FirstAndLastNamesList.txt";
        ParseStringWithEmbeddedCommas pswec = new ParseStringWithEmbeddedCommas();
        out.println("SCORE: " + pswec.readFile(filename));
    }

}
