package streams.step3;

import java.io.EOFException;

public class DataInputStream {

  InputStream is;

  /**
   * Construct a data input stream, <br>
   * aggregating (wrapping) the given input stream.
   * 
   * @param is
   */
  DataInputStream(InputStream is) {
    this.is = is;
  }

  /**
   * Read a character from the aggregated input stream.<br>
   * Reads two bytes from the input stream, since a character is a unicode in
   * Java, hence it is a 16bit quantity (2 bytes).
   * 
   * @return the character read
   * @throws EOFException
   */
  public char readChar() throws EOFException {
    byte b1 = (byte) is.read();
    byte b2 = (byte) is.read();
    int val;
    if (b1<0) {
		  val= ((256+b1)<<8);
	  }
	  else {
		  val = (b1 <<8);
	  }
	  if (b2<0) {
		  val += (256+b2);
	  }
	  else {
		  val += b2;
	  }
	  return (char) (val);
  }

  /**
   * Read a short from the aggregated input stream.<br>
   * Reads two bytes from the input stream, since a short in Java is a 16bit
   * quantity (2 bytes).
   * 
   * @return the short read
   * @throws EOFException
   */
  public short readShort() throws EOFException {
	  byte b1 = (byte) is.read();
	  byte b2 = (byte) is.read();
	  int val;
	    if (b1<0) {
			  val= ((256+b1)<<8);
		  }
		  else {
			  val =  (b1 <<8);
		  }
		  if (b2<0) {
			  val += (256+b2);
		  }
		  else {
			  val += b2;
		  }
		  return (short) (val);
  }

  /**
   * Read a byte from the aggregated input stream.<br>
   * 
   * @return the byte read
   * @throws EOFException
   */
  public byte readByte() throws EOFException {
    return is.read();
  }
}
