package util;

import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    private Set<String> words;

    public Dictionary() {
        words = new HashSet<>();
        words.add("hello");
        words.add("world");
        words.add("java");
        words.add("programming");

    }

    public boolean conintains(String word) {
        return words.contains(word);

    }

}
