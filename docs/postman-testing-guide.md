# Postman Testing Guide - TP2 User API

This guide shows how to test every route of the Spring Boot REST API in Postman.

## 1. Prerequisites

Before testing, make sure:

- The project is running on `http://localhost:8080`
- Spring Boot is started successfully
- Postman is installed

If you need to start the application, run the Spring Boot main class first.

## 2. Base URL

Use this base URL in Postman:

```text
http://localhost:8080
```

If you want, you can create a Postman environment variable:

- Variable name: `baseUrl`
- Value: `http://localhost:8080`

Then reuse it as:

```text
{{baseUrl}}/users
```

## 3. Initial Data

When the application starts, the service already contains 4 users:

- `1 - Mohammed - mhd@mail.com`
- `2 - Moad - moad@mail.com`
- `3 - Sana - sana@mail.com`
- `4 - Amina - amina@mail.com`

## 4. Routes to Test

### 4.1 Get all users

- Method: `GET`
- URL: `http://localhost:8080/users`
- Body: none

Expected result:

- Status: `200 OK`
- Response: a JSON array with all users

Example response:

```json
[
  {
    "id": 1,
    "nom": "Mohammed",
    "mail": "mhd@mail.com"
  },
  {
    "id": 2,
    "nom": "Moad",
    "mail": "moad@mail.com"
  }
]
```

### 4.2 Get one user by id

- Method: `GET`
- URL: `http://localhost:8080/users/1`
- Path variable: `p = 1`

Expected result:

- Status: `200 OK`
- Response: the user with id `1`

Example response:

```json
{
  "id": 1,
  "nom": "Mohammed",
  "mail": "mhd@mail.com"
}
```

If the id does not exist, the current implementation returns `null`, which may appear as an empty response body.

### 4.3 Add a user

- Method: `POST`
- URL: `http://localhost:8080/users/add`
- Body type: `raw`
- Body format: `JSON`

Example body:

```json
{
  "id": 5,
  "nom": "Yassine",
  "mail": "yassine@mail.com"
}
```

Expected result:

- Status: `200 OK`
- No response body is returned by the current controller

After sending this request, call `GET /users` again to verify that the user was added.

### 4.4 Update a user

- Method: `PUT`
- URL: `http://localhost:8080/users/update/2`
- Path variable: `p = 2`
- Body type: `raw`
- Body format: `JSON`

Example body:

```json
{
  "id": 99,
  "nom": "Moad Updated",
  "mail": "moad.updated@mail.com"
}
```

Important:

- Even if you send another id in the body, the service forces the id in the path variable.
- So the stored user will keep id `2`.

Expected result:

- Status: `200 OK`
- No response body is returned by the current controller

### 4.5 Delete a user

- Method: `DELETE`
- URL: `http://localhost:8080/users/supp?p=4`
- Query parameter: `p = 4`

Expected result:

- Status: `200 OK`
- No response body is returned by the current controller

After sending this request, call `GET /users` again to verify that the user was removed.

## 5. Recommended Postman Collection Structure

Create one collection named:

- `TP2 - User API`

Then add these requests:

- `Get All Users`
- `Get User By Id`
- `Add User`
- `Update User`
- `Delete User`

## 6. Suggested Postman Tests

For each request, you can add simple checks in the Tests tab.

### GET /users

```javascript
pm.test('Status code is 200', function () {
  pm.response.to.have.status(200);
});

pm.test('Response is an array', function () {
  const data = pm.response.json();
  pm.expect(data).to.be.an('array');
});
```

### GET /users/1

```javascript
pm.test('Status code is 200', function () {
  pm.response.to.have.status(200);
});

pm.test('Response contains user data', function () {
  const data = pm.response.json();
  pm.expect(data).to.have.property('id');
  pm.expect(data).to.have.property('nom');
  pm.expect(data).to.have.property('mail');
});
```

### POST /users/add

```javascript
pm.test('Status code is 200', function () {
  pm.response.to.have.status(200);
});
```

### PUT /users/update/{p}

```javascript
pm.test('Status code is 200', function () {
  pm.response.to.have.status(200);
});
```

### DELETE /users/supp?p=4

```javascript
pm.test('Status code is 200', function () {
  pm.response.to.have.status(200);
});
```

## 7. Manual Verification Workflow

A simple workflow to test everything:

1. Send `GET /users` and confirm the 4 initial users.
2. Send `POST /users/add` to insert a new user.
3. Send `GET /users` again to confirm the new user exists.
4. Send `PUT /users/update/{p}` to modify a user.
5. Send `GET /users/{p}` to confirm the update.
6. Send `DELETE /users/supp?p=...` to remove a user.
7. Send `GET /users` again to confirm the deletion.

## 8. Notes About Current Behavior

- If a user id does not exist, the API currently returns `null`.
- The controller does not yet return `404 Not Found`.
- The `POST`, `PUT`, and `DELETE` endpoints return no body.

## 9. Improvement Idea

A better version of the API would:

- return `404 Not Found` for missing users,
- return `201 Created` for additions,
- return the updated user after a successful update,
- return a clear message after deletion.
