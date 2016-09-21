package software.schwering.javacodechallenge;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class TableOfElements {

    private final Map<String, String> elementsToSymbols = new LinkedHashMap<>();
    private final List<String> elementsWithoutSymbol = new LinkedList<>();

    public TableOfElements(Stream<String> elements){
        Set<String> assignedSymbols = new HashSet<>();
        elements.forEachOrdered(element->{
            Optional<String> symbol = Splurth.symbolsSortedByPreference(element).stream().filter(s -> !assignedSymbols.contains(s)).findFirst();
            if(symbol.isPresent()){
                assignedSymbols.add(symbol.get());
                elementsToSymbols.put(element, symbol.get());
            }else{
                elementsWithoutSymbol.add(element);
            }
        });
    }

    public String getSymbol(String element){
        return elementsToSymbols.get(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        elementsToSymbols.forEach((e,s)->sb.append(String.format("%s -> %s\n", e, s)));
        sb.append("\nUNMATCHED ELEMENTS;\n");
        elementsWithoutSymbol.forEach(e->sb.append(e+'\n'));
        return sb.toString();
    }

    public static void main(String...args) throws URISyntaxException, IOException {
        System.out.println(new TableOfElements(Files.lines(Paths.get (TableOfElements.class.getResource("/KnownElements.txt").toURI()))));
    }
}
