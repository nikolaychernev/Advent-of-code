package year2022.day4.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPairs = 0;

        while (true) {
            String line = reader.readLine();

            if (line.equals("")) {
                break;
            }

            int elfOneStart = Integer.parseInt(line.split(",")[0].split("-")[0]);
            int elfOneEnd = Integer.parseInt(line.split(",")[0].split("-")[1]);
            int elfTwoStart = Integer.parseInt(line.split(",")[1].split("-")[0]);
            int elfTwoEnd = Integer.parseInt(line.split(",")[1].split("-")[1]);

            if (isOverlapping(elfOneStart, elfOneEnd, elfTwoStart, elfTwoEnd) ||
                    isOverlapping(elfTwoStart, elfTwoEnd, elfOneStart, elfOneEnd)) {
                numberOfPairs++;
            }
        }

        System.out.println(numberOfPairs);
    }

    private static boolean isOverlapping(int elfOneStart, int elfOneEnd, int elfTwoStart, int elfTwoEnd) {
        return elfOneStart <= elfTwoEnd && elfOneEnd >= elfTwoStart;
    }
}
