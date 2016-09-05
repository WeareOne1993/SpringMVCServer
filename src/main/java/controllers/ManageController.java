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
import models.ResponseStatus;
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
     * add new product to database
     * return: status
     * URL   : localhost:8080/SptirngMVCRestAPIDemo/product/add
     * method: POST
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/add", method=RequestMethod.POST, headers="Accept=application/json")
    public ResponseStatus addProductDemo(@RequestBody ProductDemo p)
    {
        ResponseStatus responseStatus;
        int number = this.productDemoService.addProductDemo(p);
        
        if (number == 200)
            responseStatus = new ResponseStatus(200, "Ok, added!");
        else
            responseStatus = new ResponseStatus(244, "fail to add new product");
        
        return responseStatus;
    }

    
    
    /*
     * update an exist product from database
     * return: 200 if ok - 245 if update failed
     * URL   : localhost:8080/SptirngMVCRestAPIDemo/product/update
     * method: PUT
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/update", method=RequestMethod.PUT, headers="Accept=application/json")
    public ResponseStatus updateProductDemo(@RequestBody ProductDemo p)
    {
        ResponseStatus responseStatus;
        int number = this.productDemoService.updateProductDemo(p);

        if (number == 200)
            responseStatus = new ResponseStatus(200, "Ok, updated!");
        else
            responseStatus = new ResponseStatus(245, "fail to update product");
        
        return responseStatus;
    } 
    
    
    
    /*
     * remove an exist product from database
     * return: 200 if ok - 246 if remove failed
     * URL   : localhost:8080/SptirngMVCRestAPIDemo/pr  oduct/remove/{id}
     * method: DELETE
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/remove/{id}", method=RequestMethod.DELETE)
    public ResponseStatus removeProductDemo(@PathVariable int id)
    {
        ResponseStatus responseStatus;
        int number = this.productDemoService.removeProductDemo(id); 

        if (number == 200)
            responseStatus = new ResponseStatus(200, "Ok, removed!");
        else
            responseStatus = new ResponseStatus(246, "fail to remove product");
        
        return responseStatus;
    }
    
    
    
    /*
     * return list of products corresponding with page number called
     * return: list productDemo
     * URL   : localhost:8080/SptirngMVCRestAPIDemo/product/page/{pageNumber}
     * method: GET
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/page/{pageNumber}", method=RequestMethod.GET)
    public List<ProductDemo> returnProductsForOnePage(@PathVariable int pageNumber)
    {
        List<ProductDemo> products = this.productDemoService.returnProductsForOnePage(pageNumber, pageSize);

        return products;
    }

    
    
    /*
     * return list of watch corresponding with page number called
     * return: list watch 
     * URL   : localhost:8080/SpringMVCRestAPIDemo/product/watch/page/{pageNumber}
     * method: GET
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/watch/page/{pageNumber}", method=RequestMethod.GET)
    public List<ProductDemo> returnProductsWatchForOnePage(@PathVariable int pageNumber)
    {
        return this.productDemoService.returnProductsWatchForOnePage(pageNumber, pageSize);
    }
    
    
    
    /*
     * return list of jewelry corresponding with page number called
     * return: list jewelry 
     * URL   : localhost:8080/SpringMVCRestAPIDemo/product/jewelery/page/{pageNumber}
     * method: GET
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/jewelry/page/{pageNumber}", method=RequestMethod.GET)
    public List<ProductDemo> returnProductsJewelryForOnePage(@PathVariable int pageNumber)
    {
        return this.productDemoService.returnProductsJewelryForOnePage(pageNumber, pageSize);
    }
    
    
    
    /*
     * return list of products corresponding with page number and name called
     * return: list products 
     * URL   : localhost:8080/SpringMVCRestAPIDemo/products/page=pageNumber&name=name
     * method: GET
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/search", method=RequestMethod.GET)
    public List<ProductDemo> returnProductsForSearchNameForOnePage(@RequestParam("page") int pageNumber, @RequestParam("name") String name)
    {
        return this.productDemoService.returnProductsForSearchNameForOnePage(pageNumber, pageSize, name);
    }
    
    
    
    /*
     * return list of products corresponding with number called
     * return: list products 
     * URL   : localhost:8080/SpringMVCRestAPIDemo/products/{number}
     * method: GET
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/products/{number}", method=RequestMethod.GET)
    public List<ProductDemo> returnAmountOfProduct(@PathVariable int number)
    {
        return this.productDemoService.returnAmountOfProduct(number);
    }
    
}
