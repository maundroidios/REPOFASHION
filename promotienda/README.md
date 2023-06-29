This App was build using H2 database in memory
Springboot
ItelliJ
Hardware : Acer Nitro 4
Java 17
Maven



ALl Data loaded by DATA.sql
Schema created by SCHEMA.sql

ENDPOINT 

(to get promotion By Id)
http://localhost:8080/api/promotion/2

(to get all promotion )
http://localhost:8080/api/promotions


(to get promotion with
[identificador de cadena],
[identificador de producto],
[fecha de aplicación])

http://localhost:8080/api/promotion/

Partial Search By Date
http://localhost:8080/api/promotion/since/2020-06-14

Partial Search By Product Id  and Date sinse
http://localhost:8080/api/promotion/custombasic/35455/2020-06-14

Partial Search By BrandId, Product Id and  Date sinse 
http://localhost:8080/api/promotion/customadvance/1/35455/2020-06-14

- Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
- Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
- Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
- Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
- Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)



PRUEBAS CON POSTMAN

http://localhost:8080/api/promotion/customadvance/1/35455/2020-06-14@10:00:00

RETORNA

{
"productId": 35455,
"brandId": 1,
"fee": 1,
"startDateTime": "2020-06-13T22:00:00.000+00:00",
"priority": 0,
"endDateTime": "2020-12-31T22:59:59.000+00:00",
"finalPrice": 35.5
}



http://localhost:8080/api/promotion/customadvance/1/35455/2020-06-14@16:00:00

RETORNA

{
"productId": 35455,
"brandId": 1,
"fee": 2,
"startDateTime": "2020-06-14T13:00:00.000+00:00",
"priority": 1,
"endDateTime": "2020-06-14T18:30:00.000+00:00",
"finalPrice": 25.45
}

http://localhost:8080/api/promotion/customadvance/1/35455/2020-06-14@21:00:00

RETORNA

{
"productId": 35455,
"brandId": 1,
"fee": 1,
"startDateTime": "2020-06-13T22:00:00.000+00:00",
"priority": 0,
"endDateTime": "2020-12-31T22:59:59.000+00:00",
"finalPrice": 35.5
}

http://localhost:8080/api/promotion/customadvance/1/35455/2020-06-15@10:00:00

RETORNA

{
"productId": 35455,
"brandId": 1,
"fee": 3,
"startDateTime": "2020-06-14T22:00:00.000+00:00",
"priority": 1,
"endDateTime": "2020-06-15T09:00:00.000+00:00",
"finalPrice": 30.5
}

http://localhost:8080/api/promotion/customadvance/1/35455/2020-06-16@21:00:00

RETORNA

{
"productId": 35455,
"brandId": 1,
"fee": 4,
"startDateTime": "2020-06-15T14:00:00.000+00:00",
"priority": 1,
"endDateTime": "2020-12-31T22:59:59.000+00:00",
"finalPrice": 38.95
}


Please let me know for any suggestion calling Support at
+34 674312339

