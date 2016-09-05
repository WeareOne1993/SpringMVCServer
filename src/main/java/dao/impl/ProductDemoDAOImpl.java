package dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import controllers.CountNumber;
import dao.ProductDemoDAO;
import models.ProductDemo;
import models.StorageSearch;
import services.HibernateUtil;

public class ProductDemoDAOImpl implements ProductDemoDAO
{
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private CountNumber countNumber;
    private static List<ProductDemo> initializedListProductDemo;
    private static List<StorageSearch> countList = new ArrayList<StorageSearch>();
    private static List<Integer> initializedListDelete = new ArrayList<Integer>();
    
    private static int isActiveInitializeList = 0;
    private static int isActiveCountData = 0;
    private static int isActiveCountWatch = 0;
    private static int isActiveCountJewelry = 0;
    
    private static int maxDataSize;
    private static int maxWatchSize;
    private static int maxJewelrySize;

    //if = 1: queried to get max maxDataSize
    public int getIsActiveCountData()
    {
        return isActiveCountData;
    }
    
    public int getIsActiveCountWatch()
    {
        return isActiveCountWatch;
    }
    
    public int getIsActiveCountJewelry()
    {
        return isActiveCountJewelry;
    }
    
    public void setIsActiveCountData(int number)
    {
        this.isActiveCountData = number;
    }
    
    public void setIsActiveCountWatch(int number)
    {
        this.isActiveCountWatch = number;
    }
    
    public void setIsActiveCountJewelry(int number)
    {
        this.isActiveCountJewelry = number;
    }
    
    public void setMaxDataSize(int maxDataSize)
    {
        this.maxDataSize = maxDataSize;
    }
    
    public void setMaxWatchSize(int maxWatchSize)
    {
        this.maxWatchSize = maxWatchSize;
    }
    
    public void setMaxJewelrySize(int maxJewelrySize)
    {
        this.maxJewelrySize = maxJewelrySize;
    }
    
    public Integer addProductDemo(ProductDemo p)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        Integer productDemoId = null;
        String name = p.getName();
        String type = p.getType();
        String brand = p.getBrand();
        String model = p.getModel();
        String gender = p.getGender();
        String movement = p.getMovement();
        String watchlabel = p.getWatchLabel();
        double caseSize = p.getCaseSize();
        double caseThickness = p.getCaseThickness();
        String caseMaterial = p.getCaseMaterial();
        String caseShape = p.getCaseShape();
        String dialType = p.getDialType();
        String dialColor = p.getDialColor();
        String crystal = p.getCrystal();
        String waterResistance = p.getWaterResistance();
        
        String metal = p.getMetal();
        String clasp = p.getClasp();
        double chainLength = p.getChainLength();
        String chainType = p.getChainType();
        double width = p.getWidth();
        double length = p.getLength();
        String rhodiumPlated = p.getRhodiumPlated();
        int numberOfCenterRoundDiamonds = p.getNumberOfCenterRoundDiamonds();
        double minimumCaratTotalWeight = p.getMinimumCaratTotalWeight();
        String minimumColor = p.getMinimumColor();
        String minimumClarity = p.getMinimumClarity();
        String minimumCut = p.getMinimumCut();
        String settingType = p.getSettingType();
        
        double price = p.getPrice();
        String path = p.getPath();
        
        if (type.equals("watch") && !name.equals(null) && price != 0)
        {
            try
            {
                maxDataSize = maxDataSize + 1;
                maxWatchSize = maxWatchSize + 1;
                tr = session.beginTransaction();
                
                ProductDemo productDemo = new ProductDemo(name, type, brand, model, gender, movement, watchlabel, caseSize, caseThickness, caseMaterial, caseShape, dialType, dialColor, crystal, waterResistance, price, path);
                productDemoId = (Integer) session.save(productDemo);

                initializedListProductDemo.add(productDemo);
                
                tr.commit();
                
                int countListSize = countList.size();
                for (int i = 0; i < countListSize; i++)
                {
                    if (name.toLowerCase().contains(countList.get(i).getName().toLowerCase()))
                    {
                        countList.get(i).setNumber(countList.get(i).getNumber() + 1);
                    }
                }
            }
            catch (HibernateException he)
            {
                maxDataSize = maxDataSize - 1;
                maxWatchSize = maxWatchSize - 1;
                if (tr != null)
                    tr.rollback();
                he.printStackTrace();
            }
            finally
            {
                session.close();
            }
        }
        else if (type.equals("jewelry") && !name.equals(null) && price != 0)
        {
            try
            {
                maxDataSize = maxDataSize + 1;
                maxJewelrySize = maxJewelrySize + 1;
                tr = session.beginTransaction();
                
                ProductDemo productDemo = new ProductDemo(name, type,  metal, clasp, chainLength, chainType, width, length, rhodiumPlated, numberOfCenterRoundDiamonds, minimumCaratTotalWeight, minimumColor, minimumClarity, minimumCut, settingType, price, path);
                productDemoId = (Integer) session.save(productDemo);

                initializedListProductDemo.add(productDemo);

                tr.commit();
            }
            catch (HibernateException he)
            {
                maxDataSize = maxDataSize - 1;
                maxJewelrySize = maxJewelrySize - 1;
                if (tr != null)
                    tr.rollback();
                he.printStackTrace();
            }
            finally
            {
                session.close();
            }
            
        }

        return productDemoId;
    }
    
    
    public void updateProductDemo(ProductDemo p)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        Integer productDemoId = p.getId();
        String name = p.getName();
        String type = p.getType();
        String brand = p.getBrand();
        String model = p.getModel();
        String gender = p.getGender();
        String movement = p.getMovement();
        String watchLabel = p.getWatchLabel();
        double caseSize = p.getCaseSize();
        double caseThickness = p.getCaseThickness();
        String caseMaterial = p.getCaseMaterial();
        String caseShape = p.getCaseShape();
        String dialType = p.getDialType();
        String dialColor = p.getDialColor();
        String crystal = p.getCrystal();
        String waterResistance = p.getWaterResistance();
        
        String metal = p.getMetal();
        String clasp = p.getClasp();
        double chainLength = p.getChainLength();
        String chainType = p.getChainType();
        double width = p.getWidth();
        double length = p.getLength();
        String rhodiumPlated = p.getRhodiumPlated();
        int numberOfCenterRoundDiamonds = p.getNumberOfCenterRoundDiamonds();
        double minimumCaratTotalWeight = p.getMinimumCaratTotalWeight();
        String minimumColor = p.getMinimumColor();
        String minimumClarity = p.getMinimumClarity();
        String minimumCut = p.getMinimumCut();
        String settingType = p.getSettingType();
        
        double price = p.getPrice();
        String path = p.getPath();
        
        try
        {
            tx = session.beginTransaction();
            ProductDemo productDemo = session.get(ProductDemo.class, productDemoId);
            productDemo.setName(name);
            productDemo.setType(type);
            productDemo.setBrand(brand);
            productDemo.setGender(gender);
            productDemo.setMovement(movement);
            productDemo.setWatchLabel(watchLabel);
            productDemo.setCaseSize(caseSize);
            productDemo.setCaseThickness(caseThickness);
            productDemo.setCaseMaterial(caseMaterial);
            productDemo.setCaseShape(caseShape);
            productDemo.setDialType(dialType);
            productDemo.setDialColor(dialColor);
            productDemo.setCrystal(crystal);
            productDemo.setWaterResistance(waterResistance);
            
            productDemo.setMetal(metal);
            productDemo.setClasp(clasp);
            productDemo.setChainLength(chainLength);
            productDemo.setChainType(chainType);
            productDemo.setWidth(width);
            productDemo.setLength(length);
            productDemo.setRhodiumPlated(rhodiumPlated);
            productDemo.setNumberOfCenterRoundDiamonds(numberOfCenterRoundDiamonds);
            productDemo.setMinimumCaratTotalWeight(minimumCaratTotalWeight);
            productDemo.setMinimumColor(minimumColor);
            productDemo.setMinimumClarity(minimumClarity);
            productDemo.setMinimumCut(minimumCut);
            productDemo.setSettingType(settingType);

            productDemo.setPrice(price);
            productDemo.setPath(path);
            
            tx.commit();
            
           updateProductIntoList(productDemo);
            
        }
        catch (HibernateException he)
        {
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }

    }

    public List<ProductDemo> listProductDemo()
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            tr = session.beginTransaction();
//            Criteria crit = session.createCriteria(ProductDemo.class);
 //           List<ProductDemo> products = crit.list();
            String hql = "from ProductDemo";
            Query query = session.createQuery(hql);
            
            return query.list();            
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
            return null;
        }
        finally
        {
            session.close();
        }
    }

    public void removeProductDemo(Integer id)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            maxDataSize = maxDataSize - 1;
            tr = session.beginTransaction();
            ProductDemo productDemo = session.get(ProductDemo.class, id);
            if (productDemo != null)
            {
                session.delete(productDemo);
                ;
                
                if (initializedListDelete.size() == 0)
                {
                    System.out.println("== 0");
                
                    initializedListDelete.add(id);                        
                    shiftIndex(id);
                    
                }
                else
                {
                    boolean isExistId = false;
                    boolean isContinue = true;
                    int index = 0;
                    
                    int listDeleteSize = initializedListDelete.size();
                    
                    while (index < listDeleteSize && isContinue == true)
                    {
                        
                        if (initializedListDelete.get(index) == id)
                        {
                            isContinue = false;
                        }
                        
                        index = index + 1;
                    }
                    
                    if (isContinue == true)
                    {
                        shiftIndex(id);
                        

                        initializedListDelete.add(id);                        
                        shiftIndex(id);
                    }
                } 
                
                tr.commit();
            }            
        }
        catch (HibernateException he)
        {
            maxDataSize = maxDataSize + 1;
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }
    
    @SuppressWarnings("deprecation")
	public List<ProductDemo> returnProductsForOnePage(int pageNumber, int pageSize)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        int maxPageSize;
        
        try
        {
            tr = session.beginTransaction();
            
            if (maxDataSize == 0)
            {
                List<ProductDemo> products = new ArrayList<ProductDemo>();
                ProductDemo product = new ProductDemo(0, 0);
                products.add(product);
                
                return products;
            }
			
            if (maxDataSize%pageSize == 0)
            {
                maxPageSize = (int) maxDataSize/pageSize;            	
            }
            else
            {
                maxPageSize = (int) maxDataSize/pageSize + 1;
            }
            
            //page number nay vuot wa' so luong data
            if (pageNumber > maxPageSize || pageNumber == 0)
            {
                return null;
            }
            else
            {
                Criteria crit = session.createCriteria(ProductDemo.class)
                                        .setFirstResult(((pageNumber-1)*pageSize))
                                        .setMaxResults(pageSize);
                List<ProductDemo> productDemos = crit.list();
                ProductDemo productDemoForCount = new ProductDemo(maxPageSize, maxDataSize);
                productDemos.add(productDemoForCount); 
                
                return productDemos;
            }
        }
        catch(HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
        
        return null;
    }
    
    //**************
    public List<ProductDemo> returnProductsForOnePagee(int pageNumber, int pageSize)
                             
    {
        int maxPageSize;
        int loopSize;
        
        if (maxDataSize == 0)
        {
            List<ProductDemo> products = new ArrayList<ProductDemo>();
            ProductDemo product = new ProductDemo(0, 0);
            products.add(product);
            
            return products;
        }
        
        if (maxDataSize%pageSize == 0)
            maxPageSize = (int) maxDataSize/pageSize;
        else
            maxPageSize = (int) maxDataSize/pageSize + 1;
        
        
        List<ProductDemo> products = new ArrayList<ProductDemo>();
        
        if (pageNumber*pageSize > maxDataSize)
            loopSize = maxDataSize-(pageNumber-1)*pageSize;
        else
            loopSize = 8;
        
        for (int i = 0; i < loopSize; i++)
        {
            products.add(initializedListProductDemo.get((pageNumber-1)*pageSize+i));
        }    


        products.add(new ProductDemo(maxPageSize, maxDataSize));
        
        return products;
    }
    //**************
    
    public List<ProductDemo> returnProductsForSearchNameForOnePage(int pageNumber, int pageSize, String name)
    {
//        int countSearchedName = 0;
//        int index = 0;
//        int maxProductAddedSize = 0;
//        List<ProductDemo> products = new ArrayList<ProductDemo>();
//
//        while (index < maxDataSize)
//        {
//            if (initializedListProductDemo.get(index).getName().toLowerCase().contains(name.toLowerCase()) == true)
//            {
//                countSearchedName = countSearchedName + 1;
//                if (countSearchedName >= (pageNumber -1)*8+1 && maxProductAddedSize < 8)
//                {
//                    products.add(initializedListProductDemo.get(index));
//                    maxProductAddedSize = maxProductAddedSize + 1;
//                }
//            } 
//            
//            index = index + 1;
//        }
//        
//        if (countSearchedName == 0)
//            products.add(new ProductDemo(0, 0));
//        else if (countSearchedName%pageSize == 0)
//            products.add(new ProductDemo(countSearchedName/pageSize, countSearchedName));
//        else
//            products.add(new ProductDemo(countSearchedName/pageSize+1, countSearchedName));
//        
//        return products;

        
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        boolean isStore = false;
        long maxSearchSize;
        int s = 0;
        
        int maxPageSize;
        
        try
        {
            tr = session.beginTransaction();
            if (countList.size() == 0)
            {
                maxSearchSize =  (Long) session.createCriteria(ProductDemo.class).add(Restrictions.like("name", "%" + name + "%")).setProjection(Projections.rowCount()).uniqueResult();
                s = (int) maxSearchSize;
                countList.add(new StorageSearch(name, s));
            }
            else
            {
                int storageSize = countList.size();
                for (int i = 0; i < storageSize; i ++)
                {
                    if (countList.get(i).getName().equals(name))
                    {
                        isStore = true;
                        s = countList.get(i).getNumber();
                        break;
                    }
                }
                
                if (isStore == false)
                {
                    maxSearchSize =  (Long) session.createCriteria(ProductDemo.class).add(Restrictions.like("name", "%" + name + "%")).setProjection(Projections.rowCount()).uniqueResult();
                    s = (int) maxSearchSize;
                    countList.add(new StorageSearch(name, s));
                }
            }

            if (s == 0)
            {
                List<ProductDemo> products = new ArrayList<ProductDemo>();
                ProductDemo product = new ProductDemo(0, 0);
                products.add(product);
                return products;
            }
            
            if (s%pageSize == 0)
            {
                maxPageSize = (int) s/pageSize;               
            }
            else
            {
                maxPageSize = (int) s/pageSize + 1;
            }
            
            //page number nay vuot wa' so luong data
            if (pageNumber > maxPageSize || pageNumber == 0)
            {
                return null;
            }
            else
            {
                Criteria crit = session.createCriteria(ProductDemo.class)
                                        .add(Restrictions.like("name", "%" + name + "%"))
                                        .setFirstResult(((pageNumber-1)*pageSize))
                                        .setMaxResults(pageSize);
                List<ProductDemo> productDemos = crit.list();
                ProductDemo productDemoForCount = new ProductDemo(maxPageSize, s);
                productDemos.add(productDemoForCount); 
                return productDemos;
            }
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
        
        return null;
    }
  
    public List<ProductDemo> returnProductsWatchForOnePage(int pageNumber, int pageSize)
    {
        int maxPageSize;
        
        if (maxWatchSize%pageSize == 0)
        {
            maxPageSize = (int) maxWatchSize/pageSize;               
        }
        else
        {
            maxPageSize = (int) maxWatchSize/pageSize + 1;
        }
        
        //page number nay vuot wa' so luong data
        if (pageNumber > maxPageSize || pageNumber == 0)
        {
            return null;
        }
        else
        {
            List<ProductDemo> products = new ArrayList<ProductDemo>();
            boolean isContinue = true;
            int index = 0;
            int indexGetCount = 0;
            int maxIndexGet;
            
            if (pageNumber < maxPageSize)
            {
                maxIndexGet = pageNumber * 8;
            }
            else
            {
                maxIndexGet = maxWatchSize;
            }
            
            while (index < maxDataSize && isContinue == true)
            {
                if (initializedListProductDemo.get(index).getType().equals("watch"))
                {
                    
                    indexGetCount = indexGetCount + 1;
                    
                    if (indexGetCount >= (pageNumber-1)*8+1 && indexGetCount <= maxIndexGet)
                        products.add(initializedListProductDemo.get(index));
                }
                
                if (indexGetCount == maxIndexGet)
                    isContinue = false;
                
                index = index + 1;
            }
            
            ProductDemo productDemoForCount = new ProductDemo(maxPageSize, maxWatchSize);
            products.add(productDemoForCount); 
            
            return products;
        }
    }

    public List<ProductDemo> returnProductsJewelryForOnePage(int pageNumber, int pageSize)
    {
        int maxPageSize;
        
        if (maxJewelrySize%pageSize == 0)
        {
            maxPageSize = (int) maxJewelrySize/pageSize;               
        }
        else
        {
            maxPageSize = (int) maxJewelrySize/pageSize + 1;
        }
        
        //page number nay vuot wa' so luong data
        if (pageNumber > maxPageSize || pageNumber == 0)
        {
            return null;
        }
        else
        {
            List<ProductDemo> products = new ArrayList<ProductDemo>();
            boolean isContinue = true;
            int index = 0;
            int indexGetCount = 0;
            int maxIndexGet;
            
            if (pageNumber < maxPageSize)
            {
                maxIndexGet = pageNumber * 8;
            }
            else
            {
                maxIndexGet = maxJewelrySize;
            }
            while (index < maxDataSize && isContinue == true)
            {
                if (initializedListProductDemo.get(index).getType().equals("jewelry"))
                {
                    indexGetCount = indexGetCount + 1;
                    
                    if (indexGetCount >= (pageNumber-1)*8+1 && indexGetCount <= maxIndexGet)
                        products.add(initializedListProductDemo.get(index));
                }
                
                if (indexGetCount == maxIndexGet)
                    isContinue = false;
                
                index = index + 1;
            }
            
            ProductDemo productDemoForCount = new ProductDemo(maxPageSize, maxJewelrySize);
            products.add(productDemoForCount); 
            
            return products;
        }
    }

    public List<ProductDemo> returnAmountOfProduct(int number)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            tr = session.beginTransaction();
            int maxPageSize;

            List<ProductDemo> products = session.createCriteria(ProductDemo.class)
                                                .setFirstResult(0)
                                                .setMaxResults(number)
                                                .list();
            
            if (number%8 == 0)
            {
                maxPageSize = number/8;
            }
            else
            {
                maxPageSize = number/8 + 1;
            }
            
            ProductDemo p = new ProductDemo(maxPageSize, number);
            
            products.add(p);
            
            return products;
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
        
        return null;
    }
    
    public int getMaxDataSize()
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        int maxSizeData;
        
        try
        {
            tr = session.beginTransaction();
            String hql = "Select count(*) from ProductDemo";
            Query query = session.createQuery(hql);
            maxSizeData = ((Long) query.uniqueResult()).intValue();
            
            return maxSizeData;
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
        
        return 0;
    }

    public int getMaxWatchSize()
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            String hql = "Select count(*) from ProductDemo as p where p.type = 'watch'";
            Query query = session.createQuery(hql);
            int maxWatchSize = ((Long) query.uniqueResult()).intValue();
            
            return maxWatchSize;
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
        
        return 0;
    }

    public int getMaxJewelrySize()
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            String hql = "Select count(*) from ProductDemo as p where p.type = 'jewelry'";
            Query query = session.createQuery(hql);
            int maxWatchSize = ((Long) query.uniqueResult()).intValue();
            
            return maxWatchSize;
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
        
        return 0;
    }

    public void initializeListProduct()
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try 
        {
            tr = session.beginTransaction();
            
            Criteria crit = session.createCriteria(ProductDemo.class);            
 //           initializedListProductDemo = crit.setFirstResult(0).setMaxResults(100).list();
            initializedListProductDemo = crit.list();
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }
    
    public String getCurrentTimeStamp()
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    public void getInfoMemory()
    {
        Runtime rt = Runtime.getRuntime();
        long totalMem = rt.totalMemory();
        long maxMem = rt.maxMemory();
        long freeMem = rt.freeMemory();
        double megs = 1048576.0;

        System.out.println ("Total Memory: " + totalMem + " (" + (totalMem/megs) + " MiB)");
        System.out.println ("Max Memory:   " + maxMem + " (" + (maxMem/megs) + " MiB)");
        System.out.println ("Free Memory:  " + freeMem + " (" + (freeMem/megs) + " MiB)");
        
        //Get the jvm heap size.
        long heapSize = Runtime.getRuntime().totalMemory();

        //Print the jvm heap size.
        System.out.println("Heap Size = " + heapSize/megs);
    }

    public void shiftIndex(int id)
    {
        boolean isContinue = true;
        int index = 0;
        int startShift = -1;
        
        while (isContinue == true && index <= maxDataSize)
        {
            if (initializedListProductDemo.get(index).getId() == id)
            {
                startShift = index;
                isContinue = false;
            }
            
            index = index + 1;
        }
        
        isContinue = true;
        
        while (isContinue == true && startShift < maxDataSize && startShift != -1)
        {
            initializedListProductDemo.set(startShift, initializedListProductDemo.get(startShift+1));
            startShift = startShift + 1;
        }
       
        initializedListProductDemo.remove(maxDataSize);                   
    }
    
    public void updateProductIntoList(ProductDemo p)
    {
        for (int i = 0; i < maxDataSize; i++)
        {
            if (initializedListProductDemo.get(i).getId() == p.getId())
            {
                initializedListProductDemo.set(i, p);
            }
        }
    }
}
