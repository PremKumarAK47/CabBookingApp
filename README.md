# CabBookingApp
## This is the project to build Rest API for Cab Booking Application 
### Features of this application:
1. The application allows users to book rides on a route.
2. Users can register themself.
3. Driving partner can onboard on the system with the vehicle details
4. Users can search and select one from multiple available rides on a route with the same source and destination based on the nearest to the user.
5. Drivers who are within 5 Kms from the users source will be available for booking.
6. You can consider x-coordinate and y-coordinate for positions.

## Formula for finding distance between two coordinates:
  ## d=root((x2-x1)^2 + (y2-y1)^2)
  
  ## **Following things I have Taken care -:**

1. Application should allow user onboarding.
    1. add_user
        1. Add basic user details
2. Application should allow Driver onboarding
    1. add_driver
        1. This will create an instance of the driver and will mark his current location on the map
3. Application should allow the user to find a ride based on the criteria below
    1. find_ride
        1. It will return a list of available rides within 5 unit of distance
    2. book_ride
        1. It will book the ride and update the position of the driver and the user to the destination given
        
## Rest API for User Resource
### HTTP Method	           URL Path	                             Status Code	   Description
### POST	             /masaicab/user/register	                 201(CREATED)	   Register a User
### POST	             /masaicab/user/login	                     200(OK)	       Login a User
### GET       	       /masaicab/user/findride	                 200(OK)	       get list of available drivers
### PUT	               /masaicab/user/book/{driverId}/{x}/{y}	   200(OK)	       User can book the ride by entering the id of available driver and destination coordinates 
