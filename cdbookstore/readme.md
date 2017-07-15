		[OPTIONAL]
		--> Stop the current running docker container
			docker-machine stop <name>
		--> Create a docker container
				docker-machine create --driver virtualbox <name>
				Eg: docker-machine create --driver virtualbox mydockervm
	
	--> A docker container should be active and in running state.
	--> Git clone this repository
	--> From the docker quickstart terminal, move to the base directory of this project
			Eg: cdbookstore>
	--> Build and Execute
			cdbookstore>docker build --tag=<name> .
			cdbookstore>docker run -it -p 8080:8080 <name>
			Eg: cdbookstore>docker build --tag=cdbookstore .
			cdbookstore>docker run -it -p 8080:8080 cdbookstore
	
	--> Open second docker quickstart terminal and verify 
			cdbookstore> docker ps
					This should show image cdbookstore status 'UP...'
			cdbookstore>docker-machine ls
					This should show 'mydockervm' container running and active.


	Open browser and execute below rest end point
	http://<ip>:8080/cdbookstore/rest/hello

	IP in above rest call should match ip of the mydockervm appear through 'docker-machine ls' command

	If everything is good, you should see below response in the browser

		method doGet invoked: Sun Jul 09 13:55:12 UTC 2017

	<time> is the local time of the remote wildfly server.

--> stop the server and stop docker container and the image.

-->	To push the image to docker hub: (Assuming account already created)
		cdbookstore>docker login
		enter user id and password of existing account.
-->	set the substitute for login id.
		cdbookstore>export DOCKER_ID_USER="username"
		username is the login id of the account.
		This command sets the substitute DOCKER_ID_USER for the login id.

-->	Tag the image.		
		cdbookstore>docker tag cdbookstore $DOCKER_ID_USER/cdbookstore
--> Push the image
		docker push $DOCKER_ID_USER/cdbookstore

If this went well, the image should appear in hub.docker.com

Now in the local remove the container that is running the local image using commands
	cdbookstore>'docker rm <container id>'		
	cdbookstore>docker rmi <image id>
		container id and image can be obtained from 'docker ps -a'
			(Note: -a shows all the containers and images that including 'not running' state)
		
	This step is necessary that the local system doesnt have cdbookstore image.


At this point there should be no service running in local system and the rest end point should be down
Accessing http://<ip>:8080/cdbookstore/rest/hello	should be unresponsive.

--> pull the image from docker hub
		docker pull <accountid/imagename>
--> Run the image pulled:
		cdbookstore>docker run -it -p 8080:8080 cdbookstore

Execute the rest end point
http://<ip>:8080/cdbookstore/rest/hello		

If everything goes well, the time stamp of the remote wildfly server should appear.
		
Happy Dockering :)