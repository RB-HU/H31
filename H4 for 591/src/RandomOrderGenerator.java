import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class RandomOrderGenerator {

    public static int[] getRandomOrder(int outputLength) {
        List<Integer> range = new ArrayList<>();
        for (int i = 1; i <= outputLength; i++) {
            range.add(i);
        }
        Collections.shuffle(range);
        int[] outputArray = new int[outputLength];
        for (int i = 0; i < outputLength; i++) {
            outputArray[i] = range.get(i);
        }
        return outputArray;
    }

    public static void main(String[] args) {
        // Print the results of RandomOrderGenerator.getRandomOrder(10);
        // ten different times.

        for (int i = 0; i < 10; i++) {
            int[] randomOrder = RandomOrderGenerator.getRandomOrder(10);
            System.out.print("order " + (i + 1) + ": [ ");
            for (int j = 0; j < 10; j++) {
                System.out.print(randomOrder[j] + " ");
            }
            System.out.println("]");
        }
    }
}
