#!/bin/bash

java -jar \
  -Dserver.port=8079 \
  ./build/libs/hours-0.0.1-SNAPSHOT.jar > ~/hours.innexgo.com.txt &
