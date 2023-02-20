![](Project_Logo.png)

# Team 7 - Recruitment and Admissions Applications

## What is it?

This application aims to solve 3 problems:

- **Tracking applications** \
Hectic way of tracking the applications manually.

- **Managing records** \
Updating, editing and managing records of the data is bothersome.

- **Analysing predictions** \
Updating, editing and managing records of the data is bothersome.

## Features

- **Closing the gap** \
Our product makes the client lives easier which offers some extra cool features. Simple design that gives the client the targeted information they need.

- **Easy user management** \
The School of Healthcare and Sciences can manage the applications very easily with account based authentication.

- **Ease of use** \
Security and admin team can edit, add and delete records with a click

- **Analyse and display predictions** \
Can predict future data based on data analysis

## Dependencies

|Dependency|Version|
|-----------|-----------|
|Java|17|
|Springboot|3.0.0|
|org.mariadb.jdbc:mariadb-java-client|?|

## How to connect to our hosted database
Host: leggett.live 
Port: 3306 
User: group7

Other dependencies are already mentioned in the **build.gradle** and **application.properties** files.

## How to build
Unzip the **Team7Bundle.zip**, open in IDE and hit run **Team7RecruitmentAndAdmissionsApplication** file.

---

## Credits
- Mariia Moroz - Developer
- Snigdha Banani - Developer
- Tomos Leggett - Developer
- Wei Peng - Developer
- Yangshuo Chen - Developer

## Special thanks to
- Bootstrap, for making stylesheets easier for us
- Fontawesome, for providing high quality scalable icons

## Test cases
In order to run the following tests successfully:
- AccountsServiceTest.java
- StatisticsServiceTest.java
- StudentApplicationServiceTest.java

We have to change the value of `id` according to the database values in the following code:

This is an example of an ID in these files:
```java
    @Test
    public void TestGetAccountById(){
        Accounts response =accountsService.getAccountById(6);
        Assertions.assertThat(response.getId()).isEqualTo(6);
    }
```

You only need to change the value of the ID corresponding to the database connected, in this example it is `6`
