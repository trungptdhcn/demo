package com.example.dao;

import com.example.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by trung on 03/19/2016.
 */
@Repository
public interface ImageDAO extends CrudRepository<Image,Integer>
{
    Image findById(int id);
    List<Image> findByName(String name);
    Iterable<Image> findAll();
    Image save(Image entity);
}
