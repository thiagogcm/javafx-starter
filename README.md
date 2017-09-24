JavaFx Starter
=============
This a simple template to start a JavaFx project using: 
* Gradle Kotlin script;
* Spring-boot integration;
* MVP design pattern;
* Checkstyle with Google style guide rules

Prerequisites
------------
* JDK 8+

How to use it
-------------
* Clone this repo and delete the `.git` dir
```
 git clone https://github.com/thiagogcm/javafx-starter.git PROJECT_NAME
```
* Replace `PROJECT_NAME` with a new name
* Rename the `rootProject.name` property in the `settings.gradle` file with the new project name

#### Now you're good to go:
```
./gradlew bootJar
java -jar build/libs/PROJECT_NAME.jar
```
