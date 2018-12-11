package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Calculator;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    Calculator calculator = new Calculator();

    @FXML
    private Button btClear;
    @FXML
    private Button btClearEntry;
    @FXML
    private Button btPlusMinus;
    @FXML
    private Button btZero;
    @FXML
    private Button btComma;
    @FXML
    private Button btEquals;
    @FXML
    private Button btThree;
    @FXML
    private Button btAddition;
    @FXML
    private Button btPlus;
    @FXML
    private Button btBackspace;
    @FXML
    private Button btDivision;
    @FXML
    private Button btSeven;
    @FXML
    private Button btEight;
    @FXML
    private Button btNine;
    @FXML
    private Button btMultiplication;
    @FXML
    private Button btFour;
    @FXML
    private Button btFive;
    @FXML
    private Button btSix;
    @FXML
    private Button btSubtraction;
    @FXML
    private Button btOne;
    @FXML
    private Button btTwo;
    @FXML
    private Button btSquareRoot;
    @FXML
    private Label lbMainPanel;
    @FXML
    private Label lbSecondPanel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btClear.setOnMouseClicked(e -> clear());

        btClearEntry.setOnMouseClicked(e -> clearEntry());

        btAddition.setOnMouseClicked(e -> prepareOperation("+"));

        btSubtraction.setOnMouseClicked(e -> prepareOperation("-"));

        btMultiplication.setOnMouseClicked(e -> prepareOperation("*"));

        btDivision.setOnMouseClicked(e -> prepareOperation("/"));

        btSquareRoot.setOnMouseClicked(e -> prepareOperation("sqrt"));

        btEquals.setOnMouseClicked(e -> performOperation(calculator.getNumber1String(), calculator.getNumber2String()));

        btPlusMinus.setOnMouseClicked(e -> changeSign(calculator.getNumber2String()));

        btZero.setOnMouseClicked(e -> {
            setLbMainPanel("0");
        });

        btOne.setOnMouseClicked(e -> {
            setLbMainPanel("1");
        });

        btTwo.setOnMouseClicked(e -> {
            setLbMainPanel("2");
        });

        btThree.setOnMouseClicked(e -> {
            setLbMainPanel("3");
        });

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

    private void clear() {
        calculator.setNumber2String("0");
        lbMainPanel.setText("0");
    }

    private void clearEntry() {
        clear();
        calculator.setNumber1String("");
        lbSecondPanel.setText("");
    }

    private void setLbMainPanel(String digit) {
        calculator.addDigit(digit);
        lbMainPanel.setText(calculator.getNumber2String());
    }

    private void prepareOperation(String operator) {
        calculator.setOperator(operator);
        calculator.setNumber1String(calculator.getNumber2String());
        calculator.setNumber2String("0");
        lbSecondPanel.setText(calculator.getNumber1String() + " " + operator);
        lbMainPanel.setText(calculator.getNumber2String());
    }

    private void convertToString() {
        calculator.setNumber2String(Double.toString(calculator.getNumber2()));
        calculator.setNumber1String("");
        lbSecondPanel.setText(calculator.getNumber1String());
        lbMainPanel.setText(calculator.getNumber2String());
    }

    private void changeSign(String number2) {
        calculator.setNumber2(-Double.parseDouble(number2));
        calculator.setNumber2String(Double.toString(calculator.getNumber2()));
        lbMainPanel.setText(calculator.getNumber2String());
    }

    private void performOperation(String number1, String number2) {
        calculator.setNumber1(Double.parseDouble(number1));
        calculator.setNumber2(Double.parseDouble(number2));

        switch (calculator.getOperator()) {
            case "+": {
                calculator.setNumber2(calculator.getNumber1() + calculator.getNumber2());
                convertToString();
            }
            break;

            case "-": {
                calculator.setNumber2(calculator.getNumber1() - calculator.getNumber2());
                convertToString();
            }
            break;

            case "*": {
                calculator.setNumber2(calculator.getNumber1() * calculator.getNumber2());
                convertToString();
            }
            break;

            case "/": {
                calculator.setNumber2(calculator.getNumber1() / calculator.getNumber2());
                convertToString();
            }
            break;

            case "sqrt": {
                calculator.setNumber2(Math.sqrt(calculator.getNumber2()));
                convertToString();
            }

            case "pow2": {
                calculator.setNumber2(Math.pow(calculator.getNumber2(), 2));
                convertToString();
            }
        }
    }
}