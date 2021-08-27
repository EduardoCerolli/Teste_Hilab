CC= javac
CC2= jar
ARQS= teste_hilab/*.java
ARQS2= MANIFEST.txt teste_hilab/*.class

all:
	$(CC) $(ARQS)
	$(CC2) cfm teste.jar $(ARQS2)