package net.heydaytime.Javazon.email;

import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger LOG = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;


    public void sendSimpleMail(EmailDetails emailDetails, boolean isHTML) {
        try {

//            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
            mimeMessageHelper.setText(emailDetails.getMsgBody(), isHTML);

            javaMailSender.send(mimeMailMessage);

            LOG.info("{} Sent A Mail To", emailDetails.getRecipient());

        } catch (Exception e) {
            LOG.warn(e.getMessage());
            LOG.warn("{} Something Went Wrong While Sending An Email", emailDetails.getRecipient());
        }

    }

    public void sendSimpleMailWithAttachment(EmailDetails emailDetails, FileSystemResource fileSystemResource) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
            mimeMessageHelper.setText(emailDetails.getMsgBody());

            mimeMessageHelper.addAttachment(fileSystemResource.getFile().getName(), fileSystemResource);

            javaMailSender.send(mimeMessage);

            LOG.info("{} Sent A Mail With An Attachment", emailDetails.getRecipient());


        } catch (Exception e) {
            LOG.warn("{} Something Went Wrong While Sending An Email", emailDetails.getRecipient());
        }

    }
}
