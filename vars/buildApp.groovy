def call() {
    withMaven(maven: 'Maven') {
        echo "Building app..."
        sh "mvn package"
    }
} 