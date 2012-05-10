package techbysample.javase.sample1.annotation.validator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import techbysample.javase.sample1.annotation.NotNullable;

/**
 * 
 * @author TechBySample.com
 *
 */

public class NotNullableValidator {
	
    public static List<String> validate(Object obj){
        List<String> errorMessages = new ArrayList<String>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for( int i = 0; i < fields.length; i++ ){
               NotNullable notNullannotation = (NotNullable)fields[i].getAnnotation(NotNullable.class);
            if(notNullannotation != null ){
                try{
                	fields[i].setAccessible(true);
                    if(fields[i].get(obj) == null){
                    	errorMessages.add(((NotNullable)notNullannotation).message());
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return errorMessages;
    }
}
