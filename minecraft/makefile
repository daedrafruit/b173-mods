UNAME := $(shell uname -s 2>/dev/null || echo "Unknown")

ifeq ($(UNAME), Linux)
	GRADLEW := ./gradlew
else ifneq ($(OS),)
	GRADLEW := gradlew.bat
else
	$(error Unsupported platform: $(UNAME))
endif

all: clean build

clean:
	$(GRADLEW) clean

build:
	$(GRADLEW) build

run:
	$(GRADLEW) run
