##Welcome to bakery shop project using Maven

## Description
- A social network that connects baking lovers, allowing them to share their bakery recipes, and interacts with each other's recipes by liking, commenting, and saving.
- This web works well on desktop, not for mobile.

## Technology
**1. Frontend**
  - HTML, CSS
  - JavaScript
  - Bootstrap 4, JQuery

**2. Backend**
  - Java Language

**3. Database**
  - MySQL - is an open-source relational database management system

**4. Other Technologies**
- MVC2 Model
- JSP/Servlet

**5. Tool**
  - Netbeans
  - Java JDK 8
  - Apache Tomcat 8
  - MySQL 8.0

## Functional requirements
**1. Guest:**
- [x] Login by Gmail
- [x] Login by username, password
- [x] View recipes
- [x] Search recipes by recipe's title, author's name

**2. Baker**
- [x] Basic functions of normal users
- [x] Create new recipe
- [x] Update/delete own recipe
- [x] Like/share/comment recipe

**3. Admin:**
- [x] Enable/Disable recipes
- [x] Account Management

## Useful Resources

#| #| Name | Description
-| -| ---- | -----------
1| -| [Main Project Folder](https://github.com/SE1613-GROUP4-BakeryReceip/BakeryRecipe_SWP/tree/main/BakeryRecipe) | Source code
2| -| [Database Folder](https://github.com/SE1613-GROUP4-BakeryReceip/BakeryRecipe_SWP/tree/main/database_script) | -
-| 2.1| [Database Script](https://github.com/SE1613-GROUP4-BakeryReceip/BakeryRecipe_SWP/blob/main/database_script/bekery_recipe_DB_final.sql) | SQL Scipt
-| 2.2| [Database Conceptual ERD Diagram](https://github.com/SE1613-GROUP4-BakeryReceip/BakeryRecipe_SWP/blob/main/database_script/erd%20swp-Conceptual%20ERD%20-%202.png) | - 
-| 2.3| [Database Logical ERD Diagram](https://github.com/SE1613-GROUP4-BakeryReceip/BakeryRecipe_SWP/blob/main/database_script/erd%20swp-Logiacl%20ERD%20-%201.png) | - 
-| 2.4| [Database Physical Diagram](https://github.com/SE1613-GROUP4-BakeryReceip/BakeryRecipe_SWP/blob/main/database_script/Physical_ERD_4.png) | -
3| -| [Front-end template](https://www.figma.com/file/8bXKMQcuvUHcne1PlG5mlE/Project-Siu-%C4%90%E1%BB%89n?node-id=151%3A368) | Html/css template for the website
4| -| [Library Folder](https://github.com/SE1613-GROUP4-BakeryReceip/BakeryRecipe_SWP/tree/main/customLib) | Useful libraries
5| -| [Document Folder](https://drive.google.com/drive/folders/1moVIVOYGr9SAljUZ-F6Qu-Cv7pB3yo2T?usp=share_link) | All of document files (Weekly Report, Product Backlog, SRS, Design Document)
6| -| [Presentation Slide](https://www.canva.com/design/DAFS72MvxDU/0QiOsfJ03MNXx1d1qtafPw/view?utm_content=DAFS72MvxDU&utm_campaign=designshare&utm_medium=link&utm_source=homepage_design_menu) | Presentation slide for defense day


## I build the project based on the same one on Github: https://github.com/se1613-group4/BakeryRecipe_SWP
# Thank you all so much for the great and impressive project

##I would like to descripte step by step to configure the project using Maven in Eclipse

 - Install the latest JDK, Eclipse, Maven and Tomcat server version (or whatever version you want)

 - Import the bakery-shop project to the Eclipse

 - Adjust the Maven compiler source in pom.xml file corresponding to the installed JDK verion on your environment

    - Before (The default JDK version):

        - <maven.compiler.source>1.7</maven.compiler.source>
        - <maven.compiler.target>1.7</maven.compiler.target>

    - After (The current JDK version on my environment is 22):

        - <maven.compiler.source>22</maven.compiler.source>
        - <maven.compiler.target>22</maven.compiler.target>
		
 - Check the Dynamic Web Module and Java version in Project Facets (make sure they're using the same version with install JDK)

 - Adjust the dependencies version in pom.xml file to the latest version (or whatever version you want)

 - Add Tomcat server to the project (refer guidline on Google)