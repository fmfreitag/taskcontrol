# taskcontrol

Passos pra rodar:

1)Abra o bash

2)cd taskcontrol

3)cd backend

4)mvn clean package

5)cd ..

6)docker-compose build

7)docker-compose up oracle& 

8)docker-compose up frontend&

9)docker-compose up backend&

obs.: Somente execute o passo 9 apos aparecer a mensagem "oracle-1  | System altered." no terminal, pois o backend necessita que o service oracle esteja 100% operacional.

Para acessar a aplicação frontend: http://localhost:3000

Para acessar a docuentação da API: http://localhost:8080/swagger-ui.html
