package thefungiz.hangman;

import java.util.List;
import java.util.Random;

public class GameLoop {

  static List<String> wordBank = List.of("hedgehog", "wolves", "kitty", "mushroom", "hungry", "football");

  public static void main(String[] args) {
    HangmanGame hangmanGame = new HangmanGame(wordBank.get(new Random().nextInt(wordBank.size())));

    while (hangmanGame.isRunning()) {
      System.out.println(hangmanGame.display());
      System.out.println(hangmanGame.guess(InputHelper.getCharInput()));
    }
    System.out.println(hangmanGame.endGameDisplay());
  }
}
