def call() {
    withMaven(maven: 'Maven') {
        echo "Running unit tests..."
        sh "mvn test"
    }
} 