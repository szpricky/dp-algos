# Dynamic Programming Algorithms

## Table of Contents

- [Dynamic Programming Algorithms](#dynamic-programming-algorithms)
  - [Table of Contents](#table-of-contents)
  - [Introduction](#introduction)
  - [Project Structure](#project-structure)
  - [Paper Roll Cutting](#paper-roll-cutting)
  - [Robot Moving](#robot-moving)

## Introduction

This project is part of a Non-Linear Data Structures and Algorithms assignment. A number of problems are included for which a solution has been implemented using a dynamic programming algorithmic technique.

## Project Structure

The project contains two packages, where:

-   `paper_roll`: the package for finding the optimal price of a paper roll to obtain the best revenue.
-   `robot`: the package for finding the path with the minimum energy cost for moving a robot through a matrix.

## Paper Roll Cutting

The solution for this problem has been implemented using a bottom up approach in the `PaperRollCuttingBottomUp.java` file. The solution is tested in the `PaperRollMain.java` file. In brief, the `cutRoll()` method computes the best revenue of cutting the roll into several roll-pieces.

## Robot Moving

The solution for this problem has been implemented using a bottom up approach in the `RobotMoving.java` file. The solution is tested in the `RobotMain.java` file. In brief, the `moveOnShortestPath()` method computes the path with the minimum energy cost for the robot to take from start to finish.
