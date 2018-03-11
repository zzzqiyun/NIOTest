package NIOTest;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created on 2018/3/11.
 *
 * @author qiyun
 */
public class ReadFile {
  public static void main(String args[])throws Exception{
    try(
            FileInputStream fis = new FileInputStream("in.txt");
            FileChannel fisChannel = fis.getChannel();
            ){
      ByteBuffer bbff = ByteBuffer.allocate(256);
      while(fisChannel.read(bbff)!= -1){
        bbff.flip();//将limit设置为position,position设置为（将没有数据的区域封印起来，避免读出null）
        Charset charset = Charset.forName("GBK");
        CharsetDecoder decoder = charset.newDecoder();
        CharBuffer charBuffer = decoder.decode(bbff);
        System.out.println(charBuffer);
        bbff.clear();//将bbff的position设置为0,为下一次读取数据做准备
      }
    }
  }
}
