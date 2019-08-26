package word.count.step2;

public class Vocabulary {

  private Word[] words;
  private int nwords;
  private int nadds;
  public int charCount;
  public int wordCount;
  public int lineCount;

  public Vocabulary() {
	  words = new Word[0];
	  nwords=words.length;
	  nadds=0;
  }

  /**
   * @return the count of known words
   */
  public int getWordCount() {
	  return nwords;
  }

  /**
   * @return the known words
   */
  public Word[] getWords() {
	  Word[] tableau = new Word[nwords];
	  System.arraycopy(words, 0, tableau, 0, nwords);
	  return tableau;
  }

  /**
   * Returns the "n" words that were added to this
   * vocabulary the most frequently.
   * @return array of words
   */
  public Word[] mostFrequentWords(int n) {
	  Word[] mfw = new Word[n];
	  System.arraycopy(words, 0, mfw, 0, n);
	  return mfw;
  }

  /**
   * Determines if the given word is already known or not.
   * Two words are equals if the Word.equals(Word) method
   * returns true.
   * @param word
   * @return
   */
  public Word find(Word word) {
	  for (int i = 0; i < nwords; i++) {
		  if (words[i].equals(word)) {
			  return word;
		  }
	  }
	  return null;
  }

  /**
   * Adds a word only if it is not already known.
   * @param word
   * @return
   */
  public Word add(Word word) {
	  if (find(word) == null) {
		  nwords=words.length+1;
		  Word[] tableau = words;
		  this.words = new Word[nwords];
		  System.arraycopy(tableau, 0, this.words, 0, nwords-1);
		  this.words[nwords-1]=word;
		  nadds++;
		  return word;
	  }
	  return null;
	  
  }

  public void echo(int n) {
    if (n > nwords)
      n = nwords;
    Word[] mfw = mostFrequentWords(n);
    System.out.printf("Found %d different words among %d words \n", nwords, nadds);
    for (int j = 0; j < mfw.length && mfw[j] != null; j++)
      System.out.printf("\t%d\t%s \n", mfw[j].noccurrences, mfw[j].toString());
  }

}
