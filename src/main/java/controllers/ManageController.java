package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import models.ProductDemo;
import services.ProductDemoService;

@RestController
public class ManageController
{
    private ProductDemoService productDemoService;
    private CountNumber countNumber;
    private int pageSize = 8; 
    //private static int number = 0;
    
    @Autowired(required=true)
    @Qualifier(value="productDemoService")
    public void setProductDemoService(ProductDemoService pds)
    {
        this.productDemoService = pds;
    }

    
    
    /*
     * return list product: watch and jewelry
     * URL    : localhost:8080/SpringMVCRestAPIDemo/products
     * Method : GET
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/products", method=RequestMethod.GET)
    public List<ProductDemo> listProductDemo()
    {
        return this.productDemoService.listProductDemo();
    }
    
    
    /*
     * add a new product: watch or jewelry
     * URL    : localhost:8080/SptirngMVCRestAPIDemo/product/add
     * Method : POST
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/add", method=RequestMethod.POST, headers="Accept=application/json")
    public List<ProductDemo> addProductDemo(@RequestBody ProductDemo pd)
    {
        Integer productDemoNewId = productDemoService.addProductDemo(pd);
        List<ProductDemo> products = this.productDemoService.returnProductsForOnePagee(1, pageSize);
        return products;
    }
    
    
    /*
     *update a current product: watch or jewelry
     * URL    : localhost:8080/SptirngMVCRestAPIDemo/product/update
     * Method : PUT
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/update", method=RequestMethod.PUT, headers="Accept=application/json")
    public Integer updateProductDemo(@RequestBody ProductDemo pd)
    {
        this.productDemoService.updateProductDemo(pd);
        
        return 200;
    } 
    
    
    
    /*
     * remove a product
     * URL    : localhost:8080/SpringMVCRestAPIDemo/product/remove/{id}
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/remove/{id}", method=RequestMethod.DELETE)
    public ProductDemo removeProductDemo(@PathVariable int id)
    {
//        this.productDemoService.getMaxDataSize();
        this.productDemoService.removeProductDemo(id);
        ProductDemo p = new ProductDemo(0, 0);
        return p;
    }
    
    
    /*
     * return product for one page = page size + + return max page number
     * URL    : localhost:8080/SpringMVCRestAPIDemo/product/page/{i}
     * method : GET
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/page/{pageNumber}", method=RequestMethod.GET)
    public List<ProductDemo> returnProductsForOnePage(@PathVariable int pageNumber)
    {
        this.productDemoService.getMaxDataSize();
        List<ProductDemo> products = this.productDemoService.returnProductsForOnePage(pageNumber, pageSize);
  //      this.productDemoService.getInfoMemory();
        return products;
    }
    
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/pagee/{pageNumber}", method=RequestMethod.GET)
    public List<ProductDemo> returnProductsForOnePagee(@PathVariable int pageNumber)
    {
//        this.productDemoService.getMaxDataSize();
        List<ProductDemo> products = this.productDemoService.returnProductsForOnePagee(pageNumber, pageSize);
        //this.productDemoService.getInfoMemory();
        return products;
    }
    
    
    /*
     * return watch products for search name in one page + return max page number
     * URL    : localhost:8080/SpringMVCRestAPIDemo/product/watch/page/{pageNumber}
     * method : GET
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/watch/page/{pageNumber}", method=RequestMethod.GET)
    public List<ProductDemo> returnProductsWatchForOnePage(@PathVariable int pageNumber)
    {
  //      countNumber.printCount();
        return this.productDemoService.returnProductsWatchForOnePage(pageNumber, pageSize);
    }
    
    
    /*
     * return jewelry products for search name in one page + return max page number
     * URL    : localhost:8080/SpringMVCRestAPIDemo/product/jewelry/page/{pageNumber}
     * method : GET
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/jewelry/page/{pageNumber}", method=RequestMethod.GET)
    public List<ProductDemo> returnProductsJewelryForOnePage(@PathVariable int pageNumber)
    {
        return this.productDemoService.returnProductsJewelryForOnePage(pageNumber, pageSize);
    }
    
    
    /*
     * return WATCH products for search name in one page + return max page number
     * URL    : localhost:8080/SpringMVCRestAPIDemo/product/search?page=***&name=****
     * method : GET
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/search", method=RequestMethod.GET)
    public List<ProductDemo> returnProductsForSearchNameForOnePage(@RequestParam("page") int pageNumber, @RequestParam("name") String name)
    {
        return this.productDemoService.returnProductsForSearchNameForOnePage(pageNumber, pageSize, name);
    }
    
    
    /*
     * return amount of product
     * URL    : localhost:8080/SpringMVCRestAPIDemo/products/{number}
     * method : GET
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/products/{number}", method=RequestMethod.GET)
    public List<ProductDemo> returnAmountOfProduct(@PathVariable int number)
    {
        return this.productDemoService.returnAmountOfProduct(number);
    }
    
}
