
<b> <h1>   ErdiOran Case with Cucumber BDD & JUnit  </h1> </b> 

## Run 
 Run this class -> `/src/test/java/com/erdioran/definitions/Runner.java`

## Failed Cases Run
Failed cases in the <b>"Runner.java"</b> class are written to the `"/target/failedrerun.txt"` file.

<b>"RunnerFailed.java"</b> class only runs tests in the fail cases file.

Run this class -> `/src/test/java/com/erdioran/definitions/RunnerFailed.java`

## Report 
It is created inside this file after the test is complete -> `/test-output`
It can be viewed as both html and pdf.

## Project Detail
The browser can be selected by changing the "browser" variable of the `"/src/test/resources/app.properties"` file.

It reads the properties file with the `"/src/main/java/com/erdioran/utils/ConfigManager.java"` class and sends the information to the `"/src/main/java/com/erdioran/base/DriverManager.java"` class to create the driver.

Gets "url" and "test data" from file `"/src/test/resources/data.json"` 

Reads `"/src/main/java/com/erdioran/utils/DataManager.java"` with "aaa".

Test report settings are in `"extent.properties"` and `"spark-config.xml"` files under `"/src/test/resources"` file.

Case feature -> `/src/test/resources/features/case.feature`

Case Definitions -> `/src/test/java/com/erdioran/definitions/CaseDefinitions.java`

Project objects -> `/src/test/java/com/erdioran/objectRepository`

Prokect Hooks -> `/src/test/java/com/erdioran/definitions/Hooks.java`

Fixed methods I use for automation -> `/src/test/java/com/erdioran/base/AutomationMethods.java`

The methods I created for this case project ->  `/src/test/java/com/erdioran/base/ProjectMethods.java`



|         | VERSION |
| -------| ----- |
| Cucumber   | 6.9.1  |
| Selenium   | 4.1.1  |
| JUnit   | 4.13.2 |
| Extentreports   | 5.0.9  |
