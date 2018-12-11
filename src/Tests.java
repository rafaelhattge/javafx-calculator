public class Tests {

    //  Best way to parseDouble with comma as decimal separator?
    /*  Use java.text.NumberFormat:

            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
            Number number = format.parse("1,234");
            double d = number.doubleValue();
    */

    //How can I format a String number to have commas and round?
    /*  You might want to look at the DecimalFormat class; it supports different locales (eg: in some countries
        that would get formatted as 1.000.500.000,57 instead).

        You also need to convert that string into a number, this can be done with:

            double amount = Double.parseDouble(number);

        Code sample:

            String number = "1000500000.574";
            double amount = Double.parseDouble(number);
            DecimalFormat formatter = new DecimalFormat("#,###.00");

            System.out.println(formatter.format(amount));

    */
}
