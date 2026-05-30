JAVAV = 26.0.1
JAVA  = java
JAVAC = javac

all: run depcheck

depcheck: depcheck.sh
	./$^ $(JAVAV)

# im lazy
Main.class: Main.class depcheck
	$(JAVAC) *.java

run: Main.java depcheck
	$(JAVA) $^

clean:
	rm *.class

