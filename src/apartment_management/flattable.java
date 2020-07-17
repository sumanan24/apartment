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
public class flattable {
    private String  flatno,floor,flattype,position,ownerid,amount;
     public flattable(String flatno,String floor,String flattype,String position,String ownerid,String amount)
    {
       this.flatno=flatno;
       this.floor=floor;
       this.flattype=flattype;
       this.position=position;
       this.ownerid=ownerid;
       this.amount=amount;
    }
     public String getflatno()
    {
        return flatno;
    }
      public String getfloor()
    {
        return floor;
    }
       public String getflattype()
    {
        return flattype;
    }
        public String getposition()
    {
        return position;
    }
        public String getownerid()
    {
        return ownerid;
    }
        public String getamount()
    {
        return amount;
    }
        
}
