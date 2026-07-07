# Git Hands-On (Modules 1 - 5)

This document covers all 5 mandatory hands-on exercises for GIT as per the Digital Nurture deepskilling track.

## Git-HOL 1: Git Basics and Local Repository
**Objective:** Initialize a repository, stage files, and commit changes.
```bash
# Initialize a new Git repository
git init my-project
cd my-project

# Create a new file and add it to the staging area
echo "Hello Git" > readme.md
git add readme.md

# Commit the changes to the local repository
git commit -m "Initial commit with readme"
```

## Git-HOL 2: Branching and Merging
**Objective:** Work with branches to isolate feature development.
```bash
# Create and switch to a new branch
git checkout -b feature/login

# Make some changes in the new branch
echo "Login Feature" > login.txt
git add login.txt
git commit -m "Added login feature"

# Switch back to main and merge the feature branch
git checkout main
git merge feature/login
```

## Git-HOL 3: Working with Remote Repositories
**Objective:** Connect local repository to a remote server (e.g., GitHub).
```bash
# Add a remote origin
git remote add origin https://github.com/Navaneethka-Dev/my-project.git

# Push local main branch to the remote repository
git push -u origin main

# Fetch and pull latest changes from remote
git pull origin main
```

## Git-HOL 4: Resolving Merge Conflicts
**Objective:** Understand how to resolve conflicts when branches diverge.
```bash
# Assuming two branches modified the same line in readme.md
git merge feature/update-readme
# CONFLICT (content): Merge conflict in readme.md

# You must manually edit the file to resolve the conflict, then:
git add readme.md
git commit -m "Resolved merge conflict in readme"
```

## Git-HOL 5: Advanced Git (Rebase & Stash)
**Objective:** Use rebase for a clean history and stash for temporary saves.
```bash
# Stash uncommitted changes to work on a hotfix
git stash
git checkout hotfix-branch
# ... work on hotfix ...

# Switch back and apply stashed changes
git checkout feature/login
git stash pop

# Rebase current branch onto main
git rebase main
```
