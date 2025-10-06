# GitHub Repo Creator 

Welcome! This is a simple Java-based GUI application designed to help developers quickly turn a local folder into a GitHub repository with just a few clicks. It was built as a proof-of-concept for a Microsoft-sponsored challenge at Quinnipiac University(assignment concept basis).

---

## What It Does

With this tool, you can:

- Turn any project folder into a Git repo
- Add a preconfigured `.gitignore` and a basic `README.md`
- Make an initial commit
- Create a corresponding GitHub repository using your personal access token
- Automatically link your local and remote repositories
- Push everything up and get a link to your brand new GitHub repo

No terminal commands needed. No GitHub navigation. Just point, click, and go.

---

## Purpose

The goal behind this tool was to help streamline and simplify the process of setting up new GitHub repos — especially for developers who are newer to Git, or anyone who just wants a faster workflow.

This project was also a great way for us to get hands-on experience with Java Swing, Git automation, and GitHub’s API — and we hope it shows.

Made for assignment for QU "Version Control" Class.

---

## Technology Used

- **Java 17+**
- **Swing** (for the GUI)
- **GitSubprocessClient** – handles local Git commands from Java
      https://github.com/CSC109/GitSubprocessClient
- **GitHubApiClient** – talks to the GitHub API to create repositories
      https://github.com/CSC109/GitHubApiClient


---

## How to Use It

Website with guidelines: https://cw-104.github.io/GitGUI/

1. Launch the application by running `Main.java`
2. Fill in the required fields:
   - Your local project folder path
   - A name and description for your GitHub repo
   - Your GitHub personal access token
   - Optional: make the repo private
3. Click **Create GitHub Repo**
4. Done! You’ll get a clickable URL to your live GitHub repository

> Note: Your token should never stored or written to a file — it’s used once during the session and discarded.

---

## Security Notes

We take token security seriously. Please **do not hardcode your GitHub token** into the source code or save it in a file that gets committed. If you accidentally do, revoke the token immediately on GitHub and generate a new one.

We’ve also included `.gitignore` suggestions to help prevent these accidents.

Bugs with Handler and Subprocessor

---

## Project Structure

