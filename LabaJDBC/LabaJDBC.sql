-- Создание таблицы для музыкальных композиций, если её ещё нет
CREATE TABLE IF NOT EXISTS study.music (
    id   INT PRIMARY KEY,
    name TEXT NOT NULL
);

-- Добавление музыкальных композиций, если они ещё не существуют
INSERT INTO study.music (id, name)
SELECT * FROM (VALUES 
    (1, 'Bohemian Rhapsody'),
    (2, 'Stairway to Heaven'),
    (3, 'Imagine'),
    (4, 'Sweet Child O Mine'),
    (5, 'Hey Jude'),
    (6, 'Hotel California'),
    (7, 'Billie Jean'),
    (8, 'Wonderwall'),
    (9, 'Smells Like Teen Spirit'),
    (10, 'Let It Be'),
    (11, 'I Want It All'),
    (12, 'November Rain'),
    (13, 'Losing My Religion'),
    (14, 'One'),
    (15, 'With or Without You'),
    (16, 'Sweet Caroline'),
    (17, 'Yesterday'),
    (18, 'Dont Stop Believin'),
    (19, 'Crazy Train'),
    (20, 'Always')) AS new_data
WHERE NOT EXISTS (SELECT 1 FROM study.music);

-- 1. Получение списка всех композиций
SELECT * FROM study.music;

-- 2. Получение композиций без букв "m" и "t" (независимо от регистра)
SELECT * FROM study.music
WHERE LOWER(name) NOT LIKE '%m%' 
  AND LOWER(name) NOT LIKE '%t%';

-- 3. Добавление своей любимой композиции
INSERT INTO study.music (id, name)
VALUES (21, 'Your Favorite Song') 
ON CONFLICT (id) DO NOTHING;

-- 4. Создание таблицы для посетителей, если её ещё нет
CREATE TABLE IF NOT EXISTS study.visitors (
    visitor_id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT UNIQUE
);

-- Создание таблицы для книг, если её ещё нет
CREATE TABLE IF NOT EXISTS study.books (
    book_id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    author TEXT NOT NULL,
    published_year INT,
    isbn TEXT UNIQUE
);

-- 5. Добавление уникальных записей в таблицы посетителей и книг
-- Замените '[JSON DATA HERE]' на данные из файла books.json
INSERT INTO study.visitors (name, email)
SELECT name, email FROM json_populate_recordset(NULL::study.visitors, '[JSON DATA HERE]')
ON CONFLICT DO NOTHING;

INSERT INTO study.books (title, author, published_year, isbn)
SELECT title, author, published_year, isbn 
FROM json_populate_recordset(NULL::study.books, '[JSON DATA HERE]')
ON CONFLICT DO NOTHING;

-- 6. Сортированный список книг по году издания
SELECT * FROM study.books
ORDER BY published_year;

-- 7. Вывод книг, опубликованных после 2000 года
SELECT * FROM study.books
WHERE published_year > 2000;

-- 8. Добавление информации о себе и своих любимых книгах
INSERT INTO study.visitors (name, email)
VALUES ('Ваше Имя', 'ваш.email@example.com')
ON CONFLICT DO NOTHING;

INSERT INTO study.books (title, author, published_year, isbn)
VALUES ('Favorite Book 1', 'Author Name', 2010, 'ISBN_1'),
       ('Favorite Book 2', 'Author Name', 2015, 'ISBN_2')
ON CONFLICT DO NOTHING;

-- 9. Вывод информации о себе и своих любимых книгах
SELECT * FROM study.visitors WHERE name = 'Ваше Имя';
SELECT * FROM study.books WHERE title IN ('Favorite Book 1', 'Favorite Book 2');

-- 10. Удаление таблиц посетителей и книг
DROP TABLE IF EXISTS study.visitors;
DROP TABLE IF EXISTS study.books;
