# RepoLink: https://github.com/Pratik-Nikam/JPaint-App.git
# JPaint Application (SE-450)
---
This project aims toward building JPaint Application using Java. Purpose of this project is learn and implement a application using Solid Principle and Design Patterns.
---

### Sprint Details
---
Project will be carried out in total 4 Sprints
1. Jan 26
Note: I have created feature branch name Sprint-1 for sprint 1 purpose and to maintain the code sprint wise. Will merge this with develop branch in the 2nd Sprint.

### Programming Language and Frameowork
---
* Java


### Project Features
---
* **Sprint 1**
* Link: 
1. https://github.com/Pratik-Nikam/JPaint-App.git
2. https://github.com/Pratik-Nikam/JPaint-App/tree/SPRINT-1

* Features

1. Draw Rectangle. 
2. Undo and Redo operations.

The class is creating the object of static factory according to the shapes and then adding the 
shapes into linked list. After that, class is calling listener using update method to draw shapes on canvas.

I have successfully implemented the Sprint 1 features. I have implemented Command Pattern when the mouse mode will be draw. 
Classes involved:
ICommand - I have created this interface which has only one method called run without its implementation.
CreateShapeCommand - This  class implements the ICommand Interface and have implementation for run() method.
Here objects of static factory are created depending on the shapes to be drawn and then add the shape into a 
array list where have handled code to call draw method of that shape object.

* Sprint 1 Feedback:
1. Remove .com folder (entire content moved directly inside src)
2. co-ordinate object removed from click handler


* **Sprint 2**
* Link: 
1. https://github.com/Pratik-Nikam/JPaint-App.git
2. https://github.com/Pratik-Nikam/JPaint-App/tree/SPRINT-2

* Features
* 
1. Draw Elipse and Traingle.
2. Select Shapes.
3. Move selected shapes.
4. coloured shapes.

I have implemented the above features in sprint 2  and worked on suggestions from sprint 1.
Design Patterns Used:
1. Command Pattern
2. Observer Pattern 
3. Strategy Pattern (Movement strategy based on displacement)

## Authors

* **Developers**: Pratik Nikam