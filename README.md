# Jenkins Shared Library

This repository contains a Jenkins Shared Library that modularizes common pipeline steps for application deployment, testing, and Kubernetes operations.

## Structure

```
Jenkins_SharedLiberary/
├── vars/
│   ├── cloneRepo.groovy                # Clone a Git repository
│   ├── runUnitTests.groovy             # Run unit tests with Maven
│   ├── buildApp.groovy                 # Build the application with Maven
│   ├── buildAndPushDockerImage         # Build and push Docker image to DockerHub
│   ├── deleteLocalDockerImage.groovy   # Delete a local Docker image
│   ├── updateDeploymentYaml.groovy     # Update deployment YAML with new image
│   └── deployToKubernetes.groovy       # Deploy to Kubernetes
└── README.md
```

## Usage

### Use Only Selected Steps

You can call any step directly in your Jenkinsfile, in any order, and with any parameters. For example, to only clone the repo and run unit tests:

```groovy
@Library('Jenkins_SharedLiberary') _

pipeline {
    agent any
    stages {
        stage('Clone Repo') {
            cloneRepo(branch: 'main', url: 'https://github.com/osalem192/Jenkins_App.git')
        }
        stage('Run Unit Tests') {
            runUnitTests()
        }
    }
}
```

### 3. Step Reference & Parameters

- **cloneRepo(Map params)**
  - `branch`: Git branch to clone (e.g., 'main')
  - `url`: Repository URL
- **runUnitTests()**
  - No parameters
- **buildApp()**
  - No parameters
- **deleteLocalDockerImage(Map params)**
  - `imageName`: Docker image name
  - `imageTag`: Docker image tag
- **updateDeploymentYaml()**
  - No parameters
- **deployToKubernetes(String credentials)**
  - `credentials`: Jenkins credentials ID for kubeconfig file

### 4. Example: Custom Pipeline

```groovy
@Library('Jenkins_SharedLiberary') _

node {
    cloneRepo(branch: 'main', url: 'https://github.com/osalem192/Jenkins_App.git')
    runUnitTests()
    // buildApp()
    // deleteLocalDockerImage(imageName: 'osalem192/jenkinsapp', imageTag: 'v123')
    // updateDeploymentYaml()
    // deployToKubernetes('kubeconfig')
}
```

## Notes
- You can use any combination of steps as needed.
- All steps are reusable and parameterized for flexibility.
- The main pipeline (`myPipeline()`) is just a convenience for the full deployment flow.

---

**For questions or improvements, please open an issue or PR.** 