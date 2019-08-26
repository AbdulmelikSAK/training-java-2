package word.count.step1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;


public class WordCount {

  public int charCount;
  public int wordCount;
  public int lineCount;
  private InputStream is;
  private UTF8Reader reader;
  
  /**
   * Construct a word count, aggregating the given input
   * stream.
   * @param is
   */
  public WordCount(InputStream is) {
    this.is = is;
    reader = new UTF8Reader(is);
  }
  
  /**
   * Reads from the aggregated input stream, parsing
   * the read characters in order to count the number
   * of characters, words, and lines.
   * @throws IOException
   */
  public void parse() throws IOException {
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
			 }
			 lineCount++;
		 }
		 if (c == space) {
			 if (charactere != space && charactere != sl) {
				 wordCount++;
			 }
		 }
		 charCount++;
		 charactere = c;
		 r = reader.read();
	  }
	  if (charactere != sl && charactere != space) {
		  wordCount++;
	  }
  }
}
