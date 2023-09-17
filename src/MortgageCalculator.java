import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public void getMortgageAmount() {
        int principal = getPrincipal();
        float interestRate = getInterestRate();
        byte period = getPeriod();
        double mortgage = getMonthlyPayment(principal, interestRate, period);
        printMonthlyPayment(mortgage);
        Main.selectProgram();
    }

    public static Scanner askQuestion(String question) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(question);
        return userInput;
    }

    public static int getPrincipal() {
        Scanner userInput = askQuestion("Your Principal ($1k - $1M): ");

        int principal = userInput.nextInt();

        if(principal < 1_000 || principal > 1_000_000) {
            System.out.println("Please select a principal amount between $1,000 and $1,000,000");
            return getPrincipal();
        }

        return principal;
    }

    public static float getInterestRate() {
        Scanner userInput = askQuestion("Annual Interest Rate (0% < Int < 30%): ");

        float interestRate = userInput.nextFloat();

        if(interestRate < 0 || interestRate >= 30) {
            System.out.println("Please enter an interest rate between 0% and 30%");
            return getInterestRate();
        }

        return interestRate;
    }

    public static byte getPeriod() {
        Scanner userInput = askQuestion("Number of years (1 - 30): ");

        byte period = userInput.nextByte();

        if(period < 1 || period > 30) {
            System.out.println("Please enter a valid number of years!");
            return getPeriod();
        }
        return period;
    }

    public static double getMonthlyPayment(int principal, float interestRate, byte period) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = interestRate / MONTHS_IN_YEAR / PERCENT;

        int numberOfPayments = period * MONTHS_IN_YEAR;

        return principal * (monthlyInterest * Math.pow(1 +  monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest,  numberOfPayments) - 1);
    }

    public static void printMonthlyPayment(double mortgage) {
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("---> Your monthly fee is: " + mortgageFormatted + " <---");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println();
    }
}
