package software.schwering.javacodechallenge;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


public class PreferenceComparatorTest {

    @Test
    public void compare() {
        assertThat(new PreferenceComparator("Chlorine").compare("Ch", "Ch"), is(0));
        assertThat(new PreferenceComparator("Chlorine").compare("Ch", "Cr"), is(lessThan(0)));
        assertThat(new PreferenceComparator("Chlorine").compare("Cr", "Ch"), is(greaterThan(0)));
        assertThat(new PreferenceComparator("Chlorine").compare("Ce", "Hl"), is(lessThan(0)));
        assertThat(new PreferenceComparator("Neon").compare("Eo", "En"), is(lessThan(0)));
        assertThat(new PreferenceComparator("Foo").compare(null, "Ba"), is(lessThan(0)));
        assertThat(new PreferenceComparator("Foo").compare(null, null), is(0));
        assertThat(new PreferenceComparator("Neon").compare("On", "AA"), is(lessThan(0)));
        assertThat(new PreferenceComparator("Chlorine").compare("Hc", "Ch"), is(greaterThan(0)));
    }
}