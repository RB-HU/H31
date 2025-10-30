public class PositiveInteger {
    private int num;
    public PositiveInteger(int number){
        num = number;
    }

    public boolean isPerfect() {
        if (num <= 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public boolean isAbundant() {
        if (num <= 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum > num;
    }
    public boolean isNarcissistic() {
        if (num < 0) {
            return false;
        }

        String numStr = String.valueOf(num);
        int n = numStr.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            int p = 1;
            for (int j = 0; j < n; j++) {
                p *= digit;
            }
            sum += p;
        }

        return sum == num;
    }
}
