package java_basic;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Project:Exercise
 * Package:main.java.java_basic
 * Author:Alan Ruan
 * Date:2018-11-08 15:18
 * Description://TODO  测试java字节序的大小端情况，验证java字节序是大端的
 *
 * 小端（little-Endian） 是指低位字节存放在内存的低地址端，高位字节存放在内存的高地址端
 * 大端（Big-Endian）与小端相反
 *
 */
public class BigEndian {

    public static void main(String[] args) throws IOException {
        byte[] arr = new byte[4];
        arr[0] = 0x78;
        arr[1] = 0x56;
        arr[2] = 0x34;
        arr[3] = 0x12;

        ByteArrayInputStream bais = new ByteArrayInputStream(arr);
        DataInputStream dis = new DataInputStream(bais);
        System.out.println("Java字节序是大端的，字节数组输出如下：");
        System.out.println(Integer.toHexString(dis.readInt()));


        System.out.println("整型数3，大端转换小端输出如下：" + toLittleEndian(3));
    }


    public static int toLittleEndian(int a) {
        return (((a & 0xFF) << 24) | (((a >> 8) & 0xFF) << 16) | (((a >> 16) & 0xFF) << 8) | ((a >> 24) & 0xFF));
    }


    //java提供了一个类库可以用来获取CPU是大端还是小端， java.nio.ByteOrder.nativeOrder()

}
