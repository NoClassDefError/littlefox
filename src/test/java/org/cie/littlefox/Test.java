package org.cie.littlefox;

import com.alibaba.fastjson.JSON;
import org.cie.littlefox.util.MyProperties;
import org.cie.littlefox.vo.FileVo;

import java.io.File;

public class Test {
    public static void main(String[] args) {
//        String s1=new File("C:/root/img/img3.gif").getAbsolutePath();
//        String root = new MyProperties().getProperty("file");
//
//
//        System.out.println(s1.substring(0,s1.length()-s1.compareTo(root)));
        String root = "C:\\root";
        File file = new File(root);
        FileVo filevo = new FileVo(file, root, 0,"");
        System.out.println(JSON.toJSON(filevo));
    }
}
