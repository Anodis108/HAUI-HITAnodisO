package com.example.projectbase.aop.annotation.validator;

import com.example.projectbase.aop.annotation.ValidFile;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * The type File validator.
 */
public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if(file != null) {
            String contentType = file.getContentType();
            if (!isSupportedContentType(Objects.requireNonNull(contentType))) {
                result = false;
            }
        }
        return result;
    }

    private boolean isSupportedContentType(String contentType) {
        return contentType.equals("application/pdf");
    }

}
