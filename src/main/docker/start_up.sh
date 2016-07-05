echo "<?xml version=\"1.0\" encoding=\"utf-8\"?>
	<Context><WatchedResource>WEB-INF/web.xml</WatchedResource>
	<Environment name=\"location\" value=\"https://s3-ap-southeast-1.amazonaws.com/vehicle-rental-css-bucket/frame.css\" type=\"java.lang.String\"/>
	<Environment name=\"datepickercsslocation\" value=\"https://s3-ap-southeast-1.amazonaws.com/vehicle-rental-css-bucket/jsDatePick_ltr.min.css\" type=\"java.lang.String\"/>
	<Environment name=\"businessURL\" value=\"http://${BUSINESS_IP}:8080/VehicleBusiness/vehiclerental\" type=\"java.lang.String\"/>
	</Context>"  > /etc/tomcat7/context.xml ;

cat /etc/tomcat7/context.xml;
service tomcat7 start ;
tail -f /var/lib/tomcat7/logs/catalina.out
