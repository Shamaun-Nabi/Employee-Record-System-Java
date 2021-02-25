
package employeerecord;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Connect {
    
    String searchId="";
    double amt;
    static UapCse myUap= new UapCse("University of Asia Pacific");
    
    public void salaried(String name,String id,String des,double sal)
    {
        
        myUap.addNewEmployees(name, id, des, sal);
       
    }
      public void hourly(String name,String id,String des,double hr,int hw)
    {
        
        myUap.addNewEmployees(name, id, des, hr,hw);
       
    }
        public void commission(String name,String id,String des,double comissionRate,double comisionSale)
    {
        
        myUap.addNewEmployees(name, id, des,comissionRate,comisionSale);
       
    }
    public ArrayList<Employee> showres()
    {
       ArrayList <Employee> em = myUap.employees;
       return em; 
    }
    
    
   public String searchID()
   {
        Employee e=myUap.findEmployee(searchId);
        String ob= e.display();
        return ob;
}
   public String updateSalary()
   {
       Employee e= myUap.findEmployee(searchId);
       if(e==null)
       {
           return "No";
       }
       else{
           e.increaseSalary(amt);
           return "Yes";
       }
       
      
   }
   
   
     public String Salary()
   {
       Employee e= myUap.findEmployee(searchId);
       String name=e.getName();
       String id=e.getId();
       double sal=e.getSalary();
       return "Name: "+name+" Id: "+id+" Salary: "+sal;
       
   }
     
    public static void savaData(){
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"));
                out.writeObject(myUap.employees);
                out.flush();
                //out.close();
            } catch (Exception ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void loadData(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
            myUap.employees = (ArrayList<Employee>)in.readObject();
            in.close();
        } catch (Exception ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void deleteAllData(){
        for(int i = 0; i<myUap.employees.size(); i++){
            myUap.employees.clear();
            savaData();
        }
        
    }
     
     
   

    
}      
    
    
