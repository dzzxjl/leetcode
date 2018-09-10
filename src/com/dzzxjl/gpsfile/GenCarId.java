package com.dzzxjl.gpsfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created by dzzxjl on 2018/8/10.
 */
public class GenCarId {

    public static HashSet<String> carIdSet = new HashSet<>();
    public static HashSet<String> getDirFile(String path){
        File file = new File(path);  // get file list where the path has
        File[] array = file.listFiles();  // get the folder list
//        ArrayList<String> fileNameList = new ArrayList<>();

        for(int i = 0; i < array.length; i++){
            if(array[i].isFile()){
                String fileName = array[i].getName();
                carIdSet.add(fileName);
//                System.out.println(fileName);
//                fileNameList.add(fileName);
//                System.out.println(array[i].getName());  // only take file name
//                System.out.println("#####" + array[i]);  // take file path and name
//                System.out.println("*****" + array[i].getPath());  // take file path and name
            }else if(array[i].isDirectory()){
                getDirFile(array[i].getPath());
            }
        }
        return carIdSet;
    }

    public static void main(String[] args) throws IOException{
        String dirPath = "/Users/dzzxjl/project/shanghai/data/06/";
        HashSet<String> carIdSet = getDirFile(dirPath);
        for(String carId: carIdSet) {
            System.out.println(carId);
        }
        System.out.println("车牌一个有多少个" + carIdSet.size());
        carIdSet.remove(".DS_Store");
        System.out.println("清除掉.DS_Store文件后" + carIdSet.size());

        String savePath = "/Users/dzzxjl/project/shanghai/data/car_id_list.txt";

        FileWriter fw = new FileWriter(savePath);  // 覆盖， 第二个参数为true时为覆盖文件
        BufferedWriter bw = new BufferedWriter(fw);
        for(String carId: carIdSet) {
            bw.write(carId + "\r\n");
            System.out.println(carId);
        }
        bw.close();
        fw.close();
    }
}
