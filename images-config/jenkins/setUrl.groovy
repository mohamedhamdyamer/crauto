import jenkins.model.*

def Jenkins_URL = System.getenv('Jenkins_URL')

def jenkinsLocationConfiguration = JenkinsLocationConfiguration.get()
jenkinsLocationConfiguration.setUrl(Jenkins_URL)
jenkinsLocationConfiguration.save()
