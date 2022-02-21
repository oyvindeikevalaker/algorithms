package org.pg4200.ex09;

import org.pg4200.les09.UndirectedGraph;

import java.util.*;

public class AllPathsGraph<V> extends UndirectedGraph<V> {

    public List<List<V>> findAllPaths(V start, V end) {
        if (!graph.containsKey(start) && !graph.containsKey(end))
            return Collections.emptyList();

        if (start.equals(end))
            throw new IllegalArgumentException();

        Deque<V> stack = new ArrayDeque<>();

        List<List<V>> paths = new ArrayList<>();

        dfs(paths, stack, start, end);

        return paths;
    }

    private void dfs(List<List<V>> paths, Deque<V> stack, V start, V end) {
        stack.push(start);

        if (isPathTo(stack, end)) {
            List<V> path = new ArrayList<>(stack);
            Collections.reverse(path);
            paths.add(path);
            return;
        }

        for (V connected : getAdjacents(start)) {
            if (stack.contains(connected)) continue;
            dfs(paths, stack, connected, end);
            stack.pop();
        }


    }
}
