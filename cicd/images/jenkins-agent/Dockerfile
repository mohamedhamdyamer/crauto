FROM ubuntu

RUN apt update
RUN apt install --assume-yes npm
RUN npm i npm-groovy-lint
RUN pip install checkov
RUN apt install --assume-yes yamllint
RUN apt install --assume-yes ansible-lint
