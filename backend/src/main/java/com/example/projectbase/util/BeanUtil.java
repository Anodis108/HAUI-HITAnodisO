package com.example.projectbase.util;

import lombok.NonNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * The type Bean util.
 */
@Component
public class BeanUtil implements ApplicationContextAware {

  private static ApplicationContext context;

  /**
   * Gets bean.
   *
   * @param <T>       the type parameter
   * @param beanClass the bean class
   * @return the bean
   */
  public static <T> T getBean(Class<T> beanClass) {
    return context.getBean(beanClass);
  }

  @Override
  public void setApplicationContext(@NonNull ApplicationContext applicationContext) {
    context = applicationContext;
  }

}