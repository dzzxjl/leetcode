package com.dzzxjl.gpsfile;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by dzzxjl on 2018/8/11.
 */
public class Main {
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

    public static void main(String[] args) throws Exception{
        StringBuilder sb  = new StringBuilder("/Users/dzzxjl/project/shanghai/data/");
//        String[] carIds = new String[]{"CU9509", "CU9510", "CU9513", "CU9517", "CU9523", "CU9526", "CU9527", "CU9531", "CU9533", "CU9536"};
//        String[] carIds = new String[]{"CU9509"};

        String[] carIds = new String[]{"CU9208"};
        for (int i = 0; i < carIds.length; i++) {
            String carId = carIds[i];
            for (int j = 6; j <=12; j++) {  // 6-12月的数据
                if (j >= 10) {
                    sb.append(Integer.toString(j) + "/");
                } else {
                    sb.append("0" + Integer.toString(j) + "/");
                }
                for (int k = 1; k <= 31; k++) {  // 天数
                    // carId的j月k号的数据
                    if (k >= 10) {
                        sb.append(Integer.toString(k) + "/" + carId);
                    } else {
                        sb.append("0" + Integer.toString(k) + "/" + carId);
                    }
//                    System.out.println(sb.toString());
                    String filePath = sb.toString();
                    File file = new File(filePath);
                    if (file.exists()) {
                        GenTrajFile1.genTrajFile(filePath);
                    } else {

                    }
                    sb.delete(sb.length()-9, sb.length());

                }
                sb.delete(sb.length()-3, sb.length());
            }
        }


    }
}
