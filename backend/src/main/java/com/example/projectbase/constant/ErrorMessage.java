package com.example.projectbase.constant;

/**
 * The type Error message.
 */
public class ErrorMessage {

  /**
   * The constant ERR_EXCEPTION_GENERAL.
   */
  public static final String ERR_EXCEPTION_GENERAL = "exception.general";
  /**
   * The constant UNAUTHORIZED.
   */
  public static final String UNAUTHORIZED = "exception.unauthorized";
  /**
   * The constant FORBIDDEN.
   */
  public static final String FORBIDDEN = "exception.forbidden";
  /**
   * The constant FORBIDDEN_UPDATE_DELETE.
   */
  public static final String FORBIDDEN_UPDATE_DELETE = "exception.forbidden.update-delete";

  /**
   * The constant INVALID_SOME_THING_FIELD.
   */
//error validation dto
  public static final String INVALID_SOME_THING_FIELD = "invalid.general";
  /**
   * The constant INVALID_FORMAT_SOME_THING_FIELD.
   */
  public static final String INVALID_FORMAT_SOME_THING_FIELD = "invalid.general.format";
  /**
   * The constant INVALID_SOME_THING_FIELD_IS_REQUIRED.
   */
  public static final String INVALID_SOME_THING_FIELD_IS_REQUIRED = "invalid.general.required";
  /**
   * The constant NOT_BLANK_FIELD.
   */
  public static final String NOT_BLANK_FIELD = "invalid.general.not-blank";
  /**
   * The constant INVALID_FORMAT_PASSWORD.
   */
  public static final String INVALID_FORMAT_PASSWORD = "invalid.password-format";
  /**
   * The constant INVALID_DATE.
   */
  public static final String INVALID_DATE = "invalid.date-format";
  /**
   * The constant INVALID_DATE_FEATURE.
   */
  public static final String INVALID_DATE_FEATURE = "invalid.date-future";
  /**
   * The constant INVALID_DATETIME.
   */
  public static final String INVALID_DATETIME = "invalid.datetime-format";

  /**
   * The type Auth.
   */
  public static class Auth {
    /**
     * The constant ERR_INCORRECT_USERNAME.
     */
    public static final String ERR_INCORRECT_USERNAME = "exception.auth.incorrect.username";
    /**
     * The constant ERR_INCORRECT_PASSWORD.
     */
    public static final String ERR_INCORRECT_PASSWORD = "exception.auth.incorrect.password";
    /**
     * The constant ERR_ACCOUNT_NOT_ENABLED.
     */
    public static final String ERR_ACCOUNT_NOT_ENABLED = "exception.auth.account.not.enabled";
    /**
     * The constant ERR_ACCOUNT_LOCKED.
     */
    public static final String ERR_ACCOUNT_LOCKED = "exception.auth.account.locked";
    /**
     * The constant INVALID_REFRESH_TOKEN.
     */
    public static final String INVALID_REFRESH_TOKEN = "exception.auth.invalid.refresh.token";
    /**
     * The constant EXPIRED_REFRESH_TOKEN.
     */
    public static final String EXPIRED_REFRESH_TOKEN = "exception.auth.expired.refresh.token";
  }

  /**
   * The type User.
   */
  public static class User {
    /**
     * The constant ERR_NOT_FOUND_USERNAME.
     */
    public static final String ERR_NOT_FOUND_USERNAME = "exception.user.not.found.username";
    /**
     * The constant ERR_NOT_FOUND_ID.
     */
    public static final String ERR_NOT_FOUND_ID = "exception.user.not.found.id";
  }

  /**
   * The type Profile.
   */
  public static class Profile {
    /**
     * The constant ERR_NOT_FOUND_ID.
     */
    public static final String ERR_NOT_FOUND_ID = "exception.profile.not.found.id";
  }

  /**
   * The type Pdf.
   */
  public static class PDF{
    /**
     * The constant ERR_NOT_FOUND_ID.
     */
    public static final String ERR_NOT_FOUND_ID = "exception.profile.not.found.id";
  }

}
