package com.example.controller;

import com.example.dao.ImageDAO;
import com.example.model.Image;
import com.example.service.ImageService;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by trung on 03/19/2016.
 */
@RestController
public class ImageController
{
    @Autowired
    ImageService imageService;

    @RequestMapping("/uploadImages")
    void uploadImages()
    {
    }

    @RequestMapping("/getImages")
    Iterable<Image> getImages()
    {
        List<Image> images = new ArrayList<>();
        Image image = new Image();
        image.setName("trung");
        image.setUrl("http://localhost:8080/image/trung");
        image.setDescription("trung dai ca");
        images.add(image);
        imageService.save(images);
        return imageService.getImages();
    }


    @RequestMapping("/image/{name}")
    public ResponseEntity<byte[]> getImageFile(@PathVariable("name") String fileName) throws IOException
    {
        InputStream in = new FileInputStream(imageService.getImageFile(fileName));
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
    }
}
