import java.io.*;

public class High_Score {

    private static final String FILE_NAME = "highscore.txt";

    public static int loadHighScore(){

        try{
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            int score = Integer.parseInt(reader.readLine());
            reader.close();
            return score;
        }
        catch(Exception e){
            return 0;
        }
    }

    public static void saveHighScore(int score){

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(String.valueOf(score));
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
