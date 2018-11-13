#Webservice du projet 7

Partie service du projet 7 parcours Developpeur d'application java


Le service regroupe toutes les méthodes permettant le bon fonctionnement d'une biliothèque :

- visualiser la liste de l'intégralité des ouvrages et la liste des ouvrages disponible 
- emprunter un ouvrage
- prolonger un emprunt
- s'authentifier comme utilisateur
- gérer les retards d'emprunt 
- clore un emprunt 

Cette partie service est contruite à l'aide de struts 2, spring jdbc, spring TX, une base de donnée Postgresql, maven et un serveur tomcat

Les scripts de création de la base de donnée sont disponibles dans le dossier script_sql qui se trouve dans le dossier parent du projet

Lancer le projet : 

Pour initialiser le projet, il faut tout d'abord creer la db et y inclure l'ensemble des scripts disponibles, ils sont numérotés afin d'éviter tout type d'erreur.
Dans un second temps il faut ouvrir un terminal et se poser a la racine du projet et creer un .war avec maven : 
    
    mvn package 
    
On note que cette commande a generer un .war dans le dossier target du dossier webapp.
Il faut copier se fichier .war dans le dossier webapps du serveur tomcat 

Enfin, il faut placer une console dans le dossier /bin du dossier du serveur tomcat afin de le lancer : 
    
Pour lancer le serveur sous windows : 

    ./catalina.bat start 
    
    
pour lancer le serveur sous macOS : 

    ./catalina.sh start
    
    
Il suffira de remplacer start par stop pour eteindre le serveur

Par la suite il suffira d'ouvrir un navigateur et de taper :

    localhost://8080/{Le nom du .war} 
    
et l'application devrait se lancer correctement.