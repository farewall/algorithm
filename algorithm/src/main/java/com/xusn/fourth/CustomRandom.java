package com.xusn.fourth;


import java.util.Random;

public class CustomRandom {
    public static int random7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }

    public static int random10() {
        while (true) {
            int a = random7(); // [1,7]
            int b = random7(); // [1,7]
            int num = (a-1) * 7 + b; // [1, 49]
            if (num <= 40) {
                return (num - 1) % 10 + 1;
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
