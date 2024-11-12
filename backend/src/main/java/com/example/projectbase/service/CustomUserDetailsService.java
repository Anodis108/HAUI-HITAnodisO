package com.example.projectbase.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * The interface Custom user details service.
 */
public interface CustomUserDetailsService {

  /**
   * Load user by username user details.
   *
   * @param usernameOrEmail the username or email
   * @return the user details
   * @throws UsernameNotFoundException the username not found exception
   */
  UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException;

  /**
   * Load user by id user details.
   *
   * @param id the id
   * @return the user details
   */
  UserDetails loadUserById(String id);

}
