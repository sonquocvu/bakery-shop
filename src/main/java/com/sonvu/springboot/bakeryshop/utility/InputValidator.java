package com.sonvu.springboot.bakeryshop.utility;

import java.util.regex.Pattern;

public class InputValidator {
	
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PHONE_REGEX = "^\\+?[0-9. ()-]{7,}$";
    
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
    
    public static String validateInput(String input)
    {
    	if (EMAIL_PATTERN.matcher(input).matches())
    	{
    		return "email";
    	}
    	else if (PHONE_PATTERN.matcher(input).matches())
    	{
    		return "phone";
    	}
    	else
    	{
    		return "invalidInput";
    	}
    }
}
