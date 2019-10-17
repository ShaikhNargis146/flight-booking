FROM java:8-jdk
MAINTAINER shaikh Nargis <shaikhnargis20@gmail.com>

RUN apt-get update \
    && apt-get install -y git

RUN git clone https://github.com/ShaikhNargis146/flight-booking.git \
    && cd flight_booking \
    && chmod +x mvnw \
    && ./mvnw -DskipTests=true package

ADD ./target/flight_booking-0.0.1-SNAPSHOT.jar /root/
CMD ["java", "-jar", "/root/flight_booking-0.0.1-SNAPSHOT.jar"]

EXPOSE 9003