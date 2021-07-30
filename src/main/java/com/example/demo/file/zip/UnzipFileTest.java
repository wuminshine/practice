package com.example.demo.file.zip;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UnzipFileTest {

    public static void main(String[] args) {
        String filePath = "E:\\bak\\lincense.zip";
        // 获取原文所在目录
        // 服务器上时，文件路径为“/”，此处测试需要换成filePath中的“\\”
        //String oldFilePath = filePath.substring(0, filePath.lastIndexOf("/"));
        String oldFilePath = filePath.substring(0, filePath.lastIndexOf("\\"));
        System.out.println("原文件路径：" + oldFilePath);
        // 临时目录，原压缩文件解压目录
        String destDirPath = "E:\\bak\\home";
        System.out.println("临时路径：" + destDirPath);
        // 将原压缩文件解压到临时目录
        ZipUtil.unzipFile(new File("E:\\bak\\lincense.zip"), destDirPath);

//        // 临时目录文件对象
//        File destDir = new File(destDirPath);
//        // 获取临时目录下的所有文件
//        File[] files = destDir.listFiles();
//        // 定义变量，保存校验结果
//        List<Integer> list = new ArrayList<>();
//        // 判断是否包含不合格PDF文件
//        if (list.contains(1)) {
//            System.out.println("压缩文件中包含不合格PDF文件");
//            // 删除解压缩的文件和临时目录
//            ZipUtil.deletefile(destDirPath);
//            // 不合格时，不生成新的压缩包文件
//            return;
//        } else {
//            System.out.println("压缩文件PDF文件均符合要求");
//        }
//
//        // 获取原压缩文件后缀
//        int pos = filePath.lastIndexOf('.');
//        String suffix = filePath.substring(pos + 1);
//        // 新生成压缩文件路径
//        String newFilePath = "E:\\bak\\home";
//        System.out.println("新的压缩文件路径：" + newFilePath);
//
//        // 将检验成功的文件压缩成一个新的压缩包
//        ZipUtil.zipFile(newFilePath, files);
//        // 删除临时目录
//        ZipUtil.deletefile(destDirPath);
    }
}
