pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Bladgrif/Innocourse-FinalCertification'
            }
        }
        stage('Build') {
            steps {
                script {
                    sh './gradlew clean build'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh './gradlew test'
                }
            }
        }
        stage('Allure Report') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        results: [[path: 'build/allure-results']]
                    ])
                }
            }
        }
    }
    post {
        always {
            junit '**/build/test-results/test/*.xml'
            archiveArtifacts artifacts: '**/build/libs/*.jar', allowEmptyArchive: true
            allure([
                includeProperties: false,
                jdk: '',
                results: [[path: 'build/allure-results']]
            ])
        }
        success {
            mail to: 'you@example.com',
                 subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                 body: """Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' was successful.
                 Check it out here: ${env.BUILD_URL}"""
        }
        failure {
            mail to: 'you@example.com',
                 subject: "FAILURE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                 body: """Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' failed.
                 Check it out here: ${env.BUILD_URL}"""
        }
    }
}
