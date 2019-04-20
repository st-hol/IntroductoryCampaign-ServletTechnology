package org.training.model.mail;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class MailBuilder {

    private static final Logger logger = LogManager.getLogger(MailBuilder.class);

    private String templatePath;

    public MailBuilder(String templatePath) {
        this.templatePath = templatePath;
    }

    public String takeMailTemplate() {
        URL url = this.getClass().getClassLoader().getResource(templatePath);
        if (url == null) {
            logger.fatal( "mail template file was not found");
            throw new RuntimeException("mail template file was not found");
        }

        StringBuilder mailTextBuilder = new StringBuilder();
        Scanner scanner = null;

        //
        try {
            scanner = new Scanner(new File(url.toURI()));
            while (scanner.hasNextLine()) {
                mailTextBuilder.append(scanner.nextLine());
            }

        } catch (FileNotFoundException | URISyntaxException e) {
            logger.fatal("Exception caught:", e);
            throw new RuntimeException(e);

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return mailTextBuilder.toString();
    }
}
