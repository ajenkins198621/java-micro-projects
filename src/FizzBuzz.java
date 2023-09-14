import java.util.Scanner;

public class FizzBuzz {

    public String getFizzBuzz() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your Number: ");

        int num = scanner.nextInt();

        if(num % 5 == 0 && num % 3 == 0)  return "FizzBuzz";

        else if(num % 5 == 0) return "Fizz";

        else if(num % 3 == 0) return "Buzz";

        return Integer.toString(num);

    }
}
