package org.cie.littlefox.vo;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class FileVo {
    public ArrayList<FileVo> children = new ArrayList<>();
    public String title;
    public String field;
    public Boolean spread = false;
    public String canonicalPath;
    public String type;
    public String size;

    /**
     * 将File递归转成vo发给前端，只递归一层
     *
     * @param file        将此对象转化成vo
     * @param root        目录根路径，为提高速度必须使用静态的方法读取
     * @param level       递归时控制级数，选定为0
     * @param contextPath 网站静态资源根目录
     */
    public FileVo(File file, String root, int level, String contextPath) {
        String s1 = file.getAbsolutePath();
        canonicalPath = (s1.substring(s1.length() - s1.compareTo(root))).replace(File.separator, "/");
        field = contextPath +"/"+ canonicalPath.replace(File.separator, "/");
//        url = s1.substring(0, s1.length() - s1.compareTo(root));
        title = file.getName();
        type = file.isDirectory() ? "directory" : new MimetypesFileTypeMap().getContentType(file);
        size = file.isDirectory() ? null : file.getTotalSpace() + "";
        if (file.listFiles() != null)
            for (File son : Objects.requireNonNull(file.listFiles()))
                if (level < 2)
                    children.add(new FileVo(son, root, level + 1, contextPath));
    }
}
