import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        selectProgram();
    }

    public static void selectProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which Program would you like to run?  Enter the corresponding #:");
        System.out.println("1: FizzBuzz");
        System.out.println("2: Mortgage Calculator");
        System.out.print("Program #: ");
        byte selectedProgram = scanner.nextByte();

        switch (selectedProgram) {
            case 1: {
                System.out.println("FizzBuzz it is!");
                FizzBuzz fizzBuzz = new FizzBuzz();
                String result = fizzBuzz.getFizzBuzz();
                System.out.println(result);
                break;
            }
            case 2: {
                System.out.println("Let's calculate your monthly payment...");
                MortgageCalculator mortgageCalculator = new MortgageCalculator();
                mortgageCalculator.getMortgageAmount();
                break;
            }
            default: {
                System.out.println("Please select a valid program!");
                selectProgram();
            }
        }
    }
}
