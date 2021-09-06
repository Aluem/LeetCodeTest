package com.one_quest_per_day;

public class EscapeGhosts_21_08_22 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int step = Math.abs(target[0]) + Math.abs(target[1]);
        for (int i = 0; i < ghosts.length; i++) {
            int num = Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1]);
            if (num <= step) {
                return false;
            }
        }
        return true;
    }
}
