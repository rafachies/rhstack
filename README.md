rhstack
=======

A demo platform using some products of the red hat stack
This demo currently is based on:

 Red Hat Data Grid 6.2.0
 Red Hat BRMS 6.0.0
 Red Hat Fuse Service Works 6.0.0
 
Configuration steps for deployment:

1) All services (login, payment and transfer) communicates with the JDG, and beacuase of that we need two system properties on FSW: datagrid.address and datagrid.port.

2) Although FSW has infinispan in its modules, we are handling with JDG 6.2.0 on server side, so we need to create an extra module on FSW that holds the client libraries of JDG 6.2.0 (infinispan 6.0.1.Final-redhat-2). The fast way to do that is creating a new folder on modules, put the module.xml, and copy the libraries of JDG to the module folder:

      mkdir -p %FSW_HOME/modules/org/infinispan/6.0.1
      
      <module xmlns="urn:jboss:module:1.1" name="org.infinispan" slot="6.0.1">
          <resources>
            <resource-root path="infinispan-core-6.0.1.Final-redhat-2.jar"/>
            <resource-root path="infinispan-client-hotrod-6.0.1.Final-redhat-2.jar"/>
            <resource-root path="infinispan-commons-6.0.1.Final-redhat-2.jar"/>
            <resource-root path="jboss-logging-3.1.2.GA-redhat-1.jar"/>
            <resource-root path="commons-pool-1.6-redhat-4.jar"/>
            <resource-root path="jboss-marshalling-1.4.2.Final-redhat-2.jar"/>
            <resource-root path="jboss-marshalling-river-1.4.2.Final-redhat-2.jar"/>
            <!-- Insert resources here -->
          </resources>

          <dependencies>
            <module name="javax.api"/>
            <module name="javax.transaction.api"/>
            <module name="javax.xml.bind.api"/>
            <module name="net.jcip"/>
            <module name="sun.jdk"/>
         </dependencies>
      </module>

3) The transfer-service uses kie-api from BRMS to call some rules, and we user the kie-ci for that, using kjar deployed in a Mevan repository. The problem is that FSW 6.0.0 does not have kie-ci in their modules, so we need to create other extra module to hold this kie-ci library. We need to create the module folder, create the module.xml, and put the library.


      mkdir -p %FSW_HOME/modules/org/kie/kie-ci/main
      
      <module xmlns="urn:jboss:module:1.0" name="org.kie.kie-ci">
         <resources>
           <resource-root path="kie-ci-6.0.0-redhat-9.jar"/>
         </resources>
         <dependencies>
           <module name="javax.enterprise.api"/>
           <module name="org.drools"/>
           <module name="org.jbpm"/>
           <module name="org.slf4j"/>
         </dependencies>
      </module>

4) Now we can deploy the services on FSW
