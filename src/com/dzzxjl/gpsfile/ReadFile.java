package com.dzzxjl.gpsfile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dzzxjl on 2018/8/2.
 */
public class ReadFile {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String carId = "CU9510";  // 暂时有问题
//        String carId = "CU9208";
        String fileName = "/Users/dzzxjl/Downloads/" + carId;
        File file = new File(fileName);    //filename为 文件目录，请自行设置


        InputStream in = null;
        byte[] bytes = null;
        in = new FileInputStream(file);    //真正要用到的是FileInputStream类的read()方法
        bytes = new byte[in.available()];    //in.available()是得到文件的字节数


        in.read(bytes);    //把文件的字节一个一个地填到bytes数组中
        in.close();    //记得要关闭in

        System.out.println("该文件中总的字节长度" + bytes.length);

        int length = bytes.length;

        byte[] gpsbyte = new byte[32];
        int idx = 0;
//        for (int i = 0; i < 64; i++) {
        for (int i = 0; i < length; i++) {
            if (i == 30) {
                System.out.println("mark");
            }
            gpsbyte[idx++] = bytes[i];

            if ((i + 1) % 32 == 0) {

//                for (byte b : gpsbyte) {
//                    System.out.println(b);
//                }

                System.out.println(genGpsTime(gpsbyte));
                idx = 0;
            }
//            System.out.println(Integer.toString(i % 32) + "    " + bytes[i]);

        }




    }

    public static String genGpsTime(byte[] bytes) {
        int result = BitConverter.ToInt32(bytes, 0);
        System.out.println(result);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
        String sd = sdf.format(new Date(result * 1000L));   // 时间戳转换成时间
        return sd;
    }

    //2字节bytes转换成short
    public static short bytes2short(byte[] p, int offset)
    {
        int result = 0;
        int type_size = 2;
        for (int i = type_size - 1; i > -1; --i)
            result = result << 8 | p[(i + offset)] & 0xFF;
        return (short) result;
    }

    public static double initLongitude(byte[] bytes) {  // 生成经度信息
        double lon = 0;
        lon = (0xFFFF & bytes2short(bytes, 13));
        lon /= 60000.0D;
        lon += (0xFF & bytes[12]);

        return lon;
    }


    public static double initLatitude(byte[] bytes) {  // 生成纬度信息
        double lat;
        lat = (0xFFFF & bytes2short(bytes, 10));
        lat /= 60000.0D;
        lat += (0xFF & bytes[9]);
        return lat;
    }



    public static Date long2Date(long time )
    {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis( time );
        return c.getTime();
    }
}
