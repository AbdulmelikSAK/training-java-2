package streams.step2;

public class OutputStream {
  private byte[] buffer;
  private int position;

  /**
   * Constructs an output stream with an initial capacity
   * of the given number of bytes.
   * 
   * @param nbytes is the initial capacity in bytes
   */
  public OutputStream(int nbytes) {
    buffer = new byte[nbytes];
    position=0;
  }

  /**
   * @return the current size of this ouput stream,
   * that is, the number of bytes it contains.
   */
  int getSize() {
    return buffer.length;
  }
  
  /**
   * Returns the buffer, without making a copy.
   */
  public byte[] getBuffer() { 
    return buffer;
  }
  
  public void write(byte value) {
	  if (position == this.getSize()) {
		  byte[] buff = new byte[this.getSize()+1];
		  System.arraycopy(buffer, 0, buff, 0, this.getSize());
		  buffer=buff;
	  }
	  buffer[position++]=value;
  }
}
