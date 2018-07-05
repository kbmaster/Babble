JAVA=java
JAVAC=javac
JFLEX=jflex
JAR=jar
CUPJAR = ./libs/java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR) <
CP= .:$(CUPJAR)  



Babble.class: Lexer.java parser.java *.java 

%.class: %.java
	$(JAVAC) -cp $(CP) $^

Lexer.java: lbabble.jflex
	$(JFLEX) lbabble.jflex

parser.java: ybabble.cup
	$(CUP) ybabble.cup

compile: Lexer.java  parser.java *.java
	$(JAVAC) -cp $(CP)  $^

interactive: Babble.class 
	 #$(JAVA) -cp $(CP) Babble -u 10 5 10 ./test/redefProbJson.rdp  ./test/json.babble
	 $(JAVA) -cp $(CP) Babble -t 10 5 10  ./test/babble.babble

jar: *.class
	$(JAR) cmvf MANIFEST.MF Babble.jar $^

clean:
	rm -f parser.java Lexer.java sym.java out.txt  Babble.jar *.class *~
