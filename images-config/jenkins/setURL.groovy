import jenkins.model.*

def jenkinsUrl = System.getenv('Jenkins_URL')

def jenkinsLocationConfiguration = JenkinsLocationConfiguration.get()
jenkinsLocationConfiguration.setUrl(jenkinsUrl)
jenkinsLocationConfiguration.save()
