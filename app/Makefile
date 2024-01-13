# Makefile
.DEFAULT_GOAL := build-run

setup:
	gradle wrapper --gradle-version 8.4

clean:
	./gradlew clean

.PHONY: build
build:
	./gradlew clean build

.PHONY: installDist
installDist:
	./gradlew clean installDist

run-dist:
	./build/install/app/bin/app

run:
	./gradlew run

.PHONY: test
test:
	./gradlew test

test-yml:
	./build/install/app/bin/app /home/d1z3d/file3.yml /home/d1z3d/file4.yml

test-json:
	./build/install/app/bin/app /home/d1z3d/file1.json /home/d1z3d/file2.json

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

check-deps:
	./gradlew dependencyUpdates -Drevision=release


build-run:
	build run