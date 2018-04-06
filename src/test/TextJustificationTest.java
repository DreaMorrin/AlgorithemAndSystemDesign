package test;

import main.LeetCode.TextJustification;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextJustificationTest {

    @Test
    public void shouldReturnEmptyWithEmptyInput() {
        String[] strings1 = null;
        String[] strings2 = new String[0];
        TextJustification tj = new TextJustification();
        assertEquals(tj.fullJustify(strings1, 6), new ArrayList<String>(), "List should be empty.");
        assertEquals(tj.fullJustify(strings2, 6), new ArrayList<String>(), "List should be empty.");
    }

    @Test
    public void generalTestWithGeneralInput() {
        String[] strings1 = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("This    is    an");
        expectedResult.add("example  of text");
        expectedResult.add("justification.  ");
        TextJustification tj = new TextJustification();
        assertEquals(tj.fullJustify(strings1, 16), expectedResult);
    }
}
