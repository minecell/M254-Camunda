# Camunda

In diesem Beispiel geht es darum mithilfe von Camunda TODO in die tat umsetzen

## BPMN für dieses Beispiel

![Create customer rating process](src/main/resources/create-customer-rating.png)

Im ersten Formular gibt der Lehrer den Namen des Schülers eingeben.
Als nächstes erhält der Schüler eine Prüfung mit bei der er eigene Antworten formulieren muss. 
Danach kann der Lehrer die Antworten des Schülers mit seinen Lösungen vergleichen und 0 bis 4 Punkte pro Antwort vergeben.
Im nächsten Schritt berechnet ein Script ob der Schüler mindestens 75% der maximalen Punktzahl erreicht hat.
Beim Gateway wird entschieden ob der Schüler sein Zertifikat erhält oder ob er eine Mittelung erhält die im mitteilt das er die Prüfung leider nicht bestanden hat.

## Model Class

Die Daten der Prüfung werden in einer Class abgespeichert:

```java
public class CustomerData {

	protected String answer1;
	protected String answer2;
	protected String answer3;
	protected int answer1points;
	protected int answer2points;
	protected int answer3points;
	protected String name;

  // ... getters / setters omitted
}
```

## Im ersten Formular wird eine Java Object Variable erstellt

The process instance is started using a form. The form is a plain HTML form which is displayed
inside Camunda Tasklist (or inside a custom application using the camunda-bpm-sdk-js library).

```html
<form name="customerForm" role="form">

  <script cam-script type="text/form-script">

    // angular form works on scope object
    var customerData = $scope.customerData = {
      addresses : []
    };

    // hook into camunda SDK JS Form Lifecycle
    camForm.on('form-loaded', function() {

      // declare variable 'customerData' incuding metadata for serialization
      camForm.variableManager.createVariable({
        name: 'customerData',
        type: 'Object',
        value: customerData,
        valueInfo: {
          // indicate that object is serialized as json
          serializationDataFormat: 'application/json',
          // provide classname of java object
          objectTypeName: 'org.camunda.bpm.example.usertask.embedded.serialized.model.CustomerData'
        }
      });

    });

  </script>

  <h3>Customer Data</h3>

  <div class="control-group">
    <label class="control-label" for="firstname">Firstname</label>
    <div class="controls">
      <input id="firstname"
             class="form-control"
             type="text"
             required 
             ng-model="customerData.firstname">
    </div>

  <!-- ... Additional fields ommitted -->

  </div>
</form>
```

The custom java script creates a Javascript Object and binds it to the angular `$scope` of the form
as a variable named `customerData`. We then hook into the lifecycle of camunda SDK JS Form and
create a process variable named `customerData` and provide additional type information and metadata
used for serialization. The Object should be serialized as "application/json" and the type of the
object is `org.camunda.bpm.example.usertask.embedded.serialized.model.CustomerData`.

The form itself is a plain angular js form (see `ng-model` binding of input field).


## Accessing the Object Variable

In a Java Delegate, the `customerData` variable can be retrieved in the regular way:

```java

public class CalculateRating implements JavaDelegate {

  public void execute(DelegateExecution execution) throws Exception {

    CustomerData customerData = (CustomerData) execution.getVariable("customerData");

    // ...
  }
}
```

## Accessing an existing Java Object Variable in a Task Form

In a task form, an existing Java Object variable can be accessed using custom Javascript. The
pattern is to first fetch the value of the variable and then bind it to an angular scope variable:


```javascript
camForm.on('form-loaded', function() {
  // fetch the variable named 'customerData'
  camForm.variableManager.fetchVariable('customerData');
});

camForm.on('variables-fetched', function() {
  // after the variables are fetched, bind the value of customerData to a angular
  // scope value such that the form can work on it
  $scope.customerData = camForm.variableManager.variable('customerData').value;
});
```

## Running the example

1. [Download a Camunda BPM Distribution](http://camunda.org/download)
2. Checkout this repository using Git
3. Build the example using `mvn clean package`
4. Deploy the `.war` file located in the `target/` folder to the server
5. Open Camunda Tasklist using the URL [http://localhost:8080/camunda/app/tasklist](http://localhost:8080/camunda/app/tasklist)
6. Start a new instance of the Process.


