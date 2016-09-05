package services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.ProductDemoDAO;
import models.ProductDemo;
import services.ProductDemoService;

public class ProductDemoServiceImpl implements ProductDemoService
{
//    private static StorageCount storageCount;
    private ProductDemoDAO productDemoDAO;
    
    public void setProductDemoDAO(ProductDemoDAO productDemoDAO)
    {
        this.productDemoDAO = productDemoDAO;
    }
    
    @Transactional
    public int addProductDemo(ProductDemo p)
    {
        return this.productDemoDAO.addProductDemo(p);
    }

    @Transactional
    public int updateProductDemo(ProductDemo p)
    {
        return this.productDemoDAO.updateProductDemo(p);

    }
    
    @Transactional
    public int removeProductDemo(int id)
    {
        return this.productDemoDAO.removeProductDemo(id);
    }
    
    @Transactional
    public List<ProductDemo> returnProductsForOnePage(int pageNumber, int pageSize)
    {
        return this.productDemoDAO.returnProductsForOnePage(pageNumber, pageSize);
    }

    @Transactional
    public List<ProductDemo> returnProductsWatchForOnePage(int pageNumber, int pageSize)
    {
        return this.productDemoDAO.returnProductsWatchForOnePage(pageNumber, pageSize);
    }    
    
    @Transactional
    public List<ProductDemo> returnProductsJewelryForOnePage(int pageNumber, int pageSize)
    {
        return this.productDemoDAO.returnProductsJewelryForOnePage(pageNumber, pageSize);
    }
    
    @Transactional
    public List<ProductDemo> returnProductsForSearchNameForOnePage(int pageNumber, int pageSize, String name)
    {
        return this.productDemoDAO.returnProductsForSearchNameForOnePage(pageNumber, pageSize, name);
    }
    
    @Transactional
    public List<ProductDemo> returnAmountOfProduct(int number)
    {
        return this.productDemoDAO.returnAmountOfProduct(number);
    }

    @Transactional
    public void getMaxDataSize()
    {
        this.productDemoDAO.getMaxDataSize();
    }
        
    @Transactional
    public void getMaxWatchSize()
    {
       this.productDemoDAO.getMaxWatchSize();
    }
    
    public void getMaxJewelrySize()
    {
       this.productDemoDAO.getMaxJewelrySize();
    }
}
