<p align="center">
<img src="data/motus.png" width="200" />
<p/>
   
# 🧠 MOTUS-MASTER

## 🎓 Projet académique

Ce dépôt contient le code associé au jeu motus. Motus-Master est un projet de Master 1 en Bioinformatique & Biologie des Systèmes (Université Toulouse III), année universitaire 2024-2025. Dans ce projet, on détourne un classique du jeu télévisé pour en faire un laboratoire d'interfaces, d'IA basique, et d’esthétique rétro-futuriste.

Ce projet a été réalisé dans le cadre d’un enseignement de programmation avancée et de conception logicielle, avec un accent particulier sur :
* la structure du projet
* la qualité visuelle et UX (expérience utilisateur)
* la gestion des états et des erreurs
* la communication homme-machine dans un environnement thématique

## Description

> "Salutations à ceux que le destin a placés sur notre chemin."

Dans une ambiance inspirée du cyberpunk, ce jeu de lettres réinvente Motus en y ajoutant :

* un design visuel néon sombre,
* des personnages expressifs aux allures de megacorpo,
* une IA capable de faire des suppositions,
* plusieurs modes de jeu : Joueur contre Joueur, Joueur contre IA, IA contre IA.

Le tout sans tricher... Enfin, sauf quand on soupçonne que quelqu’un l’a fait.

### 🎮 Fonctionnalités

* 🧍‍♂️ Modes de jeu multiples : JcJ (Joueur contre Joueur), JcI (Joueur contre IA), IcI (IA contre IA)
* 🧠 IA simple mais adaptative (filtrage des mauvaises lettres, stratégie sur la première lettre)
* 🧪 Mode console pour les puristes ou tests rapides
* 💡 Interface graphique immersif
* 🌌 Univers visuel cohérent (personnages, écrans de victoire/défaite, ambiance cyber-futuriste)

### 🛠️ Technologies utilisées

* Java (Swing)
* Génération d’images IA pour les visuels de fin

## Structure
```
📁 Motus-Master/
├── README.md                  # Présentation du projet
├── LICENSE                    # Licence d'utilisation
├── .gitignore                 # Fichiers/dossiers ignorés par Git
├── 📁 src/                    # Code source Java
│   ├── CaseLabel.java         # Case de la grille avec états visuels (JLabel personnalisé)
│   ├── Game.java              # Interface principale du jeu, logique de partie
│   ├── Humain.java            # Implémentation d’un joueur humain
│   ├── Initialize.java        # Fenêtre Swing de base (taille, fond, fermeture)
│   ├── Joueur.java            # Interface pour tous les joueurs (humain ou IA)
│   ├── LoadData.java          # Chargement et sélection aléatoire de mots
│   ├── Menu.java              # Menu principal du jeu
│   ├── Plateau.java           # Version console du jeu
│   ├── ResultsEndGame.java    # Écran de fin de partie (victoire/défaite)
│   ├── Robot.java             # IA du jeu (joueur robot)
│   ├── Rules.java             # Fenêtre d'affichage des règles du jeu
│   ├── SelectionMot.java      # Choix du mot à deviner (dans certains modes)
│   ├── SelectionNumber.java   # Choix du nombre de lettres du mot
│   ├── SelectionType.java     # Choix du type JcI : IA devine ou fait deviner
├── 📁 bin/                    # Fichiers compilés avec Java version 65.0
├── 📁 data/                   # Fichiers externes de données
│   ├── mots_6_lettres.csv     # Liste de mots de 6 lettres
│   ├── mots_7_lettres.csv     # Liste de mots de 7 lettres
│   ├── mots_8_lettres.csv     # Liste de mots de 8 lettres
│   ├── mots_9_lettres.csv     # Liste de mots de 9 lettres
│   ├── motus.png              # Logo du jeu
│   ├── win.png                # Image affichée en cas de victoire
│   ├── lose.png               # Image affichée en cas de défaite
|   ├── triche.png             # Image affichée en cas de suspicion de triche
|   ├── logo_win.png           # Logo affiché en cas de victoire
|   ├── logo_lose.png          # Logo affiché en cas de défaite
|   ├── logo_triche.png        # Logo affiché en cas de suspicion de triche
|   ├── rmdLore_win.png        # Image affichée en cas de victoire mode facile
|   ├── rmdLore_lose.png       # Image affichée en cas de défaite mode facile
|   ├── rmdLore_triche.png     # Image affichée en cas de suspicion de triche en mode facile
│   ├── Rules.txt              # Texte des règles du jeu
|   ├── Menu.txt               # Texte affiché sur l'écran du menu
|   ├── lien.txt               # Lien vers la source des fichiers csv
```

## Prérequis

🚧

## Installation et Usages

### Installation
   ```
   git clone https://github.com/CamilleAstrid/fr.univ-tlse3.Motus-Master.git
   cd fr.univ-tlse3.Motus-master.git
   ```
### Usages

🚧

## Licence
Ce projet et donc l'ensemble des éléments de ce répertoire est sous licence [MIT](https://github.com/CamilleAstrid/fr.univ-tlse3.Motus-Master/blob/master/LICENSE) (sauf cas précisé).

## Citations et Références

🚧

## Auteurs
Copyright (C) 2025 CamilleAstrid

---
ℹ️ Pour toute question, veuillez me contacter par mail :
* [Camille-Astrid Rodrigues](mailto:camilleastrid.cr@gmail.com)

Si des ajustements ou des ajouts sont nécessaires, n'hésitez pas à me le signaler !
