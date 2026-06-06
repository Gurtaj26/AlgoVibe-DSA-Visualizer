
import javax.swing.JOptionPane;

public class BubbleSortWorker implements Runnable {
    private final VisualizerPanel visualizerPanel;

    // Use a Constructor Dependency Injection pattern to maintain clean component lines
    public BubbleSortWorker(VisualizerPanel visualizerPanel) {
        this.visualizerPanel = visualizerPanel;
    }

    @Override
    public void run() {
        int[] array = visualizerPanel.getArray();
        
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                
                // Alert visualizer panel of the specific two array indices currently being evaluated
                visualizerPanel.updateHighlights(j, j + 1);
                
                // Intentionally delay processing execution for a brief moment to make sorting visible
                try { 
                    Thread.sleep(12); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // Sorting conditional calculation evaluation
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        
        // Finalize execution path routines safely
        visualizerPanel.clearHighlights();
        JOptionPane.showMessageDialog(visualizerPanel, "Sorting Algorithm Processing Completed!");
    }
}
