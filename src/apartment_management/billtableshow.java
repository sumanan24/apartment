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
public class billtableshow {
    private String  billno,ownerid,date,total,status;
    public billtableshow(String billno,String ownerid,String date,String total,String status)
    {
       this.billno=billno;
       this.ownerid=ownerid;
       this.date=date;
       this.total=total;
       this.status=status;
    }
    public String getbillno()
    {
        return billno;
    }
public String getownerid()
    {
        return ownerid;
    }
public String getdate()
    {
        return date;
    }

public String gettotal()
    {
        return total;
    }
public String getstatus()
    {
        return status;
    }
}