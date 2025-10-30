import java.util.Scanner;
public class QuadraticEquationRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();
        scanner.close();
        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        QuadraticEquationZeroes zeroes = new QuadraticEquationZeroes(equation);
        double smallerSolution = zeroes.getSmallerSolution();
        double largerSolution = zeroes.getLargerSolution();
        System.out.println(a + "x^2 + " + b + "x + " + c +
                " has solutions " + smallerSolution + " and " + largerSolution);
    }
}
