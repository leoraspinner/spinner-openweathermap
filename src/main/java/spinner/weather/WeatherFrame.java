package spinner.weather;

import javax.swing.*;
import java.awt.*;

import static java.awt.AWTEventMulticaster.add;


public class WeatherFrame extends JFrame {
    private JLabel label;

    public WeatherFrame() {
        setTitle("Weather");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        label = new JLabel("Loading...", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);
    }

    public void setTemperature(String location, double temp) {
        label.setText(String.format("Current temperature in %s: %.2f°F", location, temp));
    }

    public void setError(String message) {
        label.setText("Error: " + message);
    }


}
