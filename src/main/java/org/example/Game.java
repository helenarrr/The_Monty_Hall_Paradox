package org.example;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Game {

    public static void main(String[] args) {
        Map<Integer, String> results = new HashMap<>();
        Random random = new Random();

        int wins = 0;
        int losses = 0;

        for (int i = 1; i <= 1000; i++) {
            int carDoor = random.nextInt(3); // Автомобиль находится за одной из трех дверей
            int playerChoice = random.nextInt(3); // Игрок выбирает дверь

            int doorShown;
            do {
                doorShown = random.nextInt(3);
            } while (doorShown == carDoor || doorShown == playerChoice); // Ведущий открывает одну из невыбранных дверей

            // Меняем выбор игрока
            int newChoice;
            do {
                newChoice = random.nextInt(3);
            } while (newChoice == playerChoice || newChoice == doorShown); // Игрок меняет выбор

            if (newChoice == carDoor) {
                results.put(i, "Победа!");
                wins++;
            } else {
                results.put(i, "Поражение ..");
                losses++;
            }
        }

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);

        System.out.println("Results:");
        for (Map.Entry<Integer, String> entry : results.entrySet()) {
            System.out.println("Step " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
