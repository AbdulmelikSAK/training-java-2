package streams.step3;

import java.io.EOFException;

public class StreamsStep3 {

  static public void main(String[] args) throws EOFException {
    
    System.out.println("StreamStep3...");
    OutputStream os = new OutputStream(32);
    DataOutputStream dos = new DataOutputStream(os);
    
    String s = "HelloWorld";
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++)
      dos.writeChar(chars[i]);
    
    InputStream is = new InputStream(os);
    DataInputStream dis = new DataInputStream(is);
    
    for (int i = 0; i < chars.length; i++)
      System.out.printf("%c ",dis.readChar());
    System.out.println();

    System.out.println("That's all folks.");
    System.exit(0);
  }

}
