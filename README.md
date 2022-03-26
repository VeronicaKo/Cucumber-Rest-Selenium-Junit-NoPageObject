## Тестовое задание
Реализовать UI и API тесты с использованием:
- UI: Java + Selenium WebDriver + Cucumber
- API: Java + Rest Assured

### Требования к ПО
- Java 15
- Junit 4.12
- RestAssured 4.4.0
- Cucumber 7.1.0
- Selenium 4.1.2
- Lombok 1.18.2
- Jackson 2.13.1

### API
Автоматизировать следующие тесты, используя Rest Assured. Необходимые выдержки из документации по API приведены ниже

URL: http://test-api.d6.dev.devcaz.com/

| Тест                                 |                       Ожидаемый результат             |                                    |
|--------------------------------------|-------------------------------------------------------|------------------------------------|
| Получить токен гостя (Client Credentials Grant, scope — guest:default)| HTTP response code — 200; Ответ содержит токен | Authorization / Client Credentials Grant * POST /v2/oauth2/token |
| Зарегистрировать игрока | HTTP response code — 201; Ответ соответствует документации | Players / Register a new player * POST /v2/players |
| Авторизоваться под созданным игроком (Resource Owner Password Credentials Grant) | HTTP response code — 200; Ответ содержит токен | Resource Owner Password Credentials Grant / Access Token Request |
| Запросить данные профиля игрока | HTTP response code — 200 ; Ответ соответствует документации | Get a single player profile * GET /v2/players/:id  |
| Запросить данные другого игрока | HTTP response code — 404 | Get a single player profile * GET /v2/players/:id  |


### UI
Автоматизировать следующие тесты используя связку Java + Selenium WebDriver + Cucumber

URL: http://test-app.d6.dev.devcaz.com/admin/login

| Тест                         |                       Ожидаемый результат             | Тег готового теста|
|------------------------------|-------------------------------------------------------|----|
|Авторизоваться в админке | Пользователь успешно авторизован, админ - панель загрузилась | @loginadmin |
|Открыть список игроков | Таблица с игроками загрузилась | @tableplayers |
|Отсортировать по любому столбцу и проверить сортировку |Таблица верно отсортирована по выбранному столбцу | @sortplayerstable|

### Инструкция

В папке src/main/resources/driver/ должен лежать файл драйвера вашего текущего браузера "chromedriver.exe" 

Для запуска UI тестов через командную строку использовать команду, теги тестов указаны в таблице выше:
```bash
mvn test -Dcucumber.filter.tags="@loginadmin"
```

Для запуска API тестов через командную строку использовать команду, теги тестов указаны в таблице выше:
```bash
mvn test -Dtest=AllTest
```