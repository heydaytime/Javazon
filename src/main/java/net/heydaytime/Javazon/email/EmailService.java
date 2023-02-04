package net.heydaytime.Javazon.email;

import org.springframework.core.io.FileSystemResource;

public interface EmailService {

    void sendSimpleMail(EmailDetails emailDetails, boolean isHTML);
    void sendSimpleMailWithAttachment(EmailDetails emailDetails, FileSystemResource fileSystemResource);
}
