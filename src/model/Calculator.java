package model;

public class Calculator {

    private String number2String = "0";
    private String number1String = "";
    private String digit;
    private String operator;
    private double numerator;
    private double denominator;
    private double number2;
    private double number1;

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public String getNumber2String() {
        return number2String;
    }

    public void setNumber2String(String number2String) {
        this.number2String = number2String;
    }

    public String getNumber1String() {
        return number1String;
    }

    public void setNumber1String(String number1String) {
        this.number1String = number1String;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
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

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    //Other methods

    public void setDefault() {
        number2String = "0";
        number1String = "";
    }

    public void addDigit(String digit) {
        if (number2String.equals("0")) {
            setNumber2String(digit);
        } else {
            setNumber2String(getNumber2String() + digit);
        }
    }
}
