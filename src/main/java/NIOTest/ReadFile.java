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
        bbff.flip();//��limit����Ϊposition,position����Ϊ����û�����ݵ������ӡ�������������null��
        Charset charset = Charset.forName("GBK");
        CharsetDecoder decoder = charset.newDecoder();
        CharBuffer charBuffer = decoder.decode(bbff);
        System.out.println(charBuffer);
        bbff.clear();//��bbff��position����Ϊ0,Ϊ��һ�ζ�ȡ������׼��
      }
    }
  }
}
