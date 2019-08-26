package word.count.step2;

import java.io.IOException;
import java.io.InputStream;

public class WordCount {

  public int charCount;
  public int wordCount;
  public int lineCount;

  private Aggregator aggregator;
  private InputStream is;
  private UTF8Reader reader;
  private Vocabulary vocabulary;
  
  public WordCount(Aggregator aggregator, InputStream is) {
    this.aggregator = aggregator;
    this.is = is;
    this.vocabulary = new Vocabulary();
    this.reader = new UTF8Reader(is);
  }

  public Vocabulary getVocabulary() {
    return vocabulary;
  }

  public void parse() throws IOException {
	  Word w = null;
	  char space = ' ';
	  char sl = '\n';
	  char c;
	  int r;	
	  charCount=0;
	  wordCount=0;
	  lineCount=0;
	  r = reader.read();
	  char charactere=(char) r;
	  while ( r!=(-1)) {
		 c = (char)r;
		 
		 if (c == sl) {
			 if (charactere != sl && charactere != space) {
				 wordCount++;
				 if (aggregator != null)  aggregator.wordCount++;
			 }
			 lineCount++;
			 if (aggregator != null)  aggregator.lineCount++;
			 if (w!=null) {
				 vocabulary.add(w);
				 aggregator.vocabulary.add(w);
			 }
		     w = null;

		 }
		 else if (c == space) {
			 if (charactere != space && charactere != sl) {
				 wordCount++;
				 if (aggregator != null)  aggregator.wordCount++;
			 }
			 if (w!=null) {
				 vocabulary.add(w);
				 aggregator.vocabulary.add(w);
			 }
		     w = null;

		 }
		 else {
			 if (w==null) {
				 w = new Word();
			 }
			 w.add(c);
		 }
		 
		 
		 charCount++;
		 if (aggregator != null) { aggregator.charCount++;}
		 charactere = c;
		 r = reader.read();
	  
	  if (charactere != sl && charactere != space) {
		  wordCount++;
		  if (aggregator != null)  aggregator.wordCount++;
	  }
  }

}
}