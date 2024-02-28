import java.awt.*;
import java.util.Random;
public class MondrianArt{
    private static final int INITIAL_WIDTH = 800;
    private static final int INITIAL_HEIGHT = 600;
    private static final int MIN_SPLIT_SIZE = 100;

    private static Random random = new Random();
    public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(INITIAL_WIDTH, INITIAL_HEIGHT);

    }
public static void draw(DrawingPanel panel, int x, int y, int width, int height){
    int randomSplitWidth = random.nextInt((int)(width * 1.5 - MIN_SPLIT_SIZE)) + MIN_SPLIT_SIZE;
    int randomSplitHeight = random.nextInt((int)(height * 1.5 - MIN_SPLIT_SIZE)) + MIN_SPLIT_SIZE;

    if(randomSplitWidth < width && randomSplitHeight < height){
        boolean horizontalSplit = random.nextBoolean();
        boolean verticalSplit = random.nextBoolean();

        if(horizontalSplit && verticalSplit){
            double randomValue = random.nextDouble() * 0.34 +33;
            int splitX = x + (int)(width * randomValue);
            int splitY = y + (int)(height * randomValue);
        }
    }
}
}