package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Calculator;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    private Calculator calculator = new Calculator();

    @FXML
    private Button btClear, btClearEntry, btPlusMinus, btComma, btEquals, btThree, btAddition, btDivision, btBackspace, btPowerOfTwo,
            btSeven, btNine, btEight, btMultiplication, btFour, btFive, btSix, btSubtraction, btOne, btTwo, btSquareRoot, btZero, btPercentage;
    @FXML
    private Label lbPrimaryDisplay, lbSecondaryDisplay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btZero.setOnMouseClicked(e -> setLbPrimaryDisplay("0"));
        btOne.setOnMouseClicked(e -> setLbPrimaryDisplay("1"));
        btTwo.setOnMouseClicked(e -> setLbPrimaryDisplay("2"));
        btThree.setOnMouseClicked(e -> setLbPrimaryDisplay("3"));
        btFour.setOnMouseClicked(e -> setLbPrimaryDisplay("4"));
        btFive.setOnMouseClicked(e -> setLbPrimaryDisplay("5"));
        btSix.setOnMouseClicked(e -> setLbPrimaryDisplay("6"));
        btSeven.setOnMouseClicked(e -> setLbPrimaryDisplay("7"));
        btEight.setOnMouseClicked(e -> setLbPrimaryDisplay("8"));
        btNine.setOnMouseClicked(e -> setLbPrimaryDisplay("9"));
        btClear.setOnMouseClicked(e -> clear());
        btClearEntry.setOnMouseClicked(e -> clearEntry());
        btAddition.setOnMouseClicked(e -> prepareOperation("+"));
        btSubtraction.setOnMouseClicked(e -> prepareOperation("-"));
        btMultiplication.setOnMouseClicked(e -> prepareOperation("*"));
        btDivision.setOnMouseClicked(e -> prepareOperation("/"));
        btSquareRoot.setOnMouseClicked(e -> prepareOperation("sqrt"));
        btPlusMinus.setOnMouseClicked(e -> changeSign(calculator.getNumber2String()));
        btEquals.setOnMouseClicked(e ->
        {
            calculator.performOperation(calculator.getNumber1String(), calculator.getNumber2String());
            convertToString();
        });

    }

    private void clear() {
        calculator.setNumber2String("0");
        lbPrimaryDisplay.setText("0");
    }

    private void clearEntry() {
        clear();
        calculator.setNumber1String("");
        lbSecondaryDisplay.setText("");
    }

    private void setLbPrimaryDisplay(String digit) {
        calculator.addDigit(digit);
        lbPrimaryDisplay.setText(calculator.getNumber2String());
    }

    private void prepareOperation(String operator) {
        calculator.setOperator(operator);
        calculator.setNumber1String(calculator.getNumber2String());
        calculator.setNumber2String("0");
        lbSecondaryDisplay.setText(calculator.getNumber1String() + " " + operator);
        lbPrimaryDisplay.setText(calculator.getNumber2String());
    }

    private void convertToString() {
        calculator.setNumber2String(Double.toString(calculator.getNumber2()));
        calculator.setNumber1String("");
        lbSecondaryDisplay.setText(calculator.getNumber1String());
        lbPrimaryDisplay.setText(calculator.getNumber2String());
    }

    private void changeSign(String number2) {
        calculator.setNumber2(-Double.parseDouble(number2));
        calculator.setNumber2String(Double.toString(calculator.getNumber2()));
        lbPrimaryDisplay.setText(calculator.getNumber2String());
    }

}