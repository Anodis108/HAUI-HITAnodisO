package com.example.projectbase.constant;

/**
 * The type Url constant.
 */
public class UrlConstant {

  /**
   * The type Auth.
   */
  public static class Auth {
    private static final String PRE_FIX = "/auth";

    /**
     * The constant LOGIN.
     */
    public static final String LOGIN = PRE_FIX + "/login";
    /**
     * The constant LOGOUT.
     */
    public static final String LOGOUT = PRE_FIX + "/logout";

    private Auth() {
    }
  }

  /**
   * The type User.
   */
  public static class User {
    private static final String PRE_FIX = "/user";

    /**
     * The constant GET_USERS.
     */
    public static final String GET_USERS = PRE_FIX;
    /**
     * The constant CREATE_USER.
     */
    public static final String CREATE_USER = PRE_FIX;
    /**
     * The constant CHANGE_PASSWORD.
     */
    public static final String CHANGE_PASSWORD = PRE_FIX + "/changePassword";

    /**
     * The constant UPDATE_USER.
     */
    public static final String UPDATE_USER = PRE_FIX;
    /**
     * The constant GET_USER.
     */
    public static final String GET_USER = PRE_FIX + "/{userId}";
    /**
     * The constant GET_CURRENT_USER.
     */
    public static final String GET_CURRENT_USER = PRE_FIX + "/current";
    /**
     * The constant DELETE_USER.
     */
    public static final String DELETE_USER = PRE_FIX;

    private User() {
    }
  }

  /**
   * The type Profile.
   */
  public static class Profile {
    private static final String PRE_FIX = "/profile";
    /**
     * The constant CREATE_PROFILE.
     */
    public static final String CREATE_PROFILE = PRE_FIX;
    /**
     * The constant GET_PROFILE_BY_USERID.
     */
    public static final String GET_PROFILE_BY_USERID = PRE_FIX + "/user";
    /**
     * The constant GET_PROFILE.
     */
    public static final String GET_PROFILE = PRE_FIX;
    /**
     * The constant UPDATE_PROFILE.
     */
    public static final String UPDATE_PROFILE = PRE_FIX;
    /**
     * The constant DELETE_PROFILE.
     */
    public static final String DELETE_PROFILE = PRE_FIX;

    /**
     * The constant ACCEPT_PROFILE.
     */
    public static final String ACCEPT_PROFILE = PRE_FIX+ "/accept";

    /**
     * The constant REJECT_PROFILE.
     */
    public static final String REJECT_PROFILE = PRE_FIX+ "/reject";

    private Profile() {}
  }

  /**
   * The type Pdf.
   */
  public static class PDF {
    private static final String PRE_FIX = "/pdf";
    /**
     * The constant UPLOAD_PDF.
     */
    public static final String UPLOAD_PDF = PRE_FIX;
    /**
     * The constant GET_PDF_BY_PROFILE_ID.
     */
    public static final String GET_PDF_BY_PROFILE_ID = PRE_FIX + "/profile";
    /**
     * The constant DELETE_PDF.
     */
    public static final String DELETE_PDF = PRE_FIX;
    private PDF() {}
  }

}
