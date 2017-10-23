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
public class UserHandler {
  private int id;
  private String Username;
  private String Password;
  private String Status;
  private String First_Last_Name;
  private String ContactPhone;
  private String Email;
  
  public UserHandler(int id, String Username, String Password,String Status,String First_Last_Name,String ContactPhone,String Email){
      
      this.id=id;
      this.Username=Username;
      this.Password=Password;
      this.Status=Status;
      this.First_Last_Name=First_Last_Name;
      this.ContactPhone=ContactPhone;
      this.Email=Email;
       
  }
  
  public int getId()
  {
      
      return id;
  }
  
  public String getUsername()
  {
      
      return Username;
  }
  
  public String getPassword()
  {
      
      return Password;
  }
  
  
  public String getStatus()
  {
      
      return Status;
  }
  
  public String getFirst_Last_Name()
  {
      
      return First_Last_Name;
  }
  public String getContactPhone()
  {
      
      return ContactPhone;
  }
  public String getEmail()
  {
      
      return Email;
  }
  
  
  
  
    
}
