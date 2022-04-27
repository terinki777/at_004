--Задание: 1 (Serge I: 2002-09-30)
--Найдите номер модели, скорость и размер жесткого диска для всех ПК стоимостью менее 500 дол. Вывести: model, speed и hd
SELECT model, speed, hd from PC where price<500

--Задание: 2 (Serge I: 2002-09-21)
--Найдите производителей принтеров. Вывести: maker
SELECT distinct maker from product where type = 'Printer'

--Задание: 3 (Serge I: 2002-09-30)
--Найдите номер модели, объем памяти и размеры экранов ПК-блокнотов, цена которых превышает 1000 дол.
SELECT model, ram, screen from laptop where price > 1000

--Задание: 4 (Serge I: 2002-09-21)
--Найдите все записи таблицы Printer для цветных принтеров.
SELECT * from printer where color = 'y'

--Задание: 5 (Serge I: 2002-09-30)
--Найдите номер модели, скорость и размер жесткого диска ПК, имеющих 12x или 24x CD и цену менее 600 дол.
SELECT
model,
speed,
hd
from PC
where (cd='12x' OR cd='24x')
AND price<600

--Задание: 6 (Serge I: 2002-10-28)
--Для каждого производителя, выпускающего ПК-блокноты c объёмом жесткого диска не менее 10 Гбайт, найти скорости таких ПК-блокнотов. Вывод: производитель, скорость.
SELECT distinct Product.maker, Laptop.speed from Laptop inner join Product on (Laptop.model = Product.model) and Laptop.hd>=10

--Задание: 7 (Serge I: 2002-11-02)
--Найдите номера моделей и цены всех имеющихся в продаже продуктов (любого типа) производителя B (латинская буква).
SELECT DISTINCT
product.model,
pc.price
FROM Product
JOIN
pc
ON
product.model = pc.model
WHERE maker = 'B'
UNION
SELECT DISTINCT product.model, laptop.price
FROM product JOIN laptop ON product.model=laptop.model WHERE maker='B'
UNION
SELECT DISTINCT product.model, printer.price
FROM product JOIN printer ON product.model=printer.model WHERE maker='B'

--Задание: 8 (Serge I: 2003-02-03)
--Найдите производителя, выпускающего ПК, но не ПК-блокноты.
SELECT DISTINCT maker
FROM product
WHERE type = 'PC'
EXCEPT
SELECT DISTINCT maker
FROM product
WHERE type= 'Laptop'

--Задание: 9 (Serge I: 2002-11-02)
--Найдите производителей ПК с процессором не менее 450 Мгц. Вывести: Maker
SELECT distinct maker 
FROM 
Product, 
PC
where PC.speed>=450 
and 
PC.model = Product.model

--Задание: 10 (Serge I: 2002-09-23)
--Найдите модели принтеров, имеющих самую высокую цену. Вывести: model, price
SELECT 
model, 
price
FROM printer
WHERE price =
(SELECT 
MAX(price) 
FROM printer)

--Задание: 11 (Serge I: 2002-11-02)
--Найдите среднюю скорость ПК.
SELECT
AVG(speed) as "AVG-Speed"
from
PC

--Задание: 12 (Serge I: 2002-11-02)
--Найдите среднюю скорость ПК-блокнотов, цена которых превышает 1000 дол.
SELECT
AVG(speed) as "AVG-Speed"
from
Laptop
WHERE price>1000

--Задание: 13 (Serge I: 2002-11-02)
--Найдите среднюю скорость ПК, выпущенных производителем A.
SELECT
AVG(speed) as "AVG-Speed"
from
PC 
JOIN
Product
ON
PC.model = Product.model
and Product.maker = 'A'

--Задание: 14 (Serge I: 2002-11-05)
--Найдите класс, имя и страну для кораблей из таблицы Ships, имеющих не менее 10 орудий.
SELECT 
S.class,
S.name,
C.country
FROM
Ships S
JOIN
Classes C
ON
S.class=C.class
AND C.numGuns>=10

--Задание: 15 (Serge I: 2003-02-03)
--Найдите размеры жестких дисков, совпадающих у двух и более PC. Вывести: HD
SELECT
hd
FROM PC
group by hd
HAVING count(hd)>1

--Задание: 16 (Serge I: 2003-02-03)
--Найдите пары моделей PC, имеющих одинаковые скорость и RAM. В результате каждая пара указывается только один раз, т.е. (i,j), но не (j,i), Порядок вывода: модель с большим номером, модель с меньшим номером, скорость и RAM.
SELECT DISTINCT
A.model,
B.model,	
A.speed,	
A.ram
FROM PC A, PC B
WHERE
A.speed = B.speed 
AND
B.ram=A.ram
AND
A.model>B.model

--Задание: 17 (Serge I: 2003-02-03)
--Найдите модели ПК-блокнотов, скорость которых меньше скорости каждого из ПК.
--Вывести: type, model, speed
SELECT DISTINCT
type, 
Laptop.model, 
speed
FROM Laptop
JOIN
Product
ON
Laptop.model = Product.model
AND
speed< ALL 
(SELECT speed
FROM PC)

--Задание: 18 (Serge I: 2003-02-03)
--Найдите производителей самых дешевых цветных принтеров. Вывести: maker, price
SELECT DISTINCT  
MIN(Printer.price) price, maker
FROM Printer, Product
where color = 'y'
and Product.type = 'Printer'
group by maker

SELECT DISTINCT 
maker, 
price
FROM product 
JOIN 
printer 
ON 
product.model=printer.model
WHERE
color='y'
AND
price=
(
SELECT MIN(price)
FROM printer
WHERE color='y'
)

--Задание: 19 (Serge I: 2003-02-13)
--Для каждого производителя, имеющего модели в таблице Laptop, найдите средний размер экрана выпускаемых им ПК-блокнотов.
--Вывести: maker, средний размер экрана.
SELECT DISTINCT
maker,
AVG(Laptop.screen) "AVG_screen"
FROM
Product
JOIN
Laptop
ON
product.model=Laptop.model
WHERE
type ='Laptop'
GROUP BY maker

--Задание: 20 (Serge I: 2003-02-13)
--Найдите производителей, выпускающих по меньшей мере три различных модели ПК. Вывести: Maker, число моделей ПК.
SELECT
maker,
count(maker) "cnt"
FROM
Product
WHERE
type = 'PC'
GROUP BY maker
HAVING count(maker)>=3

--Задание: 21 (Serge I: 2003-02-13)
--Найдите максимальную цену ПК, выпускаемых каждым производителем, у которого есть модели в таблице PC.
--Вывести: maker, максимальная цена.
SELECT
Pr.maker, 
MAX(P.price)
FROM product Pr
JOIN 
PC P
ON 
Pr.model=P.model
GROUP BY maker

