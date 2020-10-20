package thefungiz.hangman;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GuessingWord {
  List<GuessingLetter> guessingLetters;

  public GuessingWord(String word) {
    guessingLetters = word.chars().mapToObj(it -> new GuessingLetter((char)it)).collect(toList());
  }

  public boolean guess(char guess) {
    boolean guessedCorrectly = false;
    for (GuessingLetter guessingLetter : guessingLetters) {
      if (guessingLetter.getLetter() == guess) {
        guessedCorrectly = true;
        guessingLetter.setGuessed(true);
      }
    }
    return guessedCorrectly;
  }

  public boolean isGuessed() {
    return guessingLetters.stream().filter(it -> !it.isGuessed()).count() == 0L;
  }

  public String getPrettyPrint() {
    StringBuilder stringBuilder = new StringBuilder();
    guessingLetters.forEach(it -> stringBuilder.append(" " + (it.isGuessed() ? it.getLetter() : '_')));
    return stringBuilder.toString();
  }

  public String getRevealedWord() {
    StringBuilder stringBuilder = new StringBuilder();
    guessingLetters.forEach(it -> stringBuilder.append(it.getLetter()));
    return stringBuilder.toString();
  }
}
class GuessingLetter {
  private char letter;
  private boolean isGuessed;
  public GuessingLetter(char letter) {
    this.letter = letter;
  }
  public boolean isGuessed() {
    return isGuessed;
  }
  public void setGuessed(boolean isGuessed) {
    this.isGuessed = isGuessed;
  }
  public char getLetter() {
    return letter;
  }
}