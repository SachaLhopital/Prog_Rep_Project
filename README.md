# Prog_Rep_Project

Projet de synthèse de Programmation Répartie pour le cursus d'ingénieur informatique à Polytech Lyon

## Objectifs

Les objectifs de ce projet sont de mettre en oeuvre les technologies suivantes :
- Architecture logicielle : Spring MVC,
- Interface homme/machine : JSP, BOOTSRAP, JQUERY, Responsive-Design,..
- Couche Métier : Beans java
- Couche Persistance : Hibernate
- Tomcat

## Outils

Utilisation de Trello.

## Documentation d'installation Dev

_Pré-requis_

1. Télécharger le projet depuis Github
2. Installer Wamp
3. Lancer le script sql (**/permispiste/database_dump/permispiste_dump.sql**) dans phpmyadmin et créer un utilisateur **userepul** / **epul** dans cette base
4. Vérifier que Tomcat 8.5 est installé


_Mise en place_

(Il est possible que certaines étapes s'executent automatiquement en fonction des versions et des systèmes)

1. Ouvrir le dossier **permispiste** avec IntelliJ
2. Laisser Maven charger les dépendances (voir barre de progression en bas à droite)
3. Définir le sdk du projet en java 1.8
4. Vérifier que **pom.xml** contient bien le driver _mysql-connector-java_
5. Ajouter une nouvelle Datasource au projet correspondant à votre base de donnée locale (MySQl, avec le nouvel utilisateur des pré-requis)
6. Assigner la Datasource à la base de donnée hibernate (dans la vue persistance : **/View/Tool Windows/persistance**)
7. Configurer Tomcat pour lancer le projet comme vu en cours

Normalement l'application doit se lancer


## Equipe

- BRAZIER Louis
- DUBOIS Thibault
- LAFAYE DE MICHEAUX Yoan 
- LHOPITAL Sacha
- PRIEUR-DREVON Thomas
