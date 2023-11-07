-- Création de la base de données
CREATE DATABASE quiz_database;

-- Utilisation de la base de données
\c quiz_database;

-- Création de la table Quiz
CREATE TABLE Quiz (
                      id_quiz SERIAL NOT NULL,
                      theme VARCHAR(50) NOT NULL,
                      CONSTRAINT Quiz_PK PRIMARY KEY (id_quiz)
);

-- Création de la table Question
CREATE TABLE Question (
                          id_question SERIAL NOT NULL,
                          statement VARCHAR(2000) NOT NULL,
                          image VARCHAR(50) NOT NULL,
                          id_quiz INT NOT NULL,
                          CONSTRAINT Question_PK PRIMARY KEY (id_question),
                          CONSTRAINT Question_Quiz_FK FOREIGN KEY (id_quiz) REFERENCES Quiz(id_quiz)
);

-- Création de la table User
CREATE TABLE User (
                      id_user SERIAL NOT NULL,
                      username VARCHAR(50) NOT NULL,
                      email VARCHAR(50) NOT NULL,
                      role BOOL NOT NULL,
                      CONSTRAINT User_PK PRIMARY KEY (id_user)
);

-- Création de la table Game
CREATE TABLE Game (
                      id_Game SERIAL NOT NULL,
                      date DATE NOT NULL,
                      score INT NOT NULL,
                      id_quiz INT NOT NULL,
                      CONSTRAINT Game_PK PRIMARY KEY (id_Game),
                      CONSTRAINT Game_Quiz_FK FOREIGN KEY (id_quiz) REFERENCES Quiz(id_quiz)
);

-- Création de la table Response
CREATE TABLE Response (
                          id_response SERIAL NOT NULL,
                          isValid_ BOOL NOT NULL,
                          value CHAR(5) NOT NULL,
                          id_question INT NOT NULL,
                          CONSTRAINT Response_PK PRIMARY KEY (id_response),
                          CONSTRAINT Response_Question_FK FOREIGN KEY (id_question) REFERENCES Question(id_question)
);

-- Création de la table UserResponse
CREATE TABLE UserResponse (
                              id_user INT NOT NULL,
                              id_response INT NOT NULL,
                              id_Game INT NOT NULL,
                              CONSTRAINT UserResponse_PK PRIMARY KEY (id_user, id_response, id_Game),
                              CONSTRAINT UserResponse_User_FK FOREIGN KEY (id_user) REFERENCES User(id_user),
                              CONSTRAINT UserResponse_Response0_FK FOREIGN KEY (id_response) REFERENCES Response(id_response),
                              CONSTRAINT UserResponse_Game1_FK FOREIGN KEY (id_Game) REFERENCES Game(id_Game)
);
