# CoinbasePro REST Application

Connects to Coinbase Pro Websocket and returns latest results per instrument.

Requirements:
- Docker 19.03.13

For building locally without Docker:
- Java 8
- Maven 3.8.1
- Tomcat 9.0.45

Launch on Docker by executing command: 

`docker-compose up`

Test by calling following endpoints:

| Instrument |  cURL  |
| :--------: | :----: |
| - (all) | curl -X GET "http://localhost:8080" -H "Accept: application/json" |
| BTCEUR | curl -X GET "http://localhost:8080/BTCEUR" -H "Accept: application/json" |
| BTCUSD | curl -X GET "http://localhost:8080/BTCUSD" -H "Accept: application/json" |
| ETHEUR | curl -X GET "http://localhost:8080/ETHEUR" -H "Accept: application/json" |
| ETHUSD | curl -X GET "http://localhost:8080/ETHUSD" -H "Accept: application/json" |