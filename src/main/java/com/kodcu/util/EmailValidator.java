/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kodcu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author hakdogan
 */

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

     private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
			"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
			"(\\.[A-Za-z]{2,})$";

    private final Pattern pattern;
    private Matcher matcher;
 
    public EmailValidator(){
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
 
    @Override
    public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
        
        matcher = pattern.matcher(value.toString());
        if(!matcher.matches()){
            
            FacesMessage msg = new FacesMessage("E-Posta adresi gecerli degil!", "Girdiginiz e-posta adresi gecerli degil...");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
