import javax.swing.*;
import java.awt.*;

// CirclePanel class to handle drawing the filled circle
class CirclePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE); // Set color for the filled circle
        g.fillOval(50, 50, 200, 200); // Draw a filled circle (x, y, width, height)
    }
}

public class FilledCircle {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Draw a Filled Circle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300); // Set frame size

        // Add the CirclePanel to the frame
        CirclePanel circlePanel = new CirclePanel();
        frame.add(circlePanel);

        frame.setVisible(true); // Make the frame visible
    }
}
