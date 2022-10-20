package com.cg.fitnesstracker.app.response;

public class ResponseMessage {

    private String message;
    private int status;
    
    public ResponseMessage(String message,int status) {
        this.message = message;
        this.status = status;
    }
    
    

   public ResponseMessage(String message) {
		super();
		this.message = message;
	}



public String getMessage() {
        return message;
    }

   public void setMessage(String message) {
        this.message = message;
    }

   public int getStatus() {
	   return status;
   }
   
   public void setStatus(int status) {
	   this.status = status;
   }
   
}