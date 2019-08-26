package word.count.step3;


public class Vocabulary {

  /*
   * The number of buckets in this vocabulary.
   * Notice that we have a power of two,
   * shifting left the hexadecimal value 0x01
   * by 8, we get 0x100, which is 256 decimal.
   */
  static final int NBUCKETS = (0x01 << 8);

  private Bucket buckets[];
  private Word[] words;
  private int nwords;
  private int nadds;

  public Vocabulary() {
	  buckets = new Bucket[NBUCKETS];
	  words = new Word[0];
	  nwords=words.length;
	  nadds=0;
  }

  /**
   * Search for a word, efficiently, using the hash of the given word to choose
   * the bucket in which to lookup if the word is already known.
   * 
   * @param word
   * @return
   */
  public Word find(Word word) {
	  long start = System.nanoTime();
	    try {
	    	int bno = word.hashCode() % buckets.length;
	    	if (bno < 0) bno = -bno;
	    	Bucket bucket = buckets[bno];
	    	if (bucket == null) { return null;}
	    	return bucket.find(word);
	       
	    } finally {
	      long end = System.nanoTime();
	      Counters.Vocabulary_find_count++;
	      Counters.Vocabulary_find_elapsed += (end - start);
	    }
  }

  /**
   * Adds a word if it is not already known. <br>
   * Relies on the find method to determine if the given word is known or not.
   * 
   * @param word
   * @return
   */
  public Word add(Word word) {
	  long start = System.nanoTime();
	  try {
		  if (find(word) == null) {
			  int bno = word.hashCode() % buckets.length;
		      if (bno < 0) bno = -bno;
		      Bucket bucket = buckets[bno];
		      if (bucket == null) {
		    	  bucket = buckets[bno] = new Bucket();
		      }
		      bucket.add(word);
			  nadds++;
			  return word;
		  }
		  return null;
	  }
	  finally {
		  long end = System.nanoTime();
		  Counters.Vocabulary_add_count++;
		  Counters.Vocabulary_add_elapsed += (end - start);
	  }
  }

  /**
   * Returns the array of all known words by this vocabulary.
   */
  public Word[] getWords() {
    int copyLen = getWordCount();
    Word[] copy = new Word[copyLen];
    int offset = 0;
    for (int i = 0; i < buckets.length; i++) {
      int n = buckets[i].getWordCount();
      System.arraycopy(buckets[i].getWords(), 0, copy, offset, n);
      offset += n;
    }
    return copy;
  }

  /**
   * Compute the number of known words in this vocabulary.
   */
  public int getWordCount() {
    int count = 0;
    for (int i = 0; i < buckets.length; i++)
    	if (buckets[i]!= null) {
    		count += buckets[i].getWordCount();
    	}
    return count;
  }

  /**
   * Builds the array of the top most frequently used words in the text that was
   * parsed.
   * 
   * @param n:
   *          number of desired words
   * @return
   */
  public Word[] mostFrequentWords(int n) {
    if (n > nwords)
      n = nwords;
    Word mfw[] = new Word[n];
    for (int i = 0; i < buckets.length; i++) {
      if (buckets[i] != null) {
    	  buckets[i].mostFrequentWords(mfw);
      }
    }
    return mfw;
  }

}
