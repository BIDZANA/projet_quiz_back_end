# Utilisation d'une image de base PostgreSQL
FROM postgres

# Informations de l'utilisateur et de la base de données (personnalisez selon vos besoins)
ENV POSTGRES_USER quiz
ENV POSTGRES_PASSWORD quiz
ENV POSTGRES_DB quiz_database

# Copiez les fichiers SQL dans le conteneur
COPY create_database.sql /docker-entrypoint-initdb.d/
COPY insert_data.sql /docker-entrypoint-initdb.d/

# Exposer le port PostgreSQL
EXPOSE 5433
