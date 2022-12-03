package year2022.day2.part2;

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
            Outcome outcome = Outcome.readOutcome(shapes[1]);

            Shape myShape = elfShape.readOtherShape(outcome);
            totalScore += myShape.calculateScore(elfShape);
        }

        System.out.println(totalScore);
    }

    private enum Shape {
        ROCK(1, "SCISSORS", "PAPER"),
        PAPER(2, "ROCK", "SCISSORS"),
        SCISSORS(3, "PAPER", "ROCK");

        private final int points;
        private final String greaterThan;
        private final String lesserThan;

        Shape(int points, String greaterThan, String lesserThan) {
            this.points = points;
            this.greaterThan = greaterThan;
            this.lesserThan = lesserThan;
        }

        public static Shape readShape(String input) {
            switch (input) {
                case "A":
                    return ROCK;
                case "B":
                    return PAPER;
                case "C":
                    return SCISSORS;
                default:
                    return ROCK;
            }
        }

        public Shape readOtherShape(Outcome outcome) {
            switch (outcome) {
                case DRAW:
                    return this;
                case WIN:
                    return Shape.valueOf(this.greaterThan);
                case LOSE:
                    return Shape.valueOf(this.lesserThan);
                default:
                    return this;
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

    private enum Outcome {
        WIN, LOSE, DRAW;

        public static Outcome readOutcome(String input) {
            switch (input) {
                case "Z":
                    return LOSE;
                case "Y":
                    return DRAW;
                case "X":
                    return WIN;
                default:
                    return WIN;
            }
        }
    }
}
