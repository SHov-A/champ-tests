### Project for testing the https://wwechampions.com

##### The software
<ul>
    <li>Java v1.8.0_251</li>
    <li>Maven v3.6.3</li>
    <li>browser drivers - all the latest versions</li>
</ul>
For running this project write <code>mvn test</code> in terminal.
<br>
Use config file to define browser name and url address. Default browser and driver
are <code>chrome</code> and <code>chromedriver</code> respectively.
<br>
It works with chrome, gecko and opera drivers in two operating systems(windows and linux).
IED driver works only for windows operating system, it doesn't support linux operating system.
<br>
After running test report is generated in <code>target</code> folder with name <code>testChampionsReport</code>, if test fails the screen shot of related page appears in report.
