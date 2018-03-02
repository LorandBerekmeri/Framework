$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/abc.feature");
formatter.feature({
  "line": 1,
  "name": "My feature",
  "description": "",
  "id": "my-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 7441307189,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Verify the Top scroll",
  "description": "",
  "id": "my-feature;verify-the-top-scroll",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@cucumber-test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I navigate on the page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Application is displayed",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I scroll to the bottom of the page",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I click the top scroll",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "logo is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.navigation()"
});
formatter.result({
  "duration": 5362771291,
  "status": "passed"
});
formatter.match({
  "location": "CommonSteps.applicationIsDisplayed()"
});
formatter.result({
  "duration": 106864969,
  "status": "passed"
});
formatter.match({
  "location": "CommonSteps.iScrollToTheBottomOfThePage()"
});
formatter.result({
  "duration": 30830479,
  "status": "passed"
});
formatter.match({
  "location": "CommonSteps.iClickTheTopScroll()"
});
formatter.result({
  "duration": 677540466,
  "status": "passed"
});
formatter.match({
  "location": "CommonSteps.logoIsDisplayed()"
});
formatter.result({
  "duration": 37157707,
  "status": "passed"
});
formatter.after({
  "duration": 181243828,
  "status": "passed"
});
});