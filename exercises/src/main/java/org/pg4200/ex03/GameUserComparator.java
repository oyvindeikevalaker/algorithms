package org.pg4200.ex03;

import java.util.Comparator;

public class GameUserComparator implements Comparator<GameUser> {

    @Override
    public int compare(GameUser o1, GameUser o2) {
        int pointDiff = o1.getPoints() - o2.getPoints();

        if (pointDiff == 0) {
            return o1.getUserId().compareTo(o2.getUserId());
        }

        return pointDiff;
    }
}
