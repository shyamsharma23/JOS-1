pipeline {
  agent any
  stages {
    stage('Clone') {
      steps {
        git(url: 'https://github.com/shyamsharma23/JOS-1', branch: 'main')
      }
    }

    stage('Build') {
      steps {
        sh 'mvn -Dmaven.test.failure.ignore=true clean package'
        tool 'M3'
      }
    }

    stage('Building image') {
      steps {
        sh '''pwd
sudo docker build -t shyamsharma23/walk-app:$BUILD_ID .
sudo docker tag shyamsharma23/walk-app:$BUILD_ID shyamsharma23/walk-app:latest
sudo docker images'''
      }
    }

  }
}