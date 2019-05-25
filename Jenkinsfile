pipeline{
    agent any

    stages{
        stage ('Compiling code'){
            steps{
               withMaven(maven: 'maven_3_6_1') {
                sh 'mvn clean compile'
               }
            }
        }

        stage ('Running tests'){
            steps{
                withMaven(maven: 'maven_3_6_1') {
                    sh 'mvn test'
                }
            }
        }

        stage ('Packaging the JAR'){
            steps{
                withMaven(maven: 'maven_3_6_1') {
                    sh 'mvn package'
                }
            }
        }
    }
}