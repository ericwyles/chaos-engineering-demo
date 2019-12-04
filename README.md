This version builds upon the WireMock example and introduces [ChaosToolkit](https://chaostoolkit.org/) with the [WireMock driver](https://docs.chaostoolkit.org/drivers/wiremock/) .

[Diff to previous branch](https://github.com/ericwyles/chaos-engineering-demo/compare/02_WireMock...03_ChaosToolkit)

![branch](branch.png?raw=true)

The application logic is unchanged, but we have ChaosToolkit to orchestrate testing and experimenting now.

Start the app and then start the wiremock.

```
./run_wire_mock.sh
```

With ChaosTookit we can run experiments and simulate failures.

# Run a Successful Experiment

```
chaos run chaostoolkit/experiment-success.json
chaos run chaostoolkit/experiment-fault.json
chaos run chaostoolkit/experiment-delay.json
```


We can see from the output that our app is not handling faults or delays within tolerance. Example:

```
chaos run chaostookit/experiment-fault.json
[2019-12-04 11:14:06 INFO] Validating the experiment's syntax
[2019-12-04 11:14:06 INFO] Experiment looks valid
[2019-12-04 11:14:06 INFO] Running experiment: What if the remote service throws a fault?
[2019-12-04 11:14:06 INFO] Steady state hypothesis: Application responds and wiremock server is runnin
g
[2019-12-04 11:14:06 INFO] Probe: retrieve a stock price
[2019-12-04 11:14:07 INFO] Probe: Wiremock server is running
[2019-12-04 11:14:08 INFO] Steady state hypothesis is met!
[2019-12-04 11:14:08 INFO] Action: adding a mappings
[2019-12-04 11:14:08 INFO] Steady state hypothesis: Application responds and wiremock server is runnin
g
[2019-12-04 11:14:08 INFO] Probe: retrieve a stock price
[2019-12-04 11:14:08 CRITICAL] Steady state probe 'retrieve a stock price' is not in the given toleran
ce so failing this experiment
[2019-12-04 11:14:08 INFO] Let's rollback...
[2019-12-04 11:14:08 INFO] Rollback: delete a mapping
[2019-12-04 11:14:08 INFO] Action: delete a mapping
[2019-12-04 11:14:08 INFO] Experiment ended with status: deviated
[2019-12-04 11:14:08 INFO] The steady-state has deviated, a weakness may have been discovered
```



Notes on this version:

A few observations about this version:
* We can use ChaosToolkit to help us by defining declarative, repeatable test scenarios.
* ChaosToolkit will also handle the details of reconfiguring the WireMock for scenarios and rolling back after.
* The application still does not handle faults in the remote service.

Continue to [04_Resilience4j_Faults](../../tree/04_Resilience4j_Faults)