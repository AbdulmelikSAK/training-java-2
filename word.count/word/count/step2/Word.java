package word.count.step2;

public class Word {
  private char[] chars;
  private int nchars;
  public int noccurrences;
  
  public Word() {
	  chars = new char[0];
	  nchars=chars.length;
	  noccurrences=0;
  }
  
  public Word(char[] chars) {
	  nchars=chars.length;
	  this.chars = new char[nchars];
	  System.arraycopy(chars, 0, this.chars, 0, nchars);
	  noccurrences=0;
  }
  
  public Word(Word c) {
	  this(c.chars);
  }
  
  public String toString() {
    return new String(chars,0,nchars);
  }

  public void add(char c) {
	  nchars=chars.length+1;
	  char[] tableau = chars;
	  this.chars = new char[nchars];
	  System.arraycopy(tableau, 0, this.chars, 0, nchars-1);
	  this.chars[nchars-1]=c;
  }
  
  public boolean equals(Word w) {
    if (nchars!=w.nchars)
      return false;
    for (int i=0;i<nchars;i++)
      if (chars[i]==w.chars[i])
        return true;
    return false;
  }
}
