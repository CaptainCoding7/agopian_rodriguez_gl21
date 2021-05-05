console.log(localStorage.getItem('FlightID'));// log to know the id of the flight selected
console.log(localStorage.getItem('pilotID'));// log to know the id of the flight selected

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
	
	let tmp = document.createElement("p");//tempary element to set correctly information
    //for the userID
	tmp.innerHTML = JSON.stringify(result.firstName);
    console.log("tmp", tmp.textContent);
    let Display = document.getElementById("Pilot_Name");
    Display.textContent = tmp.textContent.replace(/['"]+/g, "") + " ";
	tmp.innerHTML = JSON.stringify(result.lastName);
    Display.textContent += tmp.textContent.replace(/['"]+/g, "");
}

function pilotInfosCalldone(result){
	
    let Display = document.getElementById("Hour_of_flight");
    Display.textContent = "Flight hours : " + JSON.stringify(result.flightHours) + " h"; 
    Display = document.getElementById("Hour_of_flight");
    Display.innerHTML = "<h1>Description: </h1><br>" + JSON.stringify(result.flightHours); 

    
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
    Display.src = tmp.textContent.replace(/['"]+/g, "");

    //for the title
	tmp.innerHTML = JSON.stringify(result.flightTitle);
    Display = document.getElementById("title");
    Display.textContent = tmp.textContent.replace(/['"]+/g, "");

    //for the type of flight
    tmp.innerHTML = typeOfFlight;
    Display = document.getElementById("typeOfFlight");
    Display.textContent = "Type of Flight : " + tmp.textContent.replace(/['"]+/g, "");

    // for the number of seat
    tmp.innerHTML = seats;
    Display = document.getElementById("numberOfSeat");
    Display.textContent = "Seats available : " + tmp.textContent.replace(/['"]+/g, "");

    // for the duration
    tmp.innerHTML = duration;
    console.log(duration);
    Display = document.getElementById("Duration");
    Display.textContent = "Duration : " + tmp.textContent.replace(/['"]+/g, "");

    // for the Departure Date
    tmp.innerHTML = departureDate;
    Display = document.getElementById("Departure_Date");
    Display.textContent = "Departure Date : " + tmp.textContent.replace(/['"]+/g, "");

    // for the Departure Place
    tmp.innerHTML = departure;
    Display = document.getElementById("Departure_Place");
    Display.textContent = "Departure Place : " + tmp.textContent.replace(/['"]+/g, "");

    // for the Arrival Place
    tmp.innerHTML = arrival;
    Display = document.getElementById("Arrival_Place");
    Display.textContent = "Arrival Place : " + tmp.textContent.replace(/['"]+/g, "");

    // for the Description
    tmp.innerHTML = flightDescription;
    Display = document.getElementById("Description");
    Display.innerHTML = "<h2 style='color: white; font-size: 2.5 em'>Description :</h2> <p style='color: white; text-transform: none;'>" + tmp.textContent.replace(/['"]+/g, "") +"</p>";

    // for the Aircraft Information
    tmp.innerHTML = aircraft;
    Display = document.getElementById("Aircraft_Info");
    Display.textContent = tmp.textContent.replace(/['"]+/g, "");

    // for the Pilot Information
    tmp.innerHTML = pilot;
    Display = document.getElementById("Pilot_Info");

	
	tmp.innerHTML = price;
	Display = document.getElementById("price");
	Display.textContent = "Price : " + tmp.textContent.replace(/['"]+/g, "") + " € per Seat";

}

$(document).ready(function() {

	var pilotID=localStorage.getItem('pilotID')
	let path = "ws/user/getuserinfo/"+ pilotID ;
	getServerData(path,userCalldone);
	console.log("user", user);
	
	path = "ws/pilot/pilotInfos/" + pilotID;//+pilotID;
	getServerData(path,pilotInfosCalldone);
	
	getServerData(str,callDone);
});


