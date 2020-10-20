package thefungiz.hangman;

import java.util.List;

public class HangmanGame {
  private int totalGuesses;
  private int incorrectGuesses;
  private int allowedIncorrect;
  private GuessingWord guessingWord;
  private List<String> hangmanAnimation = List.of(
    "  +---+\n" +
    "  |   |\n" +
    "      |\n" +
    "      |\n" +
    "      |\n" +
    "      |\n" +
    "=========",
    "  +---+\n" +
      "  |   |\n" +
      "  O   |\n" +
      "      |\n" +
      "      |\n" +
      "      |\n" +
      "=========",
    "  +---+\n" +
      "  |   |\n" +
      "  O   |\n" +
      "  |   |\n" +
      "      |\n" +
      "      |\n" +
      "=========",
    "  +---+\n" +
      "  |   |\n" +
      "  O   |\n" +
      " /|   |\n" +
      "      |\n" +
      "      |\n" +
      "=========",
    "  +---+\n" +
      "  |   |\n" +
      "  O   |\n" +
      " /|\\  |\n" +
      "      |\n" +
      "      |\n" +
      "=========",
    "  +---+\n" +
      "  |   |\n" +
      "  O   |\n" +
      " /|\\  |\n" +
      " /    |\n" +
      "      |\n" +
      "=========",
    "  +---+\n" +
      "  |   |\n" +
      "  O   |\n" +
      " /|\\  |\n" +
      " / \\  |\n" +
      "      |\n" +
      "========="
    );

  public HangmanGame(String guessingWord) {
    this.guessingWord = new GuessingWord(guessingWord);
    totalGuesses = 0;
    incorrectGuesses = 0;
    allowedIncorrect = 6;
  }

  public String guess(char guess) {
    StringBuilder stringBuilder = new StringBuilder();
    if (guessingWord.guess(guess)) {
      stringBuilder.append("\nCorrect guess!");
    } else {
      stringBuilder.append(" \nSorry, that's incorrect");
      incorrectGuesses++;
    }
    totalGuesses++;
    return stringBuilder.toString();
  }

  public String display() {
    StringBuilder stringBuilder = new StringBuilder();
    if (totalGuesses == 0) {
      stringBuilder.append("\nWelcome to the hangman game!");
    }
    stringBuilder.append("\nTotal guesses: " + totalGuesses);
    stringBuilder.append("\nIncorrect guesses: " + incorrectGuesses);
    stringBuilder.append("\n" + hangmanAnimation.get(incorrectGuesses));
    stringBuilder.append("\n" + guessingWord.getPrettyPrint());
    return stringBuilder.toString();
  }

  public String endGameDisplay() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\n" + (guessingWord.isGuessed() ? "Congrats! You win!" : "Sorry, you lost!"));
    stringBuilder.append("\nGame stats: ");
    stringBuilder.append("\nThe word was: " + guessingWord.getRevealedWord());
    stringBuilder.append("\nTotal guesses: " + totalGuesses);
    stringBuilder.append("\nIncorrect guesses: " + incorrectGuesses);
    return stringBuilder.toString();
  }

  public boolean isRunning() {
    return incorrectGuesses < allowedIncorrect && !guessingWord.isGuessed();
  }
}
