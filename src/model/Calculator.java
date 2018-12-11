package model;

public class Calculator {

    private String mainPanel = "0";
    private String secondPanel;
    private String digit;
    private char operator;
    private double numerator;
    private double denominator;
    private double number;
    private double result;

    //Getters and Setters
    public String getDigit() { return digit; }
    public void setDigit(String digit) { this.digit = digit; }
    public String getMainPanel() {
        return mainPanel;
    }
    public void setMainPanel(String mainPanel) { this.mainPanel = mainPanel; }
    public String getSecondPanel() {
        return secondPanel;
    }
    public void setSecondPanel(String secondPanel) {
        this.secondPanel = secondPanel;
    }
    public char getOperator() {
        return operator;
    }
    public void setOperator(char operator) {
        this.operator = operator;
    }
    public double getNumerator() {
        return numerator;
    }
    public void setNumerator(double numerator) {
        this.numerator = numerator;
    }
    public double getDenominator() {
        return denominator;
    }
    public void setDenominator(double denominator) {
        this.denominator = denominator;
    }
    public double getNumber() {
        return number;
    }
    public void setNumber(double number) {
        this.number = number;
    }
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }

    //Other methods
    public void addDigit(String digit) {
        if (mainPanel.equals("0")) {
            setMainPanel(digit);
        } else {
            setMainPanel(getMainPanel() + digit);
        }
    }
}
