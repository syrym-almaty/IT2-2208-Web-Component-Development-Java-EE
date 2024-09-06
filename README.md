# SFT6310-36 Lab - Web Component Development (Java EE) - Group Project

## Project Overview
Welcome to the group project for Web Component Development (Java EE). In this project, we will work together to develop components of a Java Spring web application. Each student will have their own branch, make individual contributions, and then submit their work via a pull request to ensure code quality.

This document provides step-by-step instructions on how to collaborate effectively using GitHub.

---

## Getting Started

### 1. Clone the Repository
First, you need to clone the repository to your local machine. Open a terminal or command prompt and run:


git clone https://github.com/syrym-almaty/SFT6310-36-Lab-Web-Component-Development-Java-EE-Lab-gr-IT2-2208-building-aud-502.git

Steps to Create Your Branch:
After cloning the repository, navigate into the project folder:

bash
Copy code
cd SFT6310-36-Lab-Web-Component-Development-Java-EE-Lab-gr-IT2-2208-building-aud-502
Create a new branch named after the feature or task you’re working on. Use this format:

bash
Copy code
git checkout -b feature-<yourname>-<task>
For example, if your name is Alex and you’re working on the login system, your branch would be:

bash
Copy code
git checkout -b feature-alex-login-system
Now you're working on your own branch and any changes you make will not affect the main branch.




3. Making Changes and Committing Your Work
Once your branch is created, you can start coding and making changes.

Steps to Commit Your Changes:
After making changes (e.g., adding a new file, modifying code), you need to stage those changes:

bash
Copy code
git add .
This stages all your changes.

Next, commit your changes with a message describing what you did:

bash
Copy code
git commit -m "Describe what you changed, e.g., Implement login system"
Push your changes to GitHub:

bash
Copy code
git push -u origin feature-<yourname>-<task>
For example:

bash
Copy code
git push -u origin feature-alex-login-system
This will upload your branch to GitHub.
