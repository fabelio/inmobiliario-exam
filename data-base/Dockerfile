# Use the official MySQL image as a base
FROM mysql:latest


# Copy the current directory contents into the container at /app
ADD ./inmobiliario-db.sql /docker-entrypoint-initdb.d/init.sql



# Set environment variables for the new user
ENV MYSQL_PASSWORD=inmobiliario2025
ENV MYSQL_DATABASE=inmobiliario

# Expose port 3306 to allow connections to the database
EXPOSE 3306

# Start the MySQL server when the container is run
CMD ["mysqld"]