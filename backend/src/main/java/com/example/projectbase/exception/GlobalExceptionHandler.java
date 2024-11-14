package com.example.projectbase.exception;

import com.example.projectbase.base.RestData;
import com.example.projectbase.base.VsResponseUtil;
import com.example.projectbase.constant.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The type Global exception handler.
 */
@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

  private final MessageSource messageSource;

  /**
   * Handle constraint violation exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
//Error validate for param
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<RestData<?>> handleConstraintViolationException(ConstraintViolationException ex) {
    Map<String, String> result = new LinkedHashMap<>();
    ex.getConstraintViolations().forEach((error) -> {
      String fieldName = ((PathImpl) error.getPropertyPath()).getLeafNode().getName();
      String errorMessage = messageSource.getMessage(Objects.requireNonNull(error.getMessage()), null,
          LocaleContextHolder.getLocale());
      result.put(fieldName, errorMessage);
    });
    return VsResponseUtil.error(HttpStatus.BAD_REQUEST, result);
  }

  /**
   * Handle valid exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
//Error validate for body
  @ExceptionHandler(BindException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<RestData<?>> handleValidException(BindException ex) {
    Map<String, String> result = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = messageSource.getMessage(Objects.requireNonNull(error.getDefaultMessage()), null,
          LocaleContextHolder.getLocale());
      result.put(fieldName, errorMessage);
    });
    return VsResponseUtil.error(HttpStatus.BAD_REQUEST, result);
  }

  /**
   * Handler internal server error response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<RestData<?>> handlerInternalServerError(Exception ex) {
    log.error(ex.getMessage(), ex);
    String message = messageSource.getMessage(ErrorMessage.ERR_EXCEPTION_GENERAL, null,
        LocaleContextHolder.getLocale());
    return VsResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, message);
  }

  /**
   * Handle vs exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
//Exception custom
  @ExceptionHandler(VsException.class)
  public ResponseEntity<RestData<?>> handleVsException(VsException ex) {
    log.error(ex.getMessage(), ex);
    return VsResponseUtil.error(ex.getStatus(), ex.getErrMessage());
  }

  /**
   * Handler not found exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<RestData<?>> handlerNotFoundException(NotFoundException ex) {
    String message = messageSource.getMessage(ex.getMessage(), ex.getParams(), LocaleContextHolder.getLocale());
    log.error(message, ex);
    return VsResponseUtil.error(ex.getStatus(), message);
  }

  /**
   * Handler invalid exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(InvalidException.class)
  public ResponseEntity<RestData<?>> handlerInvalidException(InvalidException ex) {
    log.error(ex.getMessage(), ex);
    String message = messageSource.getMessage(ex.getMessage(), ex.getParams(), LocaleContextHolder.getLocale());
    return VsResponseUtil.error(ex.getStatus(), message);
  }

  /**
   * Handler internal server exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(InternalServerException.class)
  public ResponseEntity<RestData<?>> handlerInternalServerException(InternalServerException ex) {
    String message = messageSource.getMessage(ex.getMessage(), ex.getParams(), LocaleContextHolder.getLocale());
    log.error(message, ex);
    return VsResponseUtil.error(ex.getStatus(), message);
  }

  /**
   * Handle upload image exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(UploadFileException.class)
  public ResponseEntity<RestData<?>> handleUploadImageException(UploadFileException ex) {
    String message = messageSource.getMessage(ex.getMessage(), ex.getParams(), LocaleContextHolder.getLocale());
    log.error(message, ex);
    return VsResponseUtil.error(ex.getStatus(), message);
  }

  /**
   * Handle unauthorized exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<RestData<?>> handleUnauthorizedException(UnauthorizedException ex) {
    String message = messageSource.getMessage(ex.getMessage(), ex.getParams(), LocaleContextHolder.getLocale());
    log.error(message, ex);
    return VsResponseUtil.error(ex.getStatus(), message);
  }

  /**
   * Handle access denied exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(ForbiddenException.class)
  public ResponseEntity<RestData<?>> handleAccessDeniedException(ForbiddenException ex) {
    String message = messageSource.getMessage(ex.getMessage(), ex.getParams(), LocaleContextHolder.getLocale());
    log.error(message, ex);
    return VsResponseUtil.error(ex.getStatus(), message);
  }

  /**
   * Handle username already exists exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(UsernameAlreadyExistsException.class)
  public ResponseEntity<String> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

  /**
   * Handle user already has this profile response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(UserAlreadyHasThisProfile.class)
  public ResponseEntity<String> handleUserAlreadyHasThisProfile(UserAlreadyHasThisProfile ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

  /**
   * Handle profile already accepted response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(ProfileAlreadyAccepted.class)
  public ResponseEntity<String> handleProfileAlreadyAccepted(ProfileAlreadyAccepted ex) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

}