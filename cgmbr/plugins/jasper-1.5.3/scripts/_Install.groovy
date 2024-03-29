
//
// This script is executed by Grails after plugin was installed to project.
// This script is a Gant script so you can use all special variables provided
// by Gant (such as 'baseDir' which points on project base dir). You can
// use 'Ant' to access a global instance of AntBuilder
//
// For example you can create directory under project tree:
// Ant.mkdir(dir:"C:\grails-1.0.1\workspace/Jasper/grails-app/jobs")
//

Ant.property(environment:"env")
grailsHome = Ant.antProject.properties."env.GRAILS_HOME"

// Workaround for GRAILS-1668: Resource bundles contained by plugins are not resolved by the I18nGrailsPlugin
// Removed because GRAILS-1668 is fixed and http://jira.codehaus.org/browse/GRAILSPLUGINS-2178 was a bad sideeffect
// of this workaround.
//Ant.copy(todir: "${basedir}/grails-app/i18n", overwrite: true) {
//    fileset(dir: "${pluginBasedir}/grails-app/i18n")
//}
