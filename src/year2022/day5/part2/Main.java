package year2022.day5.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Deque<Character>> indexContainersMap = new LinkedHashMap<>();
        boolean readContainers = true;

        while (true) {
            String line = reader.readLine();

            if (line.equals("")) {
                if (readContainers) {
                    readContainers = false;
                    continue;
                } else {
                    break;
                }
            }

            if (readContainers) {
                char[] elements = line.toCharArray();
                int currentRowIndex = 0;

                for (int i = 1; i < elements.length; i += 4) {
                    char container = elements[i];

                    if (Character.isDigit(container)) {
                        break;
                    }

                    indexContainersMap.putIfAbsent(currentRowIndex, new ArrayDeque<>());

                    if (container != ' ') {
                        indexContainersMap.get(currentRowIndex).addLast(container);
                    }

                    currentRowIndex++;
                }
            } else {
                String[] command = line.split(" ");

                int containersToMove = Integer.parseInt(command[1]);
                int startPosition = Integer.parseInt(command[3]);
                int endPosition = Integer.parseInt(command[5]);

                Deque<Character> containers = new ArrayDeque<>();

                for (int i = 0; i < containersToMove; i++) {
                    char container = indexContainersMap.get(startPosition - 1).removeFirst();
                    containers.addFirst(container);
                }

                for (Character container : containers) {
                    indexContainersMap.get(endPosition - 1).addFirst(container);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (Deque<Character> containers : indexContainersMap.values()) {
            result.append(containers.getFirst());
        }

        System.out.println(result);
    }
}
