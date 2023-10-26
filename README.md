# DermiCycle-BackEnd

DermiCycle Backend is a skincare cycling API that allows account management for DermiCycle

## Introduction

 The term "skin cycling" is all about taking a cyclical approach to your facial skincare routine. Why? Using specific products on different days regenerates the skin and improves skin quality. Choose between a four-night or a three-night cycle alternates an exfoliant, retinol-based product, and hydrating cream or concentrate.  


## Features and Basics
DermiCycle is an application designed to help users manage their skincare routines by providing a daily list of products to use respective to the stage in within your skin cycling pattern. Here are the key features and basics of DermiCycle:

- Sign In: Users can create an account to save personal information and preferences, skin type, and skin cycle preference
- Product List: The application provides a list that allows users to customize their skin cycling pattern for the entire month.
- Product Tracking: Users can input the skincare products they have for each stage and manage their routine.

## Tols and Technologies Used
- Java
- Spring Boot
- Spring Security
- Spring JPA
- H2 console
- JWT
- Mockito
  

## User Stories
#### Sign Up
As a new user, you can create an account by following these steps:

Click the "Sign Up" button to create an account.

Acceptance Criteria: Users should be able to click "Sign Up" to access the registration page.
Fill out a registration form with the following information:

- Name
- Email address
- Password
- Skin type (e.g., dry, oily, combination)
- Skin Cycle Preference
Acceptance Criteria: Users can provide the required information to create their account.

#### Log In
For registered users, follow these steps to log in:

Click the "Log In" button.

Acceptance Criteria: Registered users should be able to click "Log In" to access the login page.
Enter your email and password.

##### Adding Products
Logged-in users can add and manage the skincare products they use. Follow these steps to add products:

Click the "Add Products" button.

Acceptance Criteria: Users should be able to access a product management page.
Provide information about the products you are using, including:

Name of the product
Directions for use
Stage (e.g., exfoliation, retinoid, recovery)
Acceptance Criteria: Users can add products and categorize them according to their stage in the skincare cycle.
Acceptance Criteria: Users should be able to log in with their email and password.
After successful login, you will be directed to a welcome loading page.

From there, you will be brought to a home page where you can set your skin cycling pattern preference (e.g., 4-day pattern, 3-day pattern).

## ERD Diagram
<img src="ERD Diagram (2).png" />


# API Endpoints

To interact with the DermiCycle API, you can use the following endpoints:

| Request Type | URL                                    | Functionality                                                  | Access  |
|--------------|----------------------------------------|----------------------------------------------------------------|---------|
| POST         | `/auth/users/register/`              | Register a new user with name, email address, password, skin type and skin cycle preference(Public) | Public  |
| POST         | `/auth/users/login/`                 | Log in and obtain a JWT token with a username and password (Public) | Public  |
| POST          | `/api/users/products/`               |Create a product (private, requires a jwt token)           | Private |
| POST          | `/api/users/stage/{stageId}`               |Gets information about a single stage and all the products for the stage  (private, requires a jwt token)         | Private |

# Challenges Faced
- Refactoring Testing Requirements: One of the primary challenges arose when I modified the project's requirements to include additional parameters for user creation. To ensure the project's functionality aligned with these changes, I needed to refactor the testing process. Adapting the existing test suite to accommodate the new parameters and successfully validate them was a complex and time-consuming task. It required careful consideration to avoid any regressions in the codebase.

- Requests and Responses for Stage Selection: Another noteworthy challenge was the implementation of requests and responses for users selecting a stage from the backend to populate a list of products associated with that stage. This involved developing a robust and efficient mechanism to communicate user preferences to the backend, receive the corresponding data, and present it as a list of products. Handling this process seamlessly and ensuring it met user expectations presented several hurdles in terms of both frontend and backend integration.

These challenges demanded a combination of problem-solving, code refactoring, and effective communication between the development team members. Overcoming them was essential to ensure the successful delivery of the project while maintaining its quality and performance standards.


# Installation Guided
`git clone <this repo url>`

make sure to head to the frontend to have this application work with the api calls 
(https://github.com/avrubio/DermiCycle-Frontend)


 `cd /dermicycle-backend`
open in IntelliJ and run the dermicylce-backend application

## Acknowledgements
[Suresh Sigera](https://github.com/sureshmelvinsigera) - helped tremendously with my back end to make sure my endpoints were working properly and that my tests were passing with every new response and request classes we created.


