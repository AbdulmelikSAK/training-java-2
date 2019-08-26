package word.count.step3;


class Bucket {
  
  static final int NWORDS = 16;

  private Word words[];
  private int nwords;
  private int nplace;

  Bucket() {
	  words = new Word[NWORDS];
	  nwords = 0;
	  nplace = NWORDS;
  }

  public Word find(Word word) {
	  
	  for (int i = 0; i < nwords; i++) {
		  if (words[i].equals(word)) {
			  return words[i];
		  }
	  }
	  return null;
	  }

  public void add(Word word) {
	  if (find(word) == null) {
		  if (nwords==nplace) {
			  Word[] tableau = words;
			  this.words = new Word[nplace+NWORDS];
			  System.arraycopy(tableau, 0, this.words, 0, nplace);
			  nplace=nplace+NWORDS;
		  }
		  this.words[nwords]=word;
		  nwords++;
	  }
  }

  public void mostFrequentWords(Word mfw[]) {
	  Word[] MFW = new Word[mfw.length];
	  System.arraycopy(mfw, 0, MFW, 0, mfw.length);
  }
  
  public int getWordCount() {
	  return nwords;
  }
  
  public Word[] getWords() {
	  Word[] words2 = new Word[nwords];
	  System.arraycopy(words2, 0, words, 0, nwords);
	  return words2;
  }

}