# Spring University
A production-ready Spring web application. I used Spring core, Security, Boot, REST, Lombok, Thymeleaf, JPA and other cool stuff.
This project is guided, and used for studying purposes only.
## Description 
This project a fully operational school website.  It relies on Spring Framework to a great extend, since it was used to study the framework itself. 
### What was used:

 - *Spring Boot* - the core of the project.
 -  **Spring Security**:
    - Authentication
    - Authorization (ROLE_USER, ROLE_ADMIN)
    - Registration
    - Secure password transfer and storage
    - CSRF attacks prevention
 - **Spring JPA**:
   - Repositories management (CRUD and others)
    - Hibernate stuff 
    - Derived Query Methods
    - Relationships(1-1, 1-M, M-M)
    - Sorting and paging.
- **MySQL**
- **REST**
  - Spring Data REST
  - HAL explorer (a tool to easily navigate through the rest options)
  - Postman (an app to construct REST queries)
- Databases are hosted on **AWS** as an RDS.
- Thymeleaf
- Lombok 
- **Git** - our Lord and savior.
- AOP (logging)


Most Frontend was done for me(layout by W3schools).
## How to use
Operate just how you would a normal website. However, as you probably are an HR or a TeamLead, the following should ease your search in used technologies:
- After you find yourself on the page, you can, of course, click on whatever looks like a button, but there isn't much backend.
- The most important stuff lies on header and footer.

![image](https://user-images.githubusercontent.com/108194191/184869532-f275a794-a954-4558-a488-685fe821a20f.png)
  - If you click on contact, you will find yourself at a page where you can submit a message to the admin. Admin can later review and interact with the message. It is saved into a database.
  
  ![image](https://user-images.githubusercontent.com/108194191/184869963-af2e0753-4c51-4538-a838-91b5e7e19892.png)
  
Fields are validated:
  
  ![image](https://user-images.githubusercontent.com/108194191/184870072-6a1f4acc-b264-4bad-9dcc-f53407f14f86.png)
  - Login: Self-explanatory, but you can also register there. below is an invalid credentials demo:
  
  ![image](https://user-images.githubusercontent.com/108194191/184870411-d5132522-4b8a-410c-aa25-0ebc557f3cde.png)
###### login credentials for user:  maksymriabov2004@gmail.com:1234567, for admin:  admin@gmail.com:admin123
  - Register: The login credentials are encrypted with BCrypt, and saved into the database. You can *not* use easy passwords like "123456","password" and "qwerty". 
  
  ![image](https://user-images.githubusercontent.com/108194191/184870574-d762ff94-a2d8-40d5-a2e4-906b99fb3a08.png)
  
various bad input demonstration(@NotBlank is as well):
  
  ![image](https://user-images.githubusercontent.com/108194191/184871226-abf9db45-436c-4cc2-8db9-91b2e5ffa9e9.png)
  
  ![image](https://user-images.githubusercontent.com/108194191/184871440-59ce3a48-d5d2-43fe-be99-7473494efd83.png)
  - Home: to the homepage.
  - When you register and login, you can view the Dashboard. 
- **Admin only**:

![image](https://user-images.githubusercontent.com/108194191/184871601-ad62d42e-5525-4e55-b12d-94d786c559ae.png)
  - If you've logged as a teacher, you will see Messages tab. Once clicked, it redirects you to the message tab, where you will see messages from students. You can set the status of the message to "closed", and it will no longer appear. Messages are paged using Spring JPA, can be sorted if clicked on a parameter name above. While descending sorting is default, click second time for it to become sorted as ascended.
  
  ![image](https://user-images.githubusercontent.com/108194191/184871936-2d0de5a7-7108-4ba2-a285-4587765531d9.png)
  - If you click "Profile", it will redirect you to a place where you can alter your information, like your place of living. Once entered, this information will be loaded every time you use this page.
  
  ![image](https://user-images.githubusercontent.com/108194191/184872128-1faadfc7-b8d0-42e9-ae12-994d8749cf52.png)
  - In "Classes" page, you can review all the classes in the school. Click "View" to get the information about students. You can add or remove students from the class.  If you enter a wrong email, system recognises it and shows an error. If you registered before, try to insert your email!
  
  - "Courses" were created as an example of Many-to-many relationships - where students have a number of courses, and courses have a number of students. You can add a course, if you like, and then view its students. You can also add a student to the course.
    
![image](https://user-images.githubusercontent.com/108194191/184915191-121f3fcf-9d6a-4c49-b52b-d08a2390bcf7.png)

Click on "VIEW" 

![image](https://user-images.githubusercontent.com/108194191/184915446-2364d29c-bdc9-4e4b-b665-5200000c2129.png)
    
  If you add a non-existent student you will see an error message. 
![image](https://user-images.githubusercontent.com/108194191/184915493-a06e0241-be7a-42d5-8d05-5c5f935019a2.png)
   - You can log in as a student and view the courses page as a student. Here, though, you can only view the courses and not interact with them.
  
- You can logout and see the message "You have been successfully logged out!" on the Login page.
![image](https://user-images.githubusercontent.com/108194191/184916345-0933f1ee-590c-44ea-adb6-c144a0886016.png)

- If you scroll down(or just ctrl+f) Holidays, you will find a Holidays tab in the footer. Click on it to see the Holidays fetched from the database. Holidays have 2 statuses, one being Federal, and one being Festival. you can change the link to /holidays/festival, or /federal, to view only one type of holidays.
![image](https://user-images.githubusercontent.com/108194191/184917652-0bfd7191-58e0-4c5b-8862-572bcdd7eaee.png)
![image](https://user-images.githubusercontent.com/108194191/184917808-e1c171b0-dee5-47ab-a590-f4da6b76e1d4.png)
![image](https://user-images.githubusercontent.com/108194191/184918127-68f0c373-3a1f-460b-b0f3-e2d772a7daae.png)

- Note that some on some buttons on the homepage the only thing clickable is text, and not the visual.
### REST implementation

Rest is implemented, you can access it with Postman, or other programs to navigate REST. It is accessed via localhost:8080/api/contact/..
You can view the list of commands in edu/mriabov/springuniversity/rest/ContactRestController.java

You can also use HAL explorer to easily navigate the REST commands. Well, it's easier, at least.

## Misc
- There are profiles, which configure the properties. 2 available, one prod, one UAT(for testing purposes). They configure which log statements are to be displayed, how many contact messages are shown per one page, how many.
- Breadcrumbs
- HAL explorer: eases the search in REST
- Custom annotation validators - password strength, as well as whether passwords and emails mathc
- Auditing. Every admin action is audited. It means that every action's creation date and time is stored in the DB, as well as it's modifying time.
![image](https://user-images.githubusercontent.com/108194191/184927197-46cc6143-85ff-4ce9-8ec6-18ad634a6d5f.png)
 - CSRF handling
 - Named and other queries.
