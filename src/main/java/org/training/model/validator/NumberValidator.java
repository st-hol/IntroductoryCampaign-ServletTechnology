package org.training.model.validator;

import java.util.regex.Pattern;

public class NumberValidator {

    public static boolean validateNumber(String value) {
        //System.out.println(value != null && Pattern.matches(Regexes.NUMBER_REGEXP.getREGEXP(), value));
        return value != null && Pattern.matches(Regexes.NUMBER_REGEXP.getREGEXP(), value);
    }


}

