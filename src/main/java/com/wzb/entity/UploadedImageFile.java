package com.wzb.entity;

/**
 * @Author Administrator
 * @Date 2021/8/4 0004 15:01
 */
import org.springframework.web.multipart.MultipartFile;

public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}
