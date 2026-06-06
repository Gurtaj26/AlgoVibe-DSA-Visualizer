import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VisualizerPanel extends JPanel {
    private final int barWidth = 8;
    private int[] array;
    private int compareIdx1 = -1;
    private int compareIdx2 = -1;
    private final int maxPanelHeight;

    public VisualizerPanel(int panelWidth, int panelHeight) {
        setBackground(Color.BLACK); // Monochrome aesthetic matching your resume layout
        int numBars = panelWidth / barWidth;
        this.array = new int[numBars];
        this.maxPanelHeight = panelHeight;
        resetArray();
    }

    public void resetArray() {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(maxPanelHeight - 120) + 15;
        }
        clearHighlights();
        repaint();
    }

    public int[] getArray() {
        return array;
    }

    public void updateHighlights(int idx1, int idx2) {
        this.compareIdx1 = idx1;
        this.compareIdx2 = idx2;
        repaint(); // Re-trigger paintComponent with new index positions
    }

    public void clearHighlights() {
        this.compareIdx1 = -1;
        this.compareIdx2 = -1;
        repaint();
    }

    public void startSorting() {
        // Instantiate our dedicated background worker engine and pass 'this' panel reference
        BubbleSortWorker sortingEngine = new BubbleSortWorker(this);
        new Thread(sortingEngine).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < array.length; i++) {
            // Check if the current element element pointer is being handled by the background thread
            if (i == compareIdx1 || i == compareIdx2) {
                g.setColor(Color.RED); 
            } else {
                g.setColor(Color.WHITE);
            }
            int barHeight = array[i];
            g.fillRect(i * barWidth, getHeight() - barHeight, barWidth - 2, barHeight);
        }
    }
}