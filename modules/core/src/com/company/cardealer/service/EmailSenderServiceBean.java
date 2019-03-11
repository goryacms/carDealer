package com.company.cardealer.service;

import com.company.cardealer.entity.Car;
import com.company.cardealer.entity.CarPurchaseRequest;
import com.company.cardealer.entity.ExtUser;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.FluentLoader;
import com.haulmont.cuba.security.entity.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service(EmailSenderService.NAME)
public class EmailSenderServiceBean implements EmailSenderService {

    private static final String MAIN_MANAGER = "Main Manager";
    private static final String PATH_TO_EMAIL_TEMPLATE = "com/company/cardealer/email/templates/new_email.txt";
    @Inject
    protected EmailService emailService;

    @Inject
    private DataManager dataManager;

    @Override
    public void sendByEmail() {
        String notPaidAuto = getNotPaidAuto();

        if(ofNullable(notPaidAuto).isPresent()) {
            String emails = getEmails();
            if (ofNullable(emails).isPresent()) {
                EmailInfo emailInfo = new EmailInfo(
                        emails, // recipients
                        "Unsold cars", // subject
                        null, // the "from" address will be taken from the "cuba.email.fromAddress" app property
                        PATH_TO_EMAIL_TEMPLATE, // body template
                        Collections.singletonMap("notPaidAuto", notPaidAuto) // template parameters
                );
                emailService.sendEmailAsync(emailInfo);
            }
        }
    }

    private String getNotPaidAuto() {
        List<CarPurchaseRequest> list = dataManager.load(CarPurchaseRequest.class)
                .query("select p from cardealer$CarPurchaseRequest p where p.carPaid = false")
                .view("carPurchaseRequest-view")
                .list();

        return list.stream()
                .map(it -> it.getCar().getName())
                .collect(Collectors.joining(", "));
    }

    private String getEmails() {
        List<ExtUser> extUsers = dataManager.load(ExtUser.class)
                .query("select p from cardealer$ExtUser p where p.userRoles.role.name = :roleParam")
                .parameter("roleParam", MAIN_MANAGER)
                .view("user.browse")
                .list();

        return extUsers.stream()
                .map(User::getEmail)
                .collect(Collectors.joining(", "));
    }
}