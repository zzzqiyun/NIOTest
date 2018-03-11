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
 *获取当前java支持的所有字符集
 * @author qiyun
 */
public class CharsetTest {
  public static void main(String args[])throws Exception{
    SortedMap<String,Charset> sortedMap = Charset.availableCharsets();
    for (String alias:sortedMap.keySet() ) {
      System.out.println(alias+"--------->"+ sortedMap.get(alias));
    }
//知道charset别名后，就可以利用反射来创建charset对象
    Charset cs = Charset.forName("x-PCK");
    Charset csCn = Charset.forName("GBK");
    //获取csCn对应的编码器和解码器
    CharsetEncoder csCnEncoder = csCn.newEncoder();
    CharsetDecoder csCnDecoder = csCn.newDecoder();
    CharBuffer cb = CharBuffer.allocate(8);
    cb.put("你");
    cb.put("好");
    cb.flip();
    ByteBuffer bf = csCnEncoder.encode(cb);
    System.out.println("字节输出：");
    for(int i=0;i<bf.capacity();i++){
      System.out.print(bf.get(i)+" ");
    }
    CharBuffer cf = csCn.decode(bf);
    System.out.println("\n"+"字符输出："+cf);
  }
}
