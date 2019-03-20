# Filmland
Rest Api built with SpringBoot.

# Api End points

# 1) User should be able to login by providing email and password.

Request URL: http://localhost:8080/login

HTTP Method Type: POST

Request Body: {  "email":"java@sogeti.com",   "password":"Javaiscool90" } 

# 2) Getting all the available categories and the subscribed categories of the authenticated subscriber.

Request URL: http://localhost:8080/filmland/userSubscribedCategories/{userEmail}

HTTP Method Type: GET

Note: Please do attach the JWT tokken in the header provided during the login. 

# 3) Customer can subscribe to a category 

Request URL: http://localhost:8080/filmland/subscribeCategory

HTTP Method Type: POST

Request Body: {  "email":"java@sogeti.com",  "availableCategory":"Dutch Films" }

# 4) Subscriber can share a category 

Request URL: http://localhost:8080/filmland/shareCategory

HTTP Method Type: POST

Request Body: {  "email":"java@sogeti.com",  "customer":"kotlin@sogeti.com",  "subscribedCategory":"Dutch Films" }


Note: Please do attach the JWT tokken in the header for each request provided during the login. 
