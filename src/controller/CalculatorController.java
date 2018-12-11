package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import model.Calculator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    Calculator calculator = new Calculator();

    @FXML private Button btClear;
    @FXML private Button btClearEntry;
    @FXML private Button btNegPos;
    @FXML private Button btZero;
    @FXML private Button btComma;
    @FXML private Button btThree;
    @FXML private Button btAddition;
    @FXML private Button btPlus;
    @FXML private Button btBackspace;
    @FXML private Button btDivision;
    @FXML private Button btSeven;
    @FXML private Button btEight;
    @FXML private Button btNine;
    @FXML private Button btMultiplication;
    @FXML private Button btFour;
    @FXML private Button btFive;
    @FXML private Button btSix;
    @FXML private Button btSubtraction;
    @FXML private Button btOne;
    @FXML private Button btTwo;
    @FXML private Label lbMainPanel;
    @FXML private Label lbSecondPanel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btClear.setOnMouseClicked(e -> clear());
        btClearEntry.setOnMouseClicked(e -> clearEntry());




        btZero.setOnMouseClicked(e -> {
            setLbMainPanel("0");
        });

        btOne.setOnMouseClicked(e -> {
            setLbMainPanel("1");
        });

        btTwo.setOnMouseClicked(e -> {
            setLbMainPanel("2");
        });

        btThree.setOnMouseClicked(e -> { setLbMainPanel("3"); });

        btFour.setOnMouseClicked(e -> {
            setLbMainPanel("4");
        });

        btFive.setOnMouseClicked(e -> {
            setLbMainPanel("5");
        });

        btSix.setOnMouseClicked(e -> {
            setLbMainPanel("6");
        });

        btSeven.setOnMouseClicked(e -> {
            setLbMainPanel("7");
        });

        btEight.setOnMouseClicked(e -> {
            setLbMainPanel("8");
        });

        btNine.setOnMouseClicked(e -> {
            setLbMainPanel("9");
        });





    }

    private void clear(){
        calculator.setMainPanel("0");
        lbMainPanel.setText("0");
    }

    private void clearEntry(){
        clear();
        calculator.setSecondPanel("");
        lbSecondPanel.setText("");
    }

    private void setLbMainPanel(String digit){
        calculator.addDigit(digit);
        lbMainPanel.setText(calculator.getMainPanel());
    }
}
