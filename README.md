# SpringUniversity
A production-ready Spring web application. I used Spring core, Security, Boot, REST, Lombok, Thymeleaf, JPA and other cool stuff
This project is a guided, and used for studying.
## Description 
This project a fully operational school website.  It relies on Spring Framework to a great extend, since it was used to study the framework itself. 
### What was used:

 - *Spring Boot* - the core of the project.
 -  **Spring Security**:
    - Authentication
    - Roles (Authorisation)
    - Registration
    - Secure password transfer and storage
    - CSRF attacks prevention
 - **Spring JPA**:
   - Repositories management (CRUD and others)
    - Hibernate stuff 
    - Derived Query Methods
- **MySQL**
- Databases were hosted on **AWS** as an RDS.
- Thymeleaf
- Lombok 
- **Git** - our Lord and savior.
- AOP

Most Frontend was done for me.
## How to use
Operate just how you would a normal website. However, as you probably are an HR or a TeamLead, the following should ease your search in used technologies:
- After you find yourself on the page, you can, of course, click on whatever looks like a button, but note that some buttons only activate when one clicks on text, and not the visual. (that's not my fault)
- The most important stuff lies on header and footer.
  - If you click on contact, you will find yourself at a page where you can submit a message to the admin. Admin can later review and interact with the message. It is saved into a database.
  - Login: Self-explanatory, but you can also register there. The login credentials are encrypted, and saved into the database.
  - Home: to the page you are currently on.
- When you register, and login, you can view the Dashboard. If you've logged as a teacher, you will see Messages tab. Once clicked, it redirects you to the message tab, where you will see your message. You can set the status of the message to "closed", and it will no longer appear.
- You can logout and see the message "You have been successfully logged out!" on the Login page.
- If you scroll down(or just ctrl+f) Holidays, you will find a Holidays tab in the footer. Click on it to see the Holidays fetched from the database. Holidays have 2 statuses, one being Federal, and one being Festival. you can change the link to /holidays/festival, or /federal, to view only one type of holidays.
###### if you see this, i haven't finished the project yet, sorry. I have to add login, but it wasn't done yet...
