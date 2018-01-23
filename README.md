HolaMundoTomcatJenkins
======================

Fuente de donde se ha sacado la info para hacer el proyecto y posteriormente se
ha personalizado:

<https://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/>

Compile
-------

Para compilar el proyecto en eclipse `clean compile`

Tomcat eclipse
--------------

Para desplegar en el tomcat integrado de eclipse `tomcat7:run`

Tomcat externo
--------------

Para desplegar en el tomcat integrado de eclipse `tomcat7:deploy /
tomcat7:redeploy`

### Cosas a tener en cuenta en el tomcat externo:

En el tomcat-config:


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  <role rolename="tomcat"/>
  <role rolename="role1"/>
  <role rolename="manager-gui"/>
  <role rolename="admin"/>
  <role rolename="manager-script"/>
  <role rolename="manager-jmx"/>
  <user username="admin" password="admin" roles="tomcat,role1,manager-gui,admin,manager-jmx,manager-script" />
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 

Si da problemas de tamaño, editar `.../webapps/manager/WEB-INF/web.xml`

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  <max-file-size>82914560</max-file-size>
  <max-request-size>82914560</max-request-size>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
