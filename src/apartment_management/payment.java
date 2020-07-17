/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartment_management;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class payment {
     private String  empid,date,salary;
     public payment(String empid,String date,String salary)
    {
       this.empid=empid;
       this.date=date;
       this.salary=salary;
       
    }
      public String getempid()
    {
        return empid;
    }
      public String getdate()
    {
        return date;
    }
      public String getsalary()
    {
        return salary;
    }
}
