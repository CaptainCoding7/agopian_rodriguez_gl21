function postServerData(url, data, success){

    $.ajax({
		type: 'POST',	
        url: url,
		data: data,
		contentType : 'application/json',
        dataType: "json"
    }).done(success);
}


function callDone(result){

    localStorage.setItem('isApilot', JSON.stringify(result.isApilot));
    if(localStorage.getItem('isApilot')=='false'){
        // if it's not the case, he can become a pilot by clicking on the corresponding section
        console.log(localStorage.getItem('isApilot'));
        $("#pilot").click(becomePilot);

    }
    else{
        // if he's a pilot, he can access to pilot features
        document.getElementById("pilot").innerHTML="<div class='pilot_section'><h2>Add a flight</h2></div>";
        document.getElementById("pilot").setAttribute("href", "add_a_flight.html");
        let viewPilotFlight = document.createElement("a");
        viewPilotFlight.href="myspace.html";
        viewPilotFlight.id="pilotFlights";
        viewPilotFlight.innerHTML="<div class='pilotFlights'><h2>My flights as a pilot</h2></div>";
        document.getElementById("menu").append(viewPilotFlight);
    }
}


function becomePilot(event){

    console.log("becoming...")
    let userID = localStorage.getItem('userID');
	postServerData("ws/user/becomePilot",userID,callDone);

}


function logOut(){
	
	console.log("logout");
	localStorage.removeItem('userID');    
	localStorage.removeItem('isApilot');    
	document.location.href = "home.html";                                                                                                                                                            

}

if((userID=localStorage.getItem('userID'))!=null){

    //we check if the user is a pilot
    postServerData("ws/user/isApilot",userID,callDone);
    console.log("the user " + userID + " is logged");


}