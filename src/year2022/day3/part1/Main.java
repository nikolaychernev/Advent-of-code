package year2022.day3.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        while (true) {
            String line = reader.readLine();

            if (line.equals("")) {
                break;
            }

            char[] sackOne = line.substring(0, line.length() / 2).toCharArray();
            char[] sackTwo = line.substring(line.length() / 2).toCharArray();

            Set<Character> sackErrors = new HashSet<>();

            for (char itemOne : sackOne) {
                if (sackErrors.contains(itemOne)) {
                    continue;
                }

                for (char itemTwo : sackTwo) {
                    if (itemOne == itemTwo) {
                        sum += getItemPriority(itemOne);
                        sackErrors.add(itemOne);
                        break;
                    }
                }
            }
        }

        System.out.println(sum);
    }

    public static int getItemPriority(char c) {
        if (Character.isUpperCase(c)) {
            return c - 64 + 26;
        } else {
            return c - 96;
        }
    }
}
