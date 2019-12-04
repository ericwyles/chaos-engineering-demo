This application keeps the same Resilience4J configuration as previous, and now we've wrapped a CompletableFuture around the AlphaVantage call.


![branch](branch.png?raw=true)

Start the app, and then start the wiremock

```
./run_wire_mock.sh
```

With ChaosTookit we can run experiments and simulate failures:

```
chaos run chaostoolkit/experiment-success.json
chaos run chaostoolkit/experiment-fault.json
chaos run chaostoolkit/experiment-delay.json
```

With resilience4j in place and the CompletableFuture for timeouts, we pass all scenarios.

Continue to [06_ChaosMonkey](tree/06_ChaosMonkey)
