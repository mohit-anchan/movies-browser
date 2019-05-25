pipeline{
    agent any

    stages{
        stage ('Compile stage'){
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

        stage ('Running tests'){
            steps{
                withMaven(maven: 'maven_3_6_1') {
                    sh 'mvn package'
                }
            }
        }
    }
}