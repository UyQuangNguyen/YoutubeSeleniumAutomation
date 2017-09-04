Youtube Selenium Test Automation [![STATUS](https://img.shields.io/badge/Project-Work%20In%20Progress-red.svg)]
========
Small home project to improve my skills when it comes to selenium automation.
This is a public repository for those who discover the repo and want to learn some test-automation too (incredibly fun and satisfying). The code has A LOT of documentation in form of java doc which might seem excessive, but this is just to ensure that new readers will understand what’s going on. Also, the green java doc text in IntelliJ is pleasing to the eyes :)

Selenium is an umbrella project encapsulating a variety of tools and
libraries enabling web browser automation. With the use of Selenium and WebDriver (chrome), I will automate the most of youtube's public interface and check that the functions are usable. The automation test-cases will be derived from the requirement specifications. 

## Why WebDriver instead of Selenium IDE
I only use WebDriver in this project.
Selenium IDE is a Record and Playback tool, which is very easy to use, but it's very unreliable. Record and playback are typically frowned upon in web applications. Since web applications are frequently changed, the IDE is not an ideal solution for a production environment, because of the maintenance nightmare that may arise. For a website such as YouTube which is under constant change, it's incredibly impractical to use in the long term. Test cases such as verifying adding videos to playlist and then confirming the number of videos etc would be so so so tiresome in Selenium IDE.
And also, programming in Java is much more fun (not sarcasm)


## Learning basic testautomation & PageObject Pattern
For those of you reading and using the code to learn basic test automation in WebDriver, this is a great place to start.
Like similar aspects of programming, it's not hard to get started, and you can start by just looking at some basic examples of
such as using the driver to go to google.com and do a simple search. The main challenge of test automation lies in test engineering.
Creating code that is easy to maintain, robust, and easy to understand is the challenge. 

I will be following the idea of PageObjects design pattern which is a concept that helps simplify test maintenance by creating layers of an object whose responsibility is knowing how to interact with the test-object, leaving the tests the responsibility of defining correct behavior.  When the application changes, I'll only have to adjust few lines of codes, and not dozens or hundreds of test cases.
More on the PageObject pattern can be read on  https://automatetheplanet.com/page-object-pattern/
If you're new to test-automation, I also recommend you to start reading about the common pitfalls etc.

Adding breakpoints to an automated test, and going through the code line for line is also extremely helpful if you don't understand what each line does.

## Requirements
This is a WIP. Only OSX with ChromeDriver is currently supported.
* [Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* `java` and `jar` on the PATH
* Google Chrome
* Selenium ChromeDriver (atleast v.3.5.1) must be installed beforehand (see https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver)
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
Install dependencies through maven, might take a while
```
```
Run one of the testsuites in XMLsuites folder

```

### Set up allure for testoverview after suites have been run
After executing whichever test suite in XMLsuite, allure can be set up for test overview which
shows current failing and passed tests. Allure needs to be installed.

```
Open terminal/command line
```
```
cd YoutubeSeleniumAutomation/Tes
```
```
allure serve target/allure-results
```

End results will look something like this

![Test functionality of youtubes left menu](https://i.gyazo.com/a8a0d9b479225ec51ecefc71fe48c947.png)


## Some previews of current tests made
```
Test functionality of youtubes left menu
```
![Test functionality of youtubes left menu](https://gyazo.com/54eaceace49d294ff102ae0251baec9c.gif)

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Selenium](https://github.com/SeleniumHQ/selenium) - Tools for web browser automation
* [TestNG](https://github.com/SeleniumHQ/selenium) - Testing framework 
* [Allure] (https://github.com/allure-framework/allure2) - Lightweight report tool 

## Authors
* **Uy Nguyen** - [UyNG](https://github.com/UyNG)
