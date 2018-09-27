# Integration Testing sample using Spring boot

This project is showing how to execute integration tests in a SpringBoot application with `mvn verify`.

On branch Master, integration tests are run against an existing MongoDB. Maven is not in charge of starting/managing
a MongoDB server.

We're expecting here that MongoDB is already up and running. e.g. This can be achieved by a CI Process.

- For Jenkins pipeline : https://jenkins.io/doc/book/pipeline/docker/#running-sidecar-containers
- For Gitlab CI : https://docs.gitlab.com/ee/ci/services/