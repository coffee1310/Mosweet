FROM 24-ea-21-windowsservercore-1809
WORKDIR /app
COPY /target/Mosweet-0.0.1-SNAPSHOT.war /app/Mosweet.war
LABEL authors="user"
ENTRYPOINT ["java", "-jar", "/Mosweet.war"]
ENTRYPOINT ["top", "-b"]