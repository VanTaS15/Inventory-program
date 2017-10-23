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
public class OrderHandler {
    
    
  private int oid;
  private String opname;
  private String oquantity;
  private String osupplier;
  private String oemployee;
  private String odate;
  private String odateshipping;
  private String odatepromised;
  private String oshippingmethod;
  private String ostatus;
  public OrderHandler(int oid, String opname, String oquantity,String osupplier,String oemployee,String odate,String odateshipping,String odatepromised,String oshippingmethod,String ostatus){
      
      this.oid=oid;
      this.opname=opname;
      this.oquantity=oquantity;
      this.osupplier=osupplier;
      this.oemployee=oemployee;
      this.odate=odate;
      this.odateshipping=odateshipping;
      this.odatepromised=odatepromised;
      this.oshippingmethod=oshippingmethod;
      this.ostatus=ostatus;
      
      
  }
  public static void main(String[] args) {
        new Login().setVisible(true);
    }
  
  
  
   public int getOid()
  {
      
      return oid;
  }
  
   public String getOPName()
  {
      
      return opname;
  }
   
  public String getOQuantity()
  {
      
      return oquantity;
  }
  public String getOSupplies()
  {
      
      return osupplier;
  }
  public String getOEmployee()
  {
      
      return oemployee;
  }
  public String getODate()
  {
      
      return odate;
  }
  public String getODateShipping()
  {
      
      return odateshipping;
  }
  public String getODatePromised()
  {
      
      return odatepromised;
  }
  public String getOShippingMethod()
  {
      
      return oshippingmethod;
  }
  
  public String getOStatus()
  {
      
      return ostatus;
  }
  
  
  
  
    
}
