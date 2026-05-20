# TP2 - Architecture REST en couches

Projet Spring Boot Java 17 pour une API REST de gestion d'utilisateurs.

## Structure

- Model : `User`
- Service : `UserService`
- Controller : `UserController`

## Endpoints

- `GET /users` : récupérer tous les utilisateurs
- `GET /users/{p}` : récupérer un utilisateur par id
- `POST /users/add` : ajouter un utilisateur
- `PUT /users/update/{p}` : modifier un utilisateur
- `DELETE /users/supp?p=1` : supprimer un utilisateur

## Réponses aux questions

### 1. Que retourne l'API si on demande un utilisateur avec un id inexistant ?

Avec l'implémentation actuelle, la méthode `getUser(Long id)` retourne `null`. Le contrôleur renvoie alors une réponse HTTP `200 OK` avec un corps vide, ce qui n'est pas le comportement le plus adapté pour une ressource absente.

Pour améliorer cela, il faut retourner un statut HTTP `404 Not Found`, par exemple avec `ResponseEntity.notFound().build()` ou avec une exception personnalisée annotée `@ResponseStatus(HttpStatus.NOT_FOUND)`.

### 2. En quoi l'architecture en couches facilite-t-elle la maintenance ?

L'architecture en couches sépare les responsabilités :

- le `Model` décrit les données,
- le `Service` contient la logique métier,
- le `Controller` gère les requêtes HTTP.

Cette séparation rend le code plus lisible, plus testable et plus simple à faire évoluer. Par exemple, on peut remplacer le stockage en mémoire par une base de données sans réécrire le contrôleur, tant que l'interface du service reste la même.
