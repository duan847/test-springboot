FROM anapsix/alpine-java:8_server-jre_unlimited

VOLUME /tmp

MAINTAINER duanjw

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /home/work/bow-eureka

WORKDIR /home/work/bow-eureka

EXPOSE 8080

ADD ./target/demo-1.0.0.jar ./

CMD java -Djava.security.egd=file:/dev/./urandom -jar demo-1.0.0.jar

