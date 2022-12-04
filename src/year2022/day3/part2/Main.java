package year2022.day3.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> currentGroupSacks = new ArrayList<>();
        int sum = 0;

        while (true) {
            String line = reader.readLine();

            if (line.equals("")) {
                break;
            }

            currentGroupSacks.add(line);

            if (currentGroupSacks.size() == 3) {
                char[] sackOne = currentGroupSacks.get(0).toCharArray();
                Set<Character> sackBadges = new HashSet<>();

                for (char itemOne : sackOne) {
                    if (sackBadges.contains(itemOne)) {
                        continue;
                    }

                    for (int i = 1; i < currentGroupSacks.size(); i++) {
                        char[] sackTwo = currentGroupSacks.get(i).toCharArray();
                        boolean match = false;

                        for (char itemTwo : sackTwo) {
                            if (itemOne == itemTwo) {
                                if (i == currentGroupSacks.size() - 1) {
                                    sum += getItemPriority(itemOne);
                                    sackBadges.add(itemOne);
                                }

                                match = true;
                                break;
                            }
                        }

                        if (!match) {
                            break;
                        }
                    }
                }

                currentGroupSacks = new ArrayList<>();
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
