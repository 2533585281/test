package com.wzb.controller;

/**
 * @Author Administrator
 * @Date 2021/8/4 0004 15:04
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import com.wzb.entity.UploadedImageFile;
import com.wzb.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {
    @RequestMapping("admin_category_add")
    @ResponseBody
    public String add(String imageId, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
       // File  imageFolder= new File(session.getServletContext().getRealPath("img/imgFile"));
        File  imageFolder=new File("E:\\img");
        if(imageId!=null&&imageId!=""){
            imageId+=System.currentTimeMillis();
        }

        File file = new File(imageFolder,imageId+".jpg");
        if(!imageFolder.exists()){
            imageFolder.mkdirs();
        }
        //保存图片到file对象中
        uploadedImageFile.getImage().transferTo(file);
        //将图片转成jpg格式
        BufferedImage img = ImageUtil.change2jpg(file);
        //将图片写入文件所在位置
        ImageIO.write(img, "jpg", file);
        return "上传成功";
    }
}
