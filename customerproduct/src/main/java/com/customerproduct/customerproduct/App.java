package com.customerproduct.customerproduct;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Customer-Product project starting..." );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
//        Product tv = new Product();
//        Product blender = new Product();
//        Product juicer = new Product();
//        Product vaccumCleaner = new Product();
//        Product washingMachine = new Product();
//        Product iron = new Product();
//        Product coffeeHeater = new Product();
//        Product microwave = new Product();
//        Product fridge = new Product();
//        Product laptop = new Product();
//        
//        tv.setPid(201);
//        tv.setPname("TV");
//        tv.setPrice(50000);
//        
//        blender.setPid(204);
//        blender.setPname("Blender");
//        blender.setPrice(3000);
//        
//        juicer.setPid(205);
//        juicer.setPname("Juicer");
//        juicer.setPrice(2500);
//        
//        vaccumCleaner.setPid(202);
//        vaccumCleaner.setPname("Vaccum Cleaner");
//        vaccumCleaner.setPrice(25000);
//        
//        washingMachine.setPid(203);
//        washingMachine.setPname("Washing Machine");
//        washingMachine.setPrice(27000);
//        
//        iron.setPid(206);
//        iron.setPname("Iron");
//        iron.setPrice(1700);
//        
//        coffeeHeater.setPid(207);
//        coffeeHeater.setPname("Coffee Heater");
//        coffeeHeater.setPrice(1200);
//        
//        microwave.setPid(208);
//        microwave.setPname("Microwave");
//        microwave.setPrice(15000);
//        
//        fridge.setPid(209);
//        fridge.setPname("Refrigerator");
//        fridge.setPrice(38000);
//        
//        laptop.setPid(210);
//        laptop.setPname("Laptop");
//        laptop.setPrice(75000);
//        
//        List<Product> listForSuraj = new ArrayList<Product>();
//        listForSuraj.add(tv);
//        listForSuraj.add(vaccumCleaner);
//        listForSuraj.add(fridge);
//        
//        List<Product> listForRiddhi = new ArrayList<Product>();
//        listForRiddhi.add(vaccumCleaner);
//        listForRiddhi.add(juicer);
//        listForRiddhi.add(fridge);
//        
//        List<Product> listForAjay = new ArrayList<Product>();
//        listForAjay.add(tv);
//        listForAjay.add(juicer);
//        listForAjay.add(iron);
//        
//        List<Product> listForKavita = new ArrayList<Product>();
//        listForKavita.add(tv);
//        listForKavita.add(juicer);
//        listForKavita.add(coffeeHeater);
//        
//        List<Product> listForTina = new ArrayList<Product>();
//        listForTina.add(tv);
//        listForTina.add(juicer);
//        listForTina.add(microwave);
//        listForTina.add(blender);
//       
//        List<Product> listForVinay = new ArrayList<Product>();
//        listForVinay.add(juicer);
//        listForVinay.add(microwave);
//        listForVinay.add(fridge);
//        
//        List<Product> listForNeha = new ArrayList<Product>();
//        listForNeha.add(washingMachine);
//        listForNeha.add(iron);
//        listForNeha.add(coffeeHeater);
//        listForNeha.add(laptop);
//        
//        List<Product> listForKiara = new ArrayList<Product>();
//        listForKiara.add(washingMachine);
//        listForKiara.add(blender);
//        listForKiara.add(laptop);
//        
//        
//        
//        Customer suraj = new Customer(101,"Suraj", "Akola", listForSuraj);
//        Customer riddhi = new Customer(102,"Riddhi", "Pune", listForRiddhi );
//        Customer ajay = new Customer(103,"Ajay", "Mumbai", listForAjay );
//        Customer kavita = new Customer(104,"Kavita", "Delhi", listForKavita );
//        Customer tina = new Customer(105,"Tina", "Pune", listForTina );
//        Customer vinay = new Customer(106,"Vinay", "Pune", listForVinay );
//        Customer neha = new Customer(107,"Neha", "Pune", listForNeha );
//        Customer kiara = new Customer(108,"Kiara", "Mumbai", listForKiara );
//        
//        List<Customer> tv_customers= new ArrayList<Customer>();
//        tv_customers.add(suraj);
//        tv_customers.add(ajay);
//        tv_customers.add(kavita);
//        tv_customers.add(tina);
//        
//        tv.setCustomer(tv_customers);
//        
//        List<Customer> vc_customers= new ArrayList<Customer>();
//        vc_customers.add(suraj);
//        vc_customers.add(kavita);
//        
//        vaccumCleaner.setCustomer(vc_customers);
//        
//        List<Customer> wm_customers = new ArrayList<Customer>();
//        wm_customers.add(neha);
//        wm_customers.add(kiara);
//        
//        washingMachine.setCustomer(wm_customers);
//        
//        List<Customer> blender_customers = new ArrayList<Customer>();
//        blender_customers.add(tina);
//        blender_customers.add(kiara);
//       
//        blender.setCustomer(blender_customers);
//        
//        List<Customer> juicer_customers = new ArrayList<Customer>();
//        juicer_customers.add(riddhi);
//        juicer_customers.add(ajay);
//        juicer_customers.add(kavita);
//        juicer_customers.add(tina);
//        juicer_customers.add(vinay);
//        
//        juicer.setCustomer(juicer_customers);
//        
//        List<Customer> iron_customers = new ArrayList<Customer>();
//        iron_customers.add(ajay);
//        iron_customers.add(neha);
//        
//        iron.setCustomer(iron_customers);
//        
//        List<Customer> ch_customers = new ArrayList<Customer>();
//        ch_customers.add(kavita);
//        ch_customers.add(neha);
//        
//        coffeeHeater.setCustomer(ch_customers);
//        
//        List<Customer> microwave_customers = new ArrayList<Customer>();
//        microwave_customers.add(tina);
//        microwave_customers.add(vinay);
//        
//        microwave.setCustomer(microwave_customers);
//        
//        List<Customer> fridge_customers = new ArrayList<Customer>();
//        fridge_customers.add(suraj);
//        fridge_customers.add(riddhi);
//        fridge_customers.add(vinay);
//        
//        fridge.setCustomer(fridge_customers);
//        
//        List<Customer> laptop_customers = new ArrayList<Customer>();
//        laptop_customers.add(kiara);
//        laptop_customers.add(neha);
//        
//        laptop.setCustomer(laptop_customers);
        
        Transaction tx = session.beginTransaction();
//        session.save(suraj);
//        session.save(riddhi);
//        session.save(ajay);
//        session.save(kavita);
//        session.save(tina);
//        session.save(vinay);
//        session.save(neha);
//        session.save(kiara);
//        
//        session.save(tv);
//        session.save(vaccumCleaner);
//        session.save(washingMachine);
//        session.save(blender);
//        session.save(juicer);
//        session.save(iron);
//        session.save(coffeeHeater);
//        session.save(microwave);
//        session.save(fridge);
//        session.save(laptop);
        
        Criteria criteria = session.;
        
        criteria.add(Restrictions.eq("pname", "laptop"));
        criteria.add(Restrictions.ge("price", 10000));
        List<Product> list1 = criteria.list();
        
        for(Product p: list1) {
        	System.out.println(p);
        }
        tx.commit();
      
        session.close();
        factory.close();
    }
}
