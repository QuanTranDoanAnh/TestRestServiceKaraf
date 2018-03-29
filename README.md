# TestRestServiceKaraf
TestRestServiceKaraf - non JPA - Karaf-Blueprint-Archetype

+ Prerequisites
- Apache Karaf 4.1.5
- CXF 3.2.2

+ Pre-installation steps:
- Run `feature:repo-add cxf 3.2.2` to add CXF repo
- Run `feature:repo-list` and verify if CXF repo has been added
- Run `feature:install cxf` to install required CXF bundle (JAX-WS, JAX-RS)
- Run `feature:list | grep cxf` to verify if CXF has been installed.

+ Installation steps
- Run `mvn clean install` in the project folder to build the `TestRestServiceKaraf` bundle
- In Karaf run `bundle:install -s mvn:RestFull_Webservice_Karaf/TestRestServiceKaraf/0.0.1-SNAPSHOT` to install the Bundle onto Karaf from local .m2 repo
- Run `cxf:list-endpoints` to vefiy if there is new endpoint`/olivier`. If yes so the bundle could start successfully. Otherwise, revise code.

+ Play around:
- Run `http://localhost:8181/cxf/olivier/customers/123` to see customer info
- Run `http://localhost:8181/cxf/olivier/customers/123/orders/223` to see an order
- Run `http://localhost:8181/cxf/olivier/customers/123/orders/223/products` to see all products in the order
