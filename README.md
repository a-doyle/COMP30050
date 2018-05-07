## COMP30050 Final Project
This is our version of a dynamic, procedural generation of Monopoly, through Java.

Owing to the fact that we had to completely refactor our code, we decided to make a new folder containing the code for submission.

The folder labelled final_project is the folder we are sending for submission, from Monopoly/src/final_project.

The game is run using the Board class.

We also decided to include the code we were using, as well as the interfaces and enums we would be implementing and integrating for the final project, so as the evaluators can see what we had planned on using before half the team dropped out last minute.

A NOCList class was implmented but there was no time to implement it to the game.

To run the game DOWNLOAD THE JAR FILE AND RUN IT FROM THERE / PULL THE CODE FROM THE GITHUB AND USE THE BOARD CLASS TO RUN.

# Codebase
Each class submitted contains relevant logic for controlling the various functionality of the game, as follows;

1. Board: Controls UI and core game logic (Run with this)
5. Chance: Contains the various hard-coded Chance cards
6. Command: Contains the various game commands a Player can enter
7. Community Chest: Contains the various hard-coded Community Chest cards
8. Dice: Contains the logic for the dice roll
11. Players: An ArrayList of Player objects, containing all the Player logic as well
12. Properties: Contains the relevant logic for each individual property

**The following Card classes are not integrated as we did not have enough time**

2. Card: A simple Card object
3. CardDeck: A LinkedList of multiple Card objects
4. CardType: An enum containing a constant for each CardType, Chance and Community Chest

**These classes was not integrated as well as we did not have enough time**

9. NOCList: We attempted to integrate the NOCList into our project
10. UI: We attempted to move the UI logic to a seperate class
