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

installDist:
	make -C app installDist

setup:
	make -C app setup

clean:
	make -C app clean

.PHONY: build
