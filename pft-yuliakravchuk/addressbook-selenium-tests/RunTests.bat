@echo off
d:
cd D:\home\yulia\Programming\Repo\pft-yuliakravchuk\addressbook-selenium-tests

java -cp bin;D:\Installs\Programming\xstream-1.4.4\lib\xstream-1.4.4.jar;D:\Installs\Programming\xstream-1.4.4\lib\xstream\xmlpull-1.1.3.1.jar;D:\Installs\Programming\xstream-1.4.4\lib\xstream\xpp3_min-1.1.4c.jar;D:\Installs\Programming\Selenium\selenium-server-standalone-2.26.0.jar -DconfigFile="firefox.properties" org.testng.TestNG testng-customsuite.xml

pause
@echo on