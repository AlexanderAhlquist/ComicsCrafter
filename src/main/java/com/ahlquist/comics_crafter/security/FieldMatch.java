package com.ahlquist.comics_crafter.security;

import javax.validation.Payload;
import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
/*This field match class creates a new annotation which will allow the user registration
 * to ensure that the fields match between password and confirm password, and 
 * email and confirm email. It is used in the UserRegistrationDto class.
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch
{
   String message() default "{constraints.field-match}";
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
   String first();
   String second();

   @Target({TYPE, ANNOTATION_TYPE})
   @Retention(RUNTIME)
   @Documented
   @interface List
   {
       FieldMatch[] value();
   }
}