public class Main {
    public static void SolveHanoi(int n, char source, char auxilary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        SolveHanoi(n - 1, source, destination, auxilary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        SolveHanoi(n - 1, auxilary, source, destination);
    }

    public static void main(String[] args) {
        int numDisks = 4;
        System.out.println("Towers of Hanoi solution for " + numDisks + " disks");
        SolveHanoi(numDisks, 'A', 'B', 'C');
    }
}
