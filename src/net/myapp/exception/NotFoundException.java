package net.myapp.exception;

public class NotFoundException extends MyException {

	
	public NotFoundException() {
		this.errorDescription="not found";
        this.i18nErrorMessageKey="NOT_FOUND";
        
	}
}
