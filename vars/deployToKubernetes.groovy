def call(String credentials, String namespace = "default") {
    withCredentials([file(credentialsId: "${credentials}", variable: 'KUBECONFIG_FILE')]) {
        sh '''
        export KUBECONFIG=$KUBECONFIG_FILE
        kubectl apply -f deployment.yaml -n ${namespace}
        '''
    }
}   