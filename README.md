## pt-strategy

### Семестровое задание по предмету "Технологии программирования"

[![Build Status](https://travis-ci.com/ftvkyo2011-study/pt-strategy.svg?branch=master)](https://travis-ci.com/ftvkyo2011-study/pt-strategy)

### Содержание
- [CONTRIBUTING](#contributing)
- [Зависимости](#dependencies)
- [Основная информация](#info)
- [Установка и запуск](#install)
- [Тестирование](#testing)

---

#### <a name="contributing">CONTRIBUTING</a>
Если вы хотите внести свой вклад в проект, пожалуйста, прочтите CONTRIBUTING.md


#### <a name="dependencies">Зависимости</a>
* JDK 8
* Gradle (установится автоматически)
* LWJGL (установится автоматически)
* JOML (установится автоматически)
* Intellij annotations (установится автоматически)


#### <a name="info">Основная информация</a>
У этого репозитория есть раздел Wiki с дополнительной информацией.

Для независимости от IntelliJ IDEA IDE используется система сборки
Gradle. Ее файлы:
```text
./
├── build.gradle
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
└── settings.gradle
```
Файл `.gitignore` указывает программе Git,
какие файлы не следует автоматически добавлять в
"файлы для коммита".

Файл `.gitattributes` указывает Git,
что он должен относиться к `*.bat` файлам с
осторожностью и не заменять в них
CRLF на LF переносы строк при pull.
```text
./                         │
└── src/                   │
    ├── main/java/         │
    │   ├── Controller/... │ Логика обработки действий игрока
    │   ├── Model/...      │ Состояние и логика игры
    │   ├── View/...       │ Описание интерфейса и его отрисовка
    │   ├── Main.java      │ Точка входа
    │   └── Renderer.java  │ Инициализация графики
    │                      │
    └── test/java/...      │ Тесты
```

#### <a name="install">Установка и запуск</a>
```bash
git clone [адрес репозитория]
cd pt-strategy

./gradlew build
./gradlew run
```
Gradle автоматически загрузит зависимоси в свой кеш
в домашней папке текущего пользователя.
В процессе сборки, могут появиться директории `build` и `out`.

Точкой входа является метод `main` из класса `Main`,
это указано в инструкциях сборки в `build.gradle`:
```groovy
mainClassName = 'Main'
```
Библиотека `LWJGL` должна правильно загружалаться и на Linux,
и на Windows (а может быть и на MacOS). Это настроено в `build.gradle`.


#### <a name="testing">Тестирование</a>
Для этого достаточно запустить:
```bash
./gradlew test
```
Gradle настроен сообщать о результатах всех тестов.
