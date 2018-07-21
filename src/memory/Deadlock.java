package memory;
import static java.lang.System.in;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class Deadlock {
	public static void main (String[] args) {
		
	

    Integer o1 = new Integer(1);
    Integer o2 = new Integer(2);
		
	
    new Thread(
    		()->
    		{
    			synchronized(o1)
    			{
    				System.out.println("Lock 1 by 1");
    				try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
    				
    				synchronized(o2)
    				{
    					System.out.println("Lock 2 by 1");
    				}
    			}
    		}
    		,"Nayan1").start();
    
		
    
    new Thread(
    		()->
    		{
    			synchronized(o2)
    			{
    				System.out.println("Lock 2 by 2");
    				try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
    				synchronized(o1)
    				{
    					System.out.println("Lock 1 by e");
    				}
    			}
    		}
    		,"Nayan2").start();
    
    
    
    
	}
}