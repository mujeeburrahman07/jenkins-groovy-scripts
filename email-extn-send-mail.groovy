node {
    stage 'Question'
    echo "Pipeline Started"
    input 'Run the build?'
    notify('Want to run the build?')
    
    stage 'Parallel'
    parallel p1: { echo "p1" }, p2:{ echo "p2" }
}

def notify(status) {
	emailext (
	  to: 'veersudhir83@gmail.com',
	  replyTo: 'noreply@jenkins-local.com',
	  subject: "${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
	  body: """<p>${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
	      <p>Check console output at <a href='${env.BUILD_URL}console'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</p>"""
	)
}
