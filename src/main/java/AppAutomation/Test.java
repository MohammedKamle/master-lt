package AppAutomation;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        String[] regions = {"ap", "eu", "us"};
        Random random = new Random();
        String randomRegion = regions[random.nextInt(regions.length)];

        // Print the random string
        System.out.println("Random region: " + randomRegion);
    }
}
