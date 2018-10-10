# interop-switch

This project provides the inplementation of /participants and its associated endpoints in PDP API.

**Methods**: 

**Reference**: 

Contents:

- [Deployment](#deployment)
- [Configuration](#configuration)
- [API](#api)
- [Logging](#logging)
- [Tests](#tests)
- [Docker](#docker)

## Deployment

Project is built using Maven and uses Circle for Continous Integration.

### Installation and Setup

#### Anypoint Studio
* [https://www.mulesoft.com/platform/studio](https://www.mulesoft.com/platform/studio)
* Clone https://github.com/LevelOneProject/interop-scheme-adapter.git to local Git repository
* Import into Studio as a Maven-based Mule Project with pom.xml
* Go to Run -> Run As Configurations.  Make sure interop-scheme-adapter project is highlighted.

#### Standalone Mule ESB
* [https://developer.mulesoft.com/download-mule-esb-runtime](https://developer.mulesoft.com/download-mule-esb-runtime)
* Add the environment variable you are testing in (dev, prod, qa, etc).  Open <Mule Installation Directory>/conf/wrapper.conf and find the GC Settings section.  Here there will be a series of wrapper.java.additional.(n) properties.  create a new one after the last one where n=x (typically 14) and assign it the next number (i.e., wrapper.java.additional.15) and assign -DMULE_ENV=dev as its value (wrapper.java.additional.15=-DMULE_ENV=dev)
* Download the zipped project from Git
* Copy zipped file (Mule Archived Project) to <Mule Installation Directory>/apps

### Run Application

#### Anypoint Studio
* Run As Mule Application with Maven

#### Standalone Mule ESB
* CD to <Mule Installation Directory>/bin -> in terminal type ./mule

## Configuration

[pom.xml](./pom.xml) and [circle.yml](./circle.yml) can be found in the repo, also linked here

## API

Below are the RAML and OpenAPI spec for reference

* RAML [here](./src/main/api/interop-switch.raml)

## Logging

Server path to logs is: <mule_home>/logs/interop-account-lookup.log for example: /opt/mule/mule-dfsp1/logs/interop-scheme-adapter.log

Currently the logs are operational and include information such as TraceID and other details related to the calls or transactions such as path, method used, header information and payer/payee details.

## Tests

This project doesn't have the desired test coverege, since this is just a pass-through for most of the end-points and will be replaced with natively implemented features/end-points in the near future.

#### Anypoint Studio
* Run Unit Tests
* Test API with Anypoint Studio in APIKit Console
* Verify Responses in Studio Console output

Tests are run as part of executing the Maven pom.xml as mvn clean package. Also, tests can be run by running com.l1p.interop.spsp.SpspClientProxyFunctionalTest java class as JUnit Test.

## Docker
* Build Image - docker build -t interop-switch .
* Run Container - docker run --name interop-switch -d -p 8500:8088 --env-file=src/main/resources/interop-switch-env.list interop-switch