import groovy.json.JsonSlurper

// Simon 04/09/2018

	def greeting = "Hello World, I'm starting up..."
	println greeting


	println "This is the httpRequest"
	
	
	
	
/*	def response = httpRequest 'https://httpbin.org/get' //'http://localhost:8080/jenkins/api/json?pretty=true'
	println("Status: "+response.status)
	println("Content: "+response.content) */
	println "This is the curl"
	def respCurl = "curl -v http://httpbin.org/get".execute().text
  	println respCurl 
	def slurper = new JsonSlurper()
	def jsonResult = slurper.parseText(respCurl)
	println "This is the host: " + jsonResult.headers.Host
	println "And this is the origin: " + jsonResult.origin
	def origin = jsonResult.origin
	println "here is it again " + origin
	println "Ending now see you later."


