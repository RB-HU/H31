public class QuadraticEquationZeroes {
    QuadraticEquation equation;

    public QuadraticEquationZeroes(QuadraticEquation equation) {
        this.equation = equation;
    }

    public double getSmallerSolution() {
        double a = equation.getA();
        double b = equation.getB();
        double c = equation.getC();
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return 0;
        }

        double sqrtDiscriminant = Math.sqrt(discriminant);
        double root1 = (-b - sqrtDiscriminant) / (2 * a);
        double root2 = (-b + sqrtDiscriminant) / (2 * a);
        return Math.min(root1, root2);
    }

    public double getLargerSolution() {
        double a = equation.getA();
        double b = equation.getB();
        double c = equation.getC();
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return 0;
        }

        double sqrtDiscriminant = Math.sqrt(discriminant);
        double root1 = (-b - sqrtDiscriminant) / (2 * a);
        double root2 = (-b + sqrtDiscriminant) / (2 * a);
        return Math.max(root1, root2);
    }
}

