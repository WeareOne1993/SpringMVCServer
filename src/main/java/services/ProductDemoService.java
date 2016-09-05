package services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import models.ProductDemo;

public interface ProductDemoService
{
    public Integer addProductDemo(ProductDemo p);
    public List<ProductDemo> listProductDemo();
    public void updateProductDemo(ProductDemo p);
    public void removeProductDemo(Integer id);
    public List<ProductDemo> returnProductsForOnePage(int pageNumber, int pageSize);
    
    public List<ProductDemo> returnProductsForOnePagee(int pageNumber, int pageSize);
    
    public List<ProductDemo> returnProductsWatchForOnePage(int pageNumber, int pageSize);
    public List<ProductDemo> returnProductsJewelryForOnePage(int pageNumber, int pageSize);
    public List<ProductDemo> returnProductsForSearchNameForOnePage(int pageNumber, int pageSize, String name);
    public List<ProductDemo> returnAmountOfProduct(int number);
    public void getMaxDataSize();
    public void getMaxWatchSize();
    public void getMaxJewelrySize();
    
    public void initializeListProduct();
    
    public String getCurrentTimeStamp();
    public void getInfoMemory();
}
