/**
 * @see Main
 */

/**
 * "Qu'est-ce que Motus ? C'est une espèce de gymnastique du cerveau qui mélange les chiffres d'un côté et les lettres...
 * Il faut savoir aller vite, être logique et avoir envie de jouer."
 * "Ceux qui n'ont pas bien compris le fonctionnement du jeu, c'est très simple, je vous invite à jouer."
 * Thierry Beccaro le 25 juin 1990
 * https://youtu.be/EKRG1qAiVVI
 */

/**
 * erreur : mot n'existant pas, mot mal épelé, mot ne commençant pas par la lettre proposée, mot trop long, mot trop court, nom propre, verbe conjugué (hors infinitif, participe passé, présent)
 * 
 * 
 * grille de 7 à 9 lettres avec 6 tentatives maximum
 * première lettre proposée (affichée)
 * rond jaune quand bonne lettre mauvais endroit
 * carré rouge quand bonne lettre bon endroit
 * chaque bonne réponse octroie 50 points, sauf la dernière qui octroie 100 points
 * à la fin des tentatives, la main passe à l'équipe adverse (une seule tentative)
 * chaque erreur, la main passe à l'équipe adverse
 * une lettre est alors ajoutée à chaque passage de main
 * 
 * grille à remplir 5x5
 * remplir une ligne, colonne ou diagonale
 * 8 cases aléatoires déjà remplies
 * 17 boules avec les numéros des cases + 3 boules noires
 * si boule noire la main va à l'équipe adverse (perd 20 points)
 * si boule numérotée on remplit la case correspondante
 * et on retire une fois
 * chaque équipe possède les nombres pairs ou les nombres impairs
 * 
 * si une ligne est complète cela déclenche MOTUS
 * on ajoute 100 points supplémentaires à l'équipe
 * on réinitialise les grilles
 * 
 * en cas d'égalité, il y a un 9e mot qui fait gagner l'équipe qui le trouve 
 * 
 * après 8 mots, on finit la première manche
 * 2 lettres proposées pour la super partie
 * on passe à la super partie
 * grille à remplir 5x5
 * 16 cases déjà remplies
 * (1,1), (1,3), (1,5), (2,2), (2,3), (2,4), (3,1), (3,2), (3,4), (3,5), (4,2), (4,3), (4,4), (5,1), (5,3), (5,5)
 * il faut éviter de faire une ligne
 * on place des boules qui n'existe pas dans la grille aussi dans l'urne
 * on ajoute alors une boule dorée
 * au troisième mot, la boule du centre est ajoutée (3,3) qui fait perdre la partie du coup
 * 7 minutes pour trouver 5 mots
 * 1e mot trouvé, 1 boule tirée
 * 2e mot trouvé, 2 boules tirées
 * 3e mot on place la boule du centre
 * 3e mot trouvé, 3 boules tirées
 * 4e mot trouvé, 4 boules tirées
 * 5e mot trouvé, 5 boules tirées
 * pour chaque erreur, on pioche une boule de plus
 * si la balle dorée est tirée, elle est comme un jocker
 * si une ligne est composée alors MOTUS ==> perdu
 * 
 * 
 * 
 * 
 * Humain vs Humain
 * Humain vs IA
 * IA vs Humain
 */