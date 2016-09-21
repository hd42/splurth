package software.schwering.javacodechallenge;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class SplurthTest {

    @Test
    public void isValid() {
        assertThat(Splurth.isValid("Spenglerium", "Ee"), is(true));
        assertThat(Splurth.isValid("Zeddemorium", "Zr"), is(true));
        assertThat(Splurth.isValid("Venkmine", "Kn"), is(true));
        assertThat(Splurth.isValid("Stantzon", "Zt"), is(false));
        assertThat(Splurth.isValid("Melintzum", "Nn"), is(false));
        assertThat(Splurth.isValid("Tullium", "Ty"), is(false));
    }

    @Test
    public void firstSymbol() {
        assertThat(Splurth.firstSymbol("Gozerium"), is("Ei"));
        assertThat(Splurth.firstSymbol("Slimyrine"), is("Ie"));
    }

    @Test
    public void distinctSymbols() {
        assertThat(Splurth.distinctSymbols("Zuulon"), is(11));
        assertThat(Splurth.distinctSymbols("aabbaba"), is(4));
    }

    @Test
    public void symbolsSortedByPreference() {
        assertThat(Splurth.symbolsSortedByPreference("Iron"), contains("Ir", "Io", "In", "Ro", "Rn", "On"));
        assertThat(Splurth.symbolsSortedByPreference("Neon"), contains("Ne", "No", "Nn", "Eo", "En", "On"));
    }
}