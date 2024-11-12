package com.example.projectbase.security;

import com.example.projectbase.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * The type User principal.
 */
public class UserPrincipal implements UserDetails {

  private final String id;

  private final String firstName;

  private final String lastName;

  @JsonIgnore
  private final String username;

  @JsonIgnore
  private String password;

  private final Collection<? extends GrantedAuthority> authorities;

  /**
   * Instantiates a new User principal.
   *
   * @param username    the username
   * @param password    the password
   * @param authorities the authorities
   */
  public UserPrincipal(String username, String password, Collection<? extends GrantedAuthority> authorities) {
    this(null, null, null, username, password, authorities);
  }

  /**
   * Instantiates a new User principal.
   *
   * @param id          the id
   * @param firstName   the first name
   * @param lastName    the last name
   * @param username    the username
   * @param password    the password
   * @param authorities the authorities
   */
  public UserPrincipal(String id, String firstName, String lastName, String username, String password,
                       Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;

    if (authorities == null) {
      this.authorities = null;
    } else {
      this.authorities = new ArrayList<>(authorities);
    }
  }

  /**
   * Create user principal.
   *
   * @param user the user
   * @return the user principal
   */
  public static UserPrincipal create(User user) {
    List<GrantedAuthority> authorities = new LinkedList<>();
    authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
    return new UserPrincipal(user.getId(), user.getFirstName(), user.getLastName(),
        user.getUsername(), user.getPassword(), authorities);
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities == null ? null : new ArrayList<>(authorities);
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public boolean equals(Object object) {
    if (this == object)
      return true;
    if (object == null || getClass() != object.getClass())
      return false;
    UserPrincipal that = (UserPrincipal) object;
    return Objects.equals(id, that.id);
  }

  public int hashCode() {
    return Objects.hash(id);
  }

}
