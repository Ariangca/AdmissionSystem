# Admission System
This is a AdmissionSystem webapplication with Spring boot framwork, and Hibernate object-relational mapping with database.
It also has permission based login with spring security framwork.


## Install

### Dependencies

You need following:

-Java
-maven
-Relational Database
-Servlet container(optional)


### Install repo and requirements

Modify application.properties file base on your database.

![AdmissionSystem](./etcs/application-properties.PNG)

After installing maven you can download application library and compiling program by

```bash
$ mvn clean install
```

## Demo

### Test Inference

You can test the the app with running AdmissionSystemApplication.

Or you can get package and put it in servlet container.

```bash
$ mvn package
```

You can try to login with three registered user student, teacher, ar(admin).
each one has their own permissions.

![AdmissionSystem](./etcs/example-username.PNG)

First you need to login with login page "/login".

Here you can see studnet, teachers, courses, and result tables.



![AdmissionSystem](./etcs/course.PNG)

you can also add, delete, and modify them by clicking on the link.

![AdmissionSystem](./etcs/student-to-course.PNG)



## Future

In the next version, you will be able to register username throw web application and verify your email by clicking on verification email that it sends you.

Moreover, please feel free to give us your feedback to share your experience.

# Contact Me


LinkedIn: https://www.linkedin.com/in/arian-sadeghi-469696241

GitHub: https://github.com/Ariangca
