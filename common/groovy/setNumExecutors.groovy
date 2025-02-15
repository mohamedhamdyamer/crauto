import jenkins.model.*

def jenkins = Jenkins.get()
jenkins.setNumExecutors(0)
jenkins.save()
