run-dist:
	./build/install/app/bin/app

run-with-arg-h:
	./build/install/app/bin/app -h

build:
	./gradlew clean build

report:
	./gradlew jacocoTestReport

run:
	./build/install/app/bin/app /home/d1z3d/file1.json /home/d1z3d/file2.json

.PHONY: build