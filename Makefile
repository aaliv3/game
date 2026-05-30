JAVAV = 26.0.1
JAVA  = java
JAVAC = javac

all: run depcheck

depcheck: depcheck.sh
	./$^ $(JAVAV)

# im lazy
Main.class: src/Main.class depcheck
	$(JAVAC) src/*.java

run: src/Main.java depcheck
	$(JAVA) $^

clean:
	rm *.class

