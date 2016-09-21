package software.schwering.javacodechallenge;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class TableOfElementsTest {
    @Test
    public void getElementsToSymbols() throws Exception {
        TableOfElements tableOfElements = new TableOfElements(Files.lines(Paths.get(TableOfElements.class.getResource("/KnownElements.txt").toURI())));
        assertThat(tableOfElements.getSymbol("Protactinium"), is("Pt"));
        assertThat(tableOfElements.getSymbol("Californium"), is("Cf"));
        assertThat(tableOfElements.getSymbol("Lionoium"), is("Iu"));
        assertThat("as it is not in the list of known elements, contrary to the example",tableOfElements.getSymbol("Lionium"), is(nullValue()));
    }

}