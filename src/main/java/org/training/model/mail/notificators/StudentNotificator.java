package org.training.model.mail.notificators;


import org.training.model.mail.MailBuilder;
import org.training.model.mail.MailProperty;
import org.training.model.mail.MailTemplatePath;
import org.training.model.mail.MailThread;

public class StudentNotificator {

    private static final String SELECTION_RESULTS = "[Selection results]";

    public void sendEmail(String emailValue, String email, MailTemplatePath mailTemplatePath ) {

        // String emailValue = "sdaf12fds21@gmail.com";
        // String login = "loginss";
        // MailTemplatePath mailTemplatePath = MailTemplatePath.ADMISSION_NOTICE;

        String templatePath = mailTemplatePath.getTemplatePath();
        MailBuilder mailBuilder = new MailBuilder(templatePath);
        String mailText = mailTextCreator(mailBuilder, email);

        MailThread thread = new MailThread(emailValue, SELECTION_RESULTS, mailText, MailProperty.getInstance().getProperties());
        thread.start();
    }

    private String mailTextCreator(MailBuilder mailBuilder, String login) {
        return String.format(mailBuilder.takeMailTemplate(), login);
    }

}














//import org.training.model.entity.ApplicationForAdmission;
//import org.training.model.service.ApplicationService;
//
//import java.util.List;
//import java.util.Observable;
//import java.util.Observer;
//
//@Deprecated
//public class StudentNotificator  implements Observer {
//
//
//    private static int IS_ENROLLED = 1;
//
//    @Deprecated
//    private Observable observable;
//
//
//    @Deprecated
//    public StudentNotificator(Observable observable) {
//        this.observable = observable;
//        observable.addObserver(this);
//    }
//
//    @Deprecated
//    @Override
//    public void update(Observable observable, Object arg) {
//
//        long id_student = (Long)arg;
//
//        if (observable instanceof ApplicationService) {
//            ApplicationService applicationService = new ApplicationService();
//            List<ApplicationForAdmission> applications = applicationService.getAllConfirmedApplications();
//
//            for (ApplicationForAdmission application: applications) {
//
//                if (application.getStudent().getId() == id_student){
//                    if (application.getIsEnrolled() == IS_ENROLLED) {
//                        notifyStudentByEmail();
//                    }
//                }
//            }
//        }
//    }
//
//    private void notifyStudentByEmail(){
//        System.out.println("email sent");
//    }
//}
