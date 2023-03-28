# Hugs the Lanes

**Alset Inc.**

Team Fundamental Disconnect  
David Carpenter, Joshua Hwang, Joshua Meharg, Saoirse Mooney

_Version 1.7_  
2022-05-04

[GitLab Repository](https://gitlab.com/cs347spring22/cs-347-b/chmm-15b/hug-the-lanes-iot)

## Table of Contents

- [Introduction](#1-introduction)
  - [Project Goals](#11-project-goals)
  - [Features & Sensors](#12-features-sensors)
    - [Features](#122-features)
    - [Sensors](#121-sensors)
  - [Team Members](#13-team-members)
  - [Development Process](#14-development-process)
- [Functional Archtecture](#2-functional-architecture)
- [Requirements](#3-requirements)
  - [Functional Requirements](#31-functional-requirements)
  - [Non-Functional Requirements](#32-non-functional-requirements)
- [Requirements Modeling](#4-requirement-modeling)
  - [Use Case Scenarios](#41-use-case-scenarios)
  - [Activity Diagrams](#42-activity-diagrams)
  - [Sequence Diagrams](#43-sequence-diagrams)
  - [Class Diagrams](#44-class-diagrams)
  - [State Diagrams](#45-state-diagrams)
- [Design](#5-design)
  - [Software Architecture](#51-software-architecture)
  - [Data-Centered Architecture](#52-interface-design)
  - [Component-level Design](#53-component-level-design)
- [Project Code](#6-project-code)
- [Testing](#7-testing)
  - [Scenario-Based Testing](#71-use-case-testing)
  - [Validation Testing](#72-validation-testing)

  <!-- - [Class Diagrams] TODO -->

## 1. Introduction

Problem: Drivers desire a safer, more convenient way to drive.

### 1.1 Project Goals

Our self-driving system will operate the vehicle safely without human interaction. This requires several features such as Light Detection and Ranging (LiDAR) for the vehicle to have a real-time image of its surroundings. With the use of state of the art sensors, hardware, and software, a mission critical real-time embedded system will be made. This relies heavily on Internet of Things (IoT) technology which allows for the embedded system to take information from the sensors, have it processed by the main computer, and then respond by changing the system’s state. IoT was selected as it is the cutting edge technology for designing embedded systems. This will be developed using a spiral process rather than an agile one to respect the mission-critical nature of the project.

### 1.2 Features & Sensors

#### 1.2.1 Sensors

- Perception Sensors
  - LiDAR: Light Detection and Ranging. This provides an accurate 3-D image of the vehicle’s surroundings.
  - Front-and-rear mounted camera. Used for estimating distance from obstacles and also displays a video feed of the car's rear when backing up
  - Temperauture sensors
- Localization Sensors
  - GPS
  - Accelerometer: sensor which measures the acceleration of a system

#### 1.2.2 Features

- Heads-Up Display (HUD): system condenses helpful information received from sensors within the car’s framework.
- Edge-of-lane warning: The vehicle will display a warning when it senses the vehicle crossing the lane boundaries through its on-baord cameras and nudges the vehicle to fall within the lane boundaries.
- On-HUD GPS directions: The vehicle will display non-distracting prompts for turns and upcoming through the HUD.
- Blind-spot warning: The vehicle will display a warning if a vehicle is within the blind-spot of the car as it is trying to merge and will stop the vehilce from completing the turn until the blind-spot of the car is free.
- Cruise Control: The vehicle will have the ability to maintain a set speed the driver inputs with a push of a button whithout having the driver manually press the gad pedal.
- Car-to-car Communication: Other cars enabled with this technology send and receive each others' data to create a local network. This allows them to coordinate their actions around each other and speeds up traffic and increases safety.
- Weather and Traction Reaction: receives weather data and surface temperature of road to determine safe speed of travel.
- Key Fob: A keyless entry remote transmitter that allows the user to start the Vehicle wirelessly so long as the Key Fob is in the car.
- Software Update: This feature allows the driver to ensure that the vehicle is up-to-date with ALSET industry standards.
- Logging: A store log to ensure that all vehicle actions are recorded for maintenance purposes.

### 1.3 Team Members

Below is an overview of each of the team members’ skills and disciplines:

- David Carpenter: Software Engineering 2022 / Python, JavaScript, C++, Go, Java, C# / Detail-oriented with experience in coding, writing, and Agile principles.
- Joshua Hwang: Electrical Engineering 2022 / C++, Python, ARM, Java/ Collaborative with communication skills and successful completion of many projects.
- Joshua Meharg: Computer Science 2024 / Python, JavaScript, C++, ARM, Java, CSS / Coding skills with experience in lengthy projects requiring patience and problem solving.
- Saoirse Mooney: Computer Science 2024 / Python, C, C++, Java, ARM / Coding and writing skills specializing in analytics.

This project began in January 2022 and is expected to end in May 2022. The team will be able to each contribute at least 4 hours per week towards this project. The final product will accurately reflect the requirements defined herein.

### 1.4 Development Process

In order to follow a quality software development process, the team will make use of the following tools and frameworks:

- Spiral process model
- UML diagrams
- Continuous integration
- Discord
- Code review

The spiral process model will be utilized in this project, as this model is appropriate for delivering an incomplete version of the product at the end of an iteration. Each iteration of the spiral process model will consist of several sprints where features from the product backlog are placed in a sprint backlog to be worked on by the team. Code ownership will be team-wide - any team member can make a change to a section of the code. To ensure a high quality design, the team will engage in a planning phase before the sprints begin. In this planning phase, the team will generate UML diagrams modeling code objects, states, and processes. Discord will be used for team communication and updates on repository events. Team meetings will occur weekly.

## 2. Functional Architecture

Using innovative Internet of Things technology, Fundamental Disconnect will combine novel software and state of the art technology for Aslet's new vehicle.

![Functional Architecture](/docs/images/functional-arch-updated.png)

Processing of the information from the localization module and perception module takes place in the sensor fusion module. This processing includes determining the location of the vehicle in actual space within a few centimeters using data from the localization module. Additionally, this module processes the data from the perception module to understand what obstacles or other potential hazards will need to be accounted for in the next few instances of time. The localization module takes in information from the LiDAR, cameras. Additionally, the driver is used like a perception sensor, able to take direct control of the vehicle control module in order to pilot that car in a non-assisted way. The system management module is responsible for generating system logs including info, warnings, and errors for technicians to examine. It also is responsible for downloading system updates over wireless connection. The dashboard module is responsible for all information displayed to the driver, such as the current GPS direction. The planning module contains the algorithm that directs the vehicle when control is not overridden by the driver.

## 3. Requirements

### 3.1 Functional Requirements

#### 3.1.2 Heads-up display

Precondition: The vehicle is not powered on.  
Postcondition: The heads-up display is on with accurate display of speed, gear, and current GPS direction.

3.1.2.1 Driver pushes the button to power on the car.  
3.1.2.2 Signal from button sent to the sensor fusion module.  
3.1.2.3 Sensor fusion sends speed data, gear data, and current GPS direction to Dashboard module.  
3.1.2.4 Dashboard module formats an image to be displayed in a projection on the windshield.  
3.1.2.5 Signal is sent from the dashboard module to the heads-up projector.  
3.1.2.6 The heads-up projector projects the next frame of the heads-up display onto the windshield.

#### 3.1.3 Edge-of-lane Warning

Preconditions:

- The vehicle is turned on and in motion.
- There are lanes on one or both sides, which are of a standard distance apart (<= 1 meter).
- Vehicle is too close to one lane or is partly over a lane (<= 0.1 meter).

Postcondition: Vehicle is within the standard distance of <= 1 meter from both sides of the vehicle.

3.1.3.1 While in motion, one side or both sides of the vehicle fall below 0.1m for more than 0.43 seconds.  
3.1.3.2 Cameras located underneath both sideview mirrors sends data to Sensor Fusion module.  
3.1.3.3 Sensor Fusion module sends data to the Dashboard module, which activates Edge-of-lane alarm, auditory and visual alarm.  
3.1.3.4 System Management module logs the activation of the alarm.  
3.1.3.5 Steering wheel is nudged in the direction which will center the vehicle within the standard distance.

#### 3.1.4 On-HUD GPS directions

Preconditions:

- The heads-up display is on.
- The driver has entered their destination in the console.
- The GPS sensor is receiving a satellite signal.

Postcondition: The GPS portion of the heads-up display shows the next direction.

3.1.4.1 The sensor fusion sends the planning module the current GPS location and the GPS location of the destination.
3.1.4.2 The planning module creates a route, stores it, logs it, and sends it to the dashboard module.  
3.1.4.3 The dashboard module sends the next GPS direction to be prepared as the part of the next rendered frame.

#### 3.1.5 Blind-spot warning

Precondition:

- Vehicle is driving at speed S > 0.
- The driver is attempting to direct the vehicle in a way that would cause a collision with an object in the driver's blind-spot.

Postcondition:
The vehicle control prevents the driver from attempting a lane switch via steering the driver to stay in their lane.

3.1.5.1 The driver activates turns the wheel in a way that the projected trajectory of that direction would result in a collision.  
3.1.5.2 The blind-spot warning will be issued automaically if the sensor fusion has picked up the presence of an object in the driver's blind-spot while the driver is attempting to move into the lane of the object.  
3.1.5.3 The blind-spot warning will utilize the fetures of the perception module of the car to sense possible object of collision.  
3.1.5.4 The dashboard issues a warning to the driver that there is an object in their right/left side bindspot.  
The blind-spot warning will appear on the HUD of the car, along with an audible warning cue to alert the driver.  
3.1.5.5 The vehicle control will lock the steering wheel until a safe lane change can be performed.

#### 3.1.6 Cruise Control

Precondition: Vehicle is driving at speed S > 0.  
Postcondition: Vehicle is driving at speed S.

3.1.6.1 Driver pushes "cruise control" button. Button sends requested speed to the sensor fusion.  
3.1.6.2 Sensor fusion sends speed request 1 to IoT HTL (hug-the-lanes).  
3.1.6.3 IoT HTL sends speed request to vehicle control system.  
3.1.6.4 IoT HTL continues sending request to VCS.  
3.1.6.5 IoT HTL sends "turn on" request to cruise control display.  
3.1.6.6 IoT HTL logs the event in system management.

#### 3.1.7 Weather and Smart Traction

Preconditions:

- The car Weather and Smart Traction requirements are met.
- The car is powered on.
- The car has a connection with speed >= 10 Kb/s to external weather server.
- The driver is not manually pressing the gas pedal.
- The car is driving over the safety speed S.
- The car is in an area of adverse weather conditions.

  Postcondition: The car is driving at speed <= S.

  3.1.7.1 The planning module sends speed request to sesnor fusion
  3.1.7.2 The planning module sends speed information to vehicle control module.  
  3.1.7.3 Sensor fusion sends location request to external weather server.  
  3.1.7.4 Weather server sends location information to planning module.  
  3.1.7.5 If the weather is rainy, the planning module analyzes speed limit and calcualtes speed S as 66% of the current speed limit.  
  3.1.7.6 If the driver is not currently pressing the gas pedal or the car is not already going less than or equal to speed S, the planning module sends a request to vehicle control to set the speed to <= S.  
  3.1.7.7 Vehicle control sets the speed of the car to speed <= S.  
  3.1.7.8 As long as the weather conditions stay rainy, the planning module will monitor speed information from the sensor fusion to maintain speed S.

#### 3.1.8 Car-to-car Communication

Precondition: The vehicle is on and the driver has opted in to become part of the IOT HTL Car-To-car communications network.
Postcondition: The vehicle joins the network of IOT HTL vehicles.

3.1.8.1 When the vehicle is turned on, it will automatically gather data from other IOT HTL vehicles to log weather conditions, traffic conditions, and optimal GPS routes.  
3.1.8.2 If the user inputs a destination in the GPS system, Car-To-Car communications will compute the fastest route based on downloaded data.  
3.1.8.3 Once the vehicle is in motion, all sensor fusion readings will be uploaded to the communications network for other vehicles to use.  
3.1.8.4 The vehicle's localization systems will log traffic conditions real-time.  
3.1.8.5 The vehicle will send speed and braking signals from surrounding cars in the network to the planning module (the planning module will then recompute the route as necessary based on the signals from other cars, for example, braking simultaneously with the network-enabled car in front).

#### 3.1.9 Adaptive Headlights/Highbeams

Precondition: The vehicle is on with headlights turned on.
Postcondition: The headlight intensity is adapted to the current environment.

3.1.9.1 Two upward-facing Light Sensors detect the outside lighting intensity, two forward-facing Light sensors detect light intensity from approaching vehicles, and the light intensity is sent to the Sensor Fusion module.

3.1.9.2 The Sensor Fusion module sends the data to the Planning module, where it calculates the necessary lighting intensity Headlights(Off - Max intensity), Highbeams(Off / On).

3.1.9.3 The Planning module sends the intensity values to the Vehicle Control System.

3.1.9.4 When it is > 1000 lumens but < 3000 lumens at the top sensors the headlights are turned on to the standard beams.

3.1.9.5 If the forward-facing sensors do not detect an approaching vehicle (< 3000 lumens), and the Sensor Fusion determines that outside conditions aren't foggy or raining, and the top sensors return a result < 1000 lumens, the Highbeams will turn on.

#### 3.1.10 Key Fob

Precondition: The Key Fob is within 10 meters of the Vehicle.
Postcondition: The Key Fob is able to either change the lock status of the Vehicle and start the engine of the Vehicle.

3.1.10.1 The vehicle is locked, and the user pulls on the handle.

3.1.10.2 The Sensor Fusion will send the distance between the car and the Key Fob to the Vehicle Control Module.

3.1.10.3 If the Key Fob is less than 10 meters away, the vehicle will unlock.

3.1.10.4 Once the user with the Key Fob is in the car, the door is shut, and the car starts to drive, the vehicle will lock automatically.

3.1.10.5 If the user presses the power button, the Sensor Fusion will send the distance between the car and the Key Fob to the Vehicle Control Module.

3.1.10.6 The Vehicle Control module checks that the Key Fob is less than a meter from the car. If it is, then the car will start after the user pressed the power button.

3.1.10.6 If the user presses the power button, and the Vehicle Control Module check indicates that the Key Fob is not inside the vehicle, a signal will be sent to the Dashboard Module to display an error message that the Key Fob is not in the vehicle.

### 3.2 Non-functional Requirements

#### 3.2.1 Performance

3.2.1.1 The sensor fusion module must be able to support 8 simultaneous requests at once.  
3.2.1.2 The sensor fusion module must be able to support 5000 requests per second.  
3.2.1.3 The frames-per-second of the heads-up display must never drop below 5.

#### 3.2.2 Security

3.2.2.1. All transmissions between Alset servers and each vehicle will be encrypted using the AES standard.  
3.2.2.2 Each Alset technician must input credentials they are issued upon certification to gain access to the technician interfaces of the Alset vehicle.  
3.2.1.3 The vehicle owner's location history will be encrypted so that a technician or hacker cannot gain access to it.

#### 3.2.3 Reliability

3.2.3.1 The heads-up-display shall have a lifespan at least 5000 hours of continuous operation.  
3.2.3.2 All sensors shall have a minimum lifespan of 5000 hours.  
3.2.3.3 The Global Positioning System will update two times a year for the most accurate directions.  
3.2.3.4 Car-to-Car communication networks will not connect to one vehicle for every 50 vehicles within the network.

#### 3.2.4 Software Update

Precondition:

- The vehicle's software version does not match the most up to date version in Alset's servers.
- The vehicle has a connection with speed >= 10 Kb/s to Alset servers.
- The vehicle is currently parked and charging.

Postcondition: The vehicle's software version matches the most up to date version in Alset's servers.

3.2.4.1 While the vehicle is charging, System Management module sends request to Alset servers for the most updated software version of the current vehicle's model.  
3.2.4.2 The System Management modulde compares the current software version and the one retrieved from the Alset servers.  
3.2.4.3 If the versions do not match, the System Management proceeds with the Software Update process and logs the action.  
3.2.4.4 If the new version is less than 1 GB and will take less than 5 minutes to download:

3.2.4.4.1 The System Management sends a request to the Dashboard module to display a popup that the vehicle is about to update and allows the user to cancel the update within 20 seconds.  
3.2.4.4.2 If the user does not cancel the update the vehicle will automatically start updating the software.  
3.2.4.4.3 Will the software is updating, the car will not be able to move until it is finished updating and it logs the update.  
3.2.4.5 If the new version is over 1 GB and will take greater than 5 minutes to download:

3.2.4.5.1 Whenver the car has been first turned on, the System Management will send a request for the Dashboard Module to display a popup asking the user if they would like to update the car or an option to schedule the downlaod, displaying the estimated time of the download.  
3.2.4.5.2 If the user indicates they would like to upate the car at that time, the Sensor Fusion will check if the car is currently being charged and sends a boolean value to the System Management module.  
3.2.4.5.3 If the value is false, the System Management Module will send a request for the Dashboard module to display a popup instructing the user to plug in the car and the System Managment will not begin the update until the bool value is true and logs the action.  
3.2.4.5.4 Once the vehicle begins charging, the vehicle will not be able to move until it is finished updating and it logs the update.  
3.2.4.6 If the user inputs a time for a scheduled update, The System Management module stores this time and will reapeat the steps from section 3.2.4.5 once that time has arrived and the car is not moving.

#### 3.2.5 Logging

Precondition: Vehicle is turned off.  
Postcondition: System Management module store log codes.

3.2.5.1 Upon turning on the vehicle, the System Management module turns on.  
3.2.5.2 Once, all functional hardware verifies connection to the Sensor Fusion module, the System Management module logs "READY" state.  
3.2.5.3 Sensor Fusion module receives continuous data from sensors and directs them to System Management, where any interruptions in data flow are logged.

## 4 Requirement Modeling

### 4.1 Use Case Scenarios

#### 4.1.1 Enable Weather Smart Traction

**Primary Actor:** NOAA Weather Server

**Goal in context:** Maintain a safe speed for the vehicle as appropriate for the current weather conditions.

**Precondition:** The car is powered on.

**Trigger:** Rainy weather is detected

**Scenario:**

<!-- include display information (Also in the requirements section) -->

4.1.1.1 The NOAA Weather server sends weather information to the Planning Module
4.1.1.2 Sensor Fusion sends speed information to Planning Module.  
4.1.1.3 If the weather is rainy, the Planning Module analyzes speed limit and calcualtes speed S as 66% of the current speed limit.  
4.1.1.4 Planning Module sends a request to Vehicle Control to set the speed to <= S.  
4.1.1.5 Vehicle Control sets the speed of the car to speed <= S.  
4.1.1.6 As long as the weather conditions stay rainy, the Planning module will monitor speed information from the sensor fusion to maintain speed S.

**Exceptions:**

4.1.1.9 The Driver is manually pressing the gas pedal after Weather and Smart Traction is activated: car's speed is no longer S.  
4.1.1.10 The car is driving under or equal to the safety speed S.
4.1.1.11 The car has a connection with speed < 10 Kb/s to an external weather server.

#### 4.1.2 Enable On-HUD GPS navigation

**Primary Actor:** Driver

**Goal in context:** Navigate to a destination with the assistance of the GPS.

**Precondition:** The Heads-Up Display is on.

**Trigger:** The Driver has entered their destination in the console.

**Scenario:**

4.1.2.1 The Sensor Fusion sends the Planning Module the current GPS location and the GPS location of the destination.  
4.1.2.2 If:

- There is no precomputed route or,
- the current speed > 0 and no route has been computed since the last turn:

the Planning Module creates a route, stores it, and sends it, to the Dashboard Module. The event of computing a route is logged.  
4.1.2.3 Else there is a precomputed route: the Dashboard Module retrieves the route from memory.  
4.1.2.4 The Dashboard Module sends the next GPS direction to be prepared as the part of the next rendered frame.  
4.1.2.5 The GPS portion of the Heads-Up Display shows the next direction.

**Exceptions**:

4.1.2.6 The GPS sensor is not receiving a satellite signal.

#### 4.1.3 Enable Cruise Control

**Primary Actor:** Driver

**Goal in context:** Drive at a constant speed, without the Driver needing to accelerate.

**Precondition:** The car is driving at a speed S.

**Trigger:** Driver turns on Cruise Control and activates it at desired speed.

**Scenario:**

4.1.3.1 "Cruise Control" button sends signal to the Sensor Fusion.  
4.1.3.2 Sensor Fusion sends signal to the Planning Module to turn on Cruise Control.  
4.1.3.3 Planning Module sends signal to Dashboard Module to render a graphic indicating that Cruise Control has been enabled.  
4.1.3.4 Sensor Fusion sends current speed to the Planning Module, where it is stored.  
4.1.3.5 Planning Module sends current speed to the Vehicle Control Module 50 times per second.  
4.1.3.6 When the Vehicle Control Module receives the speed from the Planning Module, it accelerates or decelerates as necessary to keep vehicle at the designated speed.  
4.1.3.7 System Management Module logs the event of enabling Cruise Control.

**Exceptions:**

4.1.3.8 Vehicle is not in a forward driving gear.

#### 4.1.4 Activate Blind-Spot Warning and Lock-up

**Primary Actor:** Planning Module

**Goal in context:** Alert the Driver of an obstruction when the Driver is attempting to switch lanes, and prevent possible collision by locking the steering wheel in the forward direction.

**Preconditions:** The Car is travelling at some speed S.

**Trigger:** The Driver turns the wheel when there is an object that would cause collision.

**Scenario:**

4.1.4.1 Planning Module computes whether or not the projected trajectory would result in a collision with an object in the Driver's blind spot.  
4.1.4.2 If the computed trajectory would result in a collision: an audio chime is played and a graphic is rendered on the HUD.  
4.1.4.3 The rendered graphic on the HUD indicates which blindspot the object is in: if the object is on their left, a graphic representing the left blindspot is rendered, if the object is on the vehicle's right, a graphic inidcating the right blindspot is rendered.  
4.1.4.4 If the computed trajectory would result in a collision: the Vehicle Control will lock the steering wheel.
4.1.4.5 While the computed trajectory continues to project a collision with an object in the Driver's blind spot, the steering wheel remains locked.

**Exceptions:**

4.1.4.6 Planning Module computes a trajectory that indicates that the vehicle will hit an object in front of it.  
4.1.4.7 The steering wheel has locked once before in the past 15 seconds.

#### 4.1.5 Update On-board Software

**Primary Actor:** Passenger

**Goal in context:** Update the vehicle's software to the newest software avaliable in Alset's servers.

**Preconditions:**

- The vehicle is currently parked and charging.

**Trigger:** Owner parks vehicle at a destination registered as "home".

**Scenario:**

4.1.5.1 System Management module sends request to Alset servers for the most updated software version of the current vehicle's model.  
4.1.5.2 The System management modulde compares the current software version and the one retrieved from the Alset servers.  
4.1.5.3 If the versions do not match, the system management module proceeds. A software update attempt event is logged. If the versions match, the system management module stops attempting an update.
4.1.5.4 The System Management Module will send a request for the Dashboard Module to display a prompt asking the Passenger if they would like to update the car now or schedule the download. The prompt displays the estimated time of the download.  
4.1.5.5 The user selects update the car now  
4.1.5.6 The vehicle will be begin updating the software.
4.1.5.7 System Management sends data to the Vehicle Control module preventing the vehicle from starting the engine.

**Exceptions:**

4.1.5.7 The car has a connection with speed < 10 Kb/s to an Alset's software update server.

### 4.2 Activity Diagrams

#### 4.2.1 Blind Spot Warning

![Activity Diagram - Blind Spot Warning](/docs/images/activity_blind_spot.png)

#### 4.2.2 Enable Weather Smart Traction

![Activity Diagram - Enable Weather Smart Traction](/docs/images/activity_weather.png)

#### 4.2.3 Enable Cruise Control

![Activity Diagram - Enable Cruise Control](/docs/images/activity_cruise.png)

#### 4.2.4 Update On-Board Software

![Activity Diagram - Update Software](/docs/images/activity_update.png)

#### 4.2.5 Enable On-HUD GPS Navigation

![Activity Diagram - Enable On-HUD GPS Navigation](/docs/images/activity_navigation.png)

### 4.3 Sequence Diagrams

#### 4.3.1 Blind Spot Warning

![Sequence Diagram - Blind Spot Warning](/docs/images/sequence_blind_spot.png)

#### 4.3.2 Enable Weather Smart Traction

![Sequence Diagram - Enable Weather Smart Traction](/docs/images/sequence_weather.png)

#### 4.3.3 Enable Cruise Control

![Sequence Diagram - Enable Cruise Control](/docs/images/sequence_cruise.png)

#### 4.3.4 Update On-Board Software

![Sequence Diagram - Update Software](/docs/images/sequence_update.png)

#### 4.3.5 Enable On-HUD GPS Navigation

![Sequence Diagram - Enable On-HUD GPS Navigation](/docs/images/sequence_nav_updated.png)

### 4.4 Class Diagrams

#### 4.4.1 Blind Spot Warning

![Class Diagram - Blind Spot Warning](/docs/images/class_blind_spot.png)

#### 4.4.2 Enable Weather Smart Traction

![Class Diagram - Enable Weather Smart Traction](/docs/images/class_weather.png)

#### 4.4.3 Enable Cruise Control

![Class Diagram - Enable Cruise Control](/docs/images/class_cruise.png)

#### 4.4.4 Update On-Board Software

![Class Diagram - Update Software](/docs/images/class_update.png)

#### 4.4.5 Enable On-HUD GPS Navigation

![Class Diagram - Enable On-HUD GPS Navigation](/docs/images/class_navigation.png)

### 4.5 State Diagrams

#### 4.5.1 Blind Spot Warning

![State Diagram - Blind Spot Warning](/docs/images/state_blind_spot.png)

#### 4.5.2 Enable Weather Smart Traction

![State Diagram - Enable Weather Smart Traction](/docs/images/state_weather.png)

#### 4.5.3 Enable Cruise Control

![State Diagram - Enable Cruise Control](/docs/images/state_cruise.png)

#### 4.5.4 Update On-Board Software

![State Diagram - Update Software](/docs/images/state_update.png)

#### 4.5.5 Enable On-HUD GPS Navigation

![State Diagram - Enable On-HUD GPS Navigation](/docs/images/state_navigation.png)

## 5 Design

### 5.1 Software Architecture

This section discusses various software architectures and how well they can apply to any given subsystem within the IoT HTL.

#### 5.1.1 Data-Centered Architecture

This architecture would be a poor fit for the IoT HTL. Data-centered architecture prioritize many clients accessing a central data-store at once. While it is true that the many sensors could be modeled as clients and sensor data aggregate as the data store, this is a poor model of the sensors' function. Data-centered architectures are slow to retrieve data from a request. In a system where safety is critical in real-time, this is not an acceptable trade-off.

Pros:

- Many clients can be accepted at once
- Client program takes up little space since requests are deferred to central data store
- Data store can be interfaces with different client architectures

Cons:

- Data store is slow to respond with data
- Software stops working if central data store goes down

#### 5.1.2 Data Flow Architecture

The data flow architecture would be a good fit for the sensor fusion. The sensor fusion will collect all of the sensor data in aggregate. Then, the sensor fusion will make sense of that data and use it to generate models that are usable for the planning module. Each filter may be used to process the data in some way, such as removing noise from the LIDAR mapping, synthesizing the data from two sensors, such as using the cameras and light sensors together to make a judgement about the environment.

Pros:

- Models the flow of data well
- Easily applicable to streams of data
- Can be used for MapReduce processing
- Functional programming works well as a solution

Cons:

- No communication between modules modeled

#### 5.1.3 Call Return Architecture

The call return architecture would be a good fit for the driver program (not to be confused with the driver of the car). The driver program will initiate the main system loop. This loop will setup the various controller programs responsible for managing the low-level hardware components of the car, such as the sensors, the engine, the dashboard, the airbags, etc. Loops within those controller subprograms will initiate user-facing, application subprograms, such as the windshield HUD and the console.

Pros:

- Subsystems belong to other subsystems, demonstrating a relationship between them
- All data belonging to one subsystem will only flow down that call path, and the other subsystems will not see that data

Cons:

- Primary actors lack modeling
- Details may be missed due to breadth of view

#### 5.1.4 Object-Oriented Architecture

The object-oriented architecture would be a good fit for the technician interface. Each "noun" of the technician interface can be represented with an object or design pattern - the technician themself, the port, the database of registered technician IDs, and the rest of the system.

Pros:

- Clear what the "verbs" of each part of the system
- Clear which parts of the systems interact with each other
- Properties of each system component are modeled
- Separate objects promotes separation of concerns and abstraction

Cons:

- May be unwieldy for parts of the system where data is passed through many different objects
- Detailed view: modeling each separate object would also become unwieldy
- Flaws of system structure may be lost due to depth of view

#### 5.1.5 Layered Architecture

The layered architecture would be a good fit for all parts of the system that have a graphical user interface. This includes the windshield HUD and the console screen. This could also include any interfacing the vehicle performs with a mobile application. Each deeper layer removes some of the abstraction and exposes more technical details.

Pros:

- Buttons and inputs easily modeled as going into the user interface layer
- Clear which objects, methods, or other components would interface directly with the user

Cons:

- Does not model the relationship between modules
- Does not model the relationship bewteen subsystems

#### 5.1.6 Model View Controller Architecture

The model view controller architecture would not be a good fit for the IoT HTL system. This architecture is suited for a client that browses some store of external data. These include functions like inspecting the data, transforming the data, rendering the data, and modeling the data. The data collected by the sensors by our system would not be available to the average user (the driver). This is because the driver of the vehicle is expected to be a layperson with little experience with the models generated by the sensor fusion for planning to consume.

Pros:

- Models relationship between data viewer and data well
- Models opeations that can be performed on data

Cons:

- Actors besides the client and the data are not modeled
- Relationship between browser and the rest of the system not modeled

#### 5.1.7 Finite State Machine Architecture

The finite state machine architecture would be a good fit for the vehicle control system. The vehicle control system includes many different states for the engine and other vehicle mechanisms (like the trunk or the suspension). The example that we are most familar with is the gear change - each gear is a state. Some state transitions are invalid (such as going from drive directly to reverse) so a finite state machine could be used to model these state changes.

Pros:

- State that system is in is clear at all points
- Conditions that cause a state change are clear at all points

Cons:

- Actors onto the system are not modeled
- Actual messages passed between subsystems not modeled

#### 5.1.8 Conclusion

Based on the above analysis, the system will use the Object-oriented architecture as this architecture best matches the prior experience of the team, and already works very well for one of our use cases (technician log-in).

### 5.2 Interface Design

#### 5.2.1 Driver Interface

- Software elements: ALSET Operating System
- Hardware elements: HUD,key fob, vehicle controlware (wheel, pedal, etc.)

The driver is able to communicate with the vehicle's software through the hardware elements. Each hardware input will be processed by the Vehicle Control to produce the correct vehicle response. The Planning Module may override the driver's input under specific circumstances specified in the use cases, although sometimes the driver will hold ultimate override power.

![Interface-Driver Diagram](/docs/images/Interface-driver.png)

#### 5.2.2 Technician Interface

- Software elements: HTL IOT, ALSET Operating System
- Hardware elements: HUD, technician computer

The technician is able to access the ALSET Operating System via a technician computer. The connection can be done in person or remotely depending on the circumstances. In person, the technician is able to plug the computer into the vehicle via a technician control panel on the vehicle. Remotely, both the technician's computer and the vehicle must have a stable internet connection in order for a connection to be made. Once the connection is successful, the vehicle will automatically communicate its type and software version to the computer. Then, the technician is able to access different elements of the vehicle's software for necessary checks and repairs.

![Interface-Technician Diagram](/docs/images/Interface-Tech-updated.png)

### 5.3 Component-level Design

#### 5.3.1 Top-level Component Diagram

![Top-level Component Diagram](/docs/images/SequenceDiagrams-Top-Level Component-Architecture.drawio.png)

The component-level design breaks down the structural elements into the procedures of how the software functions.
The Sensor Fusion software component takes in data from three inputs, the safty module, and the localization and perceptions units.
The Sensor Fusion acts as an interpreter for these data streams, and then distribute the processed data to the Planning Module, which will then distribute the
interpreted data accordingly to the Vehicle Control, System Management, and Dashboard.
The Technician Interface connects to the greater IOT HTL system via the System Management database.
The below diagram illustrates the exact structural elements, their classes, and the functions along with the datapaths between them.

### 5.3.2 Specified Component Diagrams

More indepth examples of how our components will be broken down into.

![Component Security Diagram](/docs/images/Component__Security_Management__.drawio.png)

![Component System Diagram](/docs/images/Component__System_Management__.drawio.png)

![Component Vehicle Management Diagram](/docs/images/Component__Vehicle_Management_.drawio.png)

## 6. Project Code

![Logger CLass pt. 1](/docs/images/LoggerClass.png)
![Logger Class pt. 2](/docs/images/LoggerClass2.png)
![Vehicle Control Class pt. 1](/docs/images/VehicleControlClass.png)
![Vehicle Control Class pt. 2](/docs/images/VehicleControlClass2.png)
![Sensor Fusion Class pt. 1](/docs/images/SensorFusionClass.png)
![Sensor Fusion Class pt. 2](/docs/images/SensorFusionClass2.png)
![Camera Class pt. 1](/docs/images/CameraClass.png)
![Camera Class pt. 2](/docs/images/CameraClass2.png)
![Planning Class](/docs/images/PlanningClass.png)
![System Management Class](/docs/images/SystemManageClass.png)
![Vehicle Display Class](/docs/images/VehicleDisplayClass.png)


## 7. Testing

### 7.1 Use Case Testing
#### 7.1.1 Blind Spot Warning
Requirement: Driver turns the wheel when there is an object that would cause collision
Precondition: Speed > 0

##### 7.1.1.1 Left turn activated, object detected to the left of the car
Start state: 
currSpeed = 45 mph
lDist = 3 m

Expected Output: 
```
“”
<time> | Received from 'PLN' | Event: Object detected at position 3m to the left of the vehicle 
<time> | Received from 'VCS' | Event: Wheel Lock activated
<time> | Received from 'DSP' | Event: HUD Visual alert
```
End state:
currSpeed = 45 mph
lDist = 3m


##### 7.1.1.2 Right turn activated, object detected to the right of the car
Start state: 
currSpeed = 60 mph
rDist = 1 m


Expected Output: 
```
“”
<time> | Received from 'PLN' |Event: Object detected at position 1m to the left of the vehicle
<time> | Received from 'VCS' |Event: Wheel Lock activated
<time> | Received from 'DSP' |Event: HUD Visual alert
```
End state:
currSpeed = 60 mph
rDist = 1m


#### 7.1.2 Enable Smart Weather Traction
Requirement: Rainy weather is detected

##### 7.1.2.1 Vehicle is at the safety speed
Start state:
WeatherRainy = true
currSpeed = 35 mph
Gear = forward
safteySpeed = 35 mph

Expected Output:
```
“”
<time> | Received from 'PLN' | Event: Safe Speed Calculated to be 35 mph
<time> | Received from 'VCS' | Event: Vehicle is at Safe Speed
```
End state:
WeatherRainy = true
currSpeed = 35 mph
Gear = forward

##### 7.1.2.2 Vehicle is under the safety speed
Start state:
WeatherRainy = true
currSpeed = 20 mph
Gear = forward
safteySpeed = 40 mph

Expected Output:
```
“”
<time> | Received from 'PLN' | Event: Safe Speed Calculated to be 40 mph
<time> | Received from 'VCS' | Event: Vehicle is under Safe Speed
```
End state:
WeatherRainy = true
currSpeed = 20 mph
Gear = forward
safteySpeed = 40 mph

##### 7.1.2.3 Vehicle is over the safety speed, and does not request an override
Start state:
WeatherRainy = true
currSpeed = 75 mph
Gear = forward
Driverinput = false
safteySpeed = 40 mph

Expected Output:
```
“”
<time> | Received from 'PLN' | Event: Safe Speed Calculated to be 40 mph
<time> | Received from 'SFU' | Event: Vehicle is over Safe Speed
<time> | Received from 'VCS' | Event: Decrease Speed to 40 mph
<time> | Received from 'VCS’ | Event: Safe Speed set
```
End state:
WeatherRainy = true
currSpeed = 40 mph
Gear = forward
Driverinput = false
safteySpeed = 40 mph

##### 7.1.2.4 Vehicle is over the safety speed, and requests an override
Start state:
WeatherRainy = true
currSpeed = 68 mph
Gear = forward
Driverinput = true
safteySpeed = 30 mph

Expected Output:
```
“”
<time> | Received from 'PLN' | Event: Safe Speed Calculated to be 30 mph
<time> | Received from 'SFU' | Event: Vehicle is over Safe Speed
<time> | Received from 'VCS' | Event: Decrease Speed to 30 mph
<time> | Received from 'VCS | Event: Driver Override
<time> | Received from 'VCS | Event: Safe Speed overridden
```
End state:
WeatherRainy = true
currSpeed = 68 mph
Gear = forward
Driverinput = true
safetySpeed = 30 mph

##### 7.1.2.5 Vehicle is over the safety speed, and requests an override
Start state:
WeatherRainy = true
currSpeed = 68 mph
Gear = backwards
Driverinput = true
safteySpeed = 30 mph

Expected Output:
```
“”
<time> | Received from 'PLN' | Event: Safe Speed Calculated to be 30 mph
<time> | Received from 'SFU' | Event: Vehicle is over Safe Speed
<time> | Received from 'VCS' | Event: Decrease Speed to 30 mph
<time> | Received from 'VCS | Event: Driver Override
<time> | Received from 'VCS | Event: Safe Speed overridden
```
End state:
WeatherRainy = true
currSpeed = 68 mph
Gear = backwards
Driverinput = true
safteySpeed = 30 mph

#### 7.1.3 Enable Cruise Control
Start state:
currSpeed = 45
Gear = forward
Driverinput = true

Expected Output:
```
“”
<time> | Received from 'VCS' | Event: Cruise Control Activated at 45 mph.
<time> | Received from 'DSP' | Event: Cruise Control (On).
```
End state:
currSpeed = 45
Gear = forward
Driverinput = false

#### 7.1.4 Update On-Board Software
##### 7.1.4.1
Start state:
isCharging == true
gear == "Park"
currVer != newVer
serverConn == true

Input:
```
retrieveUpdate()
queryUser()
promptUser()
getUpdate()
```
Expected Output:
```
“”
<time> | Received from 'SYS' | Event: retrieving update from AllSet servers
<time> | Received from 'PL' | Event: querying the user for when to update
<time> | Received from 'DSP' | Event: displaying graphical question of when to update to user
<time> | Received from 'PL' | Event: user initiates update
<time> | Received from 'SYS' | Event: installing software update
```
EndState:
isCharging == true
gear == "Park"
currVer = newVer
serverConn == true

##### 7.1.4.2 Current software version is not the most up to date but the user does not allow the update to happen presently
Start state:
isCharging == true
gear == "Park"
currVer != newVer
serverConn == true

Input:
```
retrieveUpdate()
queryUser()
promptUser()
```
Expected Output:
```
“”
<time> | Received from 'SYS' | Event: retrieving update from AllSet servers
<time> | Received from 'PL' | Event: querying the user for when to update
<time> | Received from 'DSP' | Event: displaying graphical question of when to update to user
<time> | Received from 'PL' | Event: user denies update
```
EndState:
isCharging == true
gear == "Park"
currVer != newVer
serverConn == true

##### 7.1.4.3 Current Software version is up to date
State state:
isCharging == true
gear == "Park"
currVer == newVer
serverConn == true

Input:
```
retrieveUpdate()
```
Expected Output:
```
“”
<time> | Received from 'SYS' | Event: retrieving update from AllSet servers
```
EndState:
isCharging == true
gear == "Park"
currVer == newVer
serverConn == true

##### 7.1.4.4 Vehicle cannot contact server to retrieve most up to date software version
State:
isCharging == true
gear == "Park"
serverConn == false

Input:
```
retrieveUpdate()
```
Expected Output:
```
""
<time> | Received from 'SYS' | Error: Cannot connect to Alset Servers
```
State:
isCharging == true
gear == "Park"
serverConn == false

#### 7.1.5 Enable On-HUD GPS navigation
##### 7.1.5.1 New route computed when current speed is > 0 and turn has been made
Input:
```
Current speed = 45
Has made turn = true
```
Expected Output:
```
Has new route ready = true
Logged: "Computed a new route."
```

##### 7.1.5.2 New route not computed if the current speed is < 0
Input:
```
Current speed = -45
Has made turn = true
```
Expected Output:
```
Has new route ready = false
Logged: "Invalid current speed read from sensor fusion"
```

### 7.2 Validation Testing

#### 7.2.1 Heads-up Display
##### 7.2.1.1 Heads-up display is powered off when car is
Start State:
```
Car powered = true
```
Input:
```
User presses power button.
```
Output:
```
Heads-up display powered = false
```

##### 7.2.1.2 Heads-up display renders all data when it receives all data
Start State:
currSpeed = 10
currGear = "Forward"

Output:
```
"
Current Gear: "Forward"
Current Speed: 10
"
```


### 7.2.2 Edge-of-Lane
##### 7.2.2.1 Driver’s right wheels are on a lane divider.
Start State:
lDist == 3.0 meter
rDist == 0.0 meter
Driverinput == true

Input:
```
rDist == 0.0 meter
```
Output:
```
""
<time> | Received from 'SFU' | Event: Object detected 4.0 meters right.
<time> | Received from 'SYS' | Error: Edge-of-Lane unavailable.
```
End state:
lDist == 3.0 meter
rDist == 0.0 meter
Driverinput == true

#### 7.2.3 On-HUD GPS Directions
##### 7.2.3.1 Heads-up display does not display any GPS directions if the driver has not entered a destination
Input:
```
Destination location = null
```
Output:
```
""
Logged: "failed - no source destination received from user"
```

##### 7.2.3.2 Heads-up display does not display any GPS directions if no signal can be received from a GPS satellite
Input:
```
Current location = null
```
Output:
```
""
Logged: "failed - no current location accessible from GPS"
```

##### 7.2.3.3 Heads-up display displays next GPS direction
Input:
```
Current location = 40.712778, -74.006111
Destination location = 32.779167, -96.808889
Heading = 0°
```
Output:
```
""
Shortest direction to destination: ↙
Logged: "succesfully computed new route"
```

##### 7.2.3.4 Heads-up display rejects invalid heading (not between 0 and 360)
Input:
```
Current location = 40.712778, -74.006111
Destination location = 32.779167, -96.808889
Heading = -1°
```
Output:
```
""
Logged: "failed - received a heading that was not between 0 and 360"
```
#### 7.2.4 Blind-Spot Warning
##### 7.2.4.1 Blind spot camera is malfunctioning
Start state:
currSpeed = 45 mph

Expected Output:
```
“”
<time> | Received from 'PLN' | Error: Left side Blind-Spot camera malfunction
<time> | Received from 'DSP' | Event:   Left side Blind-Spot camera malfunction. Proceed with caution.
```
End state:
currSpeed = 45 mph

##### 7.2.4.2 The Wheel is unable to lock to prevent the driver from changing lanes
Start state:
currSpeed = 45 mph

Expected Output:
```
“”
<time> | Received from 'PLN' | Event: Object detected at position 3m to the left of the vehicle 
<time> | Received from 'VCS' | Error: Wheel Lock activation failed
<time> | Received from 'DSP' | Error: Blind Spot Warning
```
End state:
currSpeed = 45 mph

#### 7.2.5 Cruise Control
##### 7.2.5.1 Cruise control is not engaged if the vehicle is 0 speed
Input: 
```
Current speed = 0
Cruise control = false
```
Expected Output: 
```
“”
Current speed = 0
Cruise control = false
Logged: “<time> | Received from 'VCS' | Attempted to engage cruise control while car is not moving”
```

##### 7.2.5.2 Cruise control is engaged if the vehicle is at >0 speed
Input:
```
Current speed = 45
```
Expected Output:
```
“”
Cruise Control = true
Current speed = 45
Logged: “<time> | Received from 'VCS' | Cruise control successfully engaged”
```

##### 7.2.5.3 Cruise control is engaged if the vehicle is at low speed
Input:
```
Current speed = 5
Cruise control = false
```
Expected Output:
```
“”
Current speed = 5
Cruise control = true
Logged: “<time> | Received from 'VCS' | Cruise control successfully engaged”
```

#### 7.2.6 Weather and Smart Traction
##### 7.2.6.1 Vehicle cannot connect to the Weather Server
State:
currSpeed == 45
safetyS == 33

Input:
```
weatherStatus()
```
Output:
```
""
<time> | Received from 'SFU' | Error: Cannot connect to Alset Servers
```
EndState:
currSpeed == 45
safetyS == 33

##### 7.2.6.2 Cannot calculate SafteySpeed because GPS cannot  retrieve the current road’s speed limit
State:
currSpeed == 45
WeatherRainy == true

Input:
```
getSafeSpeed()
```
Output:
```
""
<time> | Received from 'PL' | Error: Cannot calculate safetySpeed, current location’s speed limit unknown
```
EndState:
currSpeed == 45
WeatherRainy == true

##### 7.2.6.3 Vehicle is already driving at <= Safety Speed
State:
currSpeed == 25
safetySpeed == 30
WeatherRainy == true

Input:
```
safetySpeedSet(30)
```
Output:
```
""
<time> | Received from 'VCS' | Error: currSpeed ‘25’ is less than or equal to safetySpeed ‘30’, not overriding speed.
```
EndState:
currSpeed == 25
safetySpeed == 30
WeatherRainy == true

##### 7.2.6.4 Driver is accelerating as RainWeather is detected disallowing the speed to be altered automatically
State:
currSpeed == 63
safetySpeed == 30
WeatherRainy == true
gasPedal == true

Input:
```
safetySpeedSet(30)
```
Output:
```
""
<time> | Received from 'VCS' | Error: cannot override manual driver input
```
EndState:
currSpeed == 65
safetySpeed == 30
WeatherRainy == true
gasPedal == true
#### 7.2.7 Car-to-car Communication
##### 7.2.7.1 The drivers opts out of the IOT HTL Car-To-car communications network while the car is active on the network
Input: The drivers opts out of the IOT HTL Car-To-car communications network while the car is active on the network
Start state:
joinNetwork = false

Expected Output:
```
“”
<time> | Received from 'SYS' | Event: IOT HTL security has detected a potentially unsafe change to the software. 
<time> | Received from 'SYS' | Event: Disconnect Vehicle from Car-to-Car Communications
```
End state:
joinNetwork = false

##### 7.2.7.2 The IOT HTL network is tampered with from outside sources (e.g. getting hacked)
Start state:
joinNetwork = true

Expected Output:
```
“”
<time> | Received from 'HTL' | Event: Driver has opted out of Car-to-Car Communications
<time> | Received from 'PLN' | Event: Request data from IOT HTL vehicles
<time> | Received from 'SYS' | Error: Driver has opted out of Car-to-Car Communications
```
End state:
joinNetwork = false

#### 7.2.8 Adaptive Headlights/Highbeams
##### 7.2.8.1 User set external lights off at night, and approaching vehicles turn on headlights.
Start state:
headlights == 0.0
fDist = 5.0 meter
Driverinput = true

Expected Output:
```
“”
<time> | Received from 'SFU' | Event: Object detected 5.0 meters ahead. 
<time> | Received from 'DSP' | Event: Adaptive headlights activated.
<time> | Received from 'VCS' | Event: Headlights turned on. 
```
End state:
headlights == 1.0
fDist = 1.0 meter
Driverinput = true

#### 7.2.9 Key FOB
#### 7.2.9.1 Invalid key FOB distance to car
State:
FOBdist == -1223
canButtonStart == false

Input:
```
detectFob()
```
Output:
```
""
<time> | Received from 'SFU' | Error: Invalid distance of FOB '-1223'
```
EndState:
FOBdist == -1223
canButtonStart == false

#### 7.2.10 Logging

##### 7.2.10.1 A log is sent with a message exceeding 1024 bytes
Input:
```
inLog("VCS", "0......1023")
```
Expected Output:
```
""
<time> | Received from 'VCS' | LogError: Log message exceeds 1024 bytes
```

#### 7.2.11 Software Update
##### 7.2.11.1 A software is Update is attempted while the vehicle is not in park
Start state:
isCharging == false
gear == “Forward”
currVer != newVer

Input:
```
getUpdate()
```
Expected Output:
```
""
<time> | Received from 'SYS' | Error: Update was attempted while the vehicle was not in park and charging
```
End state:
isCharging == false
gear == "Forward"
currVer != newVer

##### 7.2.11.2 A software is Update is attempted while the vehicle is not charging
Start state:
isCharging == false
gear == “Park”
currVer != newVer

Input:
```
getUpdate()
```
Expected Output:
```
""
<time> | Received from 'SYS' | Error: Update was attempted while the vehicle was not in park and charging
```
End state:
isCharging == false
gear == "Park"
currVer != newVer

##### 7.2.11.3 A software is Update is attempted although current software is the most up-to-date
Start state:
isCharging == true
gear == “Park”
currVer == newVer

Input:
```
getUpdate()
```
Expected Output:
```
""
<time> | Received from 'SYS' | Error: Update was attempted although current software is the most up-to-date
```
End state:
isCharging == true
gear == "Park"
currVer == newVer

[Back to Top](#1-introduction)
