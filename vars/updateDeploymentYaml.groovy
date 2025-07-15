def call(Map params) {
    sh "sed -i 's|image:.*|image: ${params.imageName}:${params.imageTag}|' deployment.yaml"
} 