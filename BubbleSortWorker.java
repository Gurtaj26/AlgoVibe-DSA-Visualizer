
import javax.swing.JOptionPane;

public class BubbleSortWorker implements Runnable {
    private final VisualizerPanel visualizerPanel;

    
    public BubbleSortWorker(VisualizerPanel visualizerPanel) {
        this.visualizerPanel = visualizerPanel;
    }

    @Override
    public void run() {
        int[] array = visualizerPanel.getArray();
        
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                
                // Alert visualizer panel 
                visualizerPanel.updateHighlights(j, j + 1);
                
                //  make sorting visible
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
        
        //  execution path
        visualizerPanel.clearHighlights();
        JOptionPane.showMessageDialog(visualizerPanel, "Sorting Algorithm Processing Completed!");
    }
}
