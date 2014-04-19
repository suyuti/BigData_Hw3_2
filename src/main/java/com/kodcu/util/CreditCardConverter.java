package com.kodcu.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: hakdogan
 * Date: 9/23/13
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */

@FacesConverter("creditCardConverter")
public class CreditCardConverter implements Converter {

    private final String displayCharacter = "-";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {

        Long longValue = null;
        if(null != value && value.length() > 0){

            Pattern pattern = Pattern.compile("[0-9]{4}" +
                              displayCharacter + "[0-9]{4}" +
                              displayCharacter + "[0-9]{4}" +
                              displayCharacter + "[0-9]{4}");

            Matcher matcher = pattern.matcher(value);

            if(matcher.matches()){
                longValue = Long.valueOf(value.replaceAll(displayCharacter, ""));
            } else {
                throw new ConverterException(new FacesMessage("Nesne dönüştürme başarısız. Hatalı kredi kartı numarası!"));
            }
        }

        return longValue;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {

        String stringValue = object.toString();
        if(null != stringValue && stringValue.length() > 0){

            stringValue = stringValue.substring(0, 4) + displayCharacter +
                          stringValue.substring(4, 8) + displayCharacter +
                          stringValue.substring(8, 12) + displayCharacter +
                          stringValue.substring(12, 16);

        } else {
            throw new ConverterException(new FacesMessage("Metin dönüştürme başarısız. Hatalı kredi kartı numarası!"));
        }
        return stringValue;
    }

}
