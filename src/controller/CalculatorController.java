package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Calculator;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    @FXML private Button btClear, btClearEntry, btPlusMinus, btComma, btEquals, btThree, btAddition, btDivision, btBackspace, btPowerOfTwo,
            btSeven, btNine, btEight, btMultiplication, btFour, btFive, btSix, btSubtraction, btOne, btTwo, btSquareRoot, btZero, btPercentage;
    @FXML private Label lbPrimaryDisplay, lbSecondaryDisplay;

    private Calculator calculator = new Calculator();

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

        btComma.setOnMouseClicked(e ->
        {
            if (!containsComma(calculator.getNumber2String())) {
                setLbPrimaryDisplay(".");
            }
        });

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

    private void changeSign(String number2) {
        calculator.setNumber2(-Double.parseDouble(number2));
        calculator.setNumber2String(Double.toString(calculator.getNumber2()));
        lbPrimaryDisplay.setText(calculator.getNumber2String());
    }

    private void setLbPrimaryDisplay(String digit) {
        calculator.addDigit(digit);
        lbPrimaryDisplay.setText(calculator.getNumber2String());
    }

    public boolean containsComma(String number2){
        for(int i = 0; i < number2.length(); i++){
            if(number2.charAt(i) == '.'){
                return true;
            }
        }
        return false;
    }

    private void prepareOperation(String operator) {
        calculator.setOperator(operator);
        calculator.setNumber1String(calculator.getNumber2String());
        calculator.setNumber2String("0");
        lbSecondaryDisplay.setText(calculator.getNumber1String() + " " + operator);
        lbPrimaryDisplay.setText(calculator.getNumber2String());
    }

    //Converts to string getting rid of trailing zeros
    private void convertToString(){
        double d = calculator.getNumber2();
        if(d == (long) d){
            calculator.setNumber2String(String.format("%d", (long)d));
        }
        else {
            calculator.setNumber2String(String.format("%s", d));
        }
        calculator.setNumber1String("");
        lbSecondaryDisplay.setText(calculator.getNumber1String());
        lbPrimaryDisplay.setText(calculator.getNumber2String());

    }

    /*
        //Converts to string keeping trailing zeros
        private void convertToString() {
        calculator.setNumber2String(Double.toString(calculator.getNumber2()));
        calculator.setNumber1String("");
        lbSecondaryDisplay.setText(calculator.getNumber1String());
        lbPrimaryDisplay.setText(calculator.getNumber2String());
    }*/

}