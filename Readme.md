# Poseidon Capital Solutions

<p align="center">
<img src="https://img.shields.io/badge/Language-Java-green">
<img src="https://img.shields.io/badge/Framework-Spring-green">
<img src="https://img.shields.io/badge/PM-Maven-green">
</p>

Application de de gestion financière créée dans le cadre d'un projet de formation OpenClassrooms.


## Usage
Cette application comprend une API permettant d'accéder aux données d'une BDD MySQL ainsi qu'une interface web permettant d'accéder à l'API et d'effectuer des opérations simples de façon pratique.\
Le repo github comprend :
- `pcs` : Le code de l'application, sa documentation, les tests automatisés et l'interface web
- `data.sql` : Un script SQL permettant de créer la base de données nécessaire au bon fonctionnement de l'API, avec un compte administrateur et un compte utilisateur d'exemple.

L'API est une API REST composée de 4 couches :
- les controlleurs recoivent et gèrent les requêtes HTTP
- les services traitent le contenu des requêtes et des données 
- les repositories communiquent avec la BDD pour insérer et extraire des données
- la couche security gère l'authentification et l'autorisation pour l'API

#### Architecture
La base de données comporte 6 tables :
- `Bid List`, `Curve Point`, `Rating`, `Rule Name` et `Trade` représentent les données financières gérées par l'application
- `Users` contient les identifiants d'un utilisateur ainsi que son rôle

Telles qu'elles ont été spécifiées pour le moment les tables ne possèdent pas de relations entre elles. Le modèle physique de données est donc très simple.

### Couverture de tests
<p align="center">
<img src="https://raw.githubusercontent.com/Psolyvem/OC-Projet7/master/readme/Couverture%20de%20tests.png" alt="Modèle de données physique">
</p> 

L'application dispose de tests automatisés pour une couverture de 85%. Les tests couvrents les services, les repositories, le modèle et la sécurité avec des tests unitaires.


## Installation

Si vous souhaitez installer ce projet il vous faudra au préalable installer :
- Maven : https://maven.apache.org/download.cgi
- MySQL : https://dev.mysql.com/downloads/

Lorsque MySQL sera installé, téléchargez le fichier `data.sql`.\
Ouvrez un terminal et connectez vous a MySQL :
```bash
Mysql -u root -p
```
Déplacez vous ensuite jusqu'a l'emplacement du fichier `database.sql` et exécutez le.
```bash
source data.sql
```
Une fois ces prérequis installés et configurés, vous devrez peut être modifier le fichier application.properties afin de le configurer correctement en fonction de votre installation de MySQL.

```javascript
#Global
spring.application.name=pcs

#Tomcat
server.port=9010

#MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/poseidon?serverTimezone=UTC
spring.datasource.username=Admin
spring.datasource.password=Admin

#Hibernate Configuration
#spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.open-in-view=true

#Logs
logging.level.root=ERROR
logging.level.org.springframework=INFO
logging.level.com.openclassrooms.pcs=INFO
```

- `server.port` : choisissez le port sur lequel l'application doit s'executer
- `spring.datasource.url` : si vous avez gardé la configuration par défaut de MySQL et exécuté le fichier data.sql sans modifications, ne changez rien, sinon, ajustez le port ou le nom de la base de donnée pour correspondre à vos modifications
- `spring.datasource.username` : remplacez "Admin" par le nom d'utilisateur MySQL que vous avez défini
- `spring.datasource.password` : remplacez "Admin" par le le mot de passe de l'utilisateur MySQL que vous avez défini

Vous pouvez maintenant compiler et executer l'API. Si vous souhaitez l'executer, placez vous a la racine du projet et faites un :
```bash
mvn spring-boot:run
```
Si vous souhaitez compiler le projet pour obtenir un jar executable faites :
```bash
mvn package
```
puis dans le dossier pcs/target exécutez le jar avec :
```bash
java -jar pcs-0.1.0-jar-with-dependencies.jar
```

Maintenant que l'API fonctionne, vous pouvez ouvrir `localhost:9010` (ou le port que vous avez spécifié dans application.properties) dans votre navigateur pour avoir accès à l'interface web.

Pour vous connecter sur l'application via l'interface web vous pouvez utiliser les identifiants administrateur par défaut
```bash
Username : admin
Password : admin
```
>[!IMPORTANT]
>Les mots de passe sont encodés avec Bcrypt, si vous souhaitez en ajouter manuellement, pensez a les encoder également sans quoi l'API ne vous laissera pas vous connecter.

## Documentation
Le projet contient la documentation de ses classes et de ses méthodes, elle est située dans `pcs/doc` ou vous pouvez la consulter directement [ici](http://htmlpreview.github.io/?https://github.com/Psolyvem/OC-Projet7/blob/master/pcs/doc/index.html)
