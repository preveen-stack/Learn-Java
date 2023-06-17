import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MeasurementConverter extends JFrame implements ActionListener {
    // GUI components
    private JLabel inchLabel, mmLabel;
    private JTextField inchTextField, mmTextField;
    private JButton inchToMmButton, mmToInchButton;

    // Constructor
    public MeasurementConverter() {
        super("Measurement Converter");

        // Set up GUI components
        inchLabel = new JLabel("Inches:");
        inchTextField = new JTextField(10);
        mmLabel = new JLabel("Millimeters:");
        mmTextField = new JTextField(10);
        inchToMmButton = new JButton("Convert Inches to Millimeters");
        mmToInchButton = new JButton("Convert Millimeters to Inches");

        // Set up layout
        setLayout(new GridLayout(3, 2));
        add(inchLabel);
        add(inchTextField);
        add(mmLabel);
        add(mmTextField);
        add(inchToMmButton);
        add(mmToInchButton);

        // Add action listeners to buttons
        inchToMmButton.addActionListener(this);
        mmToInchButton.addActionListener(this);

        // Set up frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setVisible(true);
    }

    // ActionListener method
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inchToMmButton) {
            // Convert inches to millimeters
            double inches = Double.parseDouble(inchTextField.getText());
            double millimeters = inches * 25.4;
            mmTextField.setText(String.format("%.2f", millimeters));
        } else if (e.getSource() == mmToInchButton) {
            // Convert millimeters to inches
            double millimeters = Double.parseDouble(mmTextField.getText());
            double inches = millimeters / 25.4;
            inchTextField.setText(String.format("%.2f", inches));
        }
    }

    // Main method
    public static void main(String[] args) {
        new MeasurementConverter();
    }
}

