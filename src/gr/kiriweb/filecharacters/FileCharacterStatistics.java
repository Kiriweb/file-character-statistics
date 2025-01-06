package gr.kiriweb.filecharacters;

import java.io.*;
import java.util.Arrays;

/**
 * This program processes a text file to compute and display statistics about the frequency
 * of ASCII characters. Non-ASCII characters and whitespaces are ignored, and a message is
 * displayed for skipped non-ASCII characters. The program outputs statistics sorted by
 * character and by frequency.
 *
 * <p>Main Features:
 * <ul>
 *     <li>Reads characters from a text file named "input.txt".</li>
 *     <li>Counts the occurrences of ASCII characters (0–127).</li>
 *     <li>Ignores non-ASCII characters and prints a message for each one.</li>
 *     <li>Displays character statistics sorted by ASCII order and by frequency (descending).</li>
 *     <li>Handles empty files gracefully by notifying the user and exiting.</li>
 *     <li>Reports file-related errors, such as missing file or I/O issues, with user-friendly messages.</li>
 * </ul>
 * </p>
 *
 * <p>Usage:
 * Place a file named "input.txt" in the program's working directory (file-characters-statistics).
 * The file should contain text data.
 * The program outputs character frequency statistics to the console.</p>
 *
 * <p>Note:
 * Non-ASCII characters are not counted, and whitespaces are excluded from the statistics.</p>
 *
 * @author Kyriakos Koutsourelis
 */
public class FileCharacterStatistics {

    public static void main(String[] args) {
        // File to process
        File inputText = new File("input.txt");
        int[][] charStats = new int[128][2];

        // Initialize the charStats array
        for (int i = 0; i < 128; i++) {
            charStats[i][0] = i; // First column stores the ASCII value
            charStats[i][1] = 0; // Second column stores the count
        }

        // Read and process the file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputText))) {
            int character;
            while ((character = reader.read()) != -1) { // Read each character until end of file reader.read() = -1
                if (character < 128 && !Character.isWhitespace(character)) { // Ignore non ASCII and whitespaces
                    charStats[character][1]++; // Increment the count
                } else if (character > 128) { // If non ASCII char print message with that char
                    System.out.println("Character: " + (char) character + " is not ASCII so it is skipped.");
                }
            }
        } catch (FileNotFoundException e) { // In case file not found
            System.out.println("Error: The file 'input.txt' was not found. Please ensure it exists and try again.");
            return;
        } catch (IOException e) { // In case of an I/O error
            System.out.println("Error: An I/O error occurred while reading the file.");
            e.printStackTrace();
            return;
        }

        // Check if file has any ASCII character, if not print message and exit program
        if (isCharStatsEmpty(charStats)) {
            System.out.println("The file is empty!");
            return;
        }

        // Display statistics sorted by character
        System.out.println("Statistics Sorted by Character:");
        displayStatistics(charStats);

        // Display statistics sorted by frequency
        System.out.println("\nStatistics Sorted by Frequency:");
        Arrays.sort(charStats, (a, b) -> Integer.compare(b[1], a[1])); // Sort by count (descending)
        displayStatistics(charStats);
    }

    // Method to display statistics
    public static void displayStatistics(int[][] charStats) {
        for (int[] row : charStats) {
            if (row[1] > 0) { // Only display characters that appear in the file
                System.out.printf("Character: %c, Count: %d%n", row[0], row[1]);
            }
        }
    }

    // Method to check if the array has 0 amount of ASCII characters
    public static boolean isCharStatsEmpty(int[][] charStats) {
        for (int[] row : charStats) {
            if (row[1] > 0) {
                return false;
            }
        }
        return true;
    }
}