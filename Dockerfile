FROM centos:centos6
MAINTAINER  Yuan Zhencai <515265763@qq.com>
ENV         ACTIVATOR_VERSION 1.2.10
ENV         DEBIAN_FRONTEND noninteractive
# INSTALL JDK7
RUN yum update -y && yum install -y unzip
RUN yum install -y wget && wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u11-b12/jdk-8u11-linux-x64.rpm
RUN rpm -ivh jdk-8u11-linux-x64.rpm && rm jdk-8u11-linux-x64.rpm

# INSTALL TYPESAFE ACTIVATOR
RUN curl -O http://downloads.typesafe.com/typesafe-activator/$ACTIVATOR_VERSION/typesafe-activator-$ACTIVATOR_VERSION.zip 
RUN unzip typesafe-activator-$ACTIVATOR_VERSION.zip -d / && rm typesafe-activator-$ACTIVATOR_VERSION.zip && chmod a+x /activator-$ACTIVATOR_VERSION/activator
ENV PATH $PATH:/activator-$ACTIVATOR_VERSION

# COMMIT PROJECT FILES
ADD         app /root/app
ADD         test /root/test
ADD         conf /root/conf
ADD         public /root/public
ADD         build.sbt /root/
ADD         project/plugins.sbt /root/project/
ADD         project/build.properties /root/project/
# TEST AND BUILD THE PROJECT -- FAILURE WILL HALT IMAGE CREATION
RUN         cd /root; activator test stage
RUN         rm /root/target/universal/stage/bin/*.bat
# TESTS PASSED -- CONFIGURE IMAGE
WORKDIR     /root
ENTRYPOINT  ["target/universal/stage/bin/play-java-docker"]
EXPOSE      9000