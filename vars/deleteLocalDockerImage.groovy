def call(Map params) {
    sh "docker rmi ${params.imageName}:${params.imageTag}"
} 