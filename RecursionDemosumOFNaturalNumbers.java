class RecursionDemoSumOfNaturalNumbers {
    static int SumOfNaturalNumbers(int n) {
        if (n == 0) {
            return 0;  // Correct base case
        } else {
            return n + SumOfNaturalNumbers(n - 1);  // Recursive call with addition
        }
    }

    public static void main(String[] args) {
        int number = 10;
        int result = SumOfNaturalNumbers(number);
        System.out.println("Sum of first " + number + " natural numbers is " + result);
    }
}