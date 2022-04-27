--�������: 1 (Serge I: 2002-09-30)
--������� ����� ������, �������� � ������ �������� ����� ��� ���� �� ���������� ����� 500 ���. �������: model, speed � hd
SELECT model, speed, hd from PC where price<500

--�������: 2 (Serge I: 2002-09-21)
--������� �������������� ���������. �������: maker
SELECT distinct maker from product where type = 'Printer'

--�������: 3 (Serge I: 2002-09-30)
--������� ����� ������, ����� ������ � ������� ������� ��-���������, ���� ������� ��������� 1000 ���.
SELECT model, ram, screen from laptop where price > 1000

--�������: 4 (Serge I: 2002-09-21)
--������� ��� ������ ������� Printer ��� ������� ���������.
SELECT * from printer where color = 'y'

--�������: 5 (Serge I: 2002-09-30)
--������� ����� ������, �������� � ������ �������� ����� ��, ������� 12x ��� 24x CD � ���� ����� 600 ���.
SELECT
model,
speed,
hd
from PC
where (cd='12x' OR cd='24x')
AND price<600

--�������: 6 (Serge I: 2002-10-28)
--��� ������� �������������, ������������ ��-�������� c ������� �������� ����� �� ����� 10 �����, ����� �������� ����� ��-���������. �����: �������������, ��������.
SELECT distinct Product.maker, Laptop.speed from Laptop inner join Product on (Laptop.model = Product.model) and Laptop.hd>=10

--�������: 7 (Serge I: 2002-11-02)
--������� ������ ������� � ���� ���� ��������� � ������� ��������� (������ ����) ������������� B (��������� �����).
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

--�������: 8 (Serge I: 2003-02-03)
--������� �������������, ������������ ��, �� �� ��-��������.
SELECT DISTINCT maker
FROM product
WHERE type = 'PC'
EXCEPT
SELECT DISTINCT maker
FROM product
WHERE type= 'Laptop'

--�������: 9 (Serge I: 2002-11-02)
--������� �������������� �� � ����������� �� ����� 450 ���. �������: Maker
SELECT distinct maker 
FROM 
Product, 
PC
where PC.speed>=450 
and 
PC.model = Product.model

--�������: 10 (Serge I: 2002-09-23)
--������� ������ ���������, ������� ����� ������� ����. �������: model, price
SELECT 
model, 
price
FROM printer
WHERE price =
(SELECT 
MAX(price) 
FROM printer)

--�������: 11 (Serge I: 2002-11-02)
--������� ������� �������� ��.
SELECT
AVG(speed) as "AVG-Speed"
from
PC

--�������: 12 (Serge I: 2002-11-02)
--������� ������� �������� ��-���������, ���� ������� ��������� 1000 ���.
SELECT
AVG(speed) as "AVG-Speed"
from
Laptop
WHERE price>1000

--�������: 13 (Serge I: 2002-11-02)
--������� ������� �������� ��, ���������� �������������� A.
SELECT
AVG(speed) as "AVG-Speed"
from
PC 
JOIN
Product
ON
PC.model = Product.model
and Product.maker = 'A'

--�������: 14 (Serge I: 2002-11-05)
--������� �����, ��� � ������ ��� �������� �� ������� Ships, ������� �� ����� 10 ������.
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

--�������: 15 (Serge I: 2003-02-03)
--������� ������� ������� ������, ����������� � ���� � ����� PC. �������: HD
SELECT
hd
FROM PC
group by hd
HAVING count(hd)>1

--�������: 16 (Serge I: 2003-02-03)
--������� ���� ������� PC, ������� ���������� �������� � RAM. � ���������� ������ ���� ����������� ������ ���� ���, �.�. (i,j), �� �� (j,i), ������� ������: ������ � ������� �������, ������ � ������� �������, �������� � RAM.
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

--�������: 17 (Serge I: 2003-02-03)
--������� ������ ��-���������, �������� ������� ������ �������� ������� �� ��.
--�������: type, model, speed
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

--�������: 18 (Serge I: 2003-02-03)
--������� �������������� ����� ������� ������� ���������. �������: maker, price
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

--�������: 19 (Serge I: 2003-02-13)
--��� ������� �������������, �������� ������ � ������� Laptop, ������� ������� ������ ������ ����������� �� ��-���������.
--�������: maker, ������� ������ ������.
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

--�������: 20 (Serge I: 2003-02-13)
--������� ��������������, ����������� �� ������� ���� ��� ��������� ������ ��. �������: Maker, ����� ������� ��.
SELECT
maker,
count(maker) "cnt"
FROM
Product
WHERE
type = 'PC'
GROUP BY maker
HAVING count(maker)>=3

--�������: 21 (Serge I: 2003-02-13)
--������� ������������ ���� ��, ����������� ������ ��������������, � �������� ���� ������ � ������� PC.
--�������: maker, ������������ ����.
SELECT
Pr.maker, 
MAX(P.price)
FROM product Pr
JOIN 
PC P
ON 
Pr.model=P.model
GROUP BY maker

