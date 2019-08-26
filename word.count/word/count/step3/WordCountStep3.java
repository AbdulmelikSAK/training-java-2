package word.count.step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class WordCountStep3 {

  static final int NTOP = 30;

  public static void main(String[] args) throws Exception {
    WordCount wc;
    if (args.length == 0) {
      wc = new WordCount(null,System.in);
      wc.parse();
      echo(wc);
    } else {
      Aggregator aggregator = new Aggregator();
      for (int i = 0; i < args.length; i++) {
        String arg = args[i];
        File file = new File(arg);
        InputStream is = new FileInputStream(file);
        wc = new WordCount(aggregator,is);
        wc.parse();
        System.out.printf("\t%d\t%d\t%d\t%s\n", wc.lineCount, wc.wordCount, wc.charCount,arg);
      }
      echo(aggregator);
    }
    Counters.echo();
  }
  
  public static void echo(WordCount wc) {

    System.out.printf("\t%d\t%d\t%d \n", 
        wc.lineCount, wc.wordCount, wc.charCount);
    
    Vocabulary vocab = wc.getVocabulary();
    Word[] mfw = vocab.mostFrequentWords(NTOP);
    System.out.printf("Found %d different words among %d words \n", 
        vocab.getWordCount(), wc.wordCount);
    for (int j = 0; j < mfw.length && mfw[j] != null; j++)
      System.out.printf("\t%d\t%s \n", mfw[j].noccurrences, mfw[j].toString());
    
  }
  
  public static void echo(Aggregator aggregator) {
    int nwords = aggregator.vocabulary.getWordCount();
    Word[] mfw = aggregator.vocabulary.mostFrequentWords(NTOP);
    System.out.printf("Found %d different words among %d words \n", 
        nwords, aggregator.wordCount);
    for (int j = 0; j < mfw.length && mfw[j] != null; j++)
      System.out.printf("\t%d\t%s \n", 
          mfw[j].noccurrences, 
          mfw[j].toString());
    System.out.printf("\t%d\t%d\t%d\n", 
        aggregator.lineCount, aggregator.wordCount, aggregator.charCount);
  }

}
