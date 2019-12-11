package org.cie.littlefox.webController;

import com.alibaba.fastjson.JSON;
import org.cie.littlefox.util.MyProperties;
import org.cie.littlefox.vo.FileVo;
import org.cie.littlefox.vo.UserQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class Index {
    @Autowired
    MyProperties properties;
    @Autowired
    HttpServletRequest request;

    /**
     * 地址示例：
     * http://localhost:8888/littlefox/getFiles?path=/aa <br>
     * 在原来的小创网盘中path被存在了session中，此处改为存在request中。
     *
     * @param path 这个path是相对与根的路径，分隔符是'/'
     * @return FileVo对象转成的json
     */
    @RequestMapping(value = "/getFiles", method = RequestMethod.POST)
    public String getFiles(String path) {
        LoggerFactory.getLogger(this.getClass()).info("Looking into: " + path);
        path = path.replace("/", File.separator);
        String root = properties.getProperty("file");
        File file = new File(root + path);
        String url = "";
        url = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort()
                + request.getServletContext().getContextPath();
        FileVo filevo = new FileVo(file, root, 0, url);
        return JSON.toJSON(filevo).toString();
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(UserQuery query){

        return null;
    }
}
