import java.awt.*;
import java.util.Random;
public class MondrianArt{
    private static final int INITIAL_WIDTH = 800;
    private static final int INITIAL_HEIGHT = 600;
    private static final int MIN_SPLIT_SIZE = 100;

    private static Random random = new Random();

    public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(INITIAL_WIDTH, INITIAL_HEIGHT);
        draw(panel.getGraphics(), 0, 0 , INITIAL_WIDTH, INITIAL_HEIGHT);
    }

    public static void draw(Graphics g, int x, int y, int width, int height){
        int randomSplitWidth = random.nextInt((int)(width * 1.5 - MIN_SPLIT_SIZE)) + MIN_SPLIT_SIZE;
        int randomSplitHeight = random.nextInt((int)(height * 1.5 - MIN_SPLIT_SIZE)) + MIN_SPLIT_SIZE;

        int splitX = (int)(width * (random.nextDouble() * 0.34 +0.33));
        int splitY = (int)(height * (random.nextDouble() * 0.34 +0.33));

        boolean hSplit = false;
        boolean vSplit = false;

        if(width > INITIAL_WIDTH / 2 && height > INITIAL_HEIGHT / 2){
            hSplit = true;
            vSplit = true;
        }
        else if (width > INITIAL_WIDTH / 2) {
            hSplit = true;
        }
        else if (height > INITIAL_HEIGHT / 2) {
            vSplit = true;
        }
        else if (randomSplitWidth < width && randomSplitHeight < height) {
            hSplit = true;
            vSplit = true;
        }

        if (hSplit && vSplit) {
            draw(g, x, y, splitX, splitY);
            draw(g, x + splitX, y, width - splitX, splitY);
            draw(g, x, y + splitY, splitX, height - splitY);
            draw(g, x + splitX, y + splitY, width - splitX, height - splitY);
        }
        else if (hSplit) {
            draw(g, x, y, splitX, height);
            draw(g, x + splitX, y, width - splitX, height);
        }
        else if (vSplit) {
            draw(g, x, y, width, splitY);
            draw(g, x, splitY, width, height - splitY);
        }
        else {
            g.drawRect(x, y, width, height);
            //TODO: fill
        }
    }
}