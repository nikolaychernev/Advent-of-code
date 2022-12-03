package year2022.day2.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int totalScore = 0;

        while (true) {
            String line = reader.readLine();

            if (line.equals("")) {
                break;
            }

            String[] shapes = line.split(" ");

            Shape elfShape = Shape.readShape(shapes[0]);
            Shape myShape = Shape.readShape(shapes[1]);

            totalScore += myShape.calculateScore(elfShape);
        }

        System.out.println(totalScore);
    }

    private enum Shape {
        ROCK(1, "SCISSORS"),
        PAPER(2, "ROCK"),
        SCISSORS(3, "PAPER");

        private final int points;
        private final String greaterThan;

        Shape(int points, String greaterThan) {
            this.points = points;
            this.greaterThan = greaterThan;
        }

        public static Shape readShape(String input) {
            switch (input) {
                case "A":
                case "X":
                    return ROCK;
                case "B":
                case "Y":
                    return PAPER;
                case "C":
                case "Z":
                    return SCISSORS;
                default:
                    return ROCK;
            }
        }

        public int calculateScore(Shape otherShape) {
            Shape greaterThan = Shape.valueOf(this.greaterThan);
            int roundOutcomeScore = this.points;

            if (this.equals(otherShape)) {
                roundOutcomeScore += 3;
            } else if (otherShape.equals(greaterThan)) {
                roundOutcomeScore += 6;
            }

            return roundOutcomeScore;
        }
    }
}
