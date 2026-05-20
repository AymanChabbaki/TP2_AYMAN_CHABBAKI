# Prompt to Generate a Word Documentation File

Copy and paste this prompt into your agent to generate a complete `.docx` documentation file for the TP.

```text
Agis en tant que rédacteur technique et développeur Java Spring Boot expert.

Ta mission est de créer un document Word professionnel (.docx) qui explique clairement un TP d'architecture REST en couches basé sur Spring Boot, Java 17, Spring Web et Lombok.

Contexte du projet :
- API REST de gestion d'utilisateurs
- Architecture en couches : Model, Service, Controller
- Projet Spring Boot avec une liste d'utilisateurs en mémoire

Objectif du document :
Créer une documentation complète, claire et bien structurée pour un étudiant ou un enseignant qui doit comprendre, tester et expliquer le TP.

Le document Word doit contenir les sections suivantes :
1. Titre du TP
2. Introduction générale
3. Objectifs pédagogiques
4. Description de l’architecture en couches
5. Explication de la couche Model
6. Explication de la couche Service
7. Explication de la couche Controller
8. Liste complète des routes REST avec méthode HTTP, URL, paramètres, type de requête et résultat attendu
9. Guide de test sur Postman avec exemples de requêtes et exemples de réponses JSON
10. Explication du comportement actuel quand un utilisateur n’existe pas
11. Proposition d’amélioration avec HTTP 404
12. Réponses aux questions théoriques sur la maintenance et la séparation des responsabilités
13. Conclusion

Contraintes de rédaction :
- Rédige en français.
- Utilise un style clair, simple et académique.
- Ajoute des titres et sous-titres propres.
- Explique les concepts sans être trop long.
- Inclue des tableaux si utile pour les routes REST et les tests Postman.
- Ajoute des exemples JSON concrets.
- Fais une mise en page soignée et professionnelle.
- Le résultat final doit être un fichier Word .docx prêt à être remis.

Contenu technique à intégrer :
- Classe User avec les attributs id, nom, mail
- UserService avec une liste de 4 utilisateurs en mémoire
- UserController avec les routes :
  - GET /users
  - GET /users/{p}
  - POST /users/add
  - PUT /users/update/{p}
  - DELETE /users/supp?p=...
- Réponse théorique sur le cas d’un id inexistant
- Réponse théorique sur l’intérêt de l’architecture en couches

Important :
- Si des informations sont manquantes, déduis-les de façon raisonnable à partir du TP.
- Génère uniquement le fichier Word final et ne fournis pas de texte inutile.
- Le document doit être propre, cohérent et directement exploitable.
```
