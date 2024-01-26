import java.math.BigInteger;
import java.util.Scanner;

public class QuestionThreeAndFour {

    public static void main(String[] args) {
        BigInteger[] arr = generateNotFibonacciSequence(12);
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.println("");
        int a = findPosition(BigInteger.valueOf(50000000), arr);
        System.out.println(a);
    }
    public static BigInteger[] generateNotFibonacciSequence(int numTerms) {
        BigInteger[] sequence = new BigInteger[numTerms];

        // Initial values
        sequence[0] = new BigInteger("0");
        sequence[1] = new BigInteger("1");

        // Generate the NotFibonacci sequence
        for (int i = 2; i < numTerms; i++) {
            BigInteger iMinusOne = sequence[i-1];
            BigInteger three = BigInteger.valueOf(3);
            BigInteger two = BigInteger.valueOf(2);
            BigInteger iMinusTwo = sequence[i-2];
            BigInteger firstPart = three.multiply(iMinusOne);
            BigInteger secondPart = two.multiply(iMinusTwo);

            sequence[i] = firstPart.add(secondPart);
        }

        return sequence;
    }
    public static int findPosition(BigInteger input, BigInteger[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            if (input.equals(sequence[i])) {
                return i;
            } else {
                if (i != sequence.length-1 && sequence[i+1].compareTo(input) == 1) {
                    BigInteger diffOne = sequence[i+1].subtract(input);
                    BigInteger diffTwo = input.subtract(sequence[i]);
                    if (diffOne.compareTo(diffTwo) == 1) {
                        return i;
                    } else {
                        return i+1;
                    }
                }
            }
        }
        return sequence.length-1;
    }
}


