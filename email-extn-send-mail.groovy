node {
    notify('Started')
   // mail bcc: '', body: 'Hi', cc: '', from: 'noreply@jenkins-quest-global.com', replyTo: '', subject: 'Hi', to: 'sudheer.veeravalli@quest-global.com'
}
def notify(status) {
	emailext (
	  to: "${mailRecipients}",
	  replyTo: "noreply@jenkins.com",
	  subject: "${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
	  body: """<p>${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
	      <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</p>"""
	)
}
