build:
	make -C app build

run-dist:
	make -C app run-dist

test:
	make -C app test

report:
	make -C app ./gradlew test jacocoTestReport

lint:
	make -C app lint

.PHONY: build
