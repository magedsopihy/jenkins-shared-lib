#!/usr/bin/env groovy

def call(String imageName){
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]){
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USERNAME --password-stdin"
        sh "docker push $imageName"
    }
}