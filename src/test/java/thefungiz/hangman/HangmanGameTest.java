package thefungiz.hangman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HangmanGameTest {

  HangmanGame underTest;
  String testWord = "hedgehog";

  @Before
  public void setup() {
    underTest = new HangmanGame(testWord);
  }

  @Test
  public void ensureIsRunningToStart() {
    assertTrue(underTest.isRunning());
  }

  @Test
  public void ensureIsRunningFalseWhenOutOfGuesses() {
    underTest.guess('a');
    underTest.guess('a');
    underTest.guess('a');
    underTest.guess('a');
    underTest.guess('a');
    underTest.guess('a');
    underTest.guess('a');
    assertFalse(underTest.isRunning());
  }

}