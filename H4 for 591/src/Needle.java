import java.util.*;

public class Needle {

    private Random generator;
    public Needle() {
        generator = new Random();
    }

    public double runExperiment(int totalDrops) {
        int hits = 0;
        for (int i = 0; i < totalDrops; i++) {
            double y_low = generator.nextDouble() * 2;
            double alpha = generator.nextDouble() * 180;
            double radians = Math.toRadians(alpha);
            double y_high = y_low + Math.sin(radians);
            if (y_high >= 2) {
                hits++;
            }
        }
        return (double) totalDrops / hits;
    }
}

