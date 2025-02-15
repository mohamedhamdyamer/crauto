FROM jenkins/inbound-agent:latest-jdk17

# Using the root user to install packages ...
USER root

# Installing "expect" ...
RUN apt-get update
RUN apt-get install --assume-yes expect

# Installing "wget" ...
RUN apt-get update
RUN apt-get install --assume-yes wget

# Installing "gpg" ...
RUN apt-get update
RUN apt-get install --assume-yes gpg

# Installing "Ansible" ...
RUN wget -O- "https://keyserver.ubuntu.com/pks/lookup?fingerprint=on&op=get&search=0x6125E2A8C77F2818FB7BD15B93C4A3FD7BB9C367" | gpg --dearmour -o /usr/share/keyrings/ansible-archive-keyring.gpg
RUN echo "deb [signed-by=/usr/share/keyrings/ansible-archive-keyring.gpg] http://ppa.launchpad.net/ansible/ansible/ubuntu jammy main" | tee /etc/apt/sources.list.d/ansible.list
RUN apt-get update
RUN apt-get install --assume-yes ansible

# Switching back to user "jenkins" ...
USER jenkins

HEALTHCHECK NONE
