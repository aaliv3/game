JAVAV = 26.0.1
JAVA  = java
JAVAC = javac
BUILD_DIR = build
SRC_DIR = src

all: run depcheck

depcheck: depcheck.sh
	./$^ $(JAVAV)

# im lazy
build: $(SRC_DIR)/Main.java depcheck
	$(JAVAC) src/*.java
	mv $(SRC_DIR)/*.class $(BUILD_DIR)

# Build and run the java sources
$(BUILD_DIR)/Main.class: build
run_build: $(BUILD_DIR)/Main.class
	@echo "Press Enter"
	@read tmp;
	cd $(BUILD_DIR) && $(JAVA) Main

run: $(SRC_DIR)/Main.java depcheck
	$(JAVA) $^

clean:
	rm $(BUILD_DIR)/*.class

test:
	echo "put tests here"

