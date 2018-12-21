pipeline {
    agent any

    tools {
        maven 'M3'
    }

    parameters {
        booleanParam defaultValue: true, description: '', name: 'skipTests'
        string defaultValue: 'master', description: '', name: 'branch', trim: true
    }

    stages {
        stage ('Info') {
            steps {
                sh 'echo "skipTests = ${skipTests}"'
                sh 'echo "branch = ${branch}"'
                library 'myLib'
                nothing()
                nothing.sayHello()
            }            
        }

        // stage ('Clean WS') {
        //     steps {
        //         deleteDir()
        //     }
        // }

        stage ('Checkout') {
            steps {
                dir ('sources'){
                    git branch: "${branch}", url: "https://github.com/jenkinsci/jenkins.git"
                }
            }
        }

        stage ('Build') {
            steps {
                dir ('sources'){
                    sh "mvn clean package -DskipTests=${skipTests}"
                }
            }
        }
    }

    post {
        success {
            sh 'Build ${BUILD_NUMBER} is success'
        }
    }


}