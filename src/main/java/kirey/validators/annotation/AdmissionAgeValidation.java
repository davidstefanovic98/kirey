package kirey.validators.annotation;

import kirey.validators.AdmissionAgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target( { TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AdmissionAgeValidator.class)
public @interface AdmissionAgeValidation {

    String message() default "Student must be at least {differenceInYears} years old to be admitted";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String dateOfBirthField() default "dateOfBirth";

    int differenceInYears() default 12;

    String dateOfAdmissionField() default "dateOfAdmission";
}
