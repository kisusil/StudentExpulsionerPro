package beer;

import java.util.Random;

public class Beer {

    private static Beer instance;


    private int amount;

    private Beer() {
        amount = new Random().nextInt(4);
    }

    public static Beer getInstance() {
        if(instance == null) {
            instance = new Beer();
        }
        return instance;
    }

    public String giveBeer() {
        if(amount > 0) {
            amount--;
            return "Student will be given a glass of beer instead of being expelled";
        } else {
            return "Student isn't going to be expelled, but there's no beer left";
        }
    }

    public int getAmount() {
        return amount;
    }
}
