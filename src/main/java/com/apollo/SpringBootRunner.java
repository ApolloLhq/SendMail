package com.apollo;

import com.apollo.entity.TUser;
import com.apollo.orm.HibernateService;
import com.apollo.springbootmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Component
public class SpringBootRunner implements CommandLineRunner {

    public static long COUNT;

    @Autowired
    private MailService mailService;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private HibernateService hibernateService;

    @Override
    public void run(String... args) throws Exception {
        String emailMatcher="[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";
        List<TUser> tUsers = hibernateService.selectUser();
        for (TUser tUser : tUsers) {
            if (tUser.isSend() || tUser.getEmail() == null) {
                continue;
            }

            if (!Pattern.matches(emailMatcher, tUser.getEmail())) {
                continue;
            }

            //向Thymeleaf模板传值，并解析成字符串
            Context context = new Context();
            context.setVariable("id", "001");
            String emailContent = templateEngine.process("emailTemplate", context);
            try {
                mailService.sendHtmlMail("receiver@email.com", "主题", emailContent);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            COUNT++;
            tUser.setSend(true);
            hibernateService.updateUser(tUser);
            TimeUnit.MILLISECONDS.sleep(1000);
        }
    }
}
