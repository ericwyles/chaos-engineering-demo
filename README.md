 In this version we introduce Resilience4J Circuit Breaker and Fallbacks to make the app more resilient. We also add a second remote service that we can retrieve prices from when the first service is down.

![branch](https://ericwyles.com/wp-content/uploads/2019/12/branch_4-1024x469.png)

 Start the app, and then start the wiremock.

```
./run_wire_mock.sh
```

We can execute our ChaosToolkit experiments again and see what happens to the application.

```
chaos run chaostoolkit/experiment-success.json
chaos run chaostoolkit/experiment-fault.json
chaos run chaostoolkit/experiment-delay.json
```

In this version, we are handling faults very well but a delay from AlphaVantage would cause or service to go out of response time tolerance.

# Continue
Continue to [05_Resilience4j_Faults_And_Delays](../../tree/05_Resilience4j_Faults_And_Delays)