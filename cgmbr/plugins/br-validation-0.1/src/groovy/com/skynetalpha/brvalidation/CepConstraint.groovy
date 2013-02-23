package com.skynetalpha.brvalidation

import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors

/**
 * Created by IntelliJ IDEA.
 * User: oscar
 * Date: 12/12/2009
 * Time: 20:03:12
 * To change this template use File | Settings | File Templates.
 */

public class CepConstraint extends AbstractConstraint {

  private static final String DEFAULT_NOT_POSTAL_CODE_MESSAGE_CODE = "default.not.cpf.message";
  public static final String POSTAL_CODE_CONSTRAINT = "cep";

  private boolean postalCode;

  public void setParameter(Object constraintParameter) {
          if(!(constraintParameter instanceof Boolean))
          throw new IllegalArgumentException("Parameter for constraint ["
                 +POSTAL_CODE_CONSTRAINT+"] of property ["
                 +constraintPropertyName+"] of class ["
                 +constraintOwningClass+"] must be a boolean value");

          this.postalCode = ((Boolean)constraintParameter).booleanValue();
          super.setParameter(constraintParameter);
      }

      protected void processValidate(Object target, Object propertyValue, Errors errors) {
          if (! validPostalCode(target, propertyValue)) {
              def args = (Object[]) [constraintPropertyName, constraintOwningClass,
              propertyValue]
              super.rejectValue(target, errors, DEFAULT_NOT_POSTAL_CODE_MESSAGE_CODE,
                  "not." + POSTAL_CODE_CONSTRAINT, args);
          }
      }

      boolean supports(Class type) {
          return type != null && String.class.isAssignableFrom(type);
      }

      String getName() {
          return POSTAL_CODE_CONSTRAINT;
      }

      boolean validPostalCode(target, propertyValue) {
          propertyValue==~ /^[0-9]{5}-[0-9]{3}$/
      }

}