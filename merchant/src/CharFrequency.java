public enum CharFrequency {
  FREQI('I', "IIII"),
  FREQX('X', "XXXX"),
  FREQC('C', "CCCC"),
  FREQM('M', "MMMM");
  private char freqChar;
  private String freqString;

  CharFrequency(char freqChar, String freqString) {
    this.freqChar = freqChar;
    this.freqString = freqString;
  }

  public char getFreqChar() {
    return freqChar;
  }

  public String getFreqString() {
    return freqString;
  }

  public static String getCharFrequency(char character) {
    for (CharFrequency charFrequency : CharFrequency.values()) {
      if (charFrequency.getFreqChar() == character) {
        return charFrequency.getFreqString();
      }
    }

    return null;
  }
}
