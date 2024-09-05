package Classes;
import Customer.*;
import loginframe.*;


public class CustomerLoginInformation {
    
    protected  String phnNumber;
    protected String id;
    protected  String pass;
    
    public CustomerLoginInformation(String phnNumber,String id,String pass)
    {
        this.phnNumber=phnNumber;
        this.id=id;
        this.pass=pass;
        
    }
    public void setPhnNumber(String phnNumber)
    {
        this.phnNumber=phnNumber;
    }
    public void setID(String id)
    {
        this.id=id;
    }
    public void setPass(String pass)
    {
        this.pass=pass;
    }
    
    public String getPhnNumber(){return phnNumber;}
    public String getID(){return id;}
    public String getPass(){return pass;}
    
}
