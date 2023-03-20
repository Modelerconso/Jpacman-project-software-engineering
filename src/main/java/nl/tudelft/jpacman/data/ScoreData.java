package nl.tudelft.jpacman.data;

import nl.tudelft.jpacman.level.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreData {
    private static String SCORE_FILE_PATH = "./data/offline-score.txt";

    public static List<Score> getListScore() {
        List<Score> scoreList = new ArrayList<Score>();
        try {
            File scoreFile = new File(SCORE_FILE_PATH);
            Scanner scanner = new Scanner(scoreFile);
            while(scanner.hasNextLine()) {
                String[] splitData = scanner.nextLine().split(" ");
                Score data = new Score(splitData[0], Integer.parseInt(splitData[1]), Long.parseLong(splitData[2]));
                scoreList.add(data);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return scoreList;
    }

    public static List<Score> getScoreListSorted(List<Score> scores) {
        ScoreSorter sorter = new ScoreSorter();
        List<Score> newList = sorter.sortScoresByScore(scores);
        return newList;
    }

    public static boolean saveScore(Score score) {
        File fileScore = new File(SCORE_FILE_PATH);
        System.out.println(fileScore.getPath());
        if (!(fileScore.isFile() && fileScore.exists())) {
            try {
                fileScore.createNewFile();
            } catch (IOException error) {
                System.out.println("File can't create: " + error);
                return false;
            }
        }
        if(!fileScore.canWrite()) {
            System.out.println("File can't write.");
            return false;
        }
        try {
            FileWriter fw = new FileWriter(fileScore, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter writer = new PrintWriter(bw);
            writer.println(score.getPlayerName() + " " + score.getScore() + " " + score.getTime());
            writer.close();
        } catch (IOException error) {
            System.out.println("File can't write: " + error);
            return false;
        }
        return true;
    }

}
