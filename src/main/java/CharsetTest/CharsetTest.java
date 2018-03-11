package CharsetTest;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created on 2018/3/11.
 *
 *��ȡ��ǰjava֧�ֵ������ַ���
 * @author qiyun
 */
public class CharsetTest {
  public static void main(String args[])throws Exception{
    SortedMap<String,Charset> sortedMap = Charset.availableCharsets();
    for (String alias:sortedMap.keySet() ) {
      System.out.println(alias+"--------->"+ sortedMap.get(alias));
    }
//֪��charset�����󣬾Ϳ������÷���������charset����
    Charset cs = Charset.forName("x-PCK");
    Charset csCn = Charset.forName("GBK");
    //��ȡcsCn��Ӧ�ı������ͽ�����
    CharsetEncoder csCnEncoder = csCn.newEncoder();
    CharsetDecoder csCnDecoder = csCn.newDecoder();
    CharBuffer cb = CharBuffer.allocate(8);
    cb.put("��");
    cb.put("��");
    cb.flip();
    ByteBuffer bf = csCnEncoder.encode(cb);
    System.out.println("�ֽ������");
    for(int i=0;i<bf.capacity();i++){
      System.out.print(bf.get(i)+" ");
    }
    CharBuffer cf = csCn.decode(bf);
    System.out.println("\n"+"�ַ������"+cf);
  }
}
