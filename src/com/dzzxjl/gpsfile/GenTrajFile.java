package com.dzzxjl.gpsfile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dzzxjl on 2018/8/3.
 */
public class GenTrajFile {

    private static ArrayList<String> getDirFile(String path){
        File file = new File(path);  // get file list where the path has
        File[] array = file.listFiles();  // get the folder list
        ArrayList<String> fileNameList = new ArrayList<>();

        for(int i = 0; i < array.length; i++){
            if(array[i].isFile()){
                String fileName = array[i].getName();
                fileNameList.add(fileName);
                System.out.println(array[i].getName());  // only take file name
//                System.out.println("#####" + array[i]);  // take file path and name
//                System.out.println("*****" + array[i].getPath());  // take file path and name
            }else if(array[i].isDirectory()){
                getDirFile(array[i].getPath());
            }
        }
        return fileNameList;
    }


    public static void main(String[] args) throws Exception {
        // 文件路径
        String dirPath = "/Users/dzzxjl/project/shanghai/data/06/0";
//        String carId = "CU9510";
//        String carId = "CU9510_06_06";
//        String carId = "CU9208";  // 暂时有问题

//        String fileSavePath = "/Users/dzzxjl/project/shanghai/data/" +  carId + "_trajectory.txt";
        String fileSavePath = "/Users/dzzxjl/project/shanghai/data/" + "all" + "_trajectory.txt";
        String[] carIds = new String[]{"CU9509", "CU9510", "CU9513", "CU9517", "CU9523", "CU9526", "CU9527", "CU9531", "CU9533", "CU9536"};

        try {
            FileWriter fw = new FileWriter(fileSavePath);  // 覆盖， 第二个参数为true时为覆盖文件
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < carIds.length; i++) {
                String carId = carIds[i];
                for (Integer j = 1; j <= 7; j++) {
                    String fileName = dirPath + j.toString() + "/" + carId;

                    File file = new File(fileName);
                    InputStream in = new FileInputStream(file);  //实例化FileInputStream
                    int fileLength = (int)file.length();
                    byte bytes[] = new byte[fileLength];
                    int temp = 0;
                    int len = 0;

                    while ((temp = in.read()) != -1) {

                        bytes[len++]=(byte) temp;
                        if (len % 32 == 0) {  // 一个采样点的数据大小为32字节
                            String timestamp = genGpsTime(bytes);  // 0-3时间
//                System.out.println(bytes[4]);
//                System.out.println(bytes[5]);
//                System.out.println(bytes[6]);
//                System.out.println(bytes[7]);  // 4 5 6 7 全为0
//                System.out.println(bytes[8]);  // 8 出租车状态
//                initCarStatus(bytes[8]);
                            String carStatus = initCarStatus(bytes[8]);
//                            String carStatus = Byte.toString(bytes[8]);
                            double lat = initLatitude(bytes);  // 9 10 11 纬度
                            double lon = initLongitude(bytes);  // 12 13 14 经度
                            short speed = initSpeed(bytes);


//                System.out.println(bytes[16]);
//                System.out.println(bytes[17]);  // 角度
//                System.out.println(bytes[18]);  // height为0
//                System.out.println(bytes[19]);  // height为0
//                System.out.println(bytes[20]);  // 温度为0
//                System.out.println(timestamp + "," + Double.toString(lat) +  "," + Double.toString(lon));
                            String line = carId + "," + carStatus + "," + timestamp + "," + String.format("%.6f", lat) +  "," + String.format("%.6f", lon) + "," + Short.toString(speed);
                            System.out.println(line);
                            bw.write(line + "\r\n");
                            len = 0;  // 重新开始填充32位字节数组
                        }
                    }
                    in.close();
                }
            }

            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static short initSpeed(byte[] bytes) {
        return bytes2short(bytes,15);
    }

    public static String genGpsTime(byte[] bytes) {
        int result = BitConverter.ToInt32(bytes, 0);
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
        double lon;
        lon = (0xFFFF & bytes2short(bytes, 13));  // 只取低16位
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

    //从第8字节中提取车辆状态
    // TAKEN  载客
    // FETCHING  接来某人
    // FREE  空闲
    // OFFSTREAM
    // LOGOFF
    // OFFLINE
    // ALARMING

    public static String initCarStatus(byte cs) {
//        boolean dispatching;

        String carStatus = "";
        if ((cs & 0x80) == 0 && (cs & 0x40) != 0) {
//            carStatus = "TAKEN";
            carStatus = "1";
        } else if ((cs & 0x80) == 0 && (cs & 0x40) == 0) {
//            carStatus = "FREE";
            carStatus = "0";
        } else if ((cs & 0x80) != 0 && (cs & 0x40) == 0) {
//            carStatus = "FETCHING";
            carStatus = "1";  // 暂且置为1，应为标志位2
        } else if ((cs & 0x80) != 0 && (cs & 0x40) != 0){
//            carStatus = "TAKEN";
            carStatus = "1";
        }
//        else if ((cs & 0x10) == 0) {
//            carStatus = "GPSTROUBLE";
//        }


        return carStatus;
//        if ((cs & 0x80) == 0) {  // 是否被派遣调度
//            dispatching = false;
//            System.out.println("dispatching = false");
//        } else {
//            dispatching = true;
//            System.out.println("dispatching = true");
//        }
//        if ((cs & 0x40) != 0) {
//            System.out.println("this.CarStatus = CARSTATUS.TAKEN;");  // 取走
////            this.CarStatus = CARSTATUS.TAKEN;
//        } else if (dispatching) {
//            System.out.println("this.CarStatus = CARSTATUS.FETCHING;");
////            this.CarStatus = CARSTATUS.FETCHING;
//        } else {
////            this.CarStatus = CARSTATUS.FREE;
//            System.out.println("this.CarStatus = CARSTATUS.FREE;");  // 空闲
//        }
//
//        if ((cs & 0x10) == 0) {
//            System.out.println("this.gpsTrouble = true;");
//        } else {
//            System.out.println("this.gpsTrouble = false;");
//        }
    }
}
