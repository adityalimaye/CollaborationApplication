package com.niit.shoppingmallfe.webflow;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.shoppingmall.model.UserDetailsMall;

@Component
public class Demohandler {
	
	public UserDetailsMall initFlow(){
		return new UserDetailsMall();
	}
	
	public String validateDetails(UserDetailsMall userDetailsMall, MessageContext messageContext){
		String status = "success";
		
		if(userDetailsMall.getName().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source("name").defaultText("UserName cannot be Empty").build());
			status = "failure";
		}
		
		if(userDetailsMall.getId().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source("id").defaultText("UserId cannot be Empty").build());
			status = "failure";
		}
		
		if(userDetailsMall.getEmail_id().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source("email_id").defaultText("Email_id cannot be Empty").build());
			status = "failure";
		}
	
		/*if(userDetailsMall.getEmail_id().isEmpty()){
		messageContext.addMessage(new MessageBuilder().error().source("email_id").defaultText("Email_id cannot be Empty").build());
		status = "failure";
		}*/
		
		if(userDetailsMall.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source("password").defaultText("Password cannot be Empty").build());
			status = "failure";
		}
		
		if(userDetailsMall.getContact().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source("contact").defaultText("Contact cannot be Empty").build());
			status = "failure";
		}
		
		if(userDetailsMall.getUser_address().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source("user_address").defaultText("Address cannot be Empty").build());
			status = "failure";
		}
		
		/*if(userBean.getAge()==null){
		messageContext.addMessage(new MessageBuilder().error().source("age").defaultText("Age cannot be Empty").build());
		status = "failure";
		}*/
		
		return status;
	}
}	
