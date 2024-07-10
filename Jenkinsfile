pipeline {
    agent any

    tools {
        // Укажите версию Gradle, которая установлена на Jenkins-агенте
        gradle 'Gradle_7.5.1'
    }

    environment {
        // Установите переменные окружения, если нужно
        ALLURE_RESULTS = 'build/allure-results'
        ALLURE_REPORT = 'build/allure-report'
    }

    stages {
        stage('Checkout') {
            steps {
                // Склонируйте репозиторий
                git url: 'https://github.com/Bladgrif/Innocourse-FinalCertification'
            }
        }

        stage('Build') {
            steps {
                // Соберите проект
                sh './gradlew clean build'
            }
        }

        stage('Test') {
            steps {
                // Запустите тесты
                sh './gradlew test'
            }
        }

        stage('Allure Report') {
            steps {
                // Генерация Allure отчета
                allure includeProperties: false, jdk: '', results: [[path: env.ALLURE_RESULTS]]
            }
        }
    }

    post {
        always {
            // Архивируйте артефакты
            archiveArtifacts artifacts: '**/build/libs/*.jar', allowEmptyArchive: true

            // Опубликуйте Allure отчет
            allure includeProperties: false, jdk: '', results: [[path: env.ALLURE_RESULTS]]
        }
        failure {
            // Отправьте уведомление при сбое (например, по электронной почте)
            mail to: 'almazran@mail.ru',
                 subject: "Build ${env.BUILD_NUMBER} Failed",
                 body: "Build ${env.BUILD_NUMBER} has failed. Please check the Jenkins console for details."
        }
    }
}
