Texas Hamburger Admin SpringBoot Application with MongoDB.

1. Implemented log4j2 logger
2. Developed Microservices using Rest controller.

Following are the URLS of the microservices:

Model : Location 
GET : http://localhost:8080/locationapi/locations     You can also use RequestParameter "name" to search by location name.
POST : http://localhost:8080/locationapi/locations
DELETE : http://localhost:8080/locationapi/locations/{id} and http://localhost:8080/locationapi/locations
PUT : http://localhost:8080/locationapi/locations/{id}


Model : Menu
GET : http://localhost:8080/menuapi/menus   You can also use RequestParameters "name" to search by menu name and "category" to search by menu category 
POST : http://localhost:8080/menuapi/menus
DELETE : http://localhost:8080/menuapi/menus/{id}  and http://localhost:8080/menuapi/menus
PUT : http://localhost:8080/menuapi/menus/{id}
GET : http://localhost:8080/menuapi/menus/comboAllowed/{combo}   Here PathVariable could be true/false


Model : Reservation
GET : http://localhost:8080/reservationapi/reservations     You can also use RequestParameter "name" to search reservation by customer name
POST : http://localhost:8080/reservationapi/reservations
DELETE : http://localhost:8080/reservationapi/reservations/{id} and http://localhost:8080/reservationapi/reservations
PUT : http://localhost:8080/reservationapi/reservations/{id}
