package org.training.model.validator;



import javax.validation.constraints.NotNull;
import java.util.regex.Pattern;

public class UserValidator {

//    private static final String EMAIL_REGEXP = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)$";
//    private static final String PASSWORD_REGEXP = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}";


    public static boolean validateEmail(String emailValue) {
        System.out.println(emailValue != null && Pattern.matches(Regexes.EMAIL_REGEXP.getREGEXP(), emailValue));
        return emailValue != null && Pattern.matches(Regexes.EMAIL_REGEXP.getREGEXP(), emailValue);
    }

    public static boolean validatePassword(String passwordValue) {
        System.out.println(passwordValue != null && Pattern.matches(Regexes.PASSWORD_REGEXP.getREGEXP(), passwordValue));
        return passwordValue != null && Pattern.matches(Regexes.PASSWORD_REGEXP.getREGEXP(), passwordValue);
    }

}