Youtube Selenium Test Automation [![STATUS](https://img.shields.io/badge/Project-Work%20In%20Progress-red.svg)]
========
Small home project to improve myself when it comes to selenium automation skills.
Selenium is an umbrella project encapsulating a variety of tools and
libraries enabling web browser automation. With the use of Selenium and ChromeDriver, I will automate the most of youtubes' public interface and check that the functions are usable. The automation test-cases will be derived from the requirement specifications. 

## Why WebDriver instead of Selenium IDE
I only use WebDriver in this project.
Selenium IDE is a Record and Playback tool, which is very easy to use, but it's very unreliable. Record and playback is typically a frowned upon in web applications. Since web applications are frequently changed, the IDE is not an ideal solution for a production environment, because of the maintenance nightmare that may arise. For a website such as YouTube which is under constant change, it's incredibly impractical to use in the long term. Test cases such as verifying adding videos to playlist and then confirming number of videos etc, would be so so so tiresome in Selenium IDE.
And also, programming in Java is much more fun (not sarcasm)


## Requirements
This is a WIP. Only OSX with ChromeDriver is currently supported.
* [Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* `java` and `jar` on the PATH
* Selenium ChromeDriver must be installed beforehand (see https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver)
* The OS running must be OSX 10.9, 10.10 or 10.11.


### Optional Requirements
* IDE such as intellij or eclipse will make set-up of project much easier.

## Current steps to run the project
```
Clone the project
```
```
Import project with intellij/eclipse
```
```
Install dependencies through maven
```
```
Run one of the testsuites
```

## Some previews of current tests made
```
Test functionality of youtubes left menu
```
![Test functionality of youtubes left menu](https://im4.ezgif.com/tmp/ezgif-4-59170279d2.gif)

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Selenium](https://github.com/SeleniumHQ/selenium) - Tools for web browser automation
* [TestNG](https://github.com/SeleniumHQ/selenium) - Testing framework 

## Authors
* **Uy Nguyen** - [UyNG](https://github.com/UyNG)
