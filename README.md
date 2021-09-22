# SISS
Sales information storage system

###### Запуск

Для запуска всего проекта в docker нужно:
1. Установить Docker https://www.docker.com/get-started 
2. В терминале выполнить команду "docker-compose up -d"

Для запуска postgres в docker, а tomcat с веб-приложением в IDE нужно:
1. Установить Docker https://www.docker.com/get-started
2. В терминале выполнить команду "docker-compose up -d pg_db"
3. Запустить SissApplication в IDE или выполнить команду в терминале "./mvnw clean spring-boot:run"

###### Тестовое задание

Система хранения информации о продажах

Дано:
Товар. (Наименование, Цена). Раз в час случайным образом выбирается товар, на который следующий час будет действовать скидка. Скидка выбирается случайным образом от 5% до 10%.
Продажа. Состоит из Даты и нескольких (одна или больше) позиций (Товар, Количество, Скидка).

Задание:
Нужен веб-сайт отображающий следующие данные:
1. Информация о товарах. Страница должна содержать список товаров с возможностью редактирования и добавления новых позиций. По каждому товару должна присутствовать информация о его продажах.
2. Информация о продажах. Страница должна содержать список продаж с возможностью добавления новых позиций. По каждой продаже должна присутствовать информация о товарах.
3. История скидок.
4. Почасовая статистика содержащая количество чеков, общую стоимость чеков, стоимость среднего чека, сумму скидок, общую стоимость чеков с учётом скидок, стоимость среднего чека с учётом скидок, прирост среднего чека к предыдущему часу (разность между стоимостью среднего чека за текущий и предыдущий часы.

Обязательно: Spring, REST API для работы с бэкендом, Apache Tomcat, PostgreSQL, JPA (Hibernate).
Фронтенд должен использовать API бэкенда и может быть реализован любым удобным способом.

Желательно: Нагрузочные и юнит-тесты.

Необходимо приложить краткую инструкцию по установке и запуску приложения.

При проверке будет обращаться внимание на:

    • соответствие разработанного приложения тексту задания;
    • использование принципов ООП и следование выбранным технологиям;
    • наличие \ отсутствие ошибок
    • читабельность кода