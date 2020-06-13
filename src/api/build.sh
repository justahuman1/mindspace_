#!/bin/bash

cd ../../config
export $(cat api.env | xargs)
cd ../src/api/src
mvn package
