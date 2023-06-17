package com.example;

/**
 * Hello world!
 *
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.json.JSONObject;

public class SolarModuleEditorGui extends JFrame {
  private JLabel currentModelLabel = new JLabel("Current Model: ");
  private JTextField currentModelField = new JTextField(20);
  private JLabel newModelLabel = new JLabel("New Model: ");
  private JTextField newModelField = new JTextField(20);
  private JButton updateButton = new JButton("Update");

  public SolarModuleEditorGui() {
    super("Solar Module Editor");
    setLayout(new FlowLayout());
    add(currentModelLabel);
    add(currentModelField);
    add(newModelLabel);
    add(newModelField);
    add(updateButton);

    updateButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String currentModel = currentModelField.getText();
        String newModel = newModelField.getText();

        JSONObject modelJson = new JSONObject();
        modelJson.put("currentModel", currentModel);
        modelJson.put("newModel", newModel);

        try (FileWriter file = new FileWriter("solar_module_model.json")) {
          file.write(modelJson.toString());
          JOptionPane.showMessageDialog(null, "Model updated successfully.");
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(null, "Error updating model.");
        }
      }
    });
  }

  public static void main(String[] args) {
    SolarModuleEditorGui editor = new SolarModuleEditorGui();
    editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    editor.setSize(400, 100);
    editor.setVisible(true);
  }
}

