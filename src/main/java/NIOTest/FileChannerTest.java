package NIOTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created on 2018/3/11.
 *
 * @author qiyun
 */
public class FileChannerTest {
  public static void main(String args[]) {
    try {
      File file = new File("in.txt");
      FileChannel inChannel = new FileInputStream(file).getChannel();
      inChannel.getClass();
      FileChannel outChannel = new FileOutputStream("out.txt").getChannel();
      MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
      Charset charset = Charset.forName("GBK");
      System.out.println("输出channel:"+outChannel.write(buffer));
      buffer.clear();
      CharsetDecoder decoder = charset.newDecoder();
      CharBuffer charBuffer = decoder.decode(buffer);
      System.out.println("解码后的buffer:"+buffer);
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
