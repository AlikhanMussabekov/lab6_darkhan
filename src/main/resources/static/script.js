$(document).ready(function(){
	fillTable();

	$("#client-table").on('click','tr',function() {

		this.style.backgroundColor = "grey";

		var companyName = $(this).find("td").toArray()[0].innerText;

		console.log("clicked " + companyName)

		getClientInvoices(companyName);

	});

});

function fillTable() {
	$.get("http://localhost:8080/companynames", function(data){
		var markup='';

		data.forEach(function (item) {
			markup += '<tr><td>' + item + '</td></tr>';
		});

		$(".client-table tr").first().after(markup);
	});
}

function getClientInvoices(name) {

	var cur_labels;
	var cur_data;

	var url = "http://localhost:8080/clientinvoices/" + name;
	$.get(url, function(data){

			draw(data['labels'],data['data'],data['name']);
		}
	);
}

function draw(cur_labels,cur_data,cur_name) {

	var ctx = document.getElementById('chart').getContext('2d');
	var chart = new Chart(ctx, {

		type: 'bar',

		data: {
			labels: cur_labels,
			datasets: [{
				label: cur_name,
				backgroundColor: 'rgb(255, 99, 132)',
				borderColor: 'rgb(255, 99, 132)',
				data: cur_data
			}]
		},

		// Configuration options go here
		options: {
			responsive : true,
			maintainAspectRetio : false
		}
	});
}
