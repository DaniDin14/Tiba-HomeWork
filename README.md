# Selenium Java Project - YouTube Music Automation

This project is designed to automate tasks on YouTube Music using Selenium with Java.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Architecture](#architecture)
- [Tests](#tests)
- [Examples](#examples)
- [FAQ](#faq)
- [Known Issues](#known-issues)
- [License](#license)
- [Acknowledgements](#acknowledgements)
- [Contact](#contact)
- [Version History](#version-history)
- [References](#references)

---

## Installation

- Java Development Kit (JDK)
- Selenium WebDriver
- TestNG
- Log4j
- WebDriverManager
- Allure (optional for reporting)

### Setup:

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/DaniDin14/Tiba-HW.git
   ```
   
2. Import the project into your preferred Java IDE.

3. Install the required dependencies using Maven or manually download and configure.

4. Configure your project settings (e.g., browser type, timeout) in `./Configuration/DataConfig.xml`.

## Usage

To run the project, execute the test suite `youtubeSearchAndFilter.java` located in the `SanityTest` package.

```java
    @Test
    public void test01_Search() {
        webFlows.searchSong(getData("songQuery"), getData("songURL"), getData("artistName"));
    }
```

## Features

- Searching for songs on YouTube Music.
- Adding filters to search results.
- Choosing a video from the list based on URL.
- Skipping ads.
- Closing YouTube Music popup.

## Architecture

### Overview

The architecture of this Selenium Java project follows a modular and organized structure to facilitate maintainability, readability, and reusability of code. It employs the Page Object Model (POM) design pattern, which separates page elements and actions from the test logic, promoting a more efficient and scalable automation framework.

### Components

1. **Page Objects**

   Purpose: Page Objects represent web pages or components of a web application. They encapsulate the elements and interactions with those elements on a specific page.

   Location: Located in the `PageObjects` package.

   Example: `searchPage.java` contains locators elements to the YouTube Music search page.

2. **Extensions**

   Purpose: Extensions contain reusable methods that perform common actions or operations. These methods serve as building blocks for test cases.

   Location: Located in the `Extensions` package.

   Example: `uiActions.java` contains methods for interacting with web elements like clicking, sending text, and waiting for elements.

3. **Utilities**

   Purpose: Utilities contain essential functionalities and configurations that are used throughout the project. This includes WebDriver initialization, configuration reading, logging, and more.

   Location: Located in the `Utilities` package.

   Example: `commonOps.java` handles WebDriver initialization, browser setup, and common operations like reading configuration data.

4. **WorkFlows**

   Purpose: WorkFlows represent the high-level actions or tasks that a user might perform in the application. They orchestrate the sequence of actions on multiple pages.

   Location: Located in the `WorkFlows` package.

   Example: `webFlows.java` orchestrates the steps for searching a song, adding filters, playing it, and more.

5. **SanityTest**

   Purpose: SanityTest contains the actual test cases. These test cases use the Page Objects, Extensions, and WorkFlows to perform specific tasks and make assertions.

   Location: Located in the `SanityTest` package.

   Example: `youtubeSearchAndFilter.java` contains a test case for searching a song, adding filters, and asserting results.

6. **Listeners**

   Purpose: Listeners are used to customize and extend the behavior of TestNG. They are used for actions such as taking screenshots on test failures.

   Location: Located in the `Utilities` package.

7. **Configuration**

   Purpose: Configuration files store environment-specific data and settings, such as timeouts, URLs, and browser types. These values are read and used throughout the project.

   Location: `./Configuration/DataConfig.xml`.

### Workflow

1. **Test Case Execution**:

    - Test cases from the `SanityTest` package are executed using TestNG.
    - TestNG utilizes listeners for reporting and customization.

2. **Page Objects**:

    - Page Objects represent web pages or components.
    - They encapsulate elements and interactions with those elements.

3. **Extensions**:

    - Extensions contain reusable methods for interacting with web elements.

4. **Utilities**:

    - Utilities handle WebDriver initialization, configuration reading, logging, and more.

5. **WorkFlows**:

    - WorkFlows define high-level actions a user might perform.
    - They orchestrate sequences of actions across multiple pages.

6. **Assertions**:

    - Test cases in `SanityTest` use Page Objects, Extensions, and WorkFlows to perform tasks and make assertions.

### Advantages

- **Modularity**: The project is organized into distinct modules (Page Objects, Extensions, WorkFlows) for easier maintenance and reusability.

- **Separation of Concerns**: POM separates the UI elements and actions from the test logic, promoting a cleaner codebase.

- **Reusability**: Extensions contain reusable methods that can be utilized across multiple test cases.

- **Ease of Maintenance**: Changes in UI or functionality are localized to the respective Page Objects, reducing the impact on other parts of the codebase.

- **Scalability**: New test cases can be added easily by leveraging existing Page Objects and Extensions.

## Tests

The project includes automated tests located in the `SanityTest` package.

## Examples

```java:
    // Search for a song
    webFlows.searchSong("I Will Survive - Alien song", "/watch?v=ybXrrTX3LuI", "Gloria Gaynor");
```

## FAQ

- **Q**: Can I run the tests in headless mode? 
- **A**: Yes, you can configure headless mode in the browser options in commonOps.java.

- **Q**: Can I run the tests on different browsers?
- **A**: Yes, you can configure the browser type by modifying the `Browser Type` value in the `./Configuration/DataConfig.xml` file, to run tests on different browsers such as Chrome, Firefox, or Edge.

- **Q**: How can I change the timeout duration for element interactions?
- **A**: You can adjust the timeout duration by modifying the `TimeOut` value in the `./Configuration/DataConfig.xml` file.

- **Q**: Is it possible to run the tests in parallel?
- **A**: Yes, TestNG supports parallel test execution. You can configure parallel execution settings in the TestNG XML file.

- **Q**: How do I generate Allure reports for the test results?
- **A**: After running the tests, execute the Allure command to generate and view the reports. Refer to the Allure documentation for detailed instructions.

- **Q**: Can I customize the log output format?
- **A**: Yes, you can modify the log format by adjusting the Log4j configuration file located at `./Configuration/log4j2.xml`.

## Known Issues

- Issue with finding a smart timeout after pressing the "View Count" filter. The element takes longer than expected to load.

### Attempted Solutions

1. Tried implementing a smart timeout using various types of `wait.until(expectedCondition)` strategies.
2. Added a wait to the DOM using JavaScript execution.
3. Implemented a static wait using `Thread.sleep` to give the page additional time to load. While this method provided a temporary fix, it's not a sustainable solution and may lead to inefficiencies.
4. Utilized a counter before and after the action, but this did not resolve the issue.

### Current Approach

To address this issue, the most effective solution has been to print the page source to the logger in debug mode. This approach has proven more reliable than using `Thread.sleep`, providing better visibility into the state of the page and allowing for more precise timing in handling the element.


## License
- This project is licensed under the MIT License.

### Acknowledgements

- Selenium WebDriver
- TestNG
- Log4j
- Allure

## Contact

For any questions or feedback, please feel free to reach out:

- **Email:** [danieldayan14@gmail.com](mailto:danieldayan14@gmail.com)

### Version History

- 1.0.0 (2023-10-01): Initial release.

### References
 
- Selenium Documentation: https://www.selenium.dev/documentation/
    
- TestNG Documentation: https://testng-docs.readthedocs.io

- Log4j Documentation: https://logging.apache.org/log4j/2.x/manual/index.html

- Allure Documentation: https://docs.qameta.io/allure/# Tiba-HomeWork
