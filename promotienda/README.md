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

FINXING some error with Time and Dates..
Pending SOlving

http://localhost:8080/api/promotion/customadvance/1/35455/2020-06-14@16:30:00
Pending compare between hours of startDate and EndDate to get the rigth value.
Maybe for wednesday I can fix it.

Please let me know for any suggestion calling Support at
+34 674312339

