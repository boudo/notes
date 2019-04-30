# Projet Notes : Robin Joran - Slimani Arezki - Boudo Ibrahim - Tarabay Marianne

##I]Exécution Maven

###1)Création Du Package Maven

  Pour créer le dossier cible (target) de l'application avec Maven,il faut se placer dans le dossier "./notes" puis ouvrir un Terminal à ce niveau et taper la commande suivante : mvn package.
  Un dossier "target" contenant tous les fichiers nécessaires pour bien exécuter l'application devrait apparaitre dans le dossier "notes"
  
###2)Création Du Site Maven et Checkstyle

  Pour générer le site internet Maven contenant les informations liées au projet,il faut taper la commande suivante dans le Terminal: mvn site
  Allez ensuite dans le dossier target/site/ et ouvrir l'index.
Cette commande permet aussi de générer les résultats de checkstyle
    
###3)Exécution De L'Application

  Pour exécuter l'application, il suffit de taper la commande : "java -jar target/notes-1.0-SNAPSHOT.jar".
  L'application devrait s'exécuter directement dans le Terminal.
    
###4)Nettoyage du dossier target

  Il faut exécuter la commande suivante : "mvn clean".Cette commande permet de supprimer le dossier target.
  
##II]Manuel Utilisateur

  Voici les différentes actions que l'utilisateur devra effectuer pour le bon déroulement de l'application :
  
###1)Lancement du Programme

  L'utilisateur exécute le programme avec la commande suivante : "java -jar target/notes-1.0-SNAPSHOT.jar".
  Il arrive donc dans le menu d'accueil qui liste les différentes commandes qui sont les suivantes :

###2)Créer/éditer une note

Pour créer ou éditer une note, l'utilisateur doit taper la commande suivante : "edit nom_de_la_note" ou "e nom_de_la_note" 

Il a aussi la possibilité de rajouter 2 options qui sont les suivantes :

-p : Pour spécifier un project
-c : Pour spécifier un contexte

Par exemple l'utilisateur peut taper ceci : "edit nom_de_la_note -c uvsq" ou "e nom_de_la_note -p notes" ou "edit nom_de_la_note -c uvsq -p notes"

L'ordre des options n'a pas d'importance et on peut utiliser l'une sans l'autre.

###3)Visualiser une note

Pour visualiser une note, l'utilisateur doit taper la commande suivante : "view nom_de_la_note" ou "v nom_de_la_note" 

###4)Lister les notes

Pour lister les notes contenues dans le répertoire ./Document, l'utilisateur doit taper la commande suivante : "list" ou "ls" 

###5)Supprimer une note

Pour supprimer une note, l'utilisateur doit taper la commande suivante : "delete nom_de_la_note" ou "d nom_de_la_note" 

###6)Rechercher un mot-clé

Pour rechercher un mot-clé, l'utilisateur doit taper la commande suivante : "search mot-clé" ou "s mot-clé".
On peut par exemple rechercher aussi deux mots à la suite ou une phrase etc... comme ceci :
"search test mot clé" ou "s test mot clé"

###7)Consulter le manuel technique

Pour consulter le manuel technique, l'utilisateur doit taper la commande suivante : "javadoc" ou "doc".


###8)Quitter le programme

Pour quitter l'application,l'utilisateur doit taper la commande suivante : "q" ou "exit".

###9)Fichier index.adoc

Pour consulter le fichier index.adoc dans le navigateur, l'utilisateur doit taper la commande suivante : "index".
Cette commande va donc ouvrir dans le navigateur le fichier index.html et dans celui-ci 
se trouve les notes triées par Contexte et Project.

###10)Fichier de configuration

Pour modifier le fichier de configuration, l'utilisateur doit taper la commande suivante : "conf" ou "configuration".
L'utilisateur pourra donc choisir le nom du répertoire dans lequel ses notes seront stockées,le navigateur par défaut qu'il souhaite utiliser et aussi l'éditeur qu'il souhaite utiliser.

###Remarque:

l'utilisateur peut aussi effectuer toutes ces actions en ligne de commande direct à l'exécution du programme par exemple : "java -jar target/notes-1.0-SNAPSHOT.jar edit Test" exécutera la commande edit .

##III]Manuel Technique

  Pour cela,il faut consulter la JavaDoc de l'application.
L'utilisateur doit se mettre dans le dossier "target/apidocs/" puis ouvrir index.html.
Ou sinon il peut aussi accéder directement au manuel technique via l'application en tapant la commande suivante : "javadoc" ou "doc".
Le détail de chaque méthode de chaque classe et le détail des classes seront présentes.
