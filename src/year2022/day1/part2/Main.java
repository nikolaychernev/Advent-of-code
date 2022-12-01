package year2022.day1.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> elveCaloriesMap = new HashMap<>();
        elveCaloriesMap.put(1, 0);
        int currentElveNumber = 1;

        while (true) {
            String currentLine = reader.readLine();

            if (currentLine.equals("") || currentLine.equals("end")) {
                currentElveNumber++;
                elveCaloriesMap.put(currentElveNumber, 0);

                if (currentLine.equals("end")) {
                    break;
                }
            } else {
                elveCaloriesMap.put(currentElveNumber, elveCaloriesMap.get(currentElveNumber) + Integer.parseInt(currentLine));
            }
        }

        int topThreeElvesCaloriesSum = elveCaloriesMap.values().stream()
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .limit(3)
                .reduce(0, Integer::sum);

        System.out.println(topThreeElvesCaloriesSum);
    }
}
