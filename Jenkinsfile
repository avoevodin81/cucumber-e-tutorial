pipeline {
    agent any
    tools {
        maven "MAVEN"
    }
    stages {
        stage("checkout repo") {
            steps {
                git branch: 'master',
                    credentialsId: 'cd25dd89-041f-4d30-a249-d1ec63c92df9',
                    url: 'https://github.com/avoevodin81/cucumber-e-tutorial.git'
            }
        }

        stage('Initialize') {
            steps {
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
        }

        stage("build") {
            steps {
                sh 'mvn compile'
            }
        }

        stage("run tests") {
            steps {
                sh 'mvn test'
            }
        }

        stage('Generate HTML report') {
                cucumber buildStatus: 'UNSTABLE',
                        reportTitle: 'My report',
                        fileIncludePattern: '**/*.json',
                        trendsLimit: 10,
                        classifications: [
                            [
                                'key': 'Browser',
                                'value': 'Firefox'
                            ]
                        ]
            }

    }
}