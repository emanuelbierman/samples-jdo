/**********************************************************************
Copyright (c) 2003 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
    ...
**********************************************************************/
package org.datanucleus.samples.jdo.tutorial;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Extent;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

/**
 * Controlling application for the DataNucleus Tutorial using JDO.
 * Relies on the user defining a file "datanucleus.properties" to be in the CLASSPATH
 * and to include the JDO properties for the DataNucleus PersistenceManager.
 */
public class Main
{
    public static void main(String args[])
    {
        // Create a PersistenceManagerFactory for this datastore
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");

        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        
//        Trying to read and write to an excel File
        
        
//        Links:
//        http://db.apache.org/jdo/
//        http://www.datanucleus.org/products/accessplatform_4_0/jdo/schema.html
//        https://github.com/emanuelbierman/samples-jdo/blob/master/tutorial/src/main/resources/package-excel.orm
        
        
        
        
        // Persistence of a Country.
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
      {
          tx.begin();
       
          Country england = new Country();
        england.setName("England");
        
        pm.makePersistent(england);
        
        tx.commit();
        
        
//        Object inventoryId = null;
//        
//            System.out.println("Persisting Inventory of products");
//            Inventory inv = new Inventory("1Test Inventory");
//            Product product = new Product("1Television Set","A standard tv set",400.00);
//            Book book = new Book("1The Bible","The classic story",29.99,"Unknown", "12345678", "MyBooks Factory");
//            inv.getProducts().add(product);
//            inv.getProducts().add(book);
////          pm.makePersistent(inv);
// 
//            Product product1 = new Product("1Christmas Tree","An object with wood",100.00);
//            Product product2 = new Product("1Socks","A thing for your feet",10.00);
//            Product product3 = new Product("1Jabberwocky","A monster for sale",100.00);
//            
//            List<Product> products = new ArrayList<>();
//            inv.getProducts().add(product1);
//            inv.getProducts().add(product2);
//            inv.getProducts().add(product3);
//            pm.makePersistent(inv);
//            
//            tx.commit();
//            inventoryId = pm.getObjectId(inv);
//            System.out.println("Inventory, Products and Book have been persisted");
//            System.out.println(inv);
//            System.out.println(product);
//            System.out.println(book);
//            products.forEach(p -> System.out.println(p));
//            
        }
        catch (Exception e)
        {
            System.out.println("Exception persisting data : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
//        System.out.println("");

        // Basic Extent of all Products
//        pm = pmf.getPersistenceManager();
//        tx = pm.currentTransaction();
//        try
//        {
//            tx.begin();
//            
//            
//            Query query = pm.newQuery(Country.class, "name==\"Afghanistan\"");
//            Country country = (Country) query.execute();
//            System.out.println(country);
//            Query q = pm.newQuery("SELECT FROM Country c WHERE c.name == :name");
//            String name = "Afhganistan";
//            q.declareImports("import org.datanucleus.samples.jdo.tutorial.Country");
//            Object result = q.execute(name);
//            System.out.println("Object retrieved:"+result.toString());
            
            
//            System.out.println("Retrieving Extent for Countries");
//            Extent<Country> e = pm.getExtent(Country.class);
//            Iterator<Country> iter = e.iterator();
//            while (iter.hasNext())
//            {
//                Country obj = iter.next();
//                System.out.println(">  " + obj);
//            }
//            tx.commit();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
//        }
//        finally
//        {
//            if (tx.isActive())
//            {
//                tx.rollback();
//            }
//            pm.close();
//        }
//        System.out.println("");

        // Perform some query operations
//        pm = pmf.getPersistenceManager();
//        tx = pm.currentTransaction();
//        try
//        {
//            tx.begin();
//            System.out.println("Executing Query for Products with price below 150.00");
//            Query q=pm.newQuery("SELECT FROM " + Product.class.getName() + 
//                " WHERE price < 150.00 ORDER BY price ASC");
//            List<Product> products = (List<Product>)q.execute();
//            Iterator<Product> iter = products.iterator();
//            while (iter.hasNext())
//            {
//                Product p = iter.next();
//                System.out.println(">  " + p);
//
//                // Give an example of an update
//                if (p instanceof Book)
//                {
//                    Book b = (Book)p;
//                    b.setDescription("This book has been reduced in price!");
//                }
//            }
//
//            tx.commit();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Exception performing queries : " + e.getMessage());
//        }
//        finally
//        {
//            if (tx.isActive())
//            {
//                tx.rollback();
//            }
//            pm.close();
//        }
//        System.out.println("");

        // Clean out the database
//        pm = pmf.getPersistenceManager();
//        tx = pm.currentTransaction();
//        try
//        {
//            tx.begin();
//
//            System.out.println("Retrieving Inventory using its id");
//            Inventory inv = (Inventory)pm.getObjectById(inventoryId);
//            System.out.println(inv);
//            System.out.println("Clearing out Inventory");
//            inv.getProducts().clear();
//
//            System.out.println("Deleting Inventory");
//            pm.deletePersistent(inv);
//
//            System.out.println("Deleting all products from persistence");
//            Query q = pm.newQuery(Product.class);
//            long numberInstancesDeleted = q.deletePersistentAll();
//            System.out.println("Deleted " + numberInstancesDeleted + " products");
//
//            tx.commit();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Exception cleaning out the database : " + e.getMessage());
//        }
//        finally
//        {
//            if (tx.isActive())
//            {
//                tx.rollback();
//            }
//            pm.close();
//        }

        System.out.println("");
        System.out.println("End of Tutorial");
        pmf.close();
    }
}
