package streams.step1;

public class OutputStream {

	private byte[] buffer;
	private int position;
  /**
   * Constructs an output stream from an array of bytes
   * 
   * @param buff
   */
  public OutputStream(byte[] buff) {
    buffer = buff;
    position=0;
  }

  /**
   * Write a new byte to this output stream. <br>
   * Notice that this suggests a notion of a current position, where to write
   * the new byte. Of course, the current position needs to be advanced.
   */
  public void write(byte value) {
    buffer[position++]=value;
  }
}
