
const { gql } = require("apollo-server");

const typeDefs = gql`
    type Query {
        todos: [ToDoItem!]
        todo(id: ID!): ToDoItem
        users: [User!]
        user(id: ID!): User
    }  
    type ToDoItem{
        id: ID!
        title: String!
        completed: Boolean!
        user: User!
    } 
    type User{
        id: ID!
        name: String!
        email: String!
        login: String!
        todos: [ToDoItem!]!
    }
`
module.exports = typeDefs;