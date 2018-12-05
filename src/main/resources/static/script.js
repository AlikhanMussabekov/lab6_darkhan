var dataLabels;
$(document).ready(function(){
	getData();
	draw();
}
);

function draw() {

	var ctx = document.getElementById('chart').getContext('2d');
	var chart = new Chart(ctx, {
		// The type of chart we want to create
		type: 'bar',

		// The data for our dataset
		data: {
			labels: ["January", "February", "March", "April", "May", "June", "July"],
			datasets: [{
				label: "My First dataset",
				backgroundColor: 'rgb(255, 99, 132)',
				borderColor: 'rgb(255, 99, 132)',
				data: [0, 10, 5, 2, 20, 30, 45],
			}]
		},

		// Configuration options go here
		options: {
			responsive : true,
			maintainAspectRetio : false
		}
	});
}

function getData() {
	$.get("http://localhost:8080/companynames", function(data){
		$(".data").html(data);
		}
	);
}