import static java.lang.System.*;

public class NameScorerApplication {

    public static void main(String[] args) {

        BasicScorer scorer = new BasicScorer();

        for (String arg : args) {
            if (arg.length() > 0) {
                // Assume argument is a filename
                out.println("SCORE: " + scorer.scoreNamesFromFile(arg));
            }
        }
    }
}
