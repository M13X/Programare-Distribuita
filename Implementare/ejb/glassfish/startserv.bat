rem set GLASSFISH_HOME=e:\JavaApp\glassfish-4.1.2\glassfish4
set GLASSFISH_HOME=D:\Facultate\PDtema\Resurse\glassfish5
del %GLASSFISH_HOME%\glassfish\domains\domain1\logs\server.log
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_161
set PATH=%JAVA_HOME%\bin;%GLASSFISH_HOME%\bin;%PATH%
asadmin start-domain domain1 
rem asadmin start-domain --verbose

rem asadmin  start-domain  --domaindir e:\gfish domain2
