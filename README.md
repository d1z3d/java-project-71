### Hexlet tests and linter status:
[![Actions Status](https://github.com/d1z3d/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/d1z3d/java-project-71/actions) [![Maintainability](https://api.codeclimate.com/v1/badges/b536ef390e1bc0752161/maintainability)](https://codeclimate.com/github/d1z3d/java-project-71/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/b536ef390e1bc0752161/test_coverage)](https://codeclimate.com/github/d1z3d/java-project-71/test_coverage)

## Asciinema
[Step 5](https://asciinema.org/a/thPcphhGE1LrNDhfl2Zd5FdiC)

[Step 7](https://asciinema.org/a/ORJ4NflGQDOaVtRqqNXoIEeD3)

[Step 8](https://asciinema.org/a/aMhs0jmeHkeJGfRHoTdqK04fP)

[Step 9](https://asciinema.org/a/o4HhktbCLUo1PUjQi5d2nc9vn)

[Step 10](https://asciinema.org/a/ADVwojLVhjx34WBS4GXZfDYF9)

## Difference calculator
A difference calculator is a program that determines the difference between two data structures. This is a popular task, for which there are many online services, for example: http://www.jsondiff.com/. A similar mechanism is used when outputting tests or automatically tracking changes in configuration files.

Utility features:

1. Supports different input formats: "yaml" и "json"
2. Generating a report in the form "plain" text, "stylish" и "json"

Пример использования:

```bash
# plain
./app --format plain path/to/file.yml another/path/file.json

Property 'follow' was added with value: false
Property 'baz' was updated. From 'bas' to 'bars'
Property 'group2' was removed

# stylish
./app filepath1.json filepath2.json

{
  + follow: false
  + numbers: [1, 2, 3]
    setting1: Value 1
  - setting2: 200
  - setting3: true
  + setting3: {key=value}
  + setting4: blah blah
}
```

## Based on
Gradle 8.4

Java 20

## Run application
You have to install the [make](https://guides.hexlet.io/ru/makefile-as-task-runner/?_gl=1*1b2sh59*_ga*NzQ5MzAxNTIzLjE2OTkyOTM2MTc.*_ga_PM3R85EKHN*MTcwMjIyNTQ0MS4xMDguMS4xNzAyMjI3OTYzLjYwLjAuMA..*_ga_WWGZ6EVHEY*MTcwMjIyNTQ0MS4xMTEuMS4xNzAyMjI3OTYzLjYwLjAuMA..) utility.

Run command:
```
make run-dist
```
