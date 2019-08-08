Based on the project: [alvinjo/RealAccountApi](https://github.com/alvinjo/RealAccountApi). 
> **Project Definition:**
> As a user you register for an account online for a bank. Once registered you will be assigned an account number and will be given the opportunity to claim a cash prize. Whether or not a user wins is dependent upon the account number. The size of the cash prize is also dependent upon the account number of that user.

# Requirements
- MongoDB
- ActiveMQ
- Maven
- Node

# Microservices
### AccountAPI
Multitiered API with persistence (*domain* and *repository*), business (*service*) and rest layers. The AccountAPI is the *producer* in this JMS (Java Messaging Service) application.
#### rest layer
Contains all the endpoints to achieve CRUD (Create, Read, Update, Delete) functionality. The create endpoint makes calls to both the *AccountumberGeneratorAPI* and *AccountPrizeGeneratorAPI*. The created account is persisted in an embedded h2 database and sent to a ActiveMQ queue.
### AccountNumberGeneratorAPI
This API generates a random account number containing a character (A, B or C) and 6-10 digits depending on the implementation in the service layer. The API receives requests from the AccountAPI and responds with the generated account number.
### AccountPrizeGeneratorAPI
This API generates a random prize in the range of £1 - £1000. The API is called by the AccountAPI and responds with the generated prize.
### AccountConsumer
The AccountConsumer is the *consumer* in this JMS application. It waits for messages (accounts created by AccountAPI) to appear in the queue and then processes the received message (account), saving the account to a Mongo database.
### Mongo Database
An independent service running over http://localhost:27017
### ActiveMQ
This is the broker (queue) between the AccountAPI and AccountConsumer. It runs over http://localhost:8161
### React Front End
A basic react front end which allows a user to create a new account and view all accounts. More information on how to run can be found [here](https://github.com/Monika-Mistry/springboot-accountAPI/tree/master/account-front-end). The front end runs over http://localhost:3000 

# Running the application
1. Clone down this git repository
2. Navigate to the root of each of the spring boot microservices (AccountAPI, AccountNumberGeneratorAPI, AccountPrizeGeneratorAPI, AccountConsumer)
3. Run command `mvn spring-boot:run`
4. Start ActiveMQ service
5. Start MongoDB
