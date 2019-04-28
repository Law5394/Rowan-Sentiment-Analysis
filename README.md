<h1 align="center"> Rowan Sentiment Analysis </h1> <br>
<p align="center">
  <a href="https://github.com/Law5394/Rowan-Sentiment-Analysis">
    <img  src="https://images.pexels.com/photos/34533/owl-glitter-stuffed-animal-cute.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260" width="450">
  </a>
</p>

<p align="center">We heard what you said on twitter.</p> 

* :telephone_receiver:  Call the api!  
* :bar_chart:  Watch the trends!  
* :star:  Star us!

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [API](#API)
- [Build](#build)
- [Run](#run)
- [License](#license)

## Introduction
[![Total Downloads](https://travis-ci.org/Law5394/Rowan-Sentiment-Analysis.svg?branch=master)](https://travis-ci.org/Law5394/Rowan-Sentiment-Analysis) 
[![Website todo](https://img.shields.io/website-up-down-green-red/http/todo.svg)](http://todo/)
[![GitHub license](https://img.shields.io/github/license/Law5394/Rowan-Sentiment-Analysis.svg)](https://github.com/Law5394/Rowan-Sentiment-Analysis/blob/master/LICENSE)
[![GitHub release](https://img.shields.io/github/release/Law5394/Rowan-Sentiment-Analysis.svg)](https://GitHub.com/Law5394/Rowan-Sentiment-Analysis/releases/)  

Sentiment analysis (also known as opinion mining or emotion AI) refers to the use of natural language processing, text analysis, computational linguistics, and biometrics to systematically identify, extract, quantify, and study affective states and subjective information. We at team *TODO* empower our users by providing near real-time sentiment analysis, accessible via API or
through interactive visualizations.
  
## Features
- [x] Is a "fairly" unique idea
- [x] Uses a dynamic web language.
- [x] Uses JavaScript
- [x] Stores information in a database
- [x] Uses a secure database
- [x] Does not use software installs
- [x] Looks nice
- [x] has a RESTful API
- [x] uses MVC
- [ ] must be presented in front of the class on the day of the final.

## API

## Build
* Requires JDK8

1. Run the following via the terminal
```console
# Clone and cd into the repo
git clone https://github.com/Law5394/Rowan-Sentiment-Analysis && cd Rowan-Sentiment-Analysis

# Make an application.properties file and provide it with the required credentials
cp server/src/main/resources/example.properties \
server/src/main/resources/application.properties

# Make a gradle.properties file and provide it with the required credentials
cp tweet_streamer/example.properties tweet_streamer/gradle.properties

# Build the project
./gradlew build 
```
* Alternatively you can utilize the Gradle integration in your favorite IDE/Editor.

## Run
* Requires JDK8
1. [Build](#build) the project
2. Run the following via the terminal

```console
# Run the server subproject
./gradlew bootRun     

# Run the tweet_streamer subproject
./tweet_streamer/build/deployable/tweet_streamer 
```
* Alternatively you can utilize the Gradle integration in your favorite IDE/Editor.
## License
This project is licensed under GNU General Public License version 3 (https://opensource.org/licenses/gpl-3.0.html)
