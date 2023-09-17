import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public void getMortgageAmount() {
        int principal = getPrincipal();
        float interestRate = getInterestRate();
        byte period = getPeriod();
        getMonthlyPayment(principal, interestRate, period);
        Main.selectProgram();
    }

    public static int getPrincipal() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Your Principal ($1k - $1M): ");

        int principal = userInput.nextInt();

        if(principal < 1_000 || principal > 1_000_000) {
            System.out.println("Please select a principal amount between $1,000 and $1,000,000");
            return getPrincipal();
        }

        return principal;
    }

    public static float getInterestRate() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Annual Interest Rate (0% < Int < 30%): ");

        float interestRate = userInput.nextFloat();

        if(interestRate < 0 || interestRate >= 30) {
            System.out.println("Please enter an interest rate between 0% and 30%");
            return getInterestRate();
        }

        return interestRate;
    }

    public static byte getPeriod() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Number of years (1 - 30): ");

        byte period = userInput.nextByte();

        if(period < 1 || period > 30) {
            System.out.println("Please enter a valid number of years!");
            return getPeriod();
        }
        return period;
    }

    public static void getMonthlyPayment(int principal, float interestRate, byte period) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = interestRate / MONTHS_IN_YEAR / PERCENT;

        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgage = principal * (monthlyInterest * Math.pow(1 +  monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest,  numberOfPayments) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("---> Your monthly cost is: " + mortgageFormatted);
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println();
    }
}
