package com.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用FileChannel读取文件
 */
public class FileChannelRead {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(new File("E:\\test2.txt"));
        FileChannel fileChannel=fileInputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);  //初始化缓冲区大小
        fileChannel.read(byteBuffer);    //将文件通道里面的字节读到缓冲区中
        byteBuffer.flip();  //此方法将position置为0，limit放到position位置
        while (byteBuffer.hasRemaining()) {
            System.out.println((char)byteBuffer.get());
        }
        fileChannel.close();
    }
}
