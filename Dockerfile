FROM solr:8

COPY ./restaurants.json /opt/solr/server/solr/restaurants/

CMD ["docker exec -it 9c5f96bb0e88746c142d52b39f463e529ddcec87902e4497cee39e9546be39e3 bin/post -c restaurants /opt/solr/server/solr/restaurants/restaurants.json"]