console.log(localStorage.getItem('FlightID'));// log to know the id of the flight selected
console.log(localStorage.getItem('pilotID'));// log to know the id of the flight selected

if(localStorage.getItem('userID')!=null){
	let userID = JSON.parse(localStorage.getItem('userID'));
	console.log(userID+" is logged.")
	document.getElementById("logSpace").innerHTML = "<a href='myspace.html' style='color: white'>My Space</a>";
	document.getElementById("signLogout").innerHTML = "<a href='home.html' style='color: white' onclick='logOut()'>Log out</a>";

}
else{
	
	let userInfo = JSON.parse(localStorage.getItem('userID'));		

 	document.getElementById("logSpace").innerHTML = "<a href='Log-in.html' style='color: white'>Log in</a>";
	document.getElementById("signLogout").innerHTML = "<a href='Sign-in.html' style='color: white'>Sign in</a>";
	console.log("No logged user");

}

function logOut(){
	
	console.log("logout");
	localStorage.removeItem('userID');    
	localStorage.removeItem('isApilot');    
	document.location.href = "home.html";                                                                                                                                                            

}

function postServerData(url, data, success){

    $.ajax({
		type: 'POST',	
        url: url,
		data: data,
		contentType : 'application/json',
        dataType: "json"
    }).done(success);
}

var user;
var pilotInfos;

let str = "ws/flight/flightInfo/" + localStorage.getItem('FlightID'); // the path to get information about the flight



function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function userCalldone(result){
	
    
	let Display = document.getElementById("Pilot_Name");
    Display.innerHTML = JSON.stringify(result.firstName).replace(/["']+/g, "") +
                        " "+ JSON.stringify(result.lastName).replace(/["']+/g, "");
    
}

function pilotInfosCalldone(result){
	
    let Display = document.getElementById("Hour_of_flight");
    Display.innerHTML = "Hours of flight: " + JSON.stringify(result.flightHours).replace(/["']+/g, "");
    Display = document.getElementById("Discover_me");
    Display.innerHTML = "Discover me : <br>" + JSON.stringify(result.description).replace(/["']+/g, "");
}

function callDone(result){
	//using _.
	var templateExample = _.template($('#flightInfos').html());
	
    //getting all information 
    let departure = templateExample({
        "attribute":JSON.stringify(result.departureAirdrome)
    });

	let pilot = templateExample({
        "attribute":JSON.stringify(result.pilotID)
    });
    

    let arrival = templateExample({
        "attribute":JSON.stringify(result.destinationAirdrome)
    });
    
    let price = templateExample({
        "attribute":JSON.stringify(result.pricePerPassenger)
    });
    
    let seats = templateExample({
        "attribute":JSON.stringify(result.availableSeats)
    });
    
    let title = templateExample({
        "attribute":JSON.stringify(result.flightTitle)
    });
    
    let img = templateExample({
        "attribute":JSON.stringify(result.flightImg)
    });

    let aircraft = templateExample({
        "attribute":JSON.stringify(result.aircraft)
    });

    let typeOfFlight = templateExample({
        "attribute":JSON.stringify(result.typeOfFlight)
    });

    let duration = templateExample({
        "attribute":JSON.stringify(result.duration)
    });

    let departureDate = templateExample({
        "attribute":JSON.stringify(result.departureDate)
    });

    let arrivalDate = templateExample({
        "attribute":JSON.stringify(result.arrivalDate)
    });

    let flightDescription = templateExample({
        "attribute":JSON.stringify(result.flightDescription)
    });

    let tmp = document.createElement("p");//tempary element to set correctly information
    //for the img
	tmp.innerHTML = img;
    let Display = document.getElementById("Flight-Picture");
    Display.src = tmp.textContent.replace(/["']+/g, "");

    //for the title
	tmp.innerHTML = title;
    Display = document.getElementById("title");
    Display.textContent = tmp.textContent.replace(/["']+/g, "");

    //for the type of flight
    tmp.innerHTML = typeOfFlight;
    Display = document.getElementById("typeOfFlight");
    Display.textContent = "Type of Flight : " + tmp.textContent.replace(/["']+/g, "");

    // for the number of seat
    tmp.innerHTML = seats;
    Display = document.getElementById("numberOfSeat");
    Display.textContent = "Available Seats : " + tmp.textContent.replace(/["']+/g, "");
    Display = document.getElementById("nbOfSeats");
    console.log(JSON.stringify(result.availableSeats)+1)
    for (let index = 2; index < parseInt(JSON.stringify(result.availableSeats)) + 1 ; index++) { 
        Display.innerHTML += "<option value="+ index + ">"+ index +"</option>";    
    }

    // for the duration
    tmp.innerHTML = duration;
    Display = document.getElementById("Duration");
    Display.textContent = "The duration of the travel : " + tmp.textContent.replace(/["']+/g, "");

    // for the Departure Date
    tmp.innerHTML = departureDate;
    Display = document.getElementById("Departure_Date");
    Display.textContent = "Departure date : " + tmp.textContent.replace(/["']+/g, "");

    // for the Departure Place
    tmp.innerHTML = departure;
    Display = document.getElementById("Departure_Place");
    Display.textContent = " Departure Place : " + tmp.textContent.replace(/["']+/g, "");

    // for the Arrival Place
    tmp.innerHTML = arrival;
    Display = document.getElementById("Arrival_Place");
    Display.textContent = "Arrival Place : " + tmp.textContent.replace(/["']+/g, "");

    // for the Description
    tmp.innerHTML = flightDescription;
    Display = document.getElementById("Description");
    Display.innerHTML = "<h2 style='text-transform: none;'>Description : </h2> <br>" + tmp.textContent.replace(/["']+/g, "");

    // for the Aircraft Information
    tmp.innerHTML = aircraft;
    Display = document.getElementById("Aircraft_Info");
    Display.innerHTML ="Aircraft Model  :" + tmp.textContent.replace(/["']+/g, "");
    
    //for the price
	tmp.innerHTML = price;
	Display = document.getElementById("price");
	Display.textContent = "Price : " + tmp.textContent.replace(/["']+/g, "") + "€ per person";

    console.log("aircraft_info : ", JSON.stringify(result.aircraft));

}

$(document).ready(function() {

	var pilotID=localStorage.getItem('pilotID')
	let path = "ws/user/getuserinfo/"+ pilotID ;
	getServerData(path,userCalldone);
	console.log(user);
	
	path = "ws/pilot/pilotInfos/1";//+pilotID;
	getServerData(path,pilotInfosCalldone);
	
	getServerData(str,callDone);
});

function finishBook()
{
    alert("Thank for your reservation, wait the response of the pilot");
    document.location.href = "home.html";
}

$("#bookTheFlight").click(
    function(){
        if(localStorage.getItem('userID')!=null){
	    let userID = JSON.parse(localStorage.getItem('userID'));
	    console.log(userID+" is logged.")
	    let bookingflight = {
            flightID: localStorage.getItem('FlightID'),
            userID: localStorage.getItem('userID'),
            nbSeats: $("#bookTheFligh").val()
            }
        postServerData("ws/booking/user/book", JSON.stringify(bookingflight), finishBook);
        }
        else{

            localStorage.setItem("last_Page","viewFlight.html");
            document.location.href = "Log-in.html";

        }
    }

);
