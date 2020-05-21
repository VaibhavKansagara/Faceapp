FROM ubuntu:16.04

MAINTAINER Vaibhav Kansagara

# update
RUN apt-get update

RUN ./gradlew --refresh-dependencies clean
RUN ./gradlew assembleDebug
RUN archiveArtifacts '**/*.apk'
RUN ./gradlew lintDebug
RUN androidLint pattern: '**/lint-results-*.xml'


# RUN sh './gradlew installDebug'
# RUN sh './gradlew connectedDebugAndroidTest'

# Cleaning
RUN apt-get clean