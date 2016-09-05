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
    public Integer addProductDemo(ProductDemo p) {
        return this.productDemoDAO.addProductDemo(p);
    }
    
    @Transactional
    public List<ProductDemo> listProductDemo() {
        return this.productDemoDAO.listProductDemo();
    }
    
    @Transactional
    public void updateProductDemo(ProductDemo p) {
        this.productDemoDAO.updateProductDemo(p);

    }
    
    @Transactional
    public void removeProductDemo(Integer id) {
        this.productDemoDAO.removeProductDemo(id);

    }
    
    @Transactional
    public List<ProductDemo> returnProductsForOnePage(int pageNumber, int pageSize)
    {
        return this.productDemoDAO.returnProductsForOnePage(pageNumber, pageSize);
    }
    
    public List<ProductDemo> returnProductsForOnePagee(int pageNumber, int pageSize)
    {
        return this.productDemoDAO.returnProductsForOnePagee(pageNumber, pageSize);
    }
    
   
    public List<ProductDemo> returnProductsWatchForOnePage(int pageNumber, int pageSize)
    {
        return this.productDemoDAO.returnProductsWatchForOnePage(pageNumber, pageSize);
    }    
    
    
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
        if (this.productDemoDAO.getIsActiveCountData() == 0)
        {
           this.productDemoDAO.setMaxDataSize(this.productDemoDAO.getMaxDataSize());
           this.productDemoDAO.setIsActiveCountData(1);
        }
    }
        
    @Transactional
    public void getMaxWatchSize()
    {
        if(this.productDemoDAO.getIsActiveCountWatch() == 0)
        {
            this.productDemoDAO.setMaxWatchSize(this.productDemoDAO.getMaxWatchSize());
            this.productDemoDAO.setIsActiveCountWatch(1);
        }
    }
    
    @Transactional
    public void getMaxJewelrySize()
    {
        if (this.productDemoDAO.getIsActiveCountJewelry() == 0)
        {
            this.productDemoDAO.setMaxJewelrySize(this.productDemoDAO.getMaxJewelrySize());
            this.productDemoDAO.setIsActiveCountJewelry(1);
        }
    }
    
    @Transactional
    public void initializeListProduct()
    {
        this.productDemoDAO.initializeListProduct();
    }
    
    public String getCurrentTimeStamp()
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }
    
    public void getInfoMemory()
    {
        this.productDemoDAO.getInfoMemory();
    }
    
    
    
}
