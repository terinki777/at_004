--1.         Вывести список самолетов с кодами 320, 321, 733;
SELECT *
FROM LANIT.AIRCRAFTS_DATA
WHERE
AIRCRAFTS_DATA.AIRCRAFT_CODE IN ('320','321','733');

--2.         Вывести список самолетов с кодом не на 3;
SELECT
	*
FROM
	LANIT.AIRCRAFTS_DATA
WHERE
	  AIRCRAFTS_DATA.AIRCRAFT_CODE NOT LIKE '3%';

--3.         Найти билеты оформленные на имя «OLGA», с емайлом «OLGA» или без емайла;
SELECT 
  *
FROM LANIT.TICKETS T
WHERE (T.PASSENGER_NAME LIKE '%OLGA%' AND T.EMAIL IS NULL)  OR
      (T.PASSENGER_NAME LIKE '%OLGA%' AND T.EMAIL LIKE '%OLGA%');

--4.         Найти самолеты с дальностью полета 5600, 5700. Отсортировать список по убыванию дальности полета;
SELECT
	*
FROM
	LANIT.AIRCRAFTS_DATA
WHERE
	RANGE IN ('5600', '5700')
ORDER BY
	RANGE DESC;

--5.         Найти аэропорты в Moscow. Вывести название аэропорта вместе с городом. Отсортировать по полученному названию;
SELECT
  AIRPORT_NAME,
  CITY
FROM LANIT.AIRPORTS_DATA
WHERE CITY = 'Moscow'
ORDER BY AIRPORT_NAME ASC;

--6.         Вывести список всех городов без повторов в зоне «Europe»;
SELECT DISTINCT *
FROM LANIT.AIRPORTS_DATA
WHERE TIMEZONE LIKE '%Europe%';

--7.         Найти бронирование с кодом на «3A4» и вывести сумму брони со скидкой 10%
SELECT
  BOOK_REF,
  TOTAL_AMOUNT,
  TOTAL_AMOUNT - (BOOKINGS.TOTAL_AMOUNT) * 0.1 AS "SALE"
FROM LANIT.BOOKINGS
WHERE BOOK_REF LIKE '3A4%';

--8.         Вывести все данные по местам в самолете с кодом 320 и классом «Business» строками вида «Данные по месту: номер места 1», «Данные по месту: номер места 2» … и тд
SELECT 
CONCAT('Seat #: ', SEAT_NO) AS "Data"
FROM LANIT.SEATS
WHERE AIRCRAFT_CODE = '320' AND FARE_CONDITIONS = 'Business';

--9.         Найти максимальную и минимальную сумму бронирования в 2017 году;
SELECT
  MIN(TOTAL_AMOUNT),
  MAX(TOTAL_AMOUNT)
FROM LANIT.BOOKINGS
WHERE BOOK_DATE BETWEEN '01-01-2017' AND '31-12-2017';

--10.      Найти количество мест во всех самолетах, вывести в разрезе самолетов;
SELECT
  AIRCRAFT_CODE,
  count(*)
FROM LANIT.SEATS
GROUP BY AIRCRAFT_CODE
ORDER BY 1;

--11.      Найти количество мест во всех самолетах с учетом типа места, вывести в разрезе самолетов и типа мест;
SELECT
  AIRCRAFT_CODE,
  FARE_CONDITIONS,
  count(*)
FROM LANIT.SEATS
GROUP BY AIRCRAFT_CODE, FARE_CONDITIONS
ORDER BY 1, 2;

--12.      Найти количество билетов пассажира ALEKSANDR STEPANOV, телефон которого заканчивается на 11;
SELECT COUNT(*)
FROM LANIT.TICKETS
WHERE PASSENGER_NAME = 'ALEKSANDR STEPANOV' AND PHONE LIKE '%11';

--13.      Вывести всех пассажиров с именем ALEKSANDR, у которых количество билетов больше 2000. Отсортировать по убыванию количества билетов;
SELECT
  PASSENGER_NAME,
  COUNT(*) AS CNT
FROM LANIT.TICKETS
WHERE PASSENGER_NAME LIKE '%ALEKSANDR%'
GROUP BY PASSENGER_NAME
HAVING count(*) > 2000
ORDER BY 2 DESC;

--14.      Вывести дни в сентябре 2017 с количеством рейсов больше 500.
SELECT
  trunc(SCHEDULED_DEPARTURE, 'dd'),
  count(*)
FROM LANIT.FLIGHTS
WHERE
  SCHEDULED_DEPARTURE
  BETWEEN to_date('01.09.2017', 'dd.mm.yyyy') AND to_date('30.09.2017', 'dd.mm.yyyy')
GROUP BY trunc(SCHEDULED_DEPARTURE, 'dd')
HAVING count(*) > 500
ORDER BY count(*) DESC;

--15.      Вывести список городов, в которых несколько аэропортов
SELECT
  CITY,
  count(*)
FROM LANIT.AIRPORTS_DATA
GROUP BY CITY
HAVING count(*) > 1;

--16.      Вывести модель самолета и список мест в нем, т.е. на самолет одна строка результата
SELECT
  AIRCRAFT_CODE,
  LISTAGG(SEAT_NO,'; ')
WITHIN GROUP(ORDER BY SEAT_NO) SEAT_NO
  FROM LANIT.SEATS
GROUP BY AIRCRAFT_CODE;


--17.      Вывести информацию по всем рейсам из аэропортов в г.Москва за сентябрь 2017
SELECT
	FLIGHT_NO,
	DEPARTURE_AIRPORT,
	ARRIVAL_AIRPORT,
	FLIGHT_ID,
	DATE_DEPARTURE,
	DATE_ARRIVAL
FROM
	LANIT.FLIGHTS F
INNER JOIN
LANIT.AIRPORTS_DATA AD 
ON
	AD.AIRPORT_CODE = F.ARRIVAL_AIRPORT
WHERE
	AD.CITY = 'Moscow'
	AND
  DATE_ARRIVAL
  BETWEEN to_date('01.09.2017') AND to_date('30.09.2017');

--18.      Вывести кол-во рейсов по каждому аэропорту в г.Москва за 2017
SELECT
	DEPARTURE_AIRPORT,
	count(DEPARTURE_AIRPORT)
FROM
	LANIT.FLIGHTS F
INNER JOIN 
LANIT.AIRPORTS_DATA AD
ON
	AD.AIRPORT_CODE = F.ARRIVAL_AIRPORT
WHERE
	AD.CITY = 'Moscow'
	AND
  DATE_ARRIVAL
  BETWEEN to_date('01.01.2017') AND to_date('31.12.2017')
GROUP BY
	DEPARTURE_AIRPORT
ORDER BY
	DEPARTURE_AIRPORT ASC;

--19.      Вывести кол-во рейсов по каждому аэропорту, месяцу в г.Москва за 2017
-- Не совсем понял задание, поэтому вывел количество вылетов из каждого аэропорта в аэропорты Москвы
SELECT
  DEPARTURE_AIRPORT,
  TO_CHAR(DATE_ARRIVAL,'yyyy.mm')"YEAR/MONTH",
  count(*)
FROM LANIT.FLIGHTS F
INNER JOIN 
LANIT.AIRPORTS_DATA AD
ON
	AD.AIRPORT_CODE = F.ARRIVAL_AIRPORT
WHERE
	AD.CITY = 'Moscow'
  AND
  DATE_ARRIVAL
  BETWEEN to_date('01.01.2017') AND to_date('31.12.2017')
GROUP BY DEPARTURE_AIRPORT, TO_CHAR(DATE_ARRIVAL,'yyyy.mm')
ORDER BY TO_CHAR(DATE_ARRIVAL,'yyyy.mm') ASC;
--Сколько вылетов было из московских аэропортов в 2017 году:
SELECT
  DEPARTURE_AIRPORT,
  TO_CHAR(DATE_DEPARTURE,'yyyy.mm')"YEAR/MONTH",
  count(DATE_ARRIVAL)
FROM LANIT.FLIGHTS F
INNER JOIN 
LANIT.AIRPORTS_DATA AD
ON
	AD.AIRPORT_CODE = F.ARRIVAL_AIRPORT
WHERE
	AD.CITY = 'Moscow'
  AND
  TRUNC(DATE_DEPARTURE,'yyyy')= '01.01.2017'
GROUP BY DEPARTURE_AIRPORT, TO_CHAR(DATE_DEPARTURE,'yyyy.mm')
ORDER BY TO_CHAR(DATE_DEPARTURE,'yyyy.mm') ASC;

--20.      Найти все билеты по бронированию на «3A4B»
SELECT *
FROM LANIT.TICKETS
WHERE BOOK_REF LIKE '3A4B%';

--21.      Найти все перелеты по бронированию на «3A4B»
SELECT
  T.BOOK_REF,
  T.PASSENGER_NAME,
  TF.TICKET_NO,
  F.FLIGHT_NO,
  F.DEPARTURE_AIRPORT,
  F.ARRIVAL_AIRPORT
FROM LANIT.TICKETS T, LANIT.TICKET_FLIGHTS TF, LANIT.FLIGHTS F
WHERE T.BOOK_REF LIKE '3A4B%'
      AND
      T.TICKET_NO = TF.TICKET_NO
      AND
      TF.FLIGHT_ID = F.FLIGHT_ID;
