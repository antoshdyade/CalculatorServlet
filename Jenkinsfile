pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/antoshdyade/CalculatorServlet.git' 
        DOCKER_IMAGE = 'calculator-app:latest'
        CONTAINER_NAME = 'calculator-container'
        TOMCAT_INTERNAL_PORT = '8080'
        EXTERNAL_PORT = '8081' // The port exposed on the host machine
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: "${REPO_URL}"
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}")
                }
            }
        }

        stage('Deploy to Docker') {
            steps {
                script {
                    // Stop and remove any existing container
                    sh 'docker stop ${CONTAINER_NAME} || true'
                    sh 'docker rm ${CONTAINER_NAME} || true'
                    
                    // Run the new container
                    sh '''
                    docker run -d --name ${CONTAINER_NAME} \
                    -p ${EXTERNAL_PORT}:${TOMCAT_INTERNAL_PORT} \
                    ${DOCKER_IMAGE}
                    '''
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
    }
}

