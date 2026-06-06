import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;

    public Main() {
        setTitle("AlgoVibe: DSA Visualizer Suite");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //  rendering graphics panel
        VisualizerPanel visualizerPanel = new VisualizerPanel(WIDTH, HEIGHT);
        add(visualizerPanel, BorderLayout.CENTER);

        // Control Panel UI layout bar
        JPanel controlPanel = new JPanel();
        JButton sortButton = new JButton("Start Bubble Sort");
        JButton resetButton = new JButton("Reset Array");
        
        sortButton.addActionListener(e -> visualizerPanel.startSorting());
        resetButton.addActionListener(e -> visualizerPanel.resetArray());
        
        controlPanel.add(sortButton);
        controlPanel.add(resetButton);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
