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
public class ProductHandler {

    /**
     * @param args the command line arguments
     */
    
    
  private int id;
  private String barcode;
  private String pname;
  private int quantity;
  private String weight;
  private String dimentions;
  private String employee;
  private String plocation;
  
  
 
  
  public ProductHandler(int id, String barcode, String pname,int quantity,String weight,String dimentions,String employee,String plocation){
      
      this.id=id;
      this.barcode=barcode;
      this.pname=pname;
      this.quantity=quantity;
      this.weight=weight;
      this.dimentions=dimentions;
      this.employee=employee;
      this.plocation=plocation;
      
      
      
      
      
  }
    
     
    
    
    
    
    
    public static void main(String[] args) {
        new Login().setVisible(true);
    }
    
    
    public int getId()
  {
      
      return id;
  }
  
  public String getBarcode()
  {
      
      return barcode;
  }
  
  public String getPName()
  {
      
      return pname;
  }
  
  
  public int getQuantity()
  {
      
      return quantity;
  }
  
  public String getWeight()
  {
      
      return weight;
  }
  public String getDimentions()
  {
      
      return dimentions;
  }
  public String getEmployee()
  {
      
      return employee;
  }
  
  public String getPLocation()
  {
      
      return plocation;
  }
  //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
  
  
  
  
  
    
    
    
    
    
}
