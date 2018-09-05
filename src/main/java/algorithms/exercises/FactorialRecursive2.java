package algorithms.exercises;

public class FactorialRecursive2 {
    public int calculateFactorial(int num) throws Exception {
        if (num < 0) {
            throw new Exception("Negative number entered");
        }
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * calculateFactorial(num - 1);
        }
    }
}
