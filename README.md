# Hackernews clone in graphql
A really small backend for a LABS session, created via the tutorial at [howtographql.com](howtographql.com).

## Requirements
You'll need to have mongodb up and running locally at port 27017. If you've got a different setup you'll need to update `GraphQLEndpoint` to reflect your changes.

## Running
first ya go
`mvn clean install`

then ya go
`mvn jetty:run`

## Example Queries
Download GraphQL Playground to try and consume your backend! You'll need to point it at `http://localhost:8080/graphql`, then it'll download the schema for itself, and can help you with autocomplete. 

First you'll need to create a user:
```graphql
mutation {
  createUser(
    name: "Mario",
    auth: {
      email: "its_a_me@mario.com"
      password: "bowserSucks"
    }
  ) {
    id
    name
  }
}
```

Then you need to sign in:
```graphql
mutation {
  signinUser(
    auth: {
      email: "its_a_me@mario.com",
      password: "bowserSucks"
    }
  ) {
    token
    user {
      id
      name
    }
  }
}
```

Use the token under "HTTP_HEADERS" in GraphQL Playground
```json
{
    "Authorization": "Bearer replacemewiththetoken"
}
```

With this you're then ready to experiment with queries and mutations such as `allLinks`, `createVote` and `createLink`. You'll find information about the schema if you press the green "SCHEMA" button in GraphQL Playground.

![https://media.giphy.com/media/eCqFYAVjjDksg/giphy.gif](https://media.giphy.com/media/eCqFYAVjjDksg/giphy.gif)