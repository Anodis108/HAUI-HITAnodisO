package com.example.projectbase.config;

import com.example.projectbase.security.UserPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * The type Auditing config.
 */
@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    /**
     * Auditor provider auditor aware.
     *
     * @return the auditor aware
     */
    @Bean
  public AuditorAware<String> auditorProvider() {
    return new AuditorAwareImpl();
  }

}

/**
 * The type Auditor aware.
 */
class AuditorAwareImpl implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
      return Optional.empty();
    }
    UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
    return Optional.ofNullable(userPrincipal.getId());
  }

}

