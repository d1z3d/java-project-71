build:
	make -C app build

run-dist:
	make -C app run-dist

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

install:
	make -C app install

setup:
	make -C app setup

clean:
	make -C app clean

.PHONY: build
