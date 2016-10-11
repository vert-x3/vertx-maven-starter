= Vert.x Maven Starter

This project is a template to start your own Vert.x project using Apache Maven.

== Prerequisites

* Apache Maven
* JDK 8+

== Getting started

Create your project with:

[source]
----
git clone https://github.com/vert-x3/vertx-maven-starter.git PROJECT_NAME
----

Replace `PROJECT_NAME` with the name of your project.

On Linux and MacOSx (or Windows with `bash`), if you want to go faster and generate an already configured project run:

[source]
----
curl http://vertx.io/assets/starter-scripts/create-vertx-project-maven.sh -o vertx-create-maven-project.sh; bash vertx-create-maven-project.sh
----

== Running the project

Once you have retrieved the project, you can check that everything works with:

[source]
----
mvn test exec:java
----

The command compiles the project and runs the tests, then  it launches the application, so you can check by yourself. Open your browser to http://localhost:8080. You should see a _Hello World_ message.

== Anatomy of the project

The project contains:

* a `pom.xml` file
* a _main_ verticle file (src/main/java/io/vertx/starter/MainVerticle.java)
* an unit test (src/main/test/io/vertx/starter/MainVerticleTest.java)

== Start to hack

1. Delete the `.git` directory
2. Open the `pom.xml` file and customize the `groupId`, `artifactId` and `version`. You can also change the `main.verticle` property to use your own package name and verticle class.
3. Run `redeploy.sh` (or `redeploy.bat` on Windows) and the project recompiles while editing.

NOTE: the `redeploy` script are also configurable

== Building the project

To build the project, just use:

----
mvn clean package
----

It generates a _fat-jar_ in the `target` directory.
