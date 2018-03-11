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
    System.out.println("��ʼcapacty:"+cf.capacity());
    System.out.println("��ʼlimit:"+cf.limit());
    System.out.println("��ʼmark:"+cf.mark());
    System.out.println("��ʼposition��"+cf.position());
    cf.put("a");
    cf.put("b");
    cf.put("c");
    System.out.println("���Ԫ�غ��capacity:"+cf.capacity());
    System.out.println("���Ԫ�غ��limit:"+cf.limit());
    System.out.println("���Ԫ�غ��mark:"+cf.mark());
    System.out.println("���Ԫ�غ��position:"+cf.position());
    cf.flip();//��limit���ó�position,position����Ϊ0
    System.out.println("filp()���position:"+cf.position());
    System.out.println("flip()���limit:"+cf.limit());
    System.out.println("��ȡ��1��Ԫ��:"+cf.get());
    System.out.println("��ȡ��2��Ԫ��:"+cf.get(1));
    System.out.println("��ȡ��3��Ԫ��:"+cf.get(2));
    System.out.println("��ȡԪ�غ��capactiy"+cf.capacity());
    System.out.println("��ȡԪ�غ��limit"+cf.limit());
    System.out.println("��ȡԪ�غ��mark"+cf.mark());
    System.out.println("��ȡԪ�غ��position"+cf.position());
    cf.clear();

    System.out.println("c��capactiy"+cf.capacity());
    System.out.println("c��limit"+cf.limit());
    System.out.println("c��mark"+cf.mark());
    System.out.println("c��position"+cf.position());

  }
}
