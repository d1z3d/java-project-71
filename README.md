### Hexlet tests and linter status:
[![Actions Status](https://github.com/d1z3d/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/d1z3d/java-project-71/actions) [![Maintainability](https://api.codeclimate.com/v1/badges/b536ef390e1bc0752161/maintainability)](https://codeclimate.com/github/d1z3d/java-project-71/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/b536ef390e1bc0752161/test_coverage)](https://codeclimate.com/github/d1z3d/java-project-71/test_coverage)



## Вычислитель отличий
Вычислитель отличий – программа, определяющая разницу между двумя структурами данных. Это популярная задача, для решения которой существует множество онлайн-сервисов, например: http://www.jsondiff.com/. Подобный механизм используется при выводе тестов или при автоматическом отслеживании изменении в конфигурационных файлах.

Возможности утилиты:

..*Поддержка разных входных форматов: yaml и json
..*Генерация отчета в виде plain text, stylish и json

Пример использования:

```bash
# формат plain
./app --format plain path/to/file.yml another/path/file.json

Property 'follow' was added with value: false
Property 'baz' was updated. From 'bas' to 'bars'
Property 'group2' was removed

# формат stylish
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

## Asciinema
[Step 5](https://asciinema.org/a/thPcphhGE1LrNDhfl2Zd5FdiC)

[Step 7](https://asciinema.org/a/ORJ4NflGQDOaVtRqqNXoIEeD3)

[Step 8](https://asciinema.org/a/aMhs0jmeHkeJGfRHoTdqK04fP)

[Step 9](https://asciinema.org/a/o4HhktbCLUo1PUjQi5d2nc9vn)

[Step 10](https://asciinema.org/a/ADVwojLVhjx34WBS4GXZfDYF9)
