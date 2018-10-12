package com.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel往文件写入内容。
 * FileOutputStream如果有参数true则是追加内容。如果没有则是覆盖旧的内容
 */
public class FileChannelWrite {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream(new File("E:\\test2.txt"),true);
        //获取输出的fileChannel(文件通道)
        FileChannel fileChannel= fileOutputStream.getChannel();
        //开辟缓冲
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        String name="lin";
        //向缓冲区写入数据
         byteBuffer.put(name.getBytes());
         //重设缓冲区，准备输出
         byteBuffer.flip();
         //写入内容
         fileChannel.write(byteBuffer);
         fileChannel.close();
         fileOutputStream.close();
         System.out.println("写入成功");
    }
}
