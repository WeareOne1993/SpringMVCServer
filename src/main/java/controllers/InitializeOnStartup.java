package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import services.ProductDemoService;

@Component
public class InitializeOnStartup implements ApplicationListener<ContextRefreshedEvent>
{
    private ProductDemoService productDemoService;
    
    @Autowired(required=true)
    @Qualifier(value="productDemoService")
    public void setProductDemoService(ProductDemoService pds)
    {
        this.productDemoService = pds;
    }
    
    public void onApplicationEvent(ContextRefreshedEvent arg0)
    {
        System.out.println("Initializing...");
        this.productDemoService.getMaxDataSize();
        this.productDemoService.getMaxWatchSize();
        this.productDemoService.getMaxJewelrySize();
        System.out.println("initialization finished");
    }
    
}
