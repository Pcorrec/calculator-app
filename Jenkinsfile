pipeline {
    agent any

    stages {
        stage('Remove container') {
            steps {
                echo '-----REMOVE DOCKER CONTAINER-----'
                bat 'docker stop demo-calculator || VER > NUL'
            }
        }
        stage('Checkout') {
            steps {
                echo '-----CHECKOUT-----'
                git branch: 'main', url: 'https://github.com/Pcorrec/calculator-app.git'
            }
        }
        stage('Compile') {
            steps {
                echo '-----COMPILE-----'
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo '-----TEST-----'
                bat 'mvn test'
            }
        }
        stage('Package') {
            steps {
                echo '-----PACKAGE-----'
                bat 'mvn package -DskipTests'
            }
        }
        stage('Docker build') {
            steps {
                echo '-----DOCKER BUILD-----'
                bat 'docker build -t calculator-app .'
            }
        }
        stage('Docker run') {
            steps {
                echo '-----DOCKER RUN-----'
                bat 'docker run --rm -p 8180:8180 -d --name demo-calculator calculator-app'
            }
        }
    }
}
