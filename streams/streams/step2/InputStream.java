package streams.step2;

import java.io.EOFException;

public class InputStream {
  private byte[] buffer;
  private int size;
  private int position;

  /**
   * Constructs an input stream from the given output stream
   */
  public InputStream(OutputStream s) {
    buffer = s.getBuffer();
    size = s.getSize();
  }

  /**
   * @return the size of this input stream, in bytes.
   */
  public int getSize() {
    return size;
  }  
  
  /**
   * Reads the next byte from this input stream. <br>
   * Notice that this suggests a notion of a current position, where to read
   * from. Of course, the current position needs to be advanced.
   * 
   * @return the read byte
   */
  public byte read() throws EOFException {
	  if (position > buffer.length-1 || Byte.valueOf(buffer[position])==null) {
		  throw new EOFException();
	  }
	  else {
		  return buffer[position++];
	  }
  }
  
}
