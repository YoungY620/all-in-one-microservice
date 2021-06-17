# Micro-Service (Spring Cloud Netflix) All-In-One

## Introduction

This project is a exercise of Spring Cloud, which is about e-shop order management.

## Usage

### Skywalking serice observation

[Details about Skywalking java agent configure](http://skywalking.apache.org/docs/main/v8.6.0/en/setup/service-agent/java-agent/readme/)

The agents are in `./<module folder>/agent/` , you can config your own Skywalking OAP host and port.

You can also change the `Makefile` to choose your own java agent.

### Initiate Database

The `.sql` scripts is in `/scripts/e_shop_init.sql` . Run it.

### Build & Trail

To build all the components:

```bash
make build
```

To set up a specific component instance:

```bash
## the eureka service register
make run-register 
```

the other instances are similar, like `run-consumer` `run-provider` `run-gateway`.

You can also build specific one by running `run build-*` to refresh its target.

To clean targets and logs:

```bash
make clean
```

More details are in `./Makefile` .
