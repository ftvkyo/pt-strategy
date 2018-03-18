## pt-strategy

### Семестровое задание по предмету "Технологии программирования"

**У этого репозитория есть раздел Wiki с дополнительной информацией.**

### Dependencies (зависимости):
* JDK 8 (JDK 9 не поддерживается этим Gradle)
* Gradle (Gradlew установит ее автоматически)
* LWJGL (Gradlew установит ее автоматически)

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

Все остальное лежит в папке `src/` - собственно исходный код программы.
Здесь есть две папки - `main` и `test`, в них содержатся
основной код и тесты, соответственно.

#### Установка и запуск
Все, что нужно - склонировать репозиторий и запустить команды:

```bash
./gradlew build
./gradlew run
```

Gradle автоматически загрузит зависимость - библиотеку `LWJGL` -
в свой кеш в домашней папке текущего пользователя. После этого он запустит
сборку, могут появиться директории `build` и/или `out`, а потом Gradle
запустит программу. Точкой входа является метод `main` из класса `Main`,
это указано в инструкциях сборки в `build.gradle`: `mainClassName = 'Main'`.

Мы изменили конфигурационный файл Gradle так, чтобы библиотека `LWJGL`
правильно загружалась и на Linux и на Windows.


#### Запуск тестов:
Для этого достаточно запустить:

```bash
./gradlew test
```

Если Gradle не написал об ошибках - значит все тесты выполнились успешно.


#### Дополнительные инструкции:
* Чтобы собрать программу на Ubuntu, требуется установить
пакет `openjdk-8-jdk`.
* На Windows тоже понадобится 8 версия JDK.
* **Остальные инструкции можно найти в разделе Wiki на гитхабе.**


#### Ссылки
* Какая-то [Концепция](https://docs.google.com/document/d/e/2PACX-1vSpHRiPfLlqVUm37otCjSqb913a2Rj6wKtj59bPCHMOy2IUX041F3jNrHfqbqNyguhXppTrVQphbS43/pub)
* Попытка [Техническое задание](https://docs.google.com/document/d/e/2PACX-1vQM3NRpSZ0w1k_juJK0osW2sz-D8cKg0Lm-9CzF7Vcr4Iquctj_FX4qmdZEONR3xDyRBMt_i7b5aspf/pub)
* Устаревшие [Диаграммы](https://www.draw.io/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Diagrams#Uhttps%3A%2F%2Fdrive.google.com%2Fuc%3Fid%3D17TI6yRmGKrILYu83-H9geccFlDeuWDhf%26export%3Ddownload),
которые мы рисовали в начале разработки проекта.
Потом будут подкорректированы под новую версию.
