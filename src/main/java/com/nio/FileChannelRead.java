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
        //初始化缓冲区大小
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        //将文件通道里面的字节读到缓冲区中
        fileChannel.read(byteBuffer);
        //此方法将position置为0，limit放到position位置
        byteBuffer.flip();
        // position<limit时返回true，用于判断是否还有数据。
        while (byteBuffer.hasRemaining()) {
            //读取缓冲区Buffer里面的内容
            System.out.print((char)byteBuffer.get());
        }
        fileChannel.close();
    }
}
