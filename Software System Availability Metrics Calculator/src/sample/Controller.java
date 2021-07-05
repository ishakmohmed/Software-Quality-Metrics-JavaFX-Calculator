package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label FA;
    @FXML
    private Label VITA;
    @FXML
    private Label TUA;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField NYSERH;
    @FXML
    private TextField NYFH;
    @FXML
    private TextField NYVITFH;
    @FXML
    private TextField NYTFH;

    public void calculate(ActionEvent event) {
        try {
            String theNYSERH = NYSERH.getText();
            String theNYFH = NYFH.getText();
            String theNYVITFH = NYVITFH.getText();
            String theNYTFH = NYTFH.getText();

            errorLabel.setText("");

            FA.setText(Float.toString((Float.parseFloat(theNYSERH)-Float.parseFloat(theNYFH))/Float.parseFloat(theNYSERH)));
            VITA.setText(Float.toString((Float.parseFloat(theNYSERH)-Float.parseFloat(theNYVITFH))/Float.parseFloat(theNYSERH)));
            TUA.setText(Float.toString((Float.parseFloat(theNYTFH)/Float.parseFloat(theNYSERH))));
        } catch (Exception e) {
            System.out.println(e);
            errorLabel.setText("Please fill up all numbers (no empty value, no text)!");

            FA.setText("0");
            VITA.setText("0");
            TUA.setText("0");
        }
    }

    public void reset(ActionEvent event) {
        FA.setText("0");
        VITA.setText("0");
        TUA.setText("0 ");
        NYSERH.setText("");
        NYFH.setText("");
        NYVITFH.setText("");
        NYTFH.setText("");
        errorLabel.setText("");
    }
}
