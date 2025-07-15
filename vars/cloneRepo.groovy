def call(Map params) {
    git branch: "$(params.branch)", url: "$(params.url)"
} 