pipeline {
    agent any

    tools {
        maven 'M3'
    }

    parameters {
        booleanParam defaultValue: true, description: '', name: 'skipTests'
        string defaultValue: 'tags/jenkins-2.153', description: '', name: 'branch', trim: true
    }

    stages {
        stage ('Info') {
            steps {
                sh 'echo "skipTests = ${skipTests}"'
                sh 'echo "branch = ${branch}"'
            }            
        }
        stage ('Build') {

        }
    }


}