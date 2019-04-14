package org.training.model.validator;


public enum Regexes {

//    EMAIL_REGEXP ("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)$"),
//    PASSWORD_REGEXP("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}");



    EMAIL_REGEXP ("(^[\\w\\.-]+)@([\\w\\.-]+)([\\w\\.-]+)$"),

    PASSWORD_REGEXP("^([a-zA-Z0-9_.]{1,30})$"),

    NUMBER_REGEXP("^([0-9]+)$");



    String REGEXP;

    public String getREGEXP() {
        return REGEXP;
    }

    Regexes(String REGEXP) {
        this.REGEXP = REGEXP;
    }
}