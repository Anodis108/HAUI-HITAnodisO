package com.example.projectbase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.nio.charset.StandardCharsets;

/**
 * The type Thymeleaf template config.
 */
@Configuration
public class ThymeleafTemplateConfig {

  /**
   * Spring template engine spring template engine.
   *
   * @return the spring template engine
   */
  @Bean
  public SpringTemplateEngine springTemplateEngine() {
    SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
    springTemplateEngine.addTemplateResolver(emailTemplateResolver());
    return springTemplateEngine;
  }

  /**
   * Email template resolver class loader template resolver.
   *
   * @return the class loader template resolver
   */
  public ClassLoaderTemplateResolver emailTemplateResolver() {
    ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
    emailTemplateResolver.setPrefix("/templates/");
    emailTemplateResolver.setSuffix(".html");
    emailTemplateResolver.setTemplateMode(TemplateMode.HTML);
    emailTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
    emailTemplateResolver.setCacheable(false);
    return emailTemplateResolver;
  }

}
