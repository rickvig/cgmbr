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

public class CpfConstraint extends AbstractConstraint {

  private static final String DEFAULT_NOT_CPF_MESSAGE_CODE = "default.not.cpf.message";
  public static final String CPF_CONSTRAINT = "cpf";

  private boolean cpf;

  public void setParameter(Object constraintParameter) {
          if(!(constraintParameter instanceof Boolean))
          throw new IllegalArgumentException("Parameter for constraint ["
                 +CPF_CONSTRAINT+"] of property ["
                 +constraintPropertyName+"] of class ["
                 +constraintOwningClass+"] must be a boolean value");

          this.cpf = ((Boolean)constraintParameter).booleanValue();
          super.setParameter(constraintParameter);
      }

      protected void processValidate(Object target, Object propertyValue, Errors errors) {
          if (! validCpf(target, propertyValue)) {
              def args = (Object[]) [constraintPropertyName, constraintOwningClass,
              propertyValue]
              super.rejectValue(target, errors, DEFAULT_NOT_CPF_MESSAGE_CODE,
                  "not." + CPF_CONSTRAINT, args);
          }
      }

      boolean supports(Class type) {
          return type != null && String.class.isAssignableFrom(type);
      }

      String getName() {
          return CPF_CONSTRAINT;
      }

      public  boolean validacpf(String strCpf){
         if (! strCpf.substring(0,1).equals("")){
             try{
                 boolean validado=true;
                 int     d1, d2;
                 int     dg1, dg2, resto;
                 int     dgCPF;
                 String  nDigResult;
                 strCpf=strCpf.replace('.',' ');
                 strCpf=strCpf.replace('-',' ');
                 strCpf=strCpf.replaceAll(" ","");
                 d1 = d2 = 0;
                 dg1 = dg2 = resto = 0;
                 for (int nCount = 1; nCount < strCpf.length() -1; nCount++) {
                     dgCPF = Integer.valueOf(strCpf.substring(nCount -1, nCount)).intValue();
                     d1 = d1 + ( 11 - nCount ) * dgCPF;
                     d2 = d2 + ( 12 - nCount ) * dgCPF;
                 };
                 resto = (d1 % 11);
                 if (resto < 2) dg1 = 0;
                 else dg1 = 11 - resto;
                 d2 += 2 * dg1;
                 resto = (d2 % 11);
                 if (resto < 2) dg2 = 0;
                 else dg2 = 11 - resto;
                 String nDigVerific = strCpf.substring(strCpf.length()-2, strCpf.length());
                 nDigResult = String.valueOf(dg1) + String.valueOf(dg2);
                 return nDigVerific.equals(nDigResult);
             }catch (Exception e){
                 return false;
             }
         }else return false;
     }
      boolean validCpf(target, propertyValue) {
          def f= (propertyValue==~ /^([0-9]{3}\.){2}[0-9]{3}-[0-9]{2}$/)
          if (f) {
            validacpf(propertyValue)
          } else false

      }

}