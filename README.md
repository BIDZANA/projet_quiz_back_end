# Jeu de Quiz

Bienvenue dans l'application de jeu de quiz ! Cette application offre une plateforme amusante où les utilisateurs peuvent jouer à des quiz, créer de nouveaux quiz et participer à des parties passionnantes.

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre machine :

- Java (version 8 ou supérieure)
- MariaDB (assurez-vous que le serveur MariaDB est en cours d'exécution localement)
- Node.js (version LTS recommandée)
- Angular CLI (installé via `npm install -g @angular/cli`)

## Configuration de la base de données

1. Créez une base de données MariaDB nommée `database_quiz` sur votre serveur MariaDB.
2. Lancez le projet Java Spring Boot pour que la base de données soit générée automatiquement.

## Installation

1. Clonez ce référentiel.

    ```bash
    git clone https://github.com/votre-utilisateur/quiz-game.git
    cd quiz-game
    ```

2. Installez les dépendances du backend.

    ```bash
    cd backend
    ./mvnw clean install
    ```

3. Lancez le backend (assurez-vous que votre serveur MariaDB est en cours d'exécution).

    ```bash
    ./mvnw spring-boot:run
    ```

4. Installez les dépendances du frontend.

    ```bash
    cd ../frontend
    npm install
    ```

## Configuration du frontend

1. Ouvrez le fichier `src/environments/environment.ts` dans le dossier frontend.
2. Assurez-vous que l'URL du backend correspond à l'endroit où votre backend est en cours d'exécution. Par défaut, il est configuré pour `http://localhost:9090`.

## Exécution de l'application

1. Lancez le frontend.

    ```bash
    ng serve
    ```

2. Ouvrez votre navigateur et accédez à [http://localhost:4200](http://localhost:4200).

Vous êtes prêt à jouer ! Connectez-vous, créez vos propres quiz, participez à des parties et profitez de l'expérience de jeu.

## Fonctionnalités principales

- **Authentification des utilisateurs :** Les utilisateurs peuvent s'inscrire, se connecter et récupérer leur mot de passe via des adresses e-mail vérifiées.
- **Création de quiz :** Les utilisateurs administrateurs peuvent créer de nouveaux quiz avec des questions et des réponses associées.
- **Parties de jeu :** Les utilisateurs peuvent participer à des parties de jeu en répondant aux questions du quiz sélectionné.

## Auteur

- **BIDZANA MARVIN**
