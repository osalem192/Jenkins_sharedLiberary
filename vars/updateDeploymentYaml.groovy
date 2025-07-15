def call() {
    sh "sed -i 's|image:.*|image: ${env.IMAGE_NAME}:${env.IMAGE_TAG}|' deployment.yaml"
} 