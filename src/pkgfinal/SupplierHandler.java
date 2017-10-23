/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author vanta
 */
public class SupplierHandler {
    
  private int sid;
  private String sname;
  private String saddress;
  private String scity;
  private String spostalcode;
  private String scountry;
  private String sphone;
  private String semail;
    
   public SupplierHandler(int sid, String sname, String saddress,String scity,String spostalcode,String scountry,String sphone,String semail){
      
      this.sid=sid;
      this.sname=sname;
      this.saddress=saddress;
      this.scity=scity;
      this.spostalcode=spostalcode;
      this.scountry=scountry;
      this.sphone=sphone;
      this.semail=semail;
      
      
      
      
  }
   
   
   
   public static void main(String[] args) {
        new Login().setVisible(true);
    }

    
    
    public int getSId()
  {
      
      return sid;
  }
  
   public String getSName()
  {
      
      return sname;
  }
   
  public String getSAddress()
  {
      
      return saddress;
  }
  public String getSCity()
  {
      
      return scity;
  }
  public String getsPostalcode()
  {
      
      return spostalcode;
  }
  public String getSCountry()
  {
      
      return scountry;
  }
  public String getSPhone()
  {
      
      return sphone;
  }
  public String getSEmail()
  {
      
      return semail;
  }
    
    
    
}
