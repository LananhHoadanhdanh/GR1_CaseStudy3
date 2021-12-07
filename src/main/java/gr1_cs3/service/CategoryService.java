package gr1_cs3.service;

import gr1_cs3.model.Category;
import gr1_cs3.model.Product;

import java.util.List;

public interface CategoryService extends GeneralService<Category> {
    List<Product> getProductByCID(int cid);
}
