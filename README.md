rhstack
=======

A demo platform using some products of the red hat stack
This demo currently is based on:

 Red Hat Data Grid 6.2.0
 Red Hat BRMS 6.0.0
 Red Hat Fuse Service Works 6.0.0
 
Configuration steps:

1) All services (login, payment and transfer) communicates with the JDG, and beacuase of that we need two system properties on FSW: datagrid.address and datagrid.port.

2) Although FSW has infinispan in its modules, we are handling with JDG 6.2.0 on server side, so we need to create an extra module on FSW that holds the client libraries of JDG 6.2.0 (infinispan 6.0.1.Final-redhat-2). 
