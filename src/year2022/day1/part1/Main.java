package year2022.day1.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int currentElveCaloriesSum = 0;
        int maxElveCaloriesSum = Integer.MIN_VALUE;

        while (true) {
            String currentLine = reader.readLine();

            if (currentLine.equals("") || currentLine.equals("end")) {
                maxElveCaloriesSum = Math.max(currentElveCaloriesSum, maxElveCaloriesSum);
                currentElveCaloriesSum = 0;

                if (currentLine.equals("end")) {
                    break;
                }
            } else {
                currentElveCaloriesSum += Integer.parseInt(currentLine);
            }
        }

        System.out.println(maxElveCaloriesSum);
    }
}
