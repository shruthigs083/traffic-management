# 🚦 Traffic Management System

A Java-based Traffic Management System that simulates intelligent traffic signal control by monitoring vehicle density across four lanes and prioritizing emergency vehicles to improve traffic flow.

## 📌 Project Overview

The Traffic Management System is a console-based Java application designed to simulate how traffic signals can be managed dynamically.

Instead of following a fixed signal sequence, the system identifies the lane with the highest vehicle count and grants it a green signal. If an emergency vehicle is detected, that lane receives priority.

The application manages four directions:
- North
- South
- East
- West

## ✨ Features

- **Dynamic Traffic Management:** Tracks vehicle counts across four lanes.
- **Emergency Vehicle Priority:** Gives priority to lanes containing emergency vehicles.
- **Busiest Lane Detection:** Selects the lane with the highest vehicle count when no emergency is detected.
- **Traffic Signal Simulation:** Simulates Green, Yellow, and Red signal transitions.
- **Real-Time Traffic Status:** Displays vehicle counts and emergency vehicle status for every lane.
- **Menu-Driven Interface:** Provides a simple console-based interface to manage traffic.

## 🛠️ Tech Stack

- **Programming Language:** Java
- **Collections Framework:** HashMap, Map
- **Java Utilities:** Scanner, Collections, Comparator
- **Object-Oriented Programming:** Classes, Objects, Encapsulation, Enums
- **Concepts:** Conditional Statements, Loops, Methods, Dynamic Prioritization

## 🏗️ System Design

The application is organized into four main classes:

| Class | Responsibility |
|---|---|
| `TrafficLight` | Maintains traffic signal colors: RED, YELLOW, GREEN |
| `Lane` | Stores lane information, vehicle count, and emergency status |
| `TrafficSignalController` | Manages lanes and determines signal priority |
| `TrafficManagementSystem` | Provides the main method and menu-driven user interaction |

## ⚙️ How It Works

1. The user selects a lane and enters its vehicle count.
2. The user specifies whether an emergency vehicle is present.
3. The controller checks all four lanes.
4. If an emergency vehicle is detected, its lane receives priority.
5. Otherwise, the lane with the highest vehicle count is selected.
6. The selected lane receives a Green signal.
7. The system simulates the Yellow and Red signal transitions.
8. The vehicle count of the selected lane is reset.
9. The user can view updated traffic information or run another cycle.

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK 8 or later)
- Any Java IDE or a terminal
- Basic knowledge of Java

### 1. Clone the Repository

```bash
git clone YOUR_REPOSITORY_URL
```

### 2. Navigate to the Project Directory

```bash
cd Traffic-Management-System
```

### 3. Compile the Program

```bash
javac TrafficManagementSystem.java
```

### 4. Run the Application

```bash
java TrafficManagementSystem
```

## 🖥️ Sample Menu

```text
MENU:
1. Update Traffic
2. Run Traffic Cycle
3. Show Traffic Status
4. Exit

Enter choice:
```

## 🎯 Learning Outcomes

Through this project, I explored:

- Object-Oriented Programming principles in Java.
- Using HashMap to manage multiple traffic lanes.
- Enums to represent traffic signal states.
- Collections and Comparators for selecting the busiest lane.
- Implementing priority-based decision-making.
- Building interactive console applications using Java Scanner.

## 🔮 Future Enhancements

- Implement automatic signal timing based on traffic density.
- Add multiple emergency vehicle handling.
- Introduce a graphical user interface.
- Integrate real-time traffic data.
- Improve input validation and traffic scheduling.
- Prevent conflicting lane signals using intersection safety rules.

## 👩‍💻 Author

**Shruthi G S**

- GitHub: [shruthigs083](https://github.com/shruthigs083)
- LinkedIn: [Shruthi G S](https://www.linkedin.com/in/shruthigs083/)
- LeetCode: [Shruthigs](https://leetcode.com/u/Shruthigs/)

---

⭐ If you find this project interesting, feel free to explore the repository!
