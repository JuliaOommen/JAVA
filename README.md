# JAVA PROGRAMMING

LAB 1

Program 1 : (CreditCard) 
This Java program validates an 8 or 9-digit credit card number by using a checksum algorithm. The CreditCard class performs checks on the card length, reverses the number, and calculates a position-based sum according to specific rules. The program verifies the final digit to determine if the card number is valid, outputting whether it is valid or invalid.

Program 2 : (Game) 
This Java program simulates a game called "Alphabet Wars" with two teams, Team A and Team B, each represented by letters with individual strengths. Players can optionally assign custom strengths to each letter, and the program then calculates scores based on input words, determining the winning team or if there's a tie. The Solver class handles score calculations and displays the winner based on total scores.

Lab 2

Program 1 : (Frequency) 
This Java program finds the top k most frequently occurring numbers from a list of user-input integers between 0 and 100. The Num class counts occurrences of each number, sorts them by frequency, and displays the k numbers with the highest occurrences. Input validation ensures that all numbers are within the specified range.

Program 2 : (Trade) 
This Java program calculates the maximum possible profit from two stock transactions using an array of stock prices. It tracks the minimum buy prices and maximum sell profits for both transactions to maximize returns. Input validation ensures at least two prices are provided before calculating profits.

Lab 3

(Payroll) 
This Java program is an employee payroll system for managing various employee roles with different payment structures using object-oriented principles. The base class, Employee, defines general attributes and methods, while specialized classes (HourlyEmployee, SalariedEmployee, and ExecutiveEmployee) extend it, each implementing unique salary and bonus calculations. The program includes methods for calculating weekly salaries, determining bonuses, and displaying employee information. 

Lab 4

(JAVAProfessionalRobber) 
This Java program simulates a "robber" that can calculate the maximum amount of money that can be stolen from different types of houses in various localities. The program uses an abstract class Robber, which defines methods that are implemented in the JAVAProfessionalRobber subclass.
RobbingClass
RowHouses: Calculates the maximum money that can be stolen from a series of row houses by robbing alternate houses, optimizing for either odd or even indexed houses.
RoundHouses: Similar to RowHouses, but for round houses where the starting point and method vary depending on the number of houses.
SquareHouse: Calculates the maximum money that can be stolen from a square grid of houses by alternating between two patterns (starting from the first or second house).
MultiHouseBuilding: Uses dynamic programming to calculate the maximum money that can be stolen from a multi-row, multi-column matrix of houses, where the robber must skip adjacent houses.
The program then executes these methods, taking input from the user to simulate different robbery scenarios for various house layouts.

Lab 5

Program 1: (Banking)
The Java code demonstrates the use of an interface (BankInterface) and class inheritance to model three banks (BankA, BankB, BankC).
BankInterface: Defines two abstract methods: getBalance() and getInterestRate(), which are implemented by the three bank classes.
BankA, BankB, BankC: Each class implements the BankInterface and defines the getBalance() and getInterestRate() methods. Each bank class has a constructor that accepts an initial balance and a fixed interest rate (7.0% for BankA, 7.4% for BankB, and 7.9% for BankC).
Banking class (main method): This class instantiates objects of BankA, BankB, and BankC with specified balances (10000, 150000, and 200000 respectively) and displays each bank's balance and interest rate.

Program 2: (WaterConservation)
The Java program models a water conservation system to calculate the amount of rainwater trapped between city blocks based on their heights.
WaterConservationSystem Interface: Defines the method calculateTrappedWater(int[] blockHeights) to calculate the trapped water.
RainySeasonConservation Abstract Class: Implements the WaterConservationSystem interface and defines an abstract method calculateTrappedWater.
CityBlockConservation Class: Extends RainySeasonConservation and implements the calculateTrappedWater method. It uses the two-pointer approach:
It initializes two pointers, i (left) and j (right), to traverse the block heights from both ends.
As it moves the pointers towards the center, it calculates trapped water based on the minimum of the maximum heights from both sides.
WaterConservation Class (main method):
Takes input for the number of city blocks and their heights.
Calls CityBlockConservation to calculate the trapped water and prints the result.
