import com.skynetalpha.brvalidation.CnpjConstraint
import com.skynetalpha.brvalidation.CpfConstraint
import com.skynetalpha.brvalidation.CepConstraint
import org.codehaus.groovy.grails.validation.ConstrainedProperty


class BrValidationGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.1.1 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def author = "Mr Konno"
    def authorEmail = ""
    def title = "Brazil Validation"
    def description = '''\\
Add validation for commons units in Brazil
'''

  // URL to the plugin's documentation
  def documentation = "http://grails.org/BrValidation+Plugin"

  def loadAfter = ['controllers']

  def doWithSpring = {
      ConstrainedProperty.registerNewConstraint(CnpjConstraint.CNPJ_CONSTRAINT,CnpjConstraint.class);
      ConstrainedProperty.registerNewConstraint(CpfConstraint.CPF_CONSTRAINT,CpfConstraint.class);
      ConstrainedProperty.registerNewConstraint(CepConstraint.POSTAL_CODE_CONSTRAINT,CepConstraint.class);
  }
}
