package streams.step3;

import java.io.EOFException;

public class DataOutputStream {

  OutputStream is;

  /**
   * Constructs a data output stream, <br>
   * aggregating (wrapping) the given output stream.
   * 
   * @param is
   */
  DataOutputStream(OutputStream is) {
    this.is = is;
  }

  /**
   * Write the given character in the aggregated output stream. <br>
   * It uses two bytes of the output stream, since a character is a unicode in
   * Java, hence it is a 16bit quantity (2 bytes).
   * 
   * @param s
   * @throws EOFException
   */
  public void writeChar(char c) throws EOFException {
    byte b1 = (byte) (c >> 8);
    byte b2 = (byte) (c);
    is.write(b1);
    is.write(b2);
  }

  /**
   * Write the given short in the aggregated output stream. <br>
   * It uses two bytes of the output stream, since a short in Java is 16bit
   * quantity (2 bytes).
   * 
   * @param s
   * @throws EOFException
   */
  public void writeShort(short s) throws EOFException {
	  byte b1 = (byte) (s >> 8) ;
	    byte b2 = (byte) (s);
	    is.write(b1);
	    is.write(b2);
  }

  /**
   * Write the given byte in the aggregated output stream.
   * 
   * @param b
   * @throws EOFException
   */
  public void writeByte(byte b) throws EOFException {
    is.write(b);
  }

}
