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

public class CnpjConstraint extends AbstractConstraint {

  private static final String DEFAULT_NOT_CNPJ_MESSAGE_CODE = "default.not.cnpj.message";
  public static final String CNPJ_CONSTRAINT = "cnpj";

  private boolean cpf;

  public void setParameter(Object constraintParameter) {
          if(!(constraintParameter instanceof Boolean))
          throw new IllegalArgumentException("Parameter for constraint ["
                 +CNPJ_CONSTRAINT+"] of property ["
                 +constraintPropertyName+"] of class ["
                 +constraintOwningClass+"] must be a boolean value");

          this.cpf = ((Boolean)constraintParameter).booleanValue();
          super.setParameter(constraintParameter);
      }

      protected void processValidate(Object target, Object propertyValue, Errors errors) {
          if (! validCnpj(target, propertyValue)) {
              def args = (Object[]) [constraintPropertyName, constraintOwningClass,
              propertyValue]
              super.rejectValue(target, errors, DEFAULT_NOT_CNPJ_MESSAGE_CODE,
                  "not." + CNPJ_CONSTRAINT, args);
          }
      }

      boolean supports(Class type) {
          return type != null && String.class.isAssignableFrom(type);
      }

      String getName() {
          return CNPJ_CONSTRAINT;
      }

      public  boolean validaCnpj( String str_cnpj ) {
         if (! str_cnpj.substring(0,1).equals("")){
             try{
                 str_cnpj=str_cnpj.replace('.',' ');
                 str_cnpj=str_cnpj.replace('/',' ');
                 str_cnpj=str_cnpj.replace('-',' ');
                 str_cnpj=str_cnpj.replaceAll(" ","");
                 int soma = 0, aux, dig;
                 String cnpj_calc = str_cnpj.substring(0,12);

                 if ( str_cnpj.length() != 14 ) return false;
                 char[] chr_cnpj = str_cnpj.toCharArray();
                 for( int i = 0; i < 4; i++ )
                     if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 ) soma += (chr_cnpj[i] - 48 ) * (6 - (i + 1)) ;
                 for( int i = 0; i < 8; i++ )  
                     if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 ) soma += (chr_cnpj[i+4] - 48 ) * (10 - (i + 1)) ;
                 dig = 11 - (soma % 11);
                 cnpj_calc += ( dig == 10 || dig == 11 ) ? "0" : Integer.toString(dig);
                 soma = 0;
                 for ( int i = 0; i < 5; i++ )
                     if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 ) soma += (chr_cnpj[i] - 48 ) * (7 - (i + 1)) ;
                 for ( int i = 0; i < 8; i++ )
                     if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 ) soma += (chr_cnpj[i+5] - 48 ) * (10 - (i + 1)) ;
                 dig = 11 - (soma % 11);
                 cnpj_calc += ( dig == 10 || dig == 11 ) ? "0" : Integer.toString(dig);
                 return str_cnpj.equals(cnpj_calc);
             }catch (Exception e){
                 return false;
             }
         }else return false;

     }

      boolean validCnpj(target, propertyValue) {
          def f= (propertyValue==~ /^[0-9]{2}\.[0-9]{3}\.[0-9]{3}\/[0-9]{4}-[0-9]{2}$/)
          if (f) {
            validaCnpj(propertyValue)
          } else false

      }

}