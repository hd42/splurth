package software.schwering.javacodechallenge;

import java.util.*;

public class Splurth {

    public static boolean isValid(String elementName, String symbol) {
        String e = elementName.toLowerCase();
        int minIndex = 0;
        for (char c : symbol.toLowerCase().toCharArray()) {
            int i = e.indexOf(c, minIndex);
            if (i < 0) return false;
            minIndex = i + 1;
        }
        return true;
    }

    public static String firstSymbol(String elementName) {
        return symbols(elementName).first();
    }

    public static int distinctSymbols(String elementName) {
        return symbols(elementName).size();
    }

    public static List<String> symbolsSortedByPreference(String elementName){
        return new ArrayList<>(symbols(elementName, new PreferenceComparator(elementName)::compare));
    }

    private static SortedSet<String> symbols(String elementName) {
        return symbols(elementName, String::compareToIgnoreCase);
    }

    private static SortedSet<String> symbols(String elementName, Comparator<String> comparator) {
        String upper = elementName.toUpperCase();
        String lower = elementName.toLowerCase();
        SortedSet<String> symbols = new TreeSet<>(comparator);
        for (int i = 0; i < elementName.length(); i++) {
            for (int j = i + 1; j < elementName.length(); j++) {
                symbols.add("" + upper.charAt(i) + lower.charAt(j));
            }
        }
        return symbols;
    }

}
