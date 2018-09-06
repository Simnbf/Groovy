import groovy.json.JsonSlurper
import java.io.FileOutputStream
import java.io.OutputStream
import org.apache.commons.net.ftp.FTPClient

// Simon 04/09/2018

	def greeting = "Hello World, I'm starting up..."
	println greeting
	
	println "About to connect"
	new FTPClient().with{
		def remoteServer = "localhost"
		int reply
		connect remoteServer
		reply = getReplyCode();
		println "Response from connect: " + reply
		if (reply==220) {  
			println "Connected to: " + remoteServer }
			else {
				println "Connection failed: " + reply
//				exit 20
			}
		setFileType(ASCII_FILE_TYPE)
		
		enterLocalPassiveMode()
		login "sbf","wt11mg34"
		reply = getReplyCode();
		println "Response from login: " + reply
		reply = getReplyCode();
		
		changeWorkingDirectory "/home/sbf/ftp/"
		def incomingFile = new File("remote.text")
		incomingFile.withOutputStream { ostream -> retrieveFile "remote.text", ostream }
		def outputFile = "/home/sbf/local/local.text"
		OutputStream out = new FileOutputStream(outputFile)
		out.write(999)
		disconnect()
		
	}
	
	 
	
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


