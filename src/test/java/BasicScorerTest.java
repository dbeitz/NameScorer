import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicScorerTest {

    BasicScorer basicScorer;

    @BeforeEach
    void setUp() {
        basicScorer = new BasicScorer();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void scoreNameDan() {
        Assert.assertEquals(19, basicScorer.scoreName("DAN"));
    }

    @Test
    void scoreNameLinda() {
        Assert.assertEquals(40, basicScorer.scoreName("LINDA"));
    }

    @Test
    void processNamesFromSampleFile() {
        int totalScore = basicScorer.scoreNamesFromFile("C:\\Misc\\OCC_Coding_Test_Sep2020\\SampleNamesList.txt");
        Assert.assertEquals(3194, totalScore);
    }

    @Test
    void processNamesFromFileOne() {
        int totalScore = basicScorer.scoreNamesFromFile("C:\\Misc\\OCC_Coding_Test_Sep2020\\OCC_Take_Home_Coding_names.txt");
        Assert.assertEquals(871198282, totalScore);
    }

    @Test
    void processNamesFromFileTwo() {
        int totalScore = basicScorer.scoreNamesFromFile("C:\\Misc\\OCC_Coding_Test_Sep2020\\MyNamesList.txt");
        Assert.assertEquals(416, totalScore);
    }

    @Test
    void processNamesFromFileThree() {
        int totalScore = basicScorer.scoreNamesFromFile("C:\\Misc\\OCC_Coding_Test_Sep2020\\AnotherNamesList.txt");
        Assert.assertEquals(2414, totalScore);
    }

}