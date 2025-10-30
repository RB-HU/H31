public class QuadraticEquation{

        double a;
        double b;
        double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a=a;
        this.b=b;
        this.c=c;}

        public double evaluate(double x) {
            return a * x * x + b * x + c;
        }


        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }

        public double getC() {
            return c;
        }


        public static void main(String[] args) {
            QuadraticEquation qe = new QuadraticEquation(3.0, 4.0, -2.0);


            System.out.println(qe.getA());

            double output = qe.evaluate(2.0);
            System.out.println(output);
        }
}