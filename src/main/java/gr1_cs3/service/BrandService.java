package gr1_cs3.service;

import gr1_cs3.model.Brand;
import gr1_cs3.model.Product;

import java.util.List;

public interface BrandService extends GeneralService<Brand>{
    List<Product> getProductByBID(int brandId);
}
