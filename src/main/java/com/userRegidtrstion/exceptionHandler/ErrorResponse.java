package com.userRegidtrstion.exceptionHandler;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse 
{
  private Date timeStamp;
  
  private String msg;
  private String details;
    
//    private String message;
 
    //Specific errors in API request processing
   // private List<String> details;
 
    //Getter and setters
}