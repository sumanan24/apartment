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
 * @author ICTSTUDENT
 */
public class billtable {
      private String  Detail,Amount;
     public billtable(String Detail,String Amount)
    {
       this.Detail=Detail;
       this.Amount=Amount;
       
    }
     public String getDetail()
    {
        return Detail;
    }
      public String getAmount()
    {
        return Amount;
    }
      
        
}
