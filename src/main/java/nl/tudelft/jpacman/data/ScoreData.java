package nl.tudelft.jpacman.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreData {
    private String SCORE_FILE_PATH = "./data/score.txt";

    public List<Score> getListScore() {
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
        for(int i=0;i<scoreList.size();i++) {
            System.out.println(scoreList.get(i).getScore());
        }
        return scoreList;
    }

}
