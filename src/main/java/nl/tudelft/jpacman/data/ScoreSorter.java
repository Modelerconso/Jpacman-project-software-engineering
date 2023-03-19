package nl.tudelft.jpacman.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScoreSorter {

    public List<Score> sortScoresByScore(List<Score> scores) {
        List<Score> sortedScores = new ArrayList<>(scores);
        Collections.sort(sortedScores, new Comparator<Score>() {
            @Override
            public int compare(Score s1, Score s2) {
                int scoreCompare = Integer.compare(s2.getScore(), s1.getScore());
                if (scoreCompare != 0) {
                    return scoreCompare; // sort by score descending
                } else {
                    return Long.compare(s1.getTime(), s2.getTime()); // sort by time ascending if score is equal
                }
            }
        });
        return sortedScores;
    }

}
