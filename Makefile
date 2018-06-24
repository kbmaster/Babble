JAVA=java
JAVAC=javac
JFLEX=jflex
CUPJAR = ./libs/java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR) <
CP= .:$(CUPJAR)  

all: test

test: out.txt
	@(diff out.txt out.ok && echo "Test OK!") || echo "Test failed!"

out.txt: Main.class test.txt
	$(JAVA) -cp $(CP) Main test.txt > out.txt

Main.class: *.java

%.class: %.java
	$(JAVAC) -cp $(CP) $^

Lexer.java: lbabble.jflex
	$(JFLEX) lbabble.jflex

parser.java: ybabble.cup
	$(CUP) ybabble.cup

compile: *.java  Lexer.java parser.java sym.java
	$(JAVAC) -cp $(CP)  $^

interactive: Main.class
	 $(JAVA) -cp $(CP) Main

clean:
	rm -f parser.java Lexer.java sym.java out.txt *.class *~
