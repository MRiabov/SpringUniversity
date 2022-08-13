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
- Databases are hosted on **AWS** as an RDS.
- Thymeleaf
- Lombok 
- **Git** - our Lord and savior.
- AOP

Most Frontend was done for me.
## How to use
Operate just how you would a normal website. However, as you probably are an HR or a TeamLead, the following should ease your search in used technologies:
- After you find yourself on the page, you can, of course, click on whatever looks like a button, but there isn't much backend.
- The most important stuff lies on header and footer.
  - If you click on contact, you will find yourself at a page where you can submit a message to the admin. Admin can later review and interact with the message. It is saved into a database.
  - Login: Self-explanatory, but you can also register there. The login credentials are encrypted with BCrypt, and saved into the database. You can *not* use easy passwords like "123456","password" and "qwerty". 
###### login credentials for user:  maksymriabov2004@gmail.com:1234567, for admin:  admin@gmail.com:admin123
  - Home: to the page you are currently on.
  - When you register and login, you can view the Dashboard. 
- **Admin only**:
  - If you've logged as a teacher, you will see Messages tab. Once clicked, it redirects you to the message tab, where you will see messages from students. You can set the status of the message to "closed", and it will no longer appear. Messages are paged using Spring JPA, can be sorted if clicked on a parameter name above. While descending sorting is default, click second time for it to become sorted as ascended.
  - If you click "Profile", it will redirect you to a place where you can alter your information, like your place of living. Once entered, this information will be loaded every time you use this page.
  - In "Classes" page, you can review all the classes in the school. Click "View" to get the information about students. You can add or remove students from the class. If you enter a wrong email, system recognises it and shows an error. If you registered before, try to insert your email!
  - "Courses" were created as an example of Many-to-many relationships - where students have a number of courses, and courses have a number of students. You can add a course, if you like, and then view its students. You can also add a student to the course.
    - You can log in as a student and view the courses page as a student. Here, though, you can only view the courses and not interact with them.
  
- You can logout and see the message "You have been successfully logged out!" on the Login page.

- If you scroll down(or just ctrl+f) Holidays, you will find a Holidays tab in the footer. Click on it to see the Holidays fetched from the database. Holidays have 2 statuses, one being Federal, and one being Festival. you can change the link to /holidays/festival, or /federal, to view only one type of holidays.
- Note that some on some buttons the only thing clickable is text, and not the visual. (that's not my fault)
