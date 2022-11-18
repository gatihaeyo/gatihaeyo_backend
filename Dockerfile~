FROM openjdk:17 AS builder

ARG WORKSPACE=/home/gatihaeyo
ARG BUILD_SPACE=${WORKSPACE}/gatihaeyo-infrastructure/build/libs

WORKDIR ${WORKSPACE}
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

WORKDIR ${BUILD_SPACE}
RUN jar -xf *.jar

FROM openjdk:17

ARG WORKSPACE=/home/gatihaeyo
ARG BUILD_SPACE=${WORKSPACE}/gatihaeyo-infrastructure/build/libs
ARG DEPLOY_PATH=${WORKSPACE}/deploy

COPY --from=builder ${BUILD_SPACE}/org ${DEPLOY_PATH}/org
COPY --from=builder ${BUILD_SPACE}/BOOT-INF/lib ${DEPLOY_PATH}/BOOT-INF/lib
COPY --from=builder ${BUILD_SPACE}/META-INF ${DEPLOY_PATH}/META-INF
COPY --from=builder ${BUILD_SPACE}/BOOT-INF/classes ${DEPLOY_PATH}/BOOT-INF/classes

WORKDIR ${DEPLOY_PATH}

EXPOSE 8080/tcp
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]