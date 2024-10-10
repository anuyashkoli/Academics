import javax.swing.*;
import java.awt.*;

// Custom JPanel class to draw shapes and text
class CustomPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set color for the shapes
        g.setColor(Color.RED);

        // Draw an oval (x, y, width, height)
        g.drawOval(50, 50, 100, 50);

        // Draw a vertical line (x1, y1, x2, y2)
        g.drawLine(200, 50, 200, 200);

        // Draw a horizontal line (x1, y1, x2, y2)
        g.drawLine(50, 150, 250, 150);

        // Set color for the string text
        g.setColor(Color.BLUE);
        
        // Set the font to be bigger and bold
        g.setFont(new Font("Arial", Font.BOLD, 20));  // Font name, style, size

        // Draw a string with the new font
        g.drawString("Anuyash Koli", 50, 250);
    }
}

public class GUI {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Draw Shapes and Bold String");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400); // Set frame size

        // Add the CustomPanel to the frame
        CustomPanel panel = new CustomPanel();
        frame.add(panel);

        frame.setVisible(true); // Make the frame visible
    }
}
