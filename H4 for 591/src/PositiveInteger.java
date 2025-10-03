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

}
