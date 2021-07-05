package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField DevH;
    @FXML
    private TextField KLOC;
    @FXML
    private TextField NFP;
    @FXML
    private TextField ReKLOC;
    @FXML
    private TextField NP;
    @FXML
    private TextField NRP;
    @FXML
    private Button calculateButton;
    @FXML
    private Button resetButton;
    @FXML
    private Label DevP;
    @FXML
    private Label FDevP;
    @FXML
    private Label CRe;
    @FXML
    private Label DocRe;
    @FXML
    private Label errorLabel;

    public void calculate(ActionEvent event) {
        try {
            String theDevH = DevH.getText();
            String theKLOC = KLOC.getText();
            String theNFP = NFP.getText();
            String theReKLOC = ReKLOC.getText();
            String theNP = NP.getText();
            String theNRP = NRP.getText();

            errorLabel.setText("");

            DevP.setText(Float.toString(Float.parseFloat(theDevH)/Float.parseFloat(theKLOC)));
            FDevP.setText(Float.toString(Float.parseFloat(theDevH)/Float.parseFloat(theNFP)));
            CRe.setText(Float.toString(Float.parseFloat(theReKLOC)/Float.parseFloat(theKLOC)));
            DocRe.setText(Float.toString(Float.parseFloat(theNRP)/Float.parseFloat(theNP)));
        } catch (Exception e) {
            System.out.println(e);
            errorLabel.setText("Please fill up all numbers (no empty value, no text)!");

            DevP.setText("0");
            FDevP.setText("0");
            CRe.setText("0");
            DocRe.setText("0");
        }
    }

    public void reset(ActionEvent event) {
        DevH.setText("");
        KLOC.setText("");
        NFP.setText("");
        ReKLOC.setText("");
        NP.setText("");
        NRP.setText("");
        DevP.setText("0");
        FDevP.setText("0");
        CRe.setText("0");
        DocRe.setText("0");
        errorLabel.setText("");
    }
}
