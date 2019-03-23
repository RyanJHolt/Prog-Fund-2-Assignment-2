package utils;

import java.util.Scanner;

/**
 * The type Scanner input.
 */
public class ScannerInput {

    /**
     * Read next int int.
     *
     * @param prompt the prompt
     * @return the int
     */
    public static int readNextInt(String prompt) {
        do {
            var scanner = new Scanner(System.in);
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.next());
            }
            catch (NumberFormatException e) {
                System.err.println("\tEnter a number please.");
            }
        }  while (true);
    }

    /**
     * Read next double double.
     *
     * @param prompt the prompt
     * @return the double
     */
    public static double readNextDouble(String prompt) {
        do {
            var scanner = new Scanner(System.in);
            try{
                System.out.print(prompt);
                return Double.parseDouble(scanner.next());
            }
            catch (NumberFormatException e) {
                System.err.println("\tEnter a number please.");
            }
        }  while (true);
    }

    /**
     * Valid next line string.
     *
     * @param prompt the prompt
     * @return the string
     */
    public static String validNextLine(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return input.nextLine();
    }

    /**
     * Valid next char char.
     *
     * @param prompt the prompt
     * @return the char
     */
    public static char validNextChar(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return input.next().charAt(0);
    }
}
