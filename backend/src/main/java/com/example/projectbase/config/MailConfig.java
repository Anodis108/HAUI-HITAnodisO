package com.example.projectbase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * The type Mail config.
 */
@Configuration
public class MailConfig {

  /**
   * The Username.
   */
  @Value("${mail.username}")
  public String username;

  /**
   * The Password.
   */
  @Value("${mail.password}")
  public String password;

  /**
   * Gets java mail sender.
   *
   * @return the java mail sender
   */
  @Bean
  public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);

    mailSender.setUsername(username);
    mailSender.setPassword(password);
    mailSender.setDefaultEncoding("UTF-8");

    Properties properties = mailSender.getJavaMailProperties();
    properties.put("mail.transport.protocol", "smtp");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.debug", "false");
    return mailSender;
  }

}
