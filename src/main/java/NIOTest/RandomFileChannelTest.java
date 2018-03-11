package NIOTest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created on 2018/3/11.
 *
 * @author qiyun
 */
public class RandomFileChannelTest {
  public static void main(String args[])throws IOException{
    File file = new File("in.txt");
    try(
    RandomAccessFile raf = new RandomAccessFile(file,"rw");
    FileChannel rafChannel = raf.getChannel();
    ){
      ByteBuffer buffer = rafChannel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
      //把position移到最后面
      rafChannel.position(file.length());
      rafChannel.write(buffer);
    }
  }
}
