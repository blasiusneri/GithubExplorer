GithubExplorer - Modularization Journey
=======================================

GithubExplorer developed using monolith architecture where only consist of single module, an app module

Test run application before doing modularization
Requirement: Github Account

Generate Access Token in Github (https://github.com/settings/tokens)
1. Click button "Generate new token"
2. Type note in note field
3. Click on the user check box (only use user related API)
4. Click Generate Token in bottom of the page
5. Copy token to ACCESS_TOKEN

Let's try the apps, it consist of two page
1. Main page
2. Search User page


Let's start to modularized the project:
1. Right click on the project folder and create new module
2. Select Android Library for new module
3. Set :base as name for the module
4. Invalid date and restart the IDE
5. Base module will shown on the project tree