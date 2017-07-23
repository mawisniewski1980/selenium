package demoqacontact;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoqaContactForm {

	private static final Logger LOG = LogManager.getLogger("DemoqaContactForm");

	private String name;
	private String email;
	private String subject;
	private String message;
	
	public DemoqaContactForm(String name, String email){
		this.name = name;
		this.email = email;
	}
	
	public DemoqaContactForm(String name, String email, String subject, String message){
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;	
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getSubject(){
		return subject;
	}
	
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
}

