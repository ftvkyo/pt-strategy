# Инструкция для участников.

## Общая информация:
* Ветка `master` защищена от прямого внесения изменений для всех, кроме
админов репозитория.
* Перенос стабильной версии в `master` производится
с помощью механизма Pull Request.
* If you don't have write access in this repo, you should make
a pull request to the `master` branch from your fork.

## Collaborating for users with write access:
##### Edit code:
1) Склонируйте репозиторий `git clone`
2) Создайте локальную ветку для своей работы `git checkout -b [branch]`
3) Советую не вносить изменения прямо в эту ветку, а делать
merges в нее из веток для features.

##### Send changes:
```bash
# Подтянем и применим изменения в ветки origin/... и master
git pull

# Перейдем в вашу ветку
git checkout [branch]
# Перенесем ваши изменения на верхушку `master` при этом не тронув ее
# При этом можно сделать squash каких-либо коммитов
git rebase -i master

# Запушим вашу ветку
git push

# Создадим Pull-Request на GitHub
# Из вашей ветки в master
...
```

## [Collaborating for users without write access](https://gist.github.com/Chaser324/ce0505fbed06b947d962)
