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

| Тест                                 |                       Ожидаемый результат             |
|--------------------------------------|-------------------------------------------------------|
| Получить токен гостя (Client Credentials Grant, scope — guest:default)| HTTP response code — 200; Ответ содержит токен |
| Зарегистрировать игрока | HTTP response code — 201; Ответ соответствует документации |
| Авторизоваться под созданным игроком (Resource Owner Password Credentials Grant) | HTTP response code — 200; Ответ содержит токен |
| Запросить данные профиля игрока | HTTP response code — 200 ; Ответ соответствует документации |
| Запросить данные другого игрока | HTTP response code — 404 |

1 Authorization / Client Credentials Grant * POST /v2/oauth2/token HTTP/1.1 * Предоставление учетных данных клиента

3 Resource Owner Password Credentials Grant / Access Token Request * POST /v2/oauth2/token HTTP/1.1 * Владелец ресурса Пароль Учетные данные Предоставление

Protected Resource Request * GET /v2/players HTTP/1.1 * Запрос защищенного ресурса

2 Players / Register a new player * POST /v2/players HTTP/1.1 * Игроки / Зарегистрируйте нового игрока

4и5  Get a single player profile * GET /v2/players/:id HTTP/1.1 * Получить профиль одного игрока


### UI
Автоматизировать следующие тесты используя связку Java + Selenium WebDriver + Cucumber

URL: http://test-app.d6.dev.devcaz.com/admin/login

| Тест                         |                       Ожидаемый результат             | Тег готового теста|
|------------------------------|-------------------------------------------------------|----|
|Авторизоваться в админке | Пользователь успешно авторизован, админ - панель загрузилась | @loginadmin |
|Открыть список игроков | Таблица с игроками загрузилась | @tableplayers |
|Отсортировать по любому столбцу и проверить сортировку |Таблица верно отсортирована по выбранному столбцу | @sortplayerstable|

Для запуска через командную строку использовать команду, теги тестов указаны в таблице выше:
```bash
mvn test -Dcucumber.filter.tags="@loginadmin"
```