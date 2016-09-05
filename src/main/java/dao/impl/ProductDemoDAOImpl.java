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
    
    private static List<StorageSearch> countListForSearchName = new ArrayList<StorageSearch>();
    
    private static int maxDataSize;
    private static int maxWatchSize;
    private static int maxJewelrySize;

    public int addProductDemo(ProductDemo p)
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
                
                tr = session.beginTransaction();
                
                ProductDemo productDemo = new ProductDemo(name, type, brand, model, gender, movement, watchlabel, caseSize, caseThickness, caseMaterial, caseShape, dialType, dialColor, crystal, waterResistance, price, path);
                productDemoId = (Integer) session.save(productDemo);
                
                tr.commit();
                maxDataSize = maxDataSize + 1;
                maxWatchSize = maxWatchSize + 1;
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
                tr = session.beginTransaction();
                
                ProductDemo productDemo = new ProductDemo(name, type,  metal, clasp, chainLength, chainType, width, length, rhodiumPlated, numberOfCenterRoundDiamonds, minimumCaratTotalWeight, minimumColor, minimumClarity, minimumCut, settingType, price, path);
                productDemoId = (Integer) session.save(productDemo);

                tr.commit();
                maxDataSize = maxDataSize + 1;
                maxJewelrySize = maxJewelrySize + 1;
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
        else
            return 244;

        reCountListAfterAddOrUpdate(name);
        
        return 200;
    }
    
    public int updateProductDemo(ProductDemo p)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        String oldName;
        String oldType;
        
        int id = p.getId();
        
        boolean case1 = false;
        boolean case2 = false;
        
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
            tr = session.beginTransaction();
            ProductDemo productDemo = session.get(ProductDemo.class, id);
            
            oldName = productDemo.getName();
            oldType = productDemo.getType();
            
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
            
            if (type.equals("watch") && name != null && price != 0)
            {
                tr.commit();
                
                if (oldType.equals("jewelry"))
                {
                    maxWatchSize = maxWatchSize - 1;
                    maxJewelrySize = maxJewelrySize + 1;
                    case1 = true;
                }
            }
            else if (type.equals("jewelry") && name != null && price != 0)
            {
                tr.commit();
                
                if (oldType.equals("watch"))
                {
                    maxWatchSize = maxWatchSize + 1;
                    maxJewelrySize = maxJewelrySize - 1;
                    case2 = true;
                }
            }
            else
                return 245;
            
            reCountListAfterRemove(oldName);
            reCountListAfterAddOrUpdate(name);
            
            return 200;            
            
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            
            if (case1 == true)
            {
                maxWatchSize = maxWatchSize + 1;
                maxJewelrySize = maxJewelrySize - 1;
            }
            else if (case2 = true)
            {
                maxWatchSize = maxWatchSize - 1;
                maxJewelrySize = maxJewelrySize + 1;
            }
            
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }

        return 245;
    }

    public int removeProductDemo(int id)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
             tr = session.beginTransaction();
             
             ProductDemo productDemo = session.get(ProductDemo.class, id);
             String name = productDemo.getName();
             String type = productDemo.getType();
             
             if (productDemo == null)
                 return 246;
             else
             {
                 session.delete(productDemo);
                 tr.commit();
                 
                 if (type.equals("watch"))
                 {
                     maxWatchSize = maxWatchSize - 1;
                     maxDataSize = maxDataSize -1;
                 }
                 else if (type.equals("jewelry"))
                 {
                     maxJewelrySize = maxJewelrySize - 1;
                     maxDataSize = maxDataSize -1;
                 }
                 
                 reCountListAfterRemove(name);
                 
                 return 200;           
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
        
        return 246;
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
                productDemos.add(new ProductDemo(maxPageSize, maxDataSize)); 
                
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
    
    public List<ProductDemo> returnProductsWatchForOnePage(int pageNumber, int pageSize)
    {
        int maxPageSize;
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        if (maxWatchSize%pageSize == 0)
        {
            maxPageSize = (int) maxWatchSize/pageSize;               
        }
        else
        {
            maxPageSize = (int) maxWatchSize/pageSize + 1;
        }
        
        if (pageNumber > maxPageSize || pageNumber == 0)
        {
            return null;
        }
        else
        {
            try 
            {
                tr = session.beginTransaction();
                Criteria criteria = session.createCriteria(ProductDemo.class);
                criteria.add(Restrictions.eq("type", "watch"))
                        .setFirstResult(((pageNumber-1)*pageSize))
                        .setMaxResults(pageSize);
                List<ProductDemo> products = criteria.list();
                products.add(new ProductDemo(maxPageSize, maxWatchSize));
                
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
        }
        
        return null;
    }

    public List<ProductDemo> returnProductsJewelryForOnePage(int pageNumber, int pageSize)
    {
        int maxPageSize;
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        if (maxJewelrySize%pageSize == 0)
        {
            maxPageSize = (int) maxJewelrySize/pageSize;               
        }
        else
        {
            maxPageSize = (int) maxJewelrySize/pageSize + 1;
        }
        
        if (pageNumber > maxPageSize || pageNumber == 0)
        {
            return null;
        }
        else
        {
            try 
            {
                tr = session.beginTransaction();
                Criteria criteria = session.createCriteria(ProductDemo.class);
                criteria.add(Restrictions.eq("type", "jewelry"))
                        .setFirstResult(((pageNumber-1)*pageSize))
                        .setMaxResults(pageSize);
                List<ProductDemo> products = criteria.list();
                products.add(new ProductDemo(maxPageSize, maxJewelrySize));
                
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
        }
        
        return null;
    }

    public List<ProductDemo> returnProductsForSearchNameForOnePage(int pageNumber, int pageSize, String name)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        int countSize = 0;
        int maxPageSize;
        List<ProductDemo> products;
        boolean isFound = false;
        printCountList();
        
        try
        {
            tr = session.beginTransaction();
            
            if (countListForSearchName.size() == 0)
            {
                countSize = countDataWithCorrespondingName(name);
                countListForSearchName.add(new StorageSearch(name, countSize));
                isFound = true;
            }
            else
            {
                int index = 0;
                int maxSize = countListForSearchName.size();
                boolean isContinue = true;
                
                while (index < maxSize && isContinue == true)
                {
                    if (countListForSearchName.get(index).getName().equals(name))
                    {
                        isContinue = false;
                        countSize = countListForSearchName.get(index).getNumber();
                        isFound = true;
                    }
                    
                    index = index + 1;
                }
            }
            
            if (isFound == false)
            {
                countSize = countDataWithCorrespondingName(name);
                countListForSearchName.add(new StorageSearch(name, countSize));
                isFound = true;
            }

            if (countSize == 0)
            {
                products = new ArrayList<ProductDemo>();
                products.add(new ProductDemo(0, 0));
                
                return products;
            }
            else
            {
                if (countSize%pageSize == 0)
                    maxPageSize = (int) countSize/pageSize;
                else
                    maxPageSize = (int) countSize/pageSize + 1;
                
                if (pageNumber > maxPageSize || pageNumber <= 0)
                {
                    products = new ArrayList<ProductDemo>();
                    products.add(new ProductDemo(maxPageSize, countSize));
                    
                    return products;
                }
                else
                {
                    Criteria criteria = session.createCriteria(ProductDemo.class);
                    products = criteria.add(Restrictions.like("name", "%" + name + "%")).setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize).list();
                    products.add(new ProductDemo(maxPageSize, countSize));
                    
                    return products;  
                }
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
    
    public List<ProductDemo> returnAmountOfProduct(int number)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            tr = session.beginTransaction();
            int maxPageSize;
            List<ProductDemo> products;
           
            if (number <= 0)
            {
                products = new ArrayList<ProductDemo>();
                products.add(new ProductDemo(0,0));
            }
            else
            {
                products = session.createCriteria(ProductDemo.class)
                    .setFirstResult(0)
                    .setMaxResults(number)
                    .list();

                if (number%8 == 0)
                    maxPageSize = number/8;
                else
                    maxPageSize = number/8 + 1;
                
                ProductDemo p = new ProductDemo(maxPageSize, number);
                
                products.add(p);  
            }
            
            
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
    
    public void getMaxDataSize()
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        int maxSizeData;
        
        try
        {
            tr = session.beginTransaction();
            Criteria criteria = session.createCriteria(ProductDemo.class);
            maxDataSize = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
            System.out.println("max data size = " + maxDataSize);
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

    public void getMaxWatchSize()
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            tr = session.beginTransaction();
            Criteria criteria = session.createCriteria(ProductDemo.class);
            maxWatchSize = ((Long) criteria.add(Restrictions.eq("type", "watch")).setProjection(Projections.rowCount()).uniqueResult()).intValue();
            System.out.println("max watch size = " + maxWatchSize);
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

    public void getMaxJewelrySize()
    {
        maxJewelrySize = maxDataSize - maxWatchSize;
        System.out.println("max jewelry size = " + maxJewelrySize);
    }

    public int countDataWithCorrespondingName(String name)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        int countSize = 0;
        
        try 
        {
            tr = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(ProductDemo.class);
            countSize = ((Long) criteria.add(Restrictions.like("name", "%" + name + "%")).setProjection(Projections.rowCount()).uniqueResult()).intValue();
            System.out.println("count size = " + countSize);
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
        
        return countSize;
    } 

    public void printCountList()
    {
        System.out.println("count List Size = " + countListForSearchName.size());
        
        for (int i = 0; i < countListForSearchName.size(); i++)
        {
            System.out.println("name = " + countListForSearchName.get(i).getName() + "\tsize = " + countListForSearchName.get(i).getNumber());
        }
        
        System.out.println("\n");
    }
    
    public void reCountListAfterAddOrUpdate(String name)
    {
        for (int i = 0; i < countListForSearchName.size(); i ++)
        {
            if (name.toLowerCase().contains(countListForSearchName.get(i).getName().toLowerCase()) == true)
            {
                countListForSearchName.get(i).setNumber(countListForSearchName.get(i).getNumber()+1);
            }
        }
    }

    public void reCountListAfterRemove(String name)
    {
        for (int i = 0; i < countListForSearchName.size(); i ++)
        {
            if (name.toLowerCase().contains(countListForSearchName.get(i).getName().toLowerCase()) == true)
            {
                countListForSearchName.get(i).setNumber(countListForSearchName.get(i).getNumber()-1);
            }
        }       
    }
}
