import java.awt.*;
import javax.swing.*;

public class DDA_Line extends JPanel {
    private int x1, y1, x2, y2;

    public DDA_Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps;

        if (Math.abs(dx) > Math.abs(dy)) {
            steps = Math.abs(dx);
        } else {
            steps = Math.abs(dy);
        }

        float xIncrement = (float) dx / steps;
        float yIncrement = (float) dy / steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(Math.round(x), Math.round(y), 1, 1);
            x += xIncrement;
            y += yIncrement;
        }
    }

    public static void main(String[] args) {
        int x1 = 50, y1 = 50, x2 = 250, y2 = 150;

        JFrame frame = new JFrame("DDA Line Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DDA_Line(x1, y1, x2, y2));
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
