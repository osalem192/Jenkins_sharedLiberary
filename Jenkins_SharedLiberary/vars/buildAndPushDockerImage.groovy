def call(Map params) {
    echo "Building docker image..."
    withCredentials([usernamePassword(credentialsId: $(params.credentials), usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh "docker build -t ${params.imageName}:${params.imageTag} ."
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh "docker push ${params.imageName}:${params.imageTag}"
    }
} 