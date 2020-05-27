pipeline {
  environment {
    registry = "vaibhavkansagara/faceapp"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  agent any
  stages {
  	stage('Clean') {
      steps {
        // Clean the app and refersh dependincies
        sh './gradlew --refresh-dependencies clean'
      }
    }
    stage('Build APK') {
      steps {
        // Finish building and packaging the APK
        sh './gradlew assembleDebug'

        // Archive the APKs so that they can be downloaded from Jenkins
        archiveArtifacts '**/*.apk'
      }
    }
    stage('Static analysis') {
      steps {
        // Run Lint and analyse the results
        sh './gradlew lintDebug'
        androidLint pattern: '**/lint-results-*.xml'
      }
    }
    stage('Install') {
      steps {
        // Install the app
        sh './gradlew installDebug'
      }
    }
    stage('Test') {
      steps {
        // Test the app
        sh './gradlew connectedDebugAndroidTest'
      }
    }

    stage('DockerHub') {
        stages{
          stage('Build Image') {
            steps{
              script {
                dockerImage = docker.build registry + ":$BUILD_NUMBER"
              }
            }
          }
          stage('Push Image') {
            steps{
              script {
                docker.withRegistry( '', registryCredential ) {
                  dockerImage.push()
                }
              }
            }
          }
        }
    }

    stage('Deploy') {
      agent any
      steps {
        script {
          step([$class: "RundeckNotifier",
          rundeckInstance: "Rundeck",
          options: """
            BUILD_VERSION=$BUILD_NUMBER
          """,
          jobId: "46ba880e-6f36-42d2-8d0f-e2118cd42869"])
        }
      }
    }
    
  }
}
