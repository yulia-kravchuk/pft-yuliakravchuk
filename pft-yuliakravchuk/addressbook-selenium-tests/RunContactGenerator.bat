@echo off
d:
cd D:\home\yulia\Programming\Repo\pft-yuliakravchuk\addressbook-selenium-tests
java -cp bin;D:\Installs\Programming\xstream-1.4.4\lib\xstream-1.4.4.jar;D:\Installs\Programming\xstream-1.4.4\lib\xstream\xpp3_min-1.1.4c.jar com.example.tests.ContactDataGenerator 3 contacts.xml xml
pause
@echo on