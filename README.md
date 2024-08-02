# Запуск тестов
***
Для запуска тестов локально на реальном необходмо выполнить команду:
```shell
gradle allDevice -DdeviceHost=personalPhone
```
***
Для запуска тестов локально на эмуляторе необходмо выполнить команду:
```shell
gradle allDevice -DdeviceHost=local
```
***
Для запуска тестов в Browserstack необходмо выполнить команду:
```shell
gradle allDevice -DdeviceHost=browserstac
```
***
ППо умолчанию тесты запускаются в Browserstack.
