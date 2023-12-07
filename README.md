```
version app: 6.4.1001
platform: android 
platformVersion: 9.0, 14.0 
```

# Проект по автоматизации мобильного приложения Wildberries

<br>
<p align="center">
<img width="100%" title="Wildberries" src="images/logo/wb.jpg">
</p>
<br>

## Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Реализованные проверки](#computer-реализованные-проверки)
- [Запуск тестов](#running_woman-запуск-тестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Jira](#-интеграция-с-Jira)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска теста в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## :computer: Использованный стек технологий

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Android-studio" src="images/logo/Android-studio.svg">
<img width="5.5%" title="Appium" src="images/logo/Appium.svg">
<img width="5.7%" title="Appium inspector" src="images/logo/appium_inspector.svg">
<img width="5.5%" title="Browserstack" src="images/logo/Browserstack.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="5%" title="Allure TestOps" src="images/logo/allureTestOps.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Jira" src="images/logo/Jira.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

Автотесты написаны на <code>Java</code> с использованием <code>JUnit 5</code> и <code>Gradle</code>.
Для UI-тестов использован фреймворк [Selenide](https://selenide.org/), чтобы создать на локальном компьюторе эмулятор мобильного устройства с ОС Android используется [Android studio](https://selenide.org/), WebDriver-сессия устанавливается через [Appium server](https://appium.io/docs/en/2.2/).
Помимо этого в данном проекте используется [Browserstack](https://www.browserstack.com/) - облачная платформа для тестирования, которая предоставляет
возможность тестировать веб-сайты и мобильные приложения в браузерах по требованию, операционных системах и реальных мобильных устройствах.
Запуск тестов можно осуществлять локально или с помощью Browserstack.
Также реализована сборка в <code>Jenkins</code> с формированием Allure-отчета и отправкой уведомления с результатами
в <code>Telegram</code> после завершения прогона. Произведена интеграция данной сборки с <code>Allure TestOps</code>

Allure-отчет включает в себя:

* шаги выполнения тестов;
* скриншот страницы в браузере в момент окончания автотеста;
* Page Source;
* логи браузерной консоли;
* видео выполнения автотеста.

## :computer: Реализованные проверки

- [x] *Добавление товара в корзину*
- [x] *Удаление товара из корзины*
- [x] *Навигация по приложению (профиль, корзина, каталог товаров)*
- [x] *Поиcк и отображаемая карточка выбранного товара*
- [x] *Выбор товара из категорий:*
    - Женщинам
    - Новый год
    - Товары для взрослых
        - наличие Alert сообшения, для подтверждения возрастной категории
- [x] *Проверка наличия предупреждаюего сообщения на некорректно введённый номер телефона при входе в личный кабинет*
- [x] *Наличие модального окна для ввода кода верификации при входе в личный кабинет*
- [x] *Поиск товара через строку поиска*

## :running_woman: Запуск тестов

### Локальный запуск тестов

```
gradle clean test "-DdeviceHost=local"
```

### Запуск тестов через Browserstack

```
gradle clean test "-DdeviceHost=browserstack"
```

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> <a href="https://jenkins.autotests.cloud/job/Mobile_WB_app/"> Сборка в Jenkins</a>

<p align="center">
<img title="Jenkins Build" src="images/screenshots/Build.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure_Report.svg"> <a href="https://jenkins.autotests.cloud/job/Mobile_WB_app/2/allure/">Пример Allure-отчета</a>

### Overview

<p align="center">
<img title="Allure Overview" src="images/screenshots/Jenkins1g.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Allure Overview" src="images/screenshots/jenkins2g.png">
</p>
<p align="center">
<img title="Allure Overview" src="images/screenshots/jenkins3g.png">
</p>

## <img width="4%" title="Allure TestOPS" src="images/logo/allureTestOps.svg"> Интеграция с [Allure TestOps](https://qameta.io/)

### Основной дашборд

<p align="center">
  <img src="images/screenshots/testOps1.png" alt="dashboard" width="900">
</p>

### Тест-кейсы

<p align="center">
  <img src="images/screenshots/testOps2.png" alt="testcase" width="900">
</p>
<p align="center">
  <img src="images/screenshots/testOps3.png" alt="testcase" width="900">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Уведомление в Telegram с отчетом о прогоне данной сборки

<p align="center">
<img width="70%" title="Telegram Notifications" src="images/screenshots/Телеграм.png">
</p>

## <img width="4%" title="Jira" src="images/logo/Jira.svg"> Интеграция с [Jira](https://www.atlassian.com/ru/software/jira)

<p align="center">
  <img src="images/screenshots/jira_.png" alt="JiraIntegration" width="950">
</p>

### <img width="4%" style="vertical-align:middle" title="Browserstack" src="images/logo/Browserstack.svg"> Видео примера запуска теста на облачной платформе Browserstack

К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже AddingProductRemovalTest > Добавление
товара в корзину.
<p align="center">
  <img title="Selenoid Video" src="images/video/1a1224827da92c27b21c9e564de8738a.gif">
</p>