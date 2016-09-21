package software.schwering.javacodechallenge;

import java.util.Comparator;

public class PreferenceComparator implements Comparator<String> {

    private final String elementName;

    public PreferenceComparator(String elementName) {
        this.elementName = elementName.toLowerCase();
    }

    @Override
    public int compare(String symbol1, String symbol2) {
        if (symbol1 == null && symbol2 == null)
            return 0;
        if (symbol1 == null)
            return Integer.MIN_VALUE;
        if (symbol2 == null)
            return Integer.MAX_VALUE;
        int indexOfFirstLetter1 = elementName.indexOf(symbol1.toLowerCase().charAt(0));
        int indexOfFirstLetter2 = elementName.indexOf(symbol2.toLowerCase().charAt(0));
        if (indexOfFirstLetter1 != indexOfFirstLetter2) {
            if (indexOfFirstLetter1 < 0 && indexOfFirstLetter2 >= 0) return Integer.MAX_VALUE;
            if (indexOfFirstLetter2 < 0 && indexOfFirstLetter1 >= 0) return Integer.MIN_VALUE;
            return indexOfFirstLetter1 - indexOfFirstLetter2;
        }
        int indexOfSecondLetter1 = elementName.indexOf(symbol1.toLowerCase().charAt(1), indexOfFirstLetter1 + 1);
        int indexOfSecondLetter2 = elementName.indexOf(symbol2.toLowerCase().charAt(1), indexOfFirstLetter2 + 1);
        if (indexOfSecondLetter1 < 0 && indexOfSecondLetter2 >= 0) return Integer.MAX_VALUE;
        if (indexOfSecondLetter2 < 0 && indexOfSecondLetter1 >= 0) return Integer.MIN_VALUE;
        return indexOfSecondLetter1 - indexOfSecondLetter2;
    }
}