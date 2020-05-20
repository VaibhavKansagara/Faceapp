pipeline {
  agent any
  stages 
    {
    stage('Build') {
      steps {
        sh './gradlew --refresh-dependencies clean assembleDebug test connectedAndroidTest'
      }
    }
  }
}
