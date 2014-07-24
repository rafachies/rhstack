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
      
      <module xmlns="urn:jboss:module:1.1" name="org.kie.kie-ci">
	<resources>
		<resource-root path="aether-api-1.13.1.jar" />
		<resource-root path="aether-connector-file-1.13.1.jar" />
		<resource-root path="aether-connector-wagon-1.13.1.jar" />
		<resource-root path="aether-impl-1.13.1.jar" />
		<resource-root path="aether-spi-1.13.1.jar" />
		<resource-root path="aether-util-1.13.1.jar" />
		<resource-root path="ant-1.8.3.jar" />
		<resource-root path="ant-launcher-1.8.3.jar" />
		<resource-root path="antlr-2.7.7-redhat-2.jar" />
		<resource-root path="commons-logging-api-1.1.jar"/>
		<resource-root path="httpclient-4.2.1-redhat-1.jar"/>
		<resource-root path="httpcore-4.2.1-redhat-1.jar"/>
		<resource-root path="kie-ci-6.0.2-redhat-2.jar" />
		<resource-root path="maven-aether-provider-3.0.5.jar" />
		<resource-root path="maven-artifact-3.0.5.jar" />
		<resource-root path="maven-compat-3.0.5.jar" />
		<resource-root path="maven-core-3.0.5.jar" />
		<resource-root path="maven-model-3.0.5.jar" />
		<resource-root path="maven-model-builder-3.0.5.jar" />
		<resource-root path="maven-plugin-api-3.0.5.jar" />
		<resource-root path="maven-repository-metadata-3.0.5.jar" />
		<resource-root path="maven-settings-3.0.5.jar" />
		<resource-root path="maven-settings-builder-3.0.5.jar" />
		<resource-root path="mvel2-2.1.8.Final-redhat-4.jar" />
		<resource-root path="plexus-cipher-1.4.jar" />
		<resource-root path="plexus-classworlds-2.4.jar" />
		<resource-root path="plexus-component-annotations-1.5.5.jar" />
		<resource-root path="plexus-interpolation-1.14.jar" />
		<resource-root path="plexus-sec-dispatcher-1.3.jar" />
		<resource-root path="plexus-utils-3.0.9.jar" />
		<resource-root path="sisu-guice-3.0.3-no_aop.jar" />
		<resource-root path="sisu-inject-bean-2.2.3.jar" />
		<resource-root path="sisu-inject-plexus-2.2.3.jar" />
		<resource-root path="slf4j-api-1.7.2-redhat-1.jar" />
		<resource-root path="wagon-ahc-1.2.1.jar" />
		<resource-root path="wagon-http-2.0.jar"/>
		<resource-root path="wagon-provider-api-1.0-beta-7.jar" />
		<resource-root path="wagon-http-shared4-2.0.jar"/>
		<!-- Insert resources here -->
	</resources>

	<dependencies>
		<module name="javax.api" />
		<module name="sun.jdk" />
		<module name="org.kie"/>
		<module name="org.drools"/>
		<module name="org.apache.httpcomponents"/>
	</dependencies>
</module>


  After that, we need to declare in the module.xml of module org.kie that it depends on our new module org.kie.kie-ci
      
4) Now we can deploy the services on FSW

