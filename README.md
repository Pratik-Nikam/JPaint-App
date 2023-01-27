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

## Authors

* **Developers**: Pratik Nikam

