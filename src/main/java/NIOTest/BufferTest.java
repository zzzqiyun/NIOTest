package NIOTest;

import java.nio.CharBuffer;

/**
 * Created on 2018/3/11.
 *
 * @author qiyun
 */
public class BufferTest {
  public static void main(String args[]){
    CharBuffer cf = CharBuffer.allocate(8);
    System.out.println("初始capacty:"+cf.capacity());
    System.out.println("初始limit:"+cf.limit());
    System.out.println("初始mark:"+cf.mark());
    System.out.println("初始position："+cf.position());
    cf.put("a");
    cf.put("b");
    cf.put("c");
    System.out.println("添加元素后的capacity:"+cf.capacity());
    System.out.println("添加元素后的limit:"+cf.limit());
    System.out.println("添加元素后的mark:"+cf.mark());
    System.out.println("添加元素后的position:"+cf.position());
    cf.flip();//把limit设置成position,position设置为0
    System.out.println("filp()后的position:"+cf.position());
    System.out.println("flip()后的limit:"+cf.limit());
    System.out.println("获取第1个元素:"+cf.get());
    System.out.println("获取第2个元素:"+cf.get(1));
    System.out.println("获取第3个元素:"+cf.get(2));
    System.out.println("获取元素后的capactiy"+cf.capacity());
    System.out.println("获取元素后的limit"+cf.limit());
    System.out.println("获取元素后的mark"+cf.mark());
    System.out.println("获取元素后的position"+cf.position());
    cf.clear();

    System.out.println("c的capactiy"+cf.capacity());
    System.out.println("c的limit"+cf.limit());
    System.out.println("c的mark"+cf.mark());
    System.out.println("c的position"+cf.position());

  }
}
