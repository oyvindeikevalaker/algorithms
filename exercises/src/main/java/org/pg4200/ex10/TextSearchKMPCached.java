package org.pg4200.ex10;

import org.pg4200.les10.search.TextSearchKMP;

import java.util.HashMap;
import java.util.Map;

public class TextSearchKMPCached extends TextSearchKMP {

    private final Map<String, TextSearchKMP> cache = new HashMap<>();

    public TextSearchKMPCached() {
        super();
    }

    public TextSearchKMPCached(String token) {
        super(token);
    }

    @Override
    public int findFirst(String text, String token) {
        if (defaultTarget != null && defaultTarget.equals(token)) {
            findFirst(text);
        }

        TextSearchKMP kmp = cache.get(token);

        if (kmp == null) {
            kmp = new TextSearchKMP(token);
            cache.put(token, kmp);
        }

        return kmp.findFirst(text);
    }
}
