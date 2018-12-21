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
        stage ('Build') {
            steps {
                sh 'echo "Hello!"'
            }
        }
    }


}