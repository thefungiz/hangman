package thefungiz.hangman;

import java.util.Scanner;

class InputHelper {
  static char getCharInput() {
    Scanner scanner = new Scanner(System.in);
    Character input = null;
    while (input == null) {
      System.out.println("Please select a character: ");
      String line = scanner.nextLine();
      if (line != null && line.length() == 1) {
        input = line.charAt(0);
      }
    }
    return input;
  }
}