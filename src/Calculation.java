public class Calculation {
    public static void main(String[] args) {
        var calculator = new ShoppingCalculator();
        System.out.println(calculator.recalculate(1, 0.5));
        System.out.println(calculator.recalculate(2, 0.6));
        System.out.println(calculator.recalculate(2, 1));
    }
}

class ShoppingCalculator {
    int recalculate(int initial, double discount) {
        return (int) (1 / (1 - discount)) * initial;
    }
}