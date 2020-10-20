package thefungiz.hangman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuessingWordTest {
  private GuessingWord underTest;
  private String inputString = "hedgehog";

  @Before
  public void setup() {
    underTest = new GuessingWord(inputString);
  }

  @Test
  public void ensurePrettyPrintUnderscoresDisplayCorrectly() {
    assertEquals(" _ _ _ _ _ _ _ _", underTest.getPrettyPrint());
  }

  @Test
  public void ensurePrettyPrintSelectedLettersDisplayCorrectly() {
    underTest.guess('h');
    assertEquals(" h _ _ _ _ h _ _", underTest.getPrettyPrint());
  }

  @Test
  public void ensurePrettyPrintIncorrectLettersDisplayCorrectly() {
    underTest.guess('a');
    assertEquals(" _ _ _ _ _ _ _ _", underTest.getPrettyPrint());
  }

  @Test
  public void ensureIsGuessedIsFalseToStart() {
    assertFalse(underTest.isGuessed());
  }

  @Test
  public void ensureIsGuessedIsTrueAfterGuess() {
    underTest.guess('h');
    underTest.guess('e');
    underTest.guess('d');
    underTest.guess('g');
    underTest.guess('o');
    underTest.guess('g');
    assertTrue(underTest.isGuessed());
  }
}