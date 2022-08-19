# Clusus Test


#### This project is to save the incoming deal.
- #### The application will be run in port number 8081

### Request
- use baseurl:port/deal to send JSON body as below to save in database.
- For this application configuration, 3036 and 8080 are internal port used in docker for mysql and web and 3037 and 8081 mapped in local machine.
- Run [localhost:8081](http://localhost:8081/) to check if the application running. This will get you message that confirm the application is running.

**{
"id":12599,
"fromCurrencyIsoCode":"NPR",
"toCurrencyIsoCode":"NPR",
"dealTime":"2022-08-18 22:31:13",
"amount":45.44
}**

- None of the above field can be blank
- Currency code Should be valid
- If duplicate record are received, it will not be saved in database and returned message in respective response

### Response
- For each request, you will receive the response with response code and message.
- Response code will be 200 for success and 400 for failed.

#### How to run?
- Install Docker first in your local machine - https://docs.docker.com/desktop/install/windows-install/
- Run docker compose file (docker-compose up) - It will download two images from docker hub
- Use any REST API client to send deal data in JSON format




