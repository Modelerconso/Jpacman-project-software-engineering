package nl.tudelft.jpacman.data;

import nl.tudelft.jpacman.level.Player;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private String playerName;
    private int score;
    private long time;

    public Score() {

    }

    public Score(Player player, long time) {
        this.playerName = player.getName();
        this.score = player.getScore();
        this.time = time;
    }

    public Score(String playerName, int score, long time) {
        this.playerName = playerName;
        this.score = score;
        this.time = time;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("playerName", this.playerName);
        map.put("score", this.score);
        map.put("time", this.time);
        return map;
    }
}
