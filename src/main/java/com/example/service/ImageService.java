package com.example.service;

import com.example.dao.ImageDAO;
import com.example.model.Image;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.util.List;

/**
 * Created by trung on 03/19/2016.
 */
@Service
public class ImageService
{
    @Autowired
    private ImageDAO imageDAO;

    public Iterable<Image> getImages()
    {
        return imageDAO.findAll();
    }

    public void save(List<Image> images)
    {
        for (Image image : images)
        {
            imageDAO.save(images);
        }
    }

    public String getImageFile(String name)
    {
        final File folder = new File("F:\\srv");
        String filePath = null;
        for (final File fileEntry : folder.listFiles())
        {
            if (fileEntry.isFile())
            {
                String filename = fileEntry.getName();
                int pos = filename.lastIndexOf(".");
                String justName = pos > 0 ? filename.substring(0, pos) : filename;
                if (justName.equals(name))
                {
                    filePath = fileEntry.getAbsolutePath();
                    break;
                }
            }
        }
        return filePath;
    }


}
