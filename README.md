

-This is the first sprint boot/ maven project I have ever done. It's probably going to be rough. Here is how I set up the project intially

# Java Backend Banking Set up instructions
1. Go to https://start.spring.io
2. Choose:
   - Project: Maven
   - Language: Java
   - Spring Boot: 3.4.x
   - Packaging: Jar
   - Java: 17
3. Add dependencies:
   - Spring Web
   - Spring Data JPA
   - PostgreSQL Driver (optional)
4. Unzip project → move contents out of inner folder if needed.
5. Run with: ./mvnw spring-boot:run
6. Test endpoint: http://localhost:8080
7. Most likely because of the way the .zip is generated, you will have redundant folder names. To flatten that you should run -
mv JavaBackendBanking/* . && mv JavaBackendBanking/.[!.]* . 2>/dev/null && rmdir JavaBackendBanking

mv JavaBackendBanking/* . → Moves all visible files/folders up.
mv JavaBackendBanking/.[!.]* . 2>/dev/null → Moves all hidden files/folders (like .gitignore, .mvn, etc.), skipping . and ...
rmdir JavaBackendBanking → Deletes the now-empty inner folder.

8. You will replace JavaBackenBanking with whatever you root project folder name is. Most likely you will have two.


## 🚀 Next Steps
- Add a `/hello` endpoint to test Spring Boot routing.
- Connect PostgreSQL in `application.properties`.
- Create model classes for User and Account.
- Implement data persistence using JPA.
- Refactor or connect your Swing frontend to the backend.