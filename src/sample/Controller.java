package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

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
    private Label DevP;
    @FXML
    private Label FDevP;
    @FXML
    private Label CRe;
    @FXML
    private Label DocRe;
    @FXML
    private Label errorLabel;
    @FXML
    private Label FA;
    @FXML
    private Label VITA;
    @FXML
    private Label TUA;
    @FXML
    private TextField NYSERH;
    @FXML
    private TextField NYFH;
    @FXML
    private TextField NYVITFH;
    @FXML
    private TextField NYTFH;

    public void calculatePPM(ActionEvent event) {
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

    public void resetPPM(ActionEvent event) {
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

    public void calculateSSAM(ActionEvent event) {
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

    public void resetSSAM(ActionEvent event) {
        FA.setText("0");
        VITA.setText("0");
        TUA.setText("0 ");
        NYSERH.setText("");
        NYFH.setText("");
        NYVITFH.setText("");
        NYTFH.setText("");
        errorLabel.setText("");
    }

    public void switchToSSAM(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPPM(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
