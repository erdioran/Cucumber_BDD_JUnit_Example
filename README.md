
<b> <h1>   ErdiOran Case with Cucumber BDD & JUnit  </h1> </b> 

## Run 
 Run this class -> [/src/test/java/com/erdioran/definitions/Runner.java](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/java/com/erdioran/definitions/Runner.java)

## Failed Cases Run
Failed cases in the [Runner](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/java/com/erdioran/definitions/Runner.java) class are written to the `"/target/failedrerun.txt"` file.

[RunnerFailed](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/java/com/erdioran/definitions/RunnerFailed.java) class only runs tests in the fail cases file.

Run this class -> [/src/test/java/com/erdioran/definitions/RunnerFailed.java](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/java/com/erdioran/definitions/RunnerFailed.java)

## Report 
It is created inside this file after the test is complete -> `/test-output`
It can be viewed as both html and pdf.

## Project Detail


-  The browser can be selected by changing the "browser" variable of the [app.properties](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/resources/app.properties) file.

-  It reads the properties file with the [ConfigManager](https://github.com/erdioran/ErdiOran_UI/blob/master/src/main/java/com/erdioran/utils/ConfigManager.java) class and sends the information to the [DriverManager](https://github.com/erdioran/ErdiOran_UI/blob/master/src/main/java/com/erdioran/base/DriverManager.java) class to create the driver.

-  Gets "url" and "test data" from file [data.json](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/resources/data.json)

-  Reads [data.json](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/resources/data.json) with  [DataManager](https://github.com/erdioran/ErdiOran_UI/blob/master/src/main/java/com/erdioran/utils/DataManager.java)

-  Test report settings are in [extent.properties](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/resources/extent.properties) and [spark-config.xml](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/resources/spark-config.xml) files under  "/src/test/resources" file.

-  Case feature -> [case.feature](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/resources/features/case.feature)

-  Case Definitions -> [CaseDefinitions](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/java/com/erdioran/definitions/CaseDefinitions.java)

-  Project objects -> [objectRepository](https://github.com/erdioran/ErdiOran_UI/tree/master/src/test/java/com/erdioran/objectRepository) folder

-  Project Hooks -> [Hooks](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/java/com/erdioran/definitions/Hooks.java)

-  Fixed methods I use for automation -> [AutomationMethods](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/java/com/erdioran/base/AutomationMethods.java)

-  The methods I created for this case project ->  [ProjectMethods](https://github.com/erdioran/ErdiOran_UI/blob/master/src/test/java/com/erdioran/base/ProjectMethods.java)


|         | VERSION |
| -------| ----- |
| Cucumber   | 6.9.1  |
| Selenium   | 4.1.1  |
| JUnit   | 4.13.2 |
| Extentreports   | 5.0.9  |
