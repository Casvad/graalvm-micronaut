#!/bin/sh
docker build . -t complete
echo
# shellcheck disable=SC2016
echo 'To delete unused images use docker rmi $(docker images -f "dangling=true" -q)'
echo "To run the docker container execute:"
echo "    $ docker run --name complete -p 8080:8080 complete"
