package net.myapp.exception.user;


import net.myapp.exception.MyException;
import net.myapp.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException{

	
public UserNotFoundException(String login) {
	this.setErrorDescription("user "+this.getErrorDescription()+login);
    this.setI18nErrorMessageArg(login);	
}
@Override
public String getMessage() {
	return this.getErrorDescription();
}


}
