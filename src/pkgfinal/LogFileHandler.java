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
public class LogFileHandler {
    
  private int id;
  private String date_time;
  private String changedBy;
  private String action;
  private String value;
  private String inWhat;
  public LogFileHandler(int id, String date_time, String changedBy,String action,String value,String inWhat){
      
      this.id=id;
      this.date_time=date_time;
      this.changedBy=changedBy;
      this.action=action;
      this.value=value;
      this.inWhat=inWhat;
      
      
      
  }
  public int getId()
  {
      
      return id;
  }
  
   public String getDate_time()
  {
      
      return date_time;
  }
   
   public String getChangedBy()
  {
      
      return changedBy;
  }
   public String getAction()
  {
      
      return action;
  }
   public String getValue()
  {
      
      return value;
  }
   public String getInWhat()
  {
      
      return inWhat;
  }
    
    
    
    
}
