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
public class ownertable {

    private String Name, ownerd, vechiletype, vechile_model, no_of_vechile, gender, phone, email, Vechile_no, Nic;
    

    public ownertable(String Name, String ownerd, String vechiletype, String vechile_model, String no_of_vechile, String gender, String phone, String email, String Vechile_no, String nic) {
        this.Name = Name;
        this.ownerd = ownerd;
        this.vechiletype = vechiletype;
        this.vechile_model = vechile_model;
        this.no_of_vechile = no_of_vechile;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        // this.Date=Date;
        this.Vechile_no = Vechile_no;
        this.Nic = nic;
//        this.flatno = flatno;
        
    }
    public String getName() {
        return Name;
    }

    public String getownerd() {
        return ownerd;
    }

    public String getvechiletype() {
        return vechiletype;
    }

    public String getvechile_model() {
        return vechile_model;
    }

    public String getno_of_vechile() {
        return no_of_vechile;
    }

    public String getgender() {
        return gender;
    }

    public String getphone() {
        return phone;
    }

    public String getemail() {
        return email;
    }

    public String getVechile_no() {
        return Vechile_no;
    }

    public String getNic() {
        return Nic;
    }
   
}
