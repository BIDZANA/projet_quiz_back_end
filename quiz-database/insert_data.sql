-- Insertion dans la table Quiz
INSERT INTO Quiz (theme) VALUES ('Thème 1');
INSERT INTO Quiz (theme) VALUES ('Thème 2');
-- Ajoutez d'autres insertions si nécessaire

-- Insertion dans la table User
INSERT INTO User (username, email, role) VALUES ('Admin', 'admin@example.com', true);
INSERT INTO User (username, email, role) VALUES ('Gamer', 'gamer@example.com', false);
-- Ajoutez d'autres insertions si nécessaire

-- Insertion dans la table Question
INSERT INTO Question (statement, image, id_quiz) VALUES ('Question 1', 'image1.jpg', 1);
INSERT INTO Question (statement, image, id_quiz) VALUES ('Question 2', 'image2.jpg', 1);
-- Ajoutez d'autres insertions si nécessaire

-- Insertion dans la table Game
INSERT INTO Game (date, score, id_quiz) VALUES ('2023-01-01', 100, 1);
INSERT INTO Game (date, score, id_quiz) VALUES ('2023-01-02', 85, 2);
-- Ajoutez d'autres insertions si nécessaire

-- Insertion dans la table Response
INSERT INTO Response (isValid_, value, id_question) VALUES (true, 'A', 1);
INSERT INTO Response (isValid_, value, id_question) VALUES (false, 'B', 1);
-- Ajoutez d'autres insertions si nécessaire

-- Insertion dans la table UserResponse
INSERT INTO UserResponse (id_user, id_response, id_Game) VALUES (1, 1, 1);
INSERT INTO UserResponse (id_user, id_response, id_Game) VALUES (1, 2, 1);
-- Ajoutez d'autres insertions si nécessaire
