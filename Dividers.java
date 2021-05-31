import java.util.Scanner;

public class Dividers{

    public static void find_the_sum_of_dividers(int startRange, int endRange){
        int numberWithMaxSumOfDividers = 0;
        long maxSumOfDeviders = 0;
        long currentSumOfDividers = 0;
        int dividersBound = 0;

        if (Integer.toString(endRange).length() > 2 && startRange < endRange - (endRange / 20)) {
            startRange = endRange - (endRange / 20);
        }

        for (int currentNumber = startRange; currentNumber <= endRange; currentNumber++) {
            if (currentNumber % 2 != 0) {
                continue;
            }
            currentSumOfDividers = 1 + currentNumber;
            dividersBound = (int)Math.round(Math.sqrt(currentNumber));

            // search for integer (deviders up to the pairwise dividers boundary)
            // and calculate sum
            for (int divider = 2; divider <= dividersBound; divider++) {
                if (currentNumber % divider == 0) {
                    currentSumOfDividers += divider;

                    if (divider != dividersBound || Math.sqrt(currentNumber) % 1 != 0) {
                        currentSumOfDividers += currentNumber / divider;
                    }
                }
            }

            // find the number with max sum of dividers
            if (currentSumOfDividers > maxSumOfDeviders) {
                maxSumOfDeviders = currentSumOfDividers;
                numberWithMaxSumOfDividers = currentNumber;
            }
            if (currentNumber % 1000000 == 0) {
                System.out.println(currentNumber);
            }
        }
        System.out.println("Number: " + numberWithMaxSumOfDividers + "| Sum of dividers: " + maxSumOfDeviders);

    }

    public static void main(String[] args){

        var scanner = new Scanner(System.in);
        System.out.println("Enter the range limits");

        int startValue = scanner.nextInt();
        int endValue = scanner.nextInt();

        find_the_sum_of_dividers(startValue, endValue);


    }
}
