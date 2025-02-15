FROM jenkins/jenkins:latest-jdk17

# Environment variables
## Disable the initial Setup Wizard
ENV JAVA_OPTS=-Djenkins.install.runSetupWizard=false

# Recommended Plugins
RUN jenkins-plugin-cli --plugins cloudbees-folder
RUN jenkins-plugin-cli --plugins antisamy-markup-formatter
RUN jenkins-plugin-cli --plugins build-timeout
RUN jenkins-plugin-cli --plugins credentials-binding
RUN jenkins-plugin-cli --plugins timestamper
RUN jenkins-plugin-cli --plugins ws-cleanup
RUN jenkins-plugin-cli --plugins ant
RUN jenkins-plugin-cli --plugins gradle
RUN jenkins-plugin-cli --plugins workflow-aggregator
RUN jenkins-plugin-cli --plugins github-branch-source
RUN jenkins-plugin-cli --plugins pipeline-github-lib
RUN jenkins-plugin-cli --plugins pipeline-graph-view
RUN jenkins-plugin-cli --plugins git
RUN jenkins-plugin-cli --plugins ssh-slaves
RUN jenkins-plugin-cli --plugins matrix-auth
RUN jenkins-plugin-cli --plugins pam-auth
RUN jenkins-plugin-cli --plugins ldap
RUN jenkins-plugin-cli --plugins email-ext
RUN jenkins-plugin-cli --plugins mailer
RUN jenkins-plugin-cli --plugins dark-theme

# Additional Plugins
RUN jenkins-plugin-cli --plugins docker-plugin
RUN jenkins-plugin-cli --plugins docker-workflow
RUN jenkins-plugin-cli --plugins ansible
RUN jenkins-plugin-cli --plugins terraform

# Groovy scripts to run as part of the setup
COPY --chown=jenkins:jenkins common/groovy/setupSecurity.groovy /usr/share/jenkins/ref/init.groovy.d/setupSecurity.groovy
COPY --chown=jenkins:jenkins common/groovy/setURL.groovy /usr/share/jenkins/ref/init.groovy.d/setURL.groovy
COPY --chown=jenkins:jenkins common/groovy/setNumExecutors.groovy /usr/share/jenkins/ref/init.groovy.d/setNumExecutors.groovy
COPY --chown=jenkins:jenkins common/groovy/setupCloud.groovy /usr/share/jenkins/ref/init.groovy.d/setupCloud.groovy
COPY --chown=jenkins:jenkins common/groovy/createCredentials.groovy /usr/share/jenkins/ref/init.groovy.d/createCredentials.groovy
COPY --chown=jenkins:jenkins common/groovy/createPipeline.groovy /usr/share/jenkins/ref/init.groovy.d/createPipeline.groovy

USER jenkins

HEALTHCHECK NONE
