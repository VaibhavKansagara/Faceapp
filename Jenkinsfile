pipeline {
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
  }
}
