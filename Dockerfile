FROM openliberty/open-liberty:kernel-java11-openj9-ubi as staging

COPY --chown=1001:0 target/dealer-master-management-1.0.0.jar \
                    /staging/fat-dealer-master-management-1.0.0.jar

RUN springBootUtility thin \
 --sourceAppPath=/staging/fat-dealer-master-management-1.0.0.jar \
 --targetThinAppPath=/staging/thin-dealer-master-management-1.0.0.jar \
 --targetLibCachePath=/staging/lib.index.cache

FROM openliberty/open-liberty:kernel-java11-openj9-ubi

ARG VERSION=1.0
ARG REVISION=SNAPSHOT

LABEL \
  vendor="Saudi Business Machines" \
  vendor.url="www.sbm.com.sa" \
  service.group="Siebel" \
  service.name="Dealer Master Management Service" \
  service.image.version="$VERSION" \
  service.image.revision="$REVISION" \
  service.version="$VERSION-$REVISION" \
  service.summary="Dealer Master Management Microservice" 

RUN cp /opt/ol/wlp/templates/servers/springBoot2/server.xml /config/server.xml

COPY --chown=1001:0 --from=staging /staging/lib.index.cache /lib.index.cache
COPY --chown=1001:0 --from=staging /staging/thin-dealer-master-management-1.0.0.jar \
                    /config/dropins/spring/thin-dealer-master-management-1.0.0.jar

RUN configure.sh