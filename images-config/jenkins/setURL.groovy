import jenkins.model.*

def jenkinsURL = System.getenv('Jenkins_URL')

def jenkinsLocationConfiguration = JenkinsLocationConfiguration.get()
jenkinsLocationConfiguration.setUrl(jenkinsURL)
jenkinsLocationConfiguration.save()
