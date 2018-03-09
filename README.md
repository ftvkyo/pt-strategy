## pt-strategy

### Семестровое задание по предмету "Технологии программирования"

#### Основная информация
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

Также тут есть файл `.gitignore`, который указывает программе
Git, какие файлы не следует автоматически добавлять в
"файлы для коммита".

Кроме того, здесь есть файл `.gitattributes`, в котором программе Git указано,
что он должен относиться к .bat файлам с осторожностью и не заменять в них
CRLF на LF переносы строк при pull.

Все остальное лежит в папке `src/` - собственно исходныи код программы.
Здесь есть две папки - `main` и `test`, в них содержатся
основнои код и тесты, соответственно.

#### Установка и запуск
Все что нужно - склонировать репозиторий и запустить команды:

```bash
./gradlew build
./gradlew run
```

Gradle автоматически загрузит зависимость -
библиотеку `LWJGL` - в свой кеш в домашней папке текущего пользователя.
После этого он запустит сборку, могут появиться директории `build` и/или `out`,
а потом Gradle запустит программу.
Точкой входа является метод `main` из класса `Game`, это указано в инструкциях
сборки в `build.gradle`: `mainClassName = 'Game'`.


#### Ссылки
* [Концепция](https://docs.google.com/document/d/e/2PACX-1vSpHRiPfLlqVUm37otCjSqb913a2Rj6wKtj59bPCHMOy2IUX041F3jNrHfqbqNyguhXppTrVQphbS43/pub)
* [Техническое задание](https://docs.google.com/document/d/e/2PACX-1vQM3NRpSZ0w1k_juJK0osW2sz-D8cKg0Lm-9CzF7Vcr4Iquctj_FX4qmdZEONR3xDyRBMt_i7b5aspf/pub)
