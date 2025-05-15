# QuizEx

**«QuizEx»** - это десктопное приложение, разработанное в рамках дисциплины «Технологии программирования», которое предназначено для тестирования пользователей в формате викторины по следующим дисциплинам: 
+ Математический анализ; 
+ Линейная алгебра;
+ Объектно-ориентированное программирование, включая основы Си/С++;
____

# Описание проекта

Система «QuizEx» предназначена для подготовки к экзамену по выбранной дисциплине и проверки знаний студентов. 

Система обеспечивает выполнение следующих функций:
1. Регистрация пользователя
2. Авторизация пользователя
3. Выбор предмета
4. Выбор уровня по предмету
5. Просмотр достижений
6. Прохождение экзамена по выбранному предмету

Проект реализован на платформе Java 17 в качестве среды разработки использовался NetBeans (версии 24). 
Графический интерфейс был реализован с помощью библиотеки Swing.
В качестве базы данных использовался PostgreSQL версии 16.

## Диаграмма компонентов:

![image](https://github.com/user-attachments/assets/3057ec17-481c-42c2-b8c2-5c08b5e7492a)

____

# Интерфейс

+ Окно авторизации и регистрации:
  
![image](https://github.com/user-attachments/assets/fef98748-09ae-4f6e-81c4-f6986b6bfb91)

+ Основное меню:
  
![image](https://github.com/user-attachments/assets/e52b1976-fa1d-423b-b7ac-9de2c6589552)

+ Окно выбора предмета:
  
![image](https://github.com/user-attachments/assets/ca86913c-180b-4e2e-b84c-fdca1a90d56d)

+ Окно выбора уровня:
  
![image](https://github.com/user-attachments/assets/498d0e5a-b52d-4438-ac4c-050c38ed0a8d)

+ Окно задачи:
  
![image](https://github.com/user-attachments/assets/f2c7cab9-ffef-4726-9780-672ebbf4a92a)

+ Окно с шуткой:
  
![image](https://github.com/user-attachments/assets/716ca842-c3f0-4d19-8519-3365d5220446)

+ Окно достижений:
  
![image](https://github.com/user-attachments/assets/59fc6383-8bde-4587-84a8-65a6d881c80f)
____

# Запуск проекта

1) Необходимо восстановить dump файл базы данных PostgreSQL:
   
   `psql -d ваша_база -U ваш_пользователь -f файл_дампа.sql`

   или

   'pg_restore -h localhost -U postgres -d mydb backup.sql'
   
3) Указать соответсвующий URL, USER, PASSWORD в DatabaseManager.java расположенный src\main\java\db\DatabaseManager.java

   `private static final String URL = "";`

   `private static final String USER = "";`

   `private static final String PASSWORD = "";`

____

# Авторы

+ Зарубина Анжелика
+ Федотов Тимофей 
