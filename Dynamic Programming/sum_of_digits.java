import java.util.*;

public class sum_of_digits {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // taking the input number

        scn.close();

        int sum = 0;
        while(n != 0) { // tilll the number is non-zero
            int r = n % 10; // obtaining the last digit of the number
            sum += r; // adding it to the sum
            n /= 10; // decrease the number
        }

        System.out.println(sum);
    }
}
