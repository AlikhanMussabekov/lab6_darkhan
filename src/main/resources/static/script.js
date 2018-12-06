var invoiceChartContext;
var invoiceChart;
var employeeChartContext;
var employeeChart;

$(document).ready(function(){
	fillCompanyNamesTable();
	fillEmployeestable();
	getEmployeesSalary();

	$('.title').click(false);

	invoiceChartContext = document.getElementById('invoiceChart').getContext('2d');
	//invoiceChartContext.style.backgroundColor = 'rgb(255,255,255)';
	invoiceChart = new Chart(invoiceChartContext, {

		type: 'bar',

		data: {
			labels: '',
			datasets: [{
				label: [],
				backgroundColor: 'rgb(255, 99, 132)',
				borderColor: 'rgb(255, 99, 132)',
				data: []
			}],

		},

		// Configuration options go here
		options: {
			responsive : true,
			maintainAspectRatio : false,
			backgroundColor: 'rgba(255,255,255,1.0)'
		}
	});

	employeeChartContext = document.getElementById('employeeChart').getContext('2d');
	//employeeChartContext.style.backgroundColor = 'rgb(255,255,255)';
	employeeChart = new Chart(employeeChartContext, {

		type: 'line',

		data: {
			labels: '',
			datasets: [{
				label: [],
				fill: false,
				borderColor: 'rgb(255, 99, 132)',
				lineTension: 0,
				data: []
			}]
		},

		// Configuration options go here
		options: {
			responsive : true,
			maintainAspectRatio : false,
			backgroundColor: 'rgba(255,255,255,1.0)'
		}
	});

	$("#clients-table").on('click','tr',function() {

		this.style.backgroundColor = "grey";

		var companyName = $(this).find("td").toArray()[0].innerText;

		console.log("clicked " + companyName)

		getClientInvoices(companyName);

	});

});

function fillCompanyNamesTable() {
	$.get("http://localhost:8080/companynames", function(data){
		var markup='';

		data.forEach(function (item) {
			markup += '<tr><td>' + item + '</td></tr>';
		});

		$(".clients-table tr").first().after(markup);
	});
}

function fillEmployeestable(){
	$.get("http://localhost:8080/employees", function(data){
		var markup='';

		data.forEach(function(item){
			markup+= '<tr><td>' + item + '</td></tr>';
		})

		$(".employees-table tr").first().after(markup);
	});
}

function getClientInvoices(name) {

	var cur_labels;
	var cur_data;

	var url = "http://localhost:8080/clientinvoices/" + name;
	$.get(url, function(data){
			changeData(invoiceChart,data['labels'],data['data'],data['name']);
		}
	);
}

function getEmployeesSalary() {
	var cur_labels;
	var cur_data;

	var url = 'http://localhost:8080/employeessalary';
	$.get(url, function (data) {
		changeData(employeeChart,data['labels'],data['data'],data['name']);
	});
}

function changeData(chart,cur_labels,cur_data,cur_name) {

	chart.data.labels = cur_labels;

	chart.data.datasets[0].label = cur_name;
	chart.data.datasets[0].data = cur_data;

	chart.update();
}