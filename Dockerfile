FROM ubuntu:16.04

MAINTAINER Vaibhav Kansagara

# update
RUN apt-get update

# for slack notification
RUN apt-get -y install curl

# Install for running 32-bit applications
# 64-bit distribution capable of running 32-bit applications
# https://developer.android.com/studio/index.html
RUN apt-get -y install lib32stdc++6 lib32z1

# Install Java8
RUN apt-get install -y openjdk-8-jdk

RUN mkdir -p /user/local/android-sdk-linux

RUN apt-get install zip unzip && \
	apt-get -y install wget

# Environment variables
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV ANDROID_HOME /user/local/android-sdk-linux
ENV PATH ${PATH}:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools


RUN cd ${ANDROID_HOME} && \
    wget -q https://dl.google.com/android/repository/sdk-tools-linux-3859397.zip -O android_tools.zip && \
    unzip android_tools.zip && \
    rm android_tools.zip


# for accepting all licence agreements
RUN ls /user/local/android-sdk-linux/
RUN yes | $ANDROID_HOME/tools/bin/sdkmanager "platforms;android-29"

# RUN which adb
# RUN which android

WORKDIR /build
COPY . /build/

ENV GRADLE_USER_HOME=/build/.gradle
RUN chmod +x ./gradlew
