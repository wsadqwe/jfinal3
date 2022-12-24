package nxu.it.service;

import nxu.it.dao.DbHelper;
import nxu.it.model.Category;


import java.util.List;

public class CategoryService {
    public List<Category> findAll(){
        return Category.dao.findAll();
    }
}
