package kirey.validators;

import kirey.annotation.AdmissionAgeValidation;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AdmissionAgeValidator implements ConstraintValidator<AdmissionAgeValidation, Object> {

    private String dateOfBirthField;
    private int differenceInYears;
    private String dateOfAdmissionField;

    @Override
    public void initialize(AdmissionAgeValidation constraintAnnotation) {
        this.dateOfBirthField = constraintAnnotation.dateOfBirthField();
        this.differenceInYears = constraintAnnotation.differenceInYears();
        this.dateOfAdmissionField = constraintAnnotation.dateOfAdmissionField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        LocalDate dateOfBirth = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(dateOfBirthField);
        LocalDate dateOfAdmission = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(dateOfAdmissionField);
        if (dateOfBirth == null || dateOfAdmission == null) {
            return false;
        }
        return dateOfBirth.isBefore(dateOfAdmission.minusYears(differenceInYears));
    }
}
