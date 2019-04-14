package org.training.model.mail;

public enum MailTemplatePath {


    ADMISSION_NOTICE("/mailtemplates/AdmissionNotice.txt"),
    REJECTION_NOTICE("/mailtemplates/RejectionNotice.txt");


    private String templatePath;


    MailTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getTemplatePath() {
        return templatePath;
    }
}