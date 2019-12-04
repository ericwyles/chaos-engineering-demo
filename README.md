This version builds upon the WireMock example and introduces [ChaosToolkit](https://chaostoolkit.org/) with the [WireMock driver](https://docs.chaostoolkit.org/drivers/wiremock/) .

![branch](branch.png)

To run this version you will need an api key for AlphaVantage.

You can get a license key here: https://www.alphavantage.co/support/#api-key

And set it in the ALPHAVANTAGE_API_KEY environment variable when launching the app.

With this version, all calls to alphavantage go through a wiremock.

Start it using this command from the 'wiremock' directory

```
./run_wire_mock.sh
```

With the wire mock in place we can now simulate failures of the service and see how our app behaves.

With ChaosTookit we can run experiments and simulate failures:

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