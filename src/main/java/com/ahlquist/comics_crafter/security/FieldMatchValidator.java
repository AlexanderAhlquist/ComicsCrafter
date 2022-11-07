package com.ahlquist.comics_crafter.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;
/*This field match validator uses the constraint validator which will allow the registration
 * to ensure that the fields match between password and confirm password, and 
 * email and confirm email. It is part of the security configuration.
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
   private String firstFieldName;
   private String secondFieldName;

   @Override
   public void initialize(final FieldMatch constraintAnnotation) {
       firstFieldName = constraintAnnotation.first();
       secondFieldName = constraintAnnotation.second();
   }

   @Override
   public boolean isValid(final Object value, final ConstraintValidatorContext context) {
       try {
           final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
           final Object secondObj = BeanUtils.getProperty(value, secondFieldName);
           return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
       } catch (final Exception ignore) {}
       return true;
   }
}
