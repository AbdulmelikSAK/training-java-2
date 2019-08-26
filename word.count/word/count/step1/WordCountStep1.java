package word.count.step1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class WordCountStep1 {
  
  public static void main(String[] args) throws Exception {
    WordCount wc;
    if (args.length==0) {
      System.out.println("Type whatever text, UTF-8 encode, and then Ctrl-D");
      System.out.println("If your terminal does not use UTfF-8 encoding,");
      System.out.println("You may test with the test files provided to you:");
      System.out.println("  test-small.utf8  and test-html.utf8 ");
      System.out.println("borrowed from Wikipedia on UTF8");
      System.out.println("  https://fr.wikipedia.org/wiki/UTF-8");
      wc = new WordCount(System.in);
      wc.parse();
      System.out.printf("Lines\tWords\tChars \n");
      System.out.printf("%d\t%d\t%d \n",wc.lineCount,wc.wordCount,wc.charCount);
    } else {
      int nlines=0,nwords=0,nchars=0;
      System.out.println("Word Counting on multiple files:");
      System.out.printf("\tLines\tWords\tChars \n");
      for (int i=0;i<args.length;i++) {
        String arg = args[i];
        File file = new File(arg);
        InputStream is = new FileInputStream(file);
        wc = new WordCount(is);
        wc.parse();
        nlines += wc.lineCount;
        nwords += wc.wordCount;
        nchars += wc.charCount;
        System.out.printf("\t%d\t%d\t%d\t%s\n",wc.lineCount,wc.wordCount,wc.charCount,arg);
      }
      System.out.println("Totals:");
      System.out.printf("\tLines\tWords\tChars \n");
      System.out.printf("\t%d\t%d\t%d \n",nlines,nwords,nchars);
    }
  }
}
